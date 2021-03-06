package com.test.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -4207271560723623064L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(request, respone);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {

	}
}
