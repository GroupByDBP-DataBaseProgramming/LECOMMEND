package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.StudentDTO;
import model.service.UserManager;

public class ShowAllStudentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserManager manager = UserManager.getInstance();
		List<StudentDTO> studentList = manager.showAllStudent();
	
		request.setAttribute("studentList", studentList);
		
		return "/user/mypage/stuList";
	}

	
	
}
