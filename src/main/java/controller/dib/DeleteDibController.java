package controller.dib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.DibManager;

public class DeleteDibController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String stuId = (String) session.getAttribute("userId");
		String lecId = request.getParameter("lecID");
		
		DibManager manager = DibManager.getInstance();
		manager.remove(stuId, lecId);
		
		if(request.getContextPath().equals("/lecture/searchResult")) //찜해제를 강의 검색결과창에서 했을때
			return "redirect:/lecture/searchResult"; //현재 mypage가 logoutcontroller로 매핑돼있으므로 수정필요
		else //찜해제를 마이페이지 에서 했을떄
			return "redirect:/user/mypage"; //논의)forward가 필요한지
		
				
	}

}