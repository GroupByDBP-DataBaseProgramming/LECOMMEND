package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.LectureDAO;
import model.dto.LectureDTO;

public class LectureManager {
	private static LectureManager lectureMan = new LectureManager();
	private LectureDAO lecDAO;
	private LectureAnalysis lecAanlysis;

	private LectureManager() {
		try {
			lecDAO = new LectureDAO();
			lecAanlysis = new LectureAnalysis(lecDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public static LectureManager getInstance() {
		return lectureMan;
	}

	public int create(LectureDTO lec) throws SQLException, ExistingUserException {
		if (lecDAO.existingLecture(lec.getLecID()) == true) {
			throw new ExistingUserException(lec.getLecID() + "는 존재하는 강의입니다.");
		}
		return lecDAO.create(lec);
	}
	
	public int createDetail(LectureDTO lec) throws SQLException, ExistingUserException {
		if (lecDAO.existingLecture(lec.getLecID()) == true) {
			throw new ExistingUserException(lec.getLecID() + "는 존재하는 강의입니다.");
		}
		return lecDAO.createDetail(lec);
	}

	public int update(LectureDTO lec) throws SQLException, UserNotFoundException {
		return lecDAO.update(lec);
	}
	
	public int updateDetail(LectureDTO lec) throws SQLException, UserNotFoundException {
		return lecDAO.updateDetail(lec);
	}

	public int remove(String lecId) throws SQLException, UserNotFoundException {
		return lecDAO.delete(lecId);
	}
	
	public int removeDetail(String lecId) throws SQLException, UserNotFoundException {
		return lecDAO.deleteDetail(lecId);
	}
	
	public LectureDTO findLecture(String lecId) throws SQLException, UserNotFoundException {
		LectureDTO lec = lecDAO.findLecture(lecId);

		if (lec == null) {
			throw new UserNotFoundException(lecId + "는 존재하지 않는 강의입니다.");
		}
		return lec;
	}

	public List<LectureDTO> findLectureList() throws SQLException {
		return lecDAO.findAllLectures();
	}

	public List<LectureDTO> findLecturesTop5() throws SQLException{
		return lecDAO.findLecturesTop5();
	}
	
	public List<LectureDTO> findLecturesTop5InSameDept(String major) throws SQLException {
		return lecDAO.findLecturesTop5InSameDept(major);
	}
	
	public int findCountOfStuentDibs(String stuId) throws SQLException {
		return lecDAO.findCountOfStuentDibs(stuId);
	}
	
	public String[] findLecturesOtherStudentDib(String stuId, String lecId) throws SQLException {
		return lecDAO.findLecturesOtherStudentDib(stuId, lecId);
	}

	public List<LectureDTO> findLectureByKeywordAndStatus(String stuID, String loc, String week, String lecTime, int occupancy, int credit, String onOff, String lecType, String interest, String examType) throws SQLException {
		return lecDAO.findLectureByKeywordAndStatus(stuID, loc, week, lecTime, occupancy, credit, onOff, lecType, interest, examType);				
	}
	
	public List<LectureDTO> findLectureByKeyword(String loc, String week, String lecTime, int occupancy, int credit, String onOff, String lecType, String interest, String examType) throws SQLException {
		return lecDAO.findLectureByKeyword(loc, week, lecTime, occupancy, credit, onOff, lecType, interest, examType);
	}
	
	public List<LectureDTO> findLectureByKeywordWithLoc(String loc, String week, String lecTime, int occupancy, int credit, String onOff, String lecType, String interest, String examType) throws SQLException {
		return lecDAO.findLectureByKeywordWithLoc(loc, week, lecTime, occupancy, credit, onOff, lecType, interest, examType);
	}
	
	public List<LectureDTO> findLectureByKeywordWithLecType(String loc, String week, String lecTime, int occupancy, int credit, String onOff, String lecType, String interest, String examType) throws SQLException {
		return lecDAO.findLectureByKeywordWithLecType(loc, week, lecTime, occupancy, credit, onOff, lecType, interest, examType);
	}
	
	public List<LectureDTO> findLectureByKeywordWithLecTime(String loc, String week, String lecTime, int occupancy, int credit, String onOff, String lecType, String interest, String examType) throws SQLException {
		return lecDAO.findLectureByKeywordWithLecTime(loc, week, lecTime, occupancy, credit, onOff, lecType, interest, examType);
	}
	
	public List<LectureDTO> recommendLectures(String stuid, String lecid) throws Exception {
		return lecAanlysis.recommendLectures(stuid, lecid);
	}
	
	// 과거 강의 포함 X 검색
	public List<LectureDTO> findLectureByKeywordAndStatusX(String stuid, String loc, String lecTime, String interest, String lecType, String priority) throws Exception {
		return lecDAO.findLectureByKeywordAndStatusX(stuid, loc, lecTime, interest, lecType, priority);
	}

	// 과거 강의 포함 O 검색 (전체 검색)
	public List<LectureDTO> findLectureByKeywordAndStatusO(String loc, String lecTime, String interest, String lecType, String priority) throws Exception {
		return lecDAO.findLectureByKeywordAndStatusO(loc, lecTime, interest, lecType, priority);
	}
	
	// 전체 검색 시 나온 결과 중 user가 수강했던 강의 알아내기
	public List<LectureDTO> findLectureWithStatus(List<LectureDTO> searchLec, String userId) throws Exception {
		return lecAanlysis.findLectureWithStatus(searchLec, userId);
	}
	
	
	// user가 수강한 강의 검색
	public List<LectureDTO> findStatusLectures(String userId) throws Exception {
		return lecDAO.findStatusLectures(userId);
	}
	
	//
	public List<LectureDTO> searchLecturesWithStatusX(List<LectureDTO> searchLec, List<LectureDTO> statusLec) throws Exception {
		return lecAanlysis.searchLecturesWithStatusX(searchLec, statusLec);
	}


	public LectureDAO getLectureDAO() {
		return this.lecDAO;
	}
}
