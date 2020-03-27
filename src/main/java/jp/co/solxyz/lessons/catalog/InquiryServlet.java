package jp.co.solxyz.lessons.catalog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.catalog.business.InquiryService;
import jp.co.solxyz.lessons.catalog.entity.InquiryEntity;

public class InquiryServlet extends HttpServlet {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -6822491690170557101L;

    private static final String PATH = "/WEB-INF/jsp/inquiry.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        {
            req.setAttribute("id", req.getParameter("id"));
            req.setAttribute("name", "");
            req.setAttribute("company", "");
            req.setAttribute("contact", "");
            req.setAttribute("check", false);
        }

        req.getRequestDispatcher(PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 送信データの保存
        String goodsid = req.getParameter("id");
        String name = req.getParameter("name");
        String company = req.getParameter("company");
        String contact = req.getParameter("contact");

        {
            req.setAttribute("id", goodsid);
            req.setAttribute("name", name);
            req.setAttribute("company", company);
            req.setAttribute("contact", contact);
            req.setAttribute("check", true);
        }

        // Validation(if needed)
        StringBuilder sb = new StringBuilder();

        if (name == null || name.isEmpty()) {
            sb.append("お名前をご記入してください。<br>");
        } 
        if (company == null || company.isEmpty()) {
            company = null;
        } 
        
        if (contact == null || contact.isEmpty()) {
            sb.append("連絡先を記入してください。<br>");
        }

        // エラーがあればおわり。
        if(sb.length() > 0) {
            req.setAttribute("message", sb.toString());
            req.getRequestDispatcher(PATH).forward(req, resp);
            return;
        }

        InquiryEntity e = new InquiryEntity();

        e.setName(name);
        e.setCompany(company);

        if (contact.matches("0\\d{1,4}-\\d{1,4}-\\d{4}")) {
            // 電話番号
            e.setPhone(contact);
        } else if (contact.matches("^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
            // メールアドレス
            e.setMail(contact);
        } else {
            // どうするか
        }

        InquiryService service = new InquiryService();
        try {
            var result = service.registerInquiry(e);

            if (result > 0) {
                // 成功 -> Redirect to list
                resp.sendRedirect("list");
                
            } else {
                var dispatcher = req.getRequestDispatcher(PATH);

                req.setAttribute("message", "登録に失敗しました。再度おためしください。");

                dispatcher.forward(req, resp);
            }

        } catch (Exception e1) {
            e1.printStackTrace();

            // 返却
            var dispatcher = req.getRequestDispatcher(PATH);

            // エラー内容を表示
            req.setAttribute("message", "登録に失敗しました。再度おためしください。");


            dispatcher.forward(req, resp);
        }

        

    }
}
