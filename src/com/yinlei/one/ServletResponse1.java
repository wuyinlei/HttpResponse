package com.yinlei.one;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletResponse1
 */
@WebServlet("/ServletResponse1")
public class ServletResponse1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//采用字节流输出数据
		String s = "我的大学就这样悄无声息的结束了";
		//response.getOutputStream().write(s.getBytes());  //上面那一句是正常的中文输出，默认的字符集(GBK)
		
		response.getOutputStream().write(s.getBytes("utf-8"));
		
		//以上的这一个指定字符集的会出现乱码
		//解决乱码问题
		/**
		 * 第一种办法：让用户在游览器中选择字符集编码(不考虑)
		 * 第二种方法：通知游览器，我这边是什么编码格式，你也要采取某种编码
		 */
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
