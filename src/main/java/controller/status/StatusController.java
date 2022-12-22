package controller.status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.StatusManager;

public class StatusController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			HttpSession session = request.getSession();
			String stuId = (String) session.getAttribute("userId");
			String lecId = request.getParameter("statusId");
			
			StatusManager manager = StatusManager.getInstance();
			
			int statusCnt = manager.existingStatus(stuId, lecId);
			
			System.out.println("lecId: "+ lecId +" cnt: "+statusCnt);
			
			if(statusCnt == 0) 
				manager.create(statusCnt, stuId, lecId);
			else 
				manager.delete(statusCnt, stuId, lecId);
			
		} catch (Exception e) {

			request.setAttribute("deleteStatusFailed", true);
			request.setAttribute("exception", e);
		}
		return "redirect:/lecture/searchResult";
	}

}
