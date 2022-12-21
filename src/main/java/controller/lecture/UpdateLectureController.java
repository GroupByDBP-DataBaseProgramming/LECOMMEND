package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.LectureDTO;
import model.service.LectureManager;

public class UpdateLectureController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		if (request.getMethod().equals("GET")) {
			
			
			String lecId = request.getParameter("lecId");
			LectureManager manager = LectureManager.getInstance();
			
			return "/user/lecUpdate"; // 강의 수정 페이지로 이동
			
				
			
		}
		
		/*LectureDTO updateLec = new LectureDTO(
					request.getParameter("title"),
					request.getParameter("professor"),
					request.getParameter("loc"),
					request.getParameter("week"),
					request.getParameter("lectime"),
					request.getParameter("occupancy"),
					request.getParameter("credit"),
					request.getParameter("onOff"),
					request.getParameter("cNo"),
					request.getParameter("lecType"),
					request.getParameter("interest"),
					request.getParameter("examType"));
			
			manager.update(updateLec);
			return // admin page에 강의 리스트 보여주는 곳으로 이동
		 */	
		
		
		return null;
	}

}
