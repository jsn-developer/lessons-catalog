package jp.co.solxyz.lessons.catalog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailServlet extends HttpServlet{

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -5264898238107205105L;

    private static final String PATH = "/WEB-INF/jsp/detail.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        var dispatcher = req.getRequestDispatcher(PATH);
        dispatcher.forward(req, resp);
    }
    
}
