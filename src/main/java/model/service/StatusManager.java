package model.service;

import java.sql.SQLException;

import model.dao.StatusDAO;

public class StatusManager {

	private static StatusManager statusMan = new StatusManager();
	private StatusDAO statusDAO;

	private StatusManager() {
		try {
			statusDAO = new StatusDAO();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static StatusManager getInstance() {
		return statusMan;
	}
	
	public int create(int statusCnt, String stuId, String lecId) throws SQLException, ExistingUserException {
		if (statusCnt > 0) {
			throw new ExistingUserException(lecId + "는 이미 수강했던 강의입니다.");
		}
		return statusDAO.create(stuId, lecId);
	}
	
	public int delete(int statusCnt, String stuId, String lecId) throws SQLException, StatusNotFoundException {
		if (statusCnt == 0) {
			throw new StatusNotFoundException(lecId + "는 수강하지 않은 강의입니다.");
		}
		return statusDAO.delete(stuId, lecId);
	}
	
	public int existingStatus(String stuId, String lecId) throws SQLException, StatusNotFoundException {
		return statusDAO.findRegistered(stuId, lecId);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
