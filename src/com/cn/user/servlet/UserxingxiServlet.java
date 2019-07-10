package com.cn.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.UserService;
import com.cn.vo.User;

/**
 * Servlet implementation class Userxingxi
 */
@WebServlet("/UserxingxiServlet")
public class UserxingxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserxingxiServlet() {
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
		User user=(User)request.getSession().getAttribute("user");
		String name=request.getParameter("username");
		String pass=request.getParameter("pass");
		String sex=request.getParameter("sex");
		String profession=request.getParameter("profession");
		String note=request.getParameter("note");
		String favourite=request.getParameter("favourite");
		//User  user=new User();
		user.setUsername(name);
		user.setPassword(pass);
		user.setSex(sex);
		user.setFavourite(favourite);
		user.setProfession(profession);
		user.setNote(note);
		UserService  userService=new UserService();
		int i=userService.userupdate(user);
		if(i>0) {
			UserService selet =new UserService();
			user=selet.seleteUser(user.getId());
			request.getSession().setAttribute("user",user);
			response.sendRedirect("user.jsp");
		}else {
			response.sendRedirect("user.jsp");
		}
		
	}

}
