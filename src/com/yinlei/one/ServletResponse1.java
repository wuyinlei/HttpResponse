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
		//�����ֽ����������
		String s = "�ҵĴ�ѧ������������Ϣ�Ľ�����";
		//response.getOutputStream().write(s.getBytes());  //������һ�������������������Ĭ�ϵ��ַ���(GBK)
		
		response.getOutputStream().write(s.getBytes("utf-8"));
		
		//���ϵ���һ��ָ���ַ����Ļ��������
		//�����������
		/**
		 * ��һ�ְ취�����û�����������ѡ���ַ�������(������)
		 * �ڶ��ַ�����֪ͨ���������������ʲô�����ʽ����ҲҪ��ȡĳ�ֱ���
		 */
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
