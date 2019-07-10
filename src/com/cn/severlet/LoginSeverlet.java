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
 * Servlet implementation class LoginSeverlet
 */
@WebServlet("/LoginSeverlet")
public class LoginSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSeverlet() {
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
		String  user=request.getParameter("user");
		String  pass=request.getParameter("pass");
		String  type=request.getParameter("type");
		System.out.println(type);
		UserService  userService=new UserService();
		User u=userService.login(user, pass, type);
		if(u!=null) {
			request.getSession().setAttribute("user",u);
			response.sendRedirect("index.jsp");
		}else {
			
			response.sendRedirect("Login.jsp");
		}
	}

}
