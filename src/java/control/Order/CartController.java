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
import entity.*;
import dao.*;
import java.util.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */

public class CartController extends HttpServlet {

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
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        OrderDao orderDao = new OrderDao();
        Order order = null;
        if(orderDao.checkOrder1(acc.getId())){
            orderDao.updateOrder2(acc.getId());
            order = orderDao.getOrder(acc.getId());
        }
        else if(orderDao.checkOrder(acc.getId())){
            order = orderDao.getOrder(acc.getId());
        }
        else{
            orderDao.addOrder(acc.getId(), acc.getAddress());
            order = orderDao.getOrder(acc.getId());
        }
        ArrayList<OrderDetail> listOrderDetail = orderDao.getOrderDetail(order.getoID());
        ArrayList<OrderDetail> listOrderedDetail = orderDao.getOrderedtDetail(acc.getId());
        if(listOrderedDetail.size() == 0)
            listOrderedDetail = null;
        order.setDetail(listOrderDetail);
//        PrintWriter p = response.getWriter();
//        p.print(listOrderDetail);
        request.setAttribute("listOrderDetail", listOrderDetail);
        request.setAttribute("listOrderedDetail", listOrderedDetail);
        request.setAttribute("money", order.getMoney());
        request.setAttribute("oID", order.getoID());
        request.setAttribute("address", acc.getAddress());
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
