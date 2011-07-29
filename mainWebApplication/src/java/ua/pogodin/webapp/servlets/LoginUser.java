/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.pogodin.webapp.dao.DataBaseConnector;
import ua.pogodin.webapp.domain.User;

/**
 *
 * @author elias
 */
@WebServlet(name = "LoginUser", urlPatterns = {"/loginuser"})
public class LoginUser extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession(true);

        try {
            DataBaseConnector con = new DataBaseConnector();
            session.setAttribute("login", login);
            if (con.isAccess(login, pass)) {

                session.setAttribute("user", con.getUserByLogin(login));
                if (con.isDispatcher(login)) {
                    RequestDispatcher dispatcher = getServletContext().
                            getRequestDispatcher("/dispatcher.jsp");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = getServletContext().
                            getRequestDispatcher("/driver.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                out.println("<center><b>Access Diened!</b><center><br/>");
                out.println("<a href='http://localhost:8084/mainwebapplication/index.jsp'>Try again</a>");
            }
            con.closeConnection();

        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e1) {
        } catch (IllegalAccessException e2) {
        } catch (SQLException ex) {
        } finally {
            out.close();
        }
    }
    public void toErrorPage(HttpServletResponse response) throws IOException{
        RequestDispatcher dispatcher = getServletContext().
                            getRequestDispatcher("/error.jsp");
        response.sendRedirect("error.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
