package com.yinlei.one;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletResponse5 定时刷新网页
 */
@WebServlet("/ServletResponse5")
public class ServletResponse5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 每隔2秒刷新自己
		//response.setHeader("Refresh", "2");
		//response.getWriter().write("aa" + new Random().nextInt());
		
		// 每隔2秒刷新到其他资源
		response.setHeader("Refresh", "2;url=/HttpResponse/ServletResponse4");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
