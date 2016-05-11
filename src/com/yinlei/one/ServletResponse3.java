package com.yinlei.one;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletResponse3 �����ļ����ļ�������
 */
@WebServlet("/ServletResponse3")
public class ServletResponse3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��һ������ȡ�ļ���·��
		String path = getServletContext().getRealPath("/WEB-INF/classes/��Ů.jpg");// Ĭ�ϴӹ���·����ʼ

		// ����������
		InputStream is = new FileInputStream(path);
		byte[] bs = new byte[1024];
		int b = 0;

		// �������������
		ServletOutputStream os = response.getOutputStream();

		// �����Ľ��б���
		// �õ����ĵ��ļ���    ע��  ��/��----->"\\"
		String name = path.substring(path.lastIndexOf("\\") + 1, path.length());
		System.out.println("����ǰ�Ľ����" + name);
		// �������ļ������б���
		name = URLEncoder.encode(name, "utf-8");
		System.out.println("�����Ľ����" + name);

		// ֪ͨ�����������صķ�ʽ�鿴
		response.setHeader("Content-Disposition", "attachment;filename=" + name);

		while ((b = is.read(bs)) != -1) {
			os.write(bs, 0, b);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
