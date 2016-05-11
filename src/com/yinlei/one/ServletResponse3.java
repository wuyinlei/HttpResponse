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
 * Servlet implementation class ServletResponse3 中文文件名文件的下载
 */
@WebServlet("/ServletResponse3")
public class ServletResponse3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 第一步：获取文件的路径
		String path = getServletContext().getRealPath("/WEB-INF/classes/美女.jpg");// 默认从工程路径开始

		// 创建输入流
		InputStream is = new FileInputStream(path);
		byte[] bs = new byte[1024];
		int b = 0;

		// 创建输出流对象
		ServletOutputStream os = response.getOutputStream();

		// 对中文进行编码
		// 拿到中文的文件名    注意  “/”----->"\\"
		String name = path.substring(path.lastIndexOf("\\") + 1, path.length());
		System.out.println("编码前的结果：" + name);
		// 对中文文件名进行编码
		name = URLEncoder.encode(name, "utf-8");
		System.out.println("编码后的结果：" + name);

		// 通知游览器以下载的方式查看
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
