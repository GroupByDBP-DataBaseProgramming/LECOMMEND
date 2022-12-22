package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.LectureDTO;
import model.service.LectureManager;

public class UpdateLectureController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				


			
			
			LectureManager manager = LectureManager.getInstance();
			
			LectureDTO updateLec;
			
			manager.update(updateLec);
		

		return null;
	}

}
