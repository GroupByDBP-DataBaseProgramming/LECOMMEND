package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.LectureDTO;
import model.dto.StudentDTO;
import model.service.DibManager;
import model.service.UserManager;

public class myPageController implements Controller {

    @Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession loginSession = request.getSession();
		String updateId = UserSessionUtils.getLoginUserId(loginSession);

		UserManager manager = UserManager.getInstance();
		StudentDTO user = manager.findUser(updateId); // 수정하려는 사용자 정보 검색
		request.setAttribute("user", user);
		request.setAttribute("major", user.getMajor());
		
		//아래부터 찜 목록 관련 코드
		request.setAttribute("userID", updateId);
		DibManager dManager = DibManager.getInstance();
		
		List<LectureDTO> dibList = dManager.listOfDibs(updateId);
		if(dibList.isEmpty())
			request.setAttribute("searchFailed", true);
		request.setAttribute("dibList", dibList);   	

		return "/user/mypage.jsp";
	}
}
