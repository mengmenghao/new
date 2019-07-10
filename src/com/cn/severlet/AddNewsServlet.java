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
import com.cn.vo.User;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
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
		
		User user=(User)request.getSession().getAttribute("user");
		
		SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dt=simpleDateFormat.format(new Date());
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(user.getId());
		
		News  news=new News();
		news.setUserid(user.getId());
		news.setContent(content);
		news.setPubtime(dt);
		news.setTitle(title);
		//PrintWriter out=response.getWriter();
		if(!news.getTitle().equals("")&&!news.getContent().equals("")) {
			NewsService nService=new NewsService();
			int i=nService.AddNews(news);
			//PrintWriter out=response.getWriter();
			if(i>0) {
				List<News> list=nService.getAllNews("","");
				request.getSession().setAttribute("newslist",list);
				response.sendRedirect("newsManager.jsp");
				
			}else {
				response.sendRedirect("addNews.jsp");
				System.out.println("Ê§°Ü");
			}
		}else {
			response.sendRedirect("addNews.jsp");
			System.out.println("Ê§°Ü");
		}
		
	}

}
