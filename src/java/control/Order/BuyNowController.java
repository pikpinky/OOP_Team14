/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Order;

import dao.OrderDao;
import entity.Account;
import entity.Order;
import entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */

public class BuyNowController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String pID = request.getParameter("pID");
        OrderDao orderDao = new OrderDao();
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        if(orderDao.checkOrder(acc.getId()) == true){
            Order order = orderDao.getOrder(acc.getId());
            orderDao.updateOrder1(order.getoID());
        }
        orderDao.addOrder(acc.getId(), acc.getAddress());
        Order order = orderDao.getOrder(acc.getId());
        orderDao.addOrderDetail(1, order.getoID(), Integer.parseInt(pID));
        ArrayList<OrderDetail> listOrderDetail = orderDao.getOrderDetail(order.getoID());
        order.setDetail(listOrderDetail);
//        PrintWriter o = response.getWriter();
//        o.print(orderdetail);
        request.setAttribute("listOrderDetail", listOrderDetail);
        request.setAttribute("money", order.getMoney());
        request.setAttribute("oID", order.getoID());
        request.setAttribute("address", acc.getAddress());
        request.setAttribute("buynow", 1);
        request.setAttribute("pID", pID);
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
