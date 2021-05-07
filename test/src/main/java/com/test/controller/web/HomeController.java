package com.test.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.UserModel;
import com.test.service.ICategoryService;
import com.test.service.IUserService;
import com.test.utils.FormUtil;
import com.test.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/home", "/login", "/logout" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -4207271560723623064L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private IUserService userService;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, respone);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			respone.sendRedirect(request.getContextPath() + "/trang-chu");
		} else {
			request.setAttribute("categories", categoryService.findAll());
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, respone);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if (model != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				if (model.getRole().getCode().equals("USER")) {
					respone.sendRedirect(request.getContextPath() + "/home");
				} else if (model.getRole().getCode().equals("ADMIN")) {
					respone.sendRedirect(request.getContextPath() + "/admin");
				}
			} else {
				respone.sendRedirect(request.getContextPath()
						+ "/login?action=login&message=username_password_invalid&alert=danger");
			}
		}
	}
}
