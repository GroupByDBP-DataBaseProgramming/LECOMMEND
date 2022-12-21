package controller.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.LectureDTO;
import model.service.LectureManager;

public class DeleteLectureController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String lecId = request.getParameter("lecId");
		LectureManager manager = LectureManager.getInstance();
		
		
		try { 
		if(manager.remove(lecId) > 0) {
			
			List<LectureDTO> lecList = manager.findLectureList();
			System.out.println(lecList);
			//request.setAttribute("lecture", lecList);
		}
		} catch(Exception e) {
			//request.setAttribute("e", o);
		}
		
		return "/user/mypage.jsp";
		
	}

}
