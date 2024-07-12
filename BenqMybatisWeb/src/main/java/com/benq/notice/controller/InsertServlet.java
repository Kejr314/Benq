package com.benq.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.benq.notice.model.vo.Notice;
import com.benq.notice.service.NoticeService;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/notice/insert.kh")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String subject = request.getParameter("noticeSubject");
			String content = request.getParameter("noticeContent");
			String writer  = (String)session.getAttribute("memberId");
			
			Notice notice = new Notice(subject, content, writer);
			NoticeService nService = new NoticeService();
			int result = nService.insertNotice(notice);
			if(result > 0) {
				response.sendRedirect("/");
			} else {
				request.setAttribute("msg", "공지사항 등록이 완료되지 않았습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}
}
