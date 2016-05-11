package com.yinlei.one;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.regexp.internal.REDebugCompiler;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * Servlet implementation class ServletResponse4 �����֤��
 */
@WebServlet("/ServletResponse4")
public class ServletResponse4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		drawImage(response);

	}

	private void drawImage(HttpServletResponse response) {
		// ��������---->ͼƬ�Ŀ��͸�
		int width = 200;
		int height = 30;
		// ����һ���ڴ�ͼ��
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// ��������
		Graphics graphics = image.getGraphics();
		// ָ���߿���ɫ
		graphics.setColor(Color.red);
		// ��ͼ��ı߿�
		graphics.drawRect(0, 0, width, height);
		// �����εı���ɫ
		// �趨���ʵ���ɫ
		graphics.setColor(Color.yellow);
		// �����εı���
		graphics.fillRect(1, 1, width - 2, height - 2);

		// ���������С
		graphics.setFont(new Font("��Բ", Font.BOLD + Font.ITALIC, 24));

		Random r = new Random();
		// �趨���ʵ���ɫ
		graphics.setColor(Color.blue);
		//
		String s = "������ӭ�����֪��hellobeijing";
		// �Ƚ�����ת��Ϊunicode����

		s = "\u5317\u4EAC\u6B22\u8FCE\u4F60\u4F60\u53EF\u77E5\u9053hellobeijing";
		for (int i = 0; i < 4; i++) {
			char c = s.charAt(r.nextInt(s.length()));
			//����  1   -1
			int flag = r.nextBoolean() ? 1 : -1;
			//���������������
			graphics.drawString(c + "", 20 + 40 * i + flag * r.nextInt(10), 20 + flag * r.nextInt(5));
		}

		// �������4������

		/*
		 * // �������4�����������ҳ�� for (int i = 0; i < 4; i++) { int n = r.nextInt(10);
		 * // 10���ڵ����� // ����ͼ���� graphics.drawString(n + "", 20 + 40 * i, 20); }
		 */

		// ��ͼƬ������ͻ���
		try {
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}