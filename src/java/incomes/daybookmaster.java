/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package incomes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author monty
 */
public class daybookmaster extends HttpServlet {
   
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
      RequestDispatcher rd;
        try {
           
            out.println("<html>");
            out.println("<head>");
        out.println("<meta http-equiv='content-type' content='text/html; charset=utf-8' />");
out.println("<title>Sahara by Free CSS Templates</title>");
out.println("<meta name='keywords' content='' />");
out.println("<meta name='description' content='' />");
out.println("<link rel='stylesheet' type='text/css' href='default.css' />");
            out.println("</head>");
            out.println("<body>");
     out.println("<div id='outer'>");
	 out.println("<div id='outer2'>");
	 rd=request.getRequestDispatcher("header.html");
         rd.include(request, response);
 rd=request.getRequestDispatcher("mainmenu.html");
rd.include(request, response);


		 out.println("<div id='content'>");

 rd=request.getRequestDispatcher("master.html");
rd.include(request, response);
                    rd=request.getRequestDispatcher("paybookmaster.html");
rd.include(request, response);
		 out.println("</div>");


	 out.println("</div>");

         out.println("</div>");
            out.println("</body>");
            out.println("</html>");
          
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
