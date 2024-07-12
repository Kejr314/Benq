package com.benq.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.benq.notice.model.vo.Notice;
import com.benq.notice.service.NoticeService;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/notice/list.kh")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService nService = new NoticeService();
		List<Notice> nList = nService.selectAllNotice();
		// if(nList.size() > 0)
		// if(!nList.isEmpty())
		if(nList != null) {
			// list.jsp로 이동
			request.setAttribute("nList", nList);
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
		} else {
			// error.jsp로 이동
			request.setAttribute("msg", "존재하지 않는 정보입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
