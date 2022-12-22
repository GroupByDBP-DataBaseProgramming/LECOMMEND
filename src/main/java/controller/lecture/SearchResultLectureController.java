package controller.lecture;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.LectureDTO;
import model.service.LectureManager;

public class SearchResultLectureController implements Controller {
	
	private static final Logger log = LoggerFactory.getLogger(SearchResultLectureController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {

			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			
			//log.debug("userId : {}", userId);
			//log.debug("status : {}", request.getParameter("status"));
			LectureManager manager = LectureManager.getInstance();

			List<LectureDTO> hotLecList = manager.findLecturesTop5();
			List<LectureDTO> lecList = new ArrayList<LectureDTO>();
			List<LectureDTO> resultLecList  = new ArrayList<LectureDTO>();
			
			if (Integer.valueOf(request.getParameter("status")) == 1) {
				lecList = manager.findLectureByKeywordAndStatusX(userId, request.getParameter("loc").substring(0, 1),
						request.getParameter("lecTime").substring(0, 1), request.getParameter("interest"),
						request.getParameter("lecType"), request.getParameter("priority"));
				for (LectureDTO lec : lecList )
					log.debug("lec : {}", lec);
			} else {
				lecList = manager.findLectureByKeywordAndStatusO(request.getParameter("loc").substring(0, 1),
						request.getParameter("lecTime").substring(0, 1), request.getParameter("interest"),
						request.getParameter("lecType"), request.getParameter("priority"));
				
				// 전체 검색
				for (LectureDTO lec : lecList )
					log.debug("lec STATUS O : {}", lec);
				
				resultLecList = manager.findLectureWithStatus(lecList, userId);
				for (LectureDTO lec : resultLecList )
					log.debug("statusList : {}", lec);
			}
			

			ArrayList<String> keywordList = new ArrayList<String>();
			keywordList.add("강의실: " + request.getParameter("loc"));
			keywordList.add("요일: " + request.getParameter("week"));
			keywordList.add("시간: " + request.getParameter("lecTime"));
			keywordList.add("인원: " + request.getParameter("occupancy"));
			keywordList.add("학점: " + request.getParameter("credit") + "학점");
			keywordList.add("OnOff: " + request.getParameter("onOff"));
			keywordList.add("관심사: " + request.getParameter("interest"));
			keywordList.add("시험유형: " + request.getParameter("examType"));

			request.setAttribute("lecList", lecList);
			request.setAttribute("keywordList", keywordList);
			request.setAttribute("hotLecList", hotLecList);
				
			request.setAttribute("resultLecList", resultLecList);
			
			return "/lecture/searchResult.jsp";
		} catch (Exception e) {

			LectureManager manager = LectureManager.getInstance();

			List<LectureDTO> allLecList = manager.findLectureList();
			List<LectureDTO> hotLecList = manager.findLecturesTop5();
			List<LectureDTO> resultLecList = new ArrayList<LectureDTO>();;
			
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			if(userId != null) {
				resultLecList = manager.findLectureWithStatus(allLecList, userId);
			}
			
			request.setAttribute("resultLecList", resultLecList);
			request.setAttribute("hotLecList", hotLecList);
			request.setAttribute("lecList", allLecList);
			request.setAttribute("searchFailed", true);
			request.setAttribute("exception", e);
			return "/lecture/searchResult.jsp";
		}
	}
}
