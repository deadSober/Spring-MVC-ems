package com.medplus.ems.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.medplus.ems.dao.TransactionDao;
import com.medplus.ems.dao.helpers.TransactionHelper;
import com.medplus.ems.dao.queries.TransactionQueries;
import com.medplus.ems.domain.EmployeeDetails;
import com.medplus.ems.domain.EmployeeSearchCriteria;
import com.medplus.ems.domain.TransactionDetails;
import com.medplus.ems.domain.TransactionSearchCriteria;
import com.medplus.ems.domain.TransactionStatus;
import com.medplus.ems.domain.TransactionType;
import com.medplus.ems.exception.EMSException;

@Repository
public class TransactionDaoImpl extends TransactionQueries implements TransactionDao {
	@Autowired
	JdbcTemplate emsJdbcTemplate;

	@Override
	public int createTransaction(TransactionDetails transactionDetails, int userId) throws EMSException {
		try {
			Object[] createTransactionParams = new Object[] { transactionDetails.getEmployeeCode(),TransactionStatus.CREATED.getValue(),
					transactionDetails.getTransactionType().getValue(), transactionDetails.getReason(),
					transactionDetails.getAmount(), new Date(), userId };

			int[] createTransactionTypes = new int[] { Types.INTEGER, Types.CHAR, Types.CHAR, Types.VARCHAR,
					Types.DECIMAL, Types.TIMESTAMP, Types.INTEGER };
			PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(INSERT_TRANSACTION_DETAILS_QRY,
					createTransactionTypes);
			pscf.setReturnGeneratedKeys(true);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			int transactionId = emsJdbcTemplate.update(pscf.newPreparedStatementCreator(createTransactionParams),
					keyHolder);
			transactionId = keyHolder.getKey().intValue();
			transactionDetails.setTransactionId(transactionId);
			createTransactionLogDetails(transactionId);
			return transactionId;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EMSException("Invalid Data", e);
		}
	}

	private void createTransactionLogDetails(int transactionId) throws EMSException {
		TransactionSearchCriteria transactionSearchCriteria = new TransactionSearchCriteria();
		transactionSearchCriteria.setTransactionId(transactionId);
		List<TransactionDetails> TransactionDetailsList = getTransactionDetails(transactionSearchCriteria);
		if (TransactionDetailsList == null || TransactionDetailsList.isEmpty() || TransactionDetailsList.get(0) == null) {

			throw new EMSException("Transaction Details Not Found");
		}
		TransactionDetails transactionDetails = TransactionDetailsList.get(0);
		Object[] createEmployeeLogParams = new Object[] { transactionId,transactionDetails.getEmployeeCode(),transactionDetails.getTransactionType().getValue(),transactionDetails.getReason(),transactionDetails.getTransactionStatus().getValue(),transactionDetails.getComments(),transactionDetails.getAmount(),
				transactionDetails.getCreatedDate(),transactionDetails.getCreatedBy(), transactionDetails.getModifiedDate(), transactionDetails.getModifiedBy() };
		int[] createEmployeeLogTypes = new int[] { Types.INTEGER,Types.INTEGER,Types.CHAR,Types.VARCHAR,  Types.CHAR,Types.VARCHAR, Types.DECIMAL, Types.TIMESTAMP, Types.INTEGER,Types.TIMESTAMP, Types.INTEGER };
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(INSERT_TRANSACTION_DETAILS_LOG_QRY,
				createEmployeeLogTypes);
		emsJdbcTemplate.update(pscf.newPreparedStatementCreator(createEmployeeLogParams));	

	}

	public List<TransactionDetails> getTransactionDetails(TransactionSearchCriteria transactionSearchCriteria) {
		Object[] parameters=TransactionHelper.transactionSearchParameters(transactionSearchCriteria);
		List<TransactionDetails> transactionDetailsList=emsJdbcTemplate.query(TransactionQueries.GET_TRANSACTION_DETAILS_QRY,parameters,new ResultSetExtractor<List<TransactionDetails>>() {

			@Override
			public List<TransactionDetails> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				List<TransactionDetails> list=new ArrayList<TransactionDetails>();
				
				while(resultSet.next())
				{
					TransactionDetails transactionDetails= new TransactionDetails();
					transactionDetails.setTransactionId(resultSet.getInt("transactionId"));
					transactionDetails.setEmployeeCode(resultSet.getInt("employeeCode"));
					transactionDetails.setTransactionType(TransactionType.getTransactionType(resultSet.getString("transactionType")));
					transactionDetails.setReason(resultSet.getString("reason"));
					transactionDetails.setTransactionStatus(TransactionStatus.getTransactionStatus(resultSet.getString("status")));
					transactionDetails.setComments(resultSet.getString("comments"));
					transactionDetails.setAmount(resultSet.getDouble("amount"));
					transactionDetails.setCreatedBy(resultSet.getInt("createdBy"));
					transactionDetails.setCreatedDate(resultSet.getTimestamp("createdDate"));
					transactionDetails.setModifiedBy(resultSet.getInt("modifiedBy"));
					transactionDetails.setModifiedDate(resultSet.getTimestamp("modifiedDate"));
					list.add(transactionDetails);
				}
				return list;
			}
				
			});
				return transactionDetailsList;
	
	}

	@Override
	public void editTransactionDetails(TransactionDetails transactionDetails, int userId) throws EMSException {
		Object[] updateTransactionParams = new Object[] {transactionDetails.getAmount(), transactionDetails.getReason(),
				transactionDetails.getTransactionType().getValue(),userId,new Date(),transactionDetails.getTransactionId()};

		int[] updateTransactionTypes = new int[] { Types.DECIMAL, Types.VARCHAR, Types.CHAR,Types.INTEGER,Types.TIMESTAMP, Types.INTEGER };
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(EDIT_TRANSACTION_DETAILS_QRY,
				updateTransactionTypes);
		int row = emsJdbcTemplate.update(pscf.newPreparedStatementCreator(updateTransactionParams));
		if(row==0)
		{
			throw new EMSException("Cannot Update TransactionDetails");
		}
		createTransactionLogDetails(transactionDetails.getTransactionId());
		
	}

	@Override
	public void updateBalance(int employeeCode, double amount, int userId) {
		Object[] updatebalanceParams = new Object[] { amount, userId, new Date(), employeeCode };
		int[] updateBalanceTypes = new int[] { Types.DOUBLE, Types.INTEGER, Types.TIMESTAMP, Types.INTEGER };
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(UPDATE_BALANCE_QRY,
				updateBalanceTypes);
		emsJdbcTemplate.update(pscf.newPreparedStatementCreator(updatebalanceParams));
	}
	@Override
	public double getBalanceAmount(int employeeCode) throws EMSException{
		double balance = emsJdbcTemplate.queryForObject(GET_BALANCE_QRY, new Object[] {employeeCode}, Double.class);
		return balance;
	}	
	@Override
	public void updateTransactionStatus(int transactionId, TransactionStatus status, String comments, int userId) throws EMSException {

		Object[] updateTransactionParams = new Object[] { status.getValue(), comments, userId, new Date(), transactionId };

		int[] updateTransactionTypes = new int[] {Types.CHAR,Types.VARCHAR, Types.INTEGER,
				Types.TIMESTAMP, Types.INTEGER };
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(UPDATE_TRANSACTION_STATUS_QRY, updateTransactionTypes);
		int row = emsJdbcTemplate.update(pscf.newPreparedStatementCreator(updateTransactionParams));
		if (row == 0) {
			throw new EMSException("Cannot Update TransactionDetails");
		}
		createTransactionLogDetails(transactionId);
	}
	
	}
	


