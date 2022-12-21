package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.StudentDTO;
import model.service.UserManager;
public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	HttpSession loginSession = request.getSession();
		String updateId = UserSessionUtils.getLoginUserId(loginSession);

		UserManager manager = UserManager.getInstance();
		StudentDTO user = manager.findUser(updateId); // 수정하려는 사용자 정보 검색
		request.setAttribute("user", user);
    	
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		// 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
    		
    		request.setAttribute("major", user.getMajor());
    		log.debug("UpdateForm Request : {}", updateId);
    		
    		
			return "/user/updateForm.jsp"; 
	    }	
    	
    	// POST request (회원정보가 parameter로 전송됨)
    	StudentDTO updateUser = new StudentDTO(
       		user.getStuID(),
			request.getParameter("password"),
			request.getParameter("major"));

    	log.debug("Update User : {}", updateUser);

		manager.update(updateUser);			
        return "redirect:/user/mypage";			
    }
}