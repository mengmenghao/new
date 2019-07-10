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
 * Servlet implementation class UpdateUser
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserServlet() {
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
		String qu=request.getParameter("query");
		String []checkbox=request.getParameterValues("checkbox");
		//System.out.println(sex);
		//System.out.println(checkbox.toString());
		String xuz="";
		if(checkbox==null) {
			xuz="012";
		}else {
			for(int i=0;i<checkbox.length;i++){
				xuz=xuz+checkbox[i];
			}
		}
		System.out.println(qu);
		System.out.println(xuz);
		UserService userserciService=new UserService();
		List<User> list=userserciService.getAllUser(xuz,qu);
		request.getSession().setAttribute("userlist",list);
		response.sendRedirect("usermanagement.jsp");
		
	}

}
