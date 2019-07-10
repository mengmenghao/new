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
 * Servlet implementation class PasswordUserServlet
 */
@WebServlet("/PasswordUserServlet")
public class PasswordUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordUserServlet() {
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
		
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		User user=(User)request.getSession().getAttribute("user");
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		String a=user.getPassword();
		//PrintWriter pw=response.getWriter();
		if(password.equals(a)) {
			UserService  userService=new UserService();
			int i=userService.updatepass(user.getId(), password2);
			if(i>0) {
				response.sendRedirect("changepassword.jsp");
				//pw.write("success2");
				System.out.println("³É¹¦");
			}else {
				response.sendRedirect("changepassword.jsp");
				//pw.write("fail1");
				System.out.println("Ê§°Ü");
			}
			//pw.write("success");
			
		}else {
			//pw.write("fail");
		}
		
	}

}
