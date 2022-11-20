/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.product;

import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import entity.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        String key = request.getParameter("key");
        ProductDao dao = new ProductDao();
        int amount = dao.getAmountOfKeyProduct(key);
        int endPage = amount / 3;
        if(amount % 3 != 0)
            endPage++;
        String page = request.getParameter("page");
        if(page == null)
            page = "1";
        ArrayList<Product> listOfP = dao.getProducByKey(key, Integer.parseInt(page));
        ArrayList<Category> listOfC = dao.getAllCategory();
        request.setAttribute("listOfP", listOfP);
        request.setAttribute("listOfC", listOfC);
        request.setAttribute("endPage", endPage);
        request.setAttribute("key", key);
        request.setAttribute("keyValue", key);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
//        PrintWriter o = response.getWriter();
//        for(int i = 0; i < listOfP.size(); i++){
//            o.print(listOfP.get(i));
//        }
        //o.print(listOfP.size() + "\n");
        //o.print(request.getParameter("key"));
        //o.print(amount);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
