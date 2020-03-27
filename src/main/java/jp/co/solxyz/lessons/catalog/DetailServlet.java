package jp.co.solxyz.lessons.catalog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.catalog.business.GoodsService;

public class DetailServlet extends HttpServlet {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -5264898238107205105L;

    private static final String PATH = "/WEB-INF/jsp/detail.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        req.setAttribute("id", id);
        
        try {
            var goods = new GoodsService().getGoodsFromId(id);

            goods.ifPresent(item -> {
                req.setAttribute("name", item.getName());
                req.setAttribute("description", item.getDescription());
                req.setAttribute("price", item.getPrice());
            });

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("list");
            return;
        }

        var dispatcher = req.getRequestDispatcher(PATH);
        dispatcher.forward(req, resp);
    }
    
}
