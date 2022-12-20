package controller.dib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.DibManager;

public class DeleteDibController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String stuId = request.getParameter("stuID");
		String lecId = request.getParameter("lecID");
		
		try {
			DibManager manager = DibManager.getInstance();
			manager.remove(stuId, lecId);
		} catch (Exception e) {
			//논의 : dib 해제 오류를 꼭 지정해야하는지?
			request.setAttribute("exception", e);
		}
		if(request.getContextPath().equals("/lecture/searchResult")) //찜해제를 강의 검색결과창에서 했을때
			return "redirect:/user/mypage"; //현재 mypage가 logoutcontroller로 매핑돼있으므로 수정필요
		else //찜해제를 마이페이지 에서 했을떄
			return "forward:/user/mypage"; //논의)forward가 필요한지
		
				
	}

}