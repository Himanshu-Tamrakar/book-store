/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Request;
import users.userDAO;
import users.userbean;

/**
 *
 * @author monty
 */
public class register extends HttpServlet {
   
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
       int check=0;
      String uname=null;
           String email=null;
       String pass=null;
       String mobile=null;
         String address=null;
        String name=null;

       try {
             uname=request.getParameter("uname");
             pass=request.getParameter("pass");
             name=request.getParameter("name");
             address=request.getParameter("address");
             mobile=request.getParameter("mobile");
             email=request.getParameter("email");




            userDAO ud=new userDAO();
            check=ud.checkAvailable(uname);
                    if(check!=0)
        {
           response.sendRedirect("registration?msg=exist");

        }
                    else{

            userbean bn=new userbean(uname,pass,name,address,mobile,email);
            ud.create(bn);
            out.println("<h3 id=column2>registration is sucessfull</h3>");
            response.sendRedirect("login");
            }
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */

        } finally { 
            out.close();
        }
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
