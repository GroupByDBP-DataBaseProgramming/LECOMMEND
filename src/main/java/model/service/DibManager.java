package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.DibDAO;
import model.dto.DibDTO;
import model.dto.LectureDTO;

public class DibManager {
	
	private static DibManager dibMan = new DibManager();
	private DibDAO dibDAO;
	
	private DibManager() {
		try {
			dibDAO = new DibDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DibManager getInstance() {
		return dibMan;
	}
	
	public int create(String stuID, String lecID) throws SQLException {
		return dibDAO.create(stuID, lecID);
	}
	
	public int remove(String stuID, String lecID) throws SQLException {
		//dib이 있는지 없는지를 jsp에서만 판단할지, 메소드를 추가할지..
		return dibDAO.delete(stuID, lecID);
	}
	
	public int numOfLecDibs(String lecId) throws SQLException {
		//lec 있는지 없는지 여부
		return dibDAO.numOfLecDibs(lecId);
	}
	
	public int numOfStuDibs(String stuId) throws SQLException {
		//std 있는 지 없는지 여부
		return dibDAO.numOfLecDibs(stuId);
	}
	
	public List<LectureDTO> listOfDibs(String stuId) throws SQLException {
		//existing stu
		return dibDAO.listOfDibs(stuId);
	}

}