package controller.lecture;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.dto.LectureDTO;
import model.dto.StudentDTO;
import model.service.LectureManager;
import model.service.UserManager;

public class LectureController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	LectureManager manager = LectureManager.getInstance();
    	List<LectureDTO> lecList = manager.findLectureList();
    	
    	
    	UserManager userManager = UserManager.getInstance();
    	List<StudentDTO> stuList = userManager.showAllStudent();
    	
    	
    	request.setAttribute("stuList", stuList);
    	request.setAttribute("lecList", lecList);
    	
		//List<Community> commList = manager.findCommunityList();
		
		// commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
		//request.setAttribute("commList", commList);				
		return "/user/mypage.jsp";        
    }
}



