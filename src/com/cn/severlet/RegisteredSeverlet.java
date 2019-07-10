package com.cn.severlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.UserService;
import com.cn.vo.User;

/**
 * Servlet implementation class RegisteredSeverlet
 */
@WebServlet("/RegisteredSeverlet")
public class RegisteredSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisteredSeverlet() {
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
		String name=request.getParameter("username");
		String pass=request.getParameter("pass");
		String sex=request.getParameter("sex");
		String profession=request.getParameter("profession");
		String note=request.getParameter("note");
		String []favourite=request.getParameterValues("favourite");
		//System.out.println(sex);
		//System.out.print(favourite.toString());
		String aihao="";
		/*if(favourite!=null) {*/
			for(int i=0;i<favourite.length;i++){
				aihao=aihao+favourite[i]+",";
			}
			User  user=new User();
			user.setUsername(name);
			user.setPassword(pass);
			user.setSex(sex);
			user.setFavourite(aihao);
			user.setProfession(profession);
			user.setNote(note);
		
			UserService  userService=new UserService();
			int i=userService.addUser(user);
			
			if(i>0) {
				response.sendRedirect("Login.jsp");
			}else {
				response.sendRedirect("register.jsp");
			}
		/*
		 * }else { response.sendRedirect("register.jsp"); }
		 */
	}
	

}
