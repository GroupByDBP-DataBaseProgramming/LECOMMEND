package model.service;

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
}
