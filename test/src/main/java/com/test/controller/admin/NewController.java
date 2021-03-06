package com.test.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.constant.SystemConstant;
import com.test.model.NewModel;
import com.test.paging.PageRequest;
import com.test.paging.Pageble;
import com.test.service.ICategoryService;
import com.test.service.INewService;
import com.test.sort.Sorter;
import com.test.utils.FormUtil;
import com.test.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-news" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = -4207271560723623064L;

	@Inject
	private INewService newService;

	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		NewModel model = FormUtil.toModel(NewModel.class, request);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newService.findAll(pageble));
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/news/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = newService.findOne(model.getId());
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/news/edit.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, respone);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {

	}
}
