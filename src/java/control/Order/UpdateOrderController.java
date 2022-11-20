/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Order;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import entity.Account;
import entity.Order;
import entity.OrderDetail;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */

public class UpdateOrderController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter o = response.getWriter();
        String op = request.getParameter("op");
        int pID = Integer.parseInt(request.getParameter("pID"));
        int oID = Integer.parseInt(request.getParameter("oID"));
        //o.print(pid);
        OrderDao orderDao = new OrderDao();
        int quantity = orderDao.getProductQuantity(oID, pID);
        orderDao.updateOrder(pID, oID, quantity, op);
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        ArrayList<OrderDetail> listOrderDetail = orderDao.getOrderDetail(oID);
        ArrayList<OrderDetail> listOrderedDetail = orderDao.getOrderedtDetail(acc.getId());
        Order order = orderDao.getOrder(acc.getId());
        order.setDetail(listOrderDetail);
        response.sendRedirect("cart");
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
