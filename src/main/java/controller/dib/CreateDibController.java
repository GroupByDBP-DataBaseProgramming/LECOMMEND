package controller.dib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.DibManager;

public class CreateDibController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get/post 구분 꼭 해야하는지?
		String stuId = request.getParameter("stuID");
		String lecId = request.getParameter("lecID");
		
		try {
			DibManager manager = DibManager.getInstance();
			manager.create(stuId, lecId);
			//논의 : 찜 성공 후 redirect 할 곳이 없음
		} catch (Exception e) {
			//논의 : existingDib을 만들면 catch에 적용가능하지만 굳이 필요한가?
			request.setAttribute("exception", e);
		}
		return "";
	}		

}