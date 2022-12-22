package model.service;

import java.util.ArrayList;
import java.util.List;

import model.dao.LectureDAO;
import model.dto.LectureDTO;

public class LectureAnalysis {
	private LectureDAO lecdao;

	public LectureAnalysis() {
	}

	public LectureAnalysis(LectureDAO dao) {
		super();
		this.lecdao = dao;
	}

	public List<LectureDTO> recommendLectures(String stuId, String lecId) throws Exception {
		int i = 0;
		String[] dibList = lecdao.findLecturesOtherStudentDib(stuId, lecId);

		List<LectureDTO> recommendLecList = new ArrayList<LectureDTO>();
		while (i < 6) {
			LectureDTO lec = lecdao.findLecture(dibList[i]);
			recommendLecList.add(lec);
		}

		return recommendLecList;
	}

	// 전체 검색 시 나온 결과 중 user가 수강했던 강의 알아내기
	public List<LectureDTO> findLectureWithStatus(List<LectureDTO> searchLec, String userId) throws Exception {

		List<LectureDTO> resultLecList = new ArrayList<LectureDTO>();
		List<LectureDTO> statusList = lecdao.findStatusLectures(userId);

		for (int i = 0; i < searchLec.size(); i++) {
			for (int j = 0; j < statusList.size(); j++) {
				if (searchLec.get(i).getLecID().equals(statusList.get(j).getLecID()))
					resultLecList.add(searchLec.get(i));
			}
		}

		return resultLecList;
	}

	// 키워드를 선택하지 않은 상태에서 search result 폼으로 갈 때, 수강 여부 체크 (수정 필요)
	public List<LectureDTO> searchLecturesWithStatusX(List<LectureDTO> searchLec, String userId) throws Exception {

		List<LectureDTO> lecList = new ArrayList<LectureDTO>();
		int statusCount = lecdao.findCountOfStuentDibs(userId);

		for (int i = statusCount; i < searchLec.size(); i++) {
			lecList.add(searchLec.get(i));
		}
		return lecList;
	}

	public List<LectureDTO> searchLecturesWithStatusX(List<LectureDTO> searchLec, List<LectureDTO> statusLec)
			throws Exception {

		searchLec.retainAll(statusLec);

		return searchLec;

	}

}
