package controller.status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.StatusManager;

public class DeleteStatusController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			HttpSession session = request.getSession();
			String stuId = (String) session.getAttribute("userId");
			String lecId = request.getParameter("lecID");

			StatusManager manager = StatusManager.getInstance();
			//manager.delete(stuId, lecId);

		} catch (Exception e) {

			request.setAttribute("deleteStatusFailed", true);
			request.setAttribute("exception", e);
		}
		return "redirect:/lecture/searchResult";
	}

}
