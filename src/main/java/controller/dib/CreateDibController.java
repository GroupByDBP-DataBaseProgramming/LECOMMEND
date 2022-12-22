package controller.dib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.DibManager;

public class CreateDibController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String stuId = (String) session.getAttribute("userId");
		String lecId = request.getParameter("lecID");
		
		try {
			DibManager manager = DibManager.getInstance();
			int duplicated = 0, rslt = 1; //rslt이 negative 값
			
			if(!stuId.equals(null))
				duplicated = manager.duplicationCheck(stuId, lecId);						
			if(duplicated == 1)
				rslt = manager.create(stuId, lecId);
		} catch (Exception e) {
			//논의 : existingDib을 만들면 catch에 적용가능하지만 굳이 필요한가?
			request.setAttribute("exception", e);
		}
		return "redirect:/lecture/searchResult";
	}
}