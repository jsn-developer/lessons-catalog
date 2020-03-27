package jp.co.solxyz.lessons.catalog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.catalog.business.GoodsService;
import jp.co.solxyz.lessons.catalog.entity.GoodsEntity;

public class ListServlet extends HttpServlet {

	/**
	 * Serial Versiion UID
	 */
	private static final long serialVersionUID = 4936832954865854271L;

	private static final String PATH = "/WEB-INF/jsp/list.jsp";

	/**
	 * Get Request
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<GoodsEntity> list;

		try {
			list = new GoodsService().getAllGoods();
		} catch (Exception e) {
			e.printStackTrace();

			list = new ArrayList<>();
		}
		
		req.setAttribute("list", list);

		// 遷移先を指定
		RequestDispatcher dispatcher = req.getRequestDispatcher(PATH);
		dispatcher.forward(req, resp);
	}

	/**
	 * Post Request
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}


}
