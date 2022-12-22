package controller.dib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.DibManager;
import model.dto.LectureDTO;

public class ListDibController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			DibManager manager = DibManager.getInstance();
			
			HttpSession session = request.getSession();
			String userId = (String)session.getAttribute("userId");
	
			//String stuID = request.getParameter("userId");
			List<LectureDTO> dibList = manager.listOfDibs("test1");
	
			// dibList를 request에 저장하여 전달
			request.setAttribute("dibList", dibList);
			request.setAttribute("userID", userId);			
		} catch (Exception e) {
			request.setAttribute("searchFailed", true);
		}

		return "/user/dibList.jsp";      
		
	}

}