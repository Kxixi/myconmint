package com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.servuce.loginservice;

/**
 * test
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String name = null;
		String pwd = null;
		name = request.getParameter("name");
		pwd = request.getParameter("pwd");
		User user = new User();
		user.setUsername(name);
		user.setPwd(pwd);
		loginservice loginservice = new loginservice();
		try {
			List list = loginservice.login(user);
			if(!list.isEmpty()) {
				System.out.println("�ɹ�");
				request.getSession().setAttribute("name", name);
				response.sendRedirect(contextPath+"/index.jsp");
			}else {
				request.setAttribute("erro", "�˺Ż��������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��½ʧ��");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
