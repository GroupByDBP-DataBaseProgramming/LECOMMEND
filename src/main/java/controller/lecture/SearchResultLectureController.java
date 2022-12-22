package controller.lecture;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dto.LectureDTO;
import model.service.DibManager;
import model.service.LectureManager;

public class SearchResultLectureController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			LectureManager manager = LectureManager.getInstance();
			DibManager dMan = DibManager.getInstance();

			HttpSession session = request.getSession();
			String stuId = (String) session.getAttribute("userId");		
			session.setAttribute("stuId", stuId);
			
			List<LectureDTO> hotLecList = manager.findLecturesTop5();
			List<LectureDTO> lecList = new ArrayList<LectureDTO>();
			List<String> dibList = dMan.listOfDibsID(stuId);
			request.setAttribute("dibList", dibList);
			
			if (request.getParameter("priority").equals("p1")) {
				lecList = manager.findLectureByKeywordWithLoc(request.getParameter("loc").substring(0, 1),
						request.getParameter("week"), request.getParameter("lecTime").substring(0, 1),
						Integer.parseInt(request.getParameter("occupancy")),
						Integer.parseInt(request.getParameter("credit")), request.getParameter("onOff"),
						request.getParameter("lecType"), request.getParameter("interest"),
						request.getParameter("examType"));
			} else if (request.getParameter("priority").equals("p2")) {
				lecList = manager.findLectureByKeywordWithLecType(request.getParameter("loc").substring(0, 1),
						request.getParameter("week"), request.getParameter("lecTime").substring(0, 1),
						Integer.parseInt(request.getParameter("occupancy")),
						Integer.parseInt(request.getParameter("credit")), request.getParameter("onOff"),
						request.getParameter("lecType"), request.getParameter("interest"),
						request.getParameter("examType"));
			} else if (request.getParameter("priority").equals("p3")) {
				lecList = manager.findLectureByKeywordWithLecTime(request.getParameter("loc").substring(0, 1),
						request.getParameter("week"), request.getParameter("lecTime").substring(0, 1),
						Integer.parseInt(request.getParameter("occupancy")),
						Integer.parseInt(request.getParameter("credit")), request.getParameter("onOff"),
						request.getParameter("lecType"), request.getParameter("interest"),
						request.getParameter("examType"));
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
			
			
			return "/lecture/searchResult.jsp";
		} catch (Exception e) {

			LectureManager manager = LectureManager.getInstance();

			List<LectureDTO> allLecList = manager.findLectureList();
			List<LectureDTO> hotLecList = manager.findLecturesTop5();
			
			request.setAttribute("hotLecList", hotLecList);
			request.setAttribute("lecList", allLecList);
			request.setAttribute("searchFailed", true);
			request.setAttribute("exception", e);
			return "/lecture/searchResult.jsp";
		}
	}
}
