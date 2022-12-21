package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.StudentDTO;
import model.service.UserManager;

public class myPageController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(myPageController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession loginSession = request.getSession();
		String updateId = UserSessionUtils.getLoginUserId(loginSession);
		if(updateId == null) {
			log.debug("updateId : {}", updateId);
			return "redirect:/user/login/form";
		}

		UserManager manager = UserManager.getInstance();
		StudentDTO user = manager.findUser(updateId); // 수정하려는 사용자 정보 검색
		request.setAttribute("user", user);
		request.setAttribute("major", user.getMajor());
		
		request.setAttribute("dibList", loginSession);

		return "/user/mypage.jsp";
	}
}
