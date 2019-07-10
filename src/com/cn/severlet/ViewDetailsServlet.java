package com.cn.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.NewsService;
import com.cn.vo.News;

/**
 * Servlet implementation class ViewDetailsServlet
 */
@WebServlet("/ViewDetailsServlet")
public class ViewDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		NewsService selet =new NewsService();
		News news=selet.getview(Integer.parseInt(id));
		request.getSession().setAttribute("news",news);
		response.sendRedirect("viewdetails.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id=request.getParameter("id");
		/*
		 * NewsService selet =new NewsService(); List<News>
		 * list=selet.getAllNews("","");
		 * 
		 * request.getSession().setAttribute("newslist",list);
		 * response.sendRedirect("viewdetails.jsp");
		 */	}

}
