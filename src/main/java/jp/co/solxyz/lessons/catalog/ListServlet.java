package jp.co.solxyz.lessons.catalog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet{

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
