package com.cn.severlet;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.NewsService;
import com.cn.vo.News;

/**
 * Servlet implementation class UpdateNewsServlet
 */
@WebServlet("/UpdateNewsServlet")
public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String id=request.getParameter("id");
		
		SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String d=simpleDateFormat.format(new Date());
		
		News  news=new News();		
		news.setContent(content);
		news.setPubtime(d);
		news.setTitle(title);
		news.setId(Integer.parseInt(id));
		
		NewsService newsService=new NewsService();
		int i=newsService.updateNews(news);	
		//PrintWriter up=response.getWriter();
		if(i>0) {
			List<News> list=newsService.getAllNews("","");
			request.getSession().setAttribute("newslist",list);
			//up.write("success");
		} /*
			 * else { up.write("fail"); }
			 */
		/*
		 * up.flush(); up.close();
		 */
		response.sendRedirect("newsManager.jsp");
		
	}


}
