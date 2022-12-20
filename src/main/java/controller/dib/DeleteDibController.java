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
			//논의 : 찜해제 성공 후 redirect 할 곳이 없음
		} catch (Exception e) {
			//논의 : existingDib을 만들면 catch에 적용가능하지만 굳이 필요한가?
			request.setAttribute("exception", e);
		}
		return ""; //찜한 장소 그대로 있을 것 인지?		
		//논의 : 찜을 강의 검색과 마이페이지 둘 다에서 할 수 있는데, 그렇다면 찜을 하고나서 forward 할 것인지 아니면 해당 페이지에 머무를 것 인지?
				
	}

}