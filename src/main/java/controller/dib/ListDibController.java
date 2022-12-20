package controller.dib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.DibManager;
import model.dto.LectureDTO;

public class ListDibController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//찜 목록은 마이페이지에서 볼 수 있는데, 마이페이지는 로그인을 먼저해야 접속 가능하므로 굳이 hasLogin을 써야하나?		
		DibManager manager = DibManager.getInstance();
		
		String stuID = request.getParameter("stuID");
		List<LectureDTO> dibList = manager.listOfDibs(stuID);

		// dibList를 request에 저장하여 전달
		request.setAttribute("dibList", dibList);				

		return "/lecture/dibList.jsp";      
		
	}

}