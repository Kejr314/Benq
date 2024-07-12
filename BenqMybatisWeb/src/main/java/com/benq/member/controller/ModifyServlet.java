package com.benq.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.benq.member.model.vo.Member;
import com.benq.member.service.MemberService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update.kh")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String memberId 	= request.getParameter("memberId");
			String email 		= request.getParameter("email");
			String phone 		= request.getParameter("phone");
			String address 		= request.getParameter("address");
			String hobby 		= request.getParameter("hobby");
			
			// Member에 생성자 만들기
			Member member = new Member(memberId, email, phone, address, hobby);
			MemberService mService = new MemberService();
			int result = mService.updateMember(member);
			if(result > 0) {
				// 마이페이지로 이동
				// 메인페이지로 이동
				response.sendRedirect("/");
			}else {
				request.setAttribute("msg",  "회원 정보 수정이 완료되지 않았습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
