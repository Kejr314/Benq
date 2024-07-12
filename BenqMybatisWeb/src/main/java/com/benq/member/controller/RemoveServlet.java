package com.benq.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.benq.member.service.MemberService;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/member/remove.kh")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String memberId = request.getParameter("memberId");
			// 세션에 있는 값과 같은지 체크 후 비즈니스 로직 진행
			HttpSession session = request.getSession();
			// 세션 Id 가져오기
			String sMemberId = (String)session.getAttribute("memberId");
			// sMemberId가 null이 아니거나 sMemberId가 memberId와 일치할 경우
			if(sMemberId != null && sMemberId.equals(memberId)){
				MemberService mService = new MemberService();
				int result = mService.deleteMember(memberId);
				if(result > 0) {
					response.sendRedirect("/member/logout.kh");
				} else {
					request.setAttribute("msg",  "존재하지 않는 정보입니다.");
					request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
				}
			}			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);

		}
	}

}