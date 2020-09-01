package web_study_09.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_study_09.dto.Member;
import web_study_09.service.LoginService;


@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService service = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String url = "member/login.jsp";
	    
	    if (request.getMethod().equalsIgnoreCase("get")) {
	        request.getRequestDispatcher(url).forward(request, response);
	    }else {
	    
    	    String userId = request.getParameter("userId");
    	    String pwd = request.getParameter("pwd");
    	    System.out.println("userId " + userId + " pwd " + pwd);
    	    
    	    Member findMember = new Member(userId);
    	    Member resMember = service.getMember(findMember);
    	    
    	    if (resMember == null) {
    	        request.setAttribute("message", "존재하지 않는 회원입니다");
    	    }else {
    	        if (pwd.equals(resMember.getPwd())) {
    	            HttpSession session = request.getSession();
    	            session.setAttribute("loginUser", resMember);
//    	            session.setMaxInactiveInterval(60*60);
    	            request.setAttribute("message", "회원 가입에 성공했습니다");
    	            url = "main.jsp";
    	        }else {
    	            request.setAttribute("message", "비밀번호가 맞지 않습니다.");
    	        }
    	    }
    	    request.getRequestDispatcher(url).forward(request, response);
	    }
    }
}







