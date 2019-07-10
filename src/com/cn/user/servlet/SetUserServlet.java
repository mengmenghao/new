package com.cn.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.UserService;
import com.cn.vo.User;

/**
 * Servlet implementation class SetUserServlet
 */
@WebServlet("/SetUserServlet")
public class SetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");	
		UserService uService=new UserService();
		String id=request.getParameter("id");
		System.out.println(id);
		String type="0";
		User u = new User();
		u.setType(type);
		u.setId(Integer.parseInt(id));
		int i = uService.updateType(u);
		if(i>0) {
			List<User> list=uService.getAllUser("","");
			request.getSession().setAttribute("userlist",list);
		}
		response.sendRedirect("usermanagement.jsp");
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
