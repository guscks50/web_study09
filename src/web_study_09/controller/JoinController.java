package web_study_09.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_study_09.dto.Member;
import web_study_09.service.JoinService;

@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JoinService service= new JoinService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

   private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       if (request.getMethod().equalsIgnoreCase("get")) {
           request.getRequestDispatcher("member/join.jsp").forward(request, response);
       }else {
           Member member = getMember(request);
           int res = service.insertMember(member);
           
           HttpSession session = request.getSession();
           if (res == 1) {
               session.setAttribute("userId", member.getUserId());
               request.setAttribute("message", "회원 가입에 성공했습니다.");
           }else {
               request.setAttribute("message", "회원 가입에 실패했습니다.");
           }
           
           request.getRequestDispatcher("member/login.jsp").forward(request, response);
       }
    }

    private Member getMember(HttpServletRequest request) {
        String name = request.getParameter("name");
        String userId = request.getParameter("userId");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int admin = Integer.parseInt(request.getParameter("admin"));
        return new Member(name, userId, pwd, email, phone, admin);
    }
}
