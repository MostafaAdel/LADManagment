/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.instructor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.instructor.LabController;
import logic.instructor.LabPageController;

/**
 *
 * @author Hossam
 */
public class LabsController extends HttpServlet {
//    LabController labController ;
//    LabPageController labPageController;
//
//    static{
//        this.labPageController = new LabPageController(instructorId, null);
//        this.labController = new LabController(null, instructorId);
//    }
    //////////////////////////////////////////////////////////////////////////////
    //////from where can i get the instructor id and labviewdto and labsviewdto////
    /////////////////////////////////////////////////////////////////////////////////
    /////////Session///////////Cookies////////////Requests////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ////how to move data from server to reflect on ui///////////////
    /////////////////////////////////////////////////////////////
    
    
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
        String labNumber="";
        String NotifyAssistanceName="";
        String NotifyDeliveryName="";
        try{
            labNumber = request.getParameter("lab");
            NotifyAssistanceName = request.getParameter("notifyAssist");
            NotifyDeliveryName = request.getParameter("notifyDelivery");
        }catch(Exception ex){}
        
        PrintWriter out = response.getWriter();
        out.println(labNumber);
        out.println(NotifyAssistanceName);
        out.println(NotifyDeliveryName);
        
        if(labNumber.equals("1")){
            response.sendRedirect("/LADManagment/labs.jsp?lab=1");
        }
        else if(labNumber.equals("2")){
            response.sendRedirect("/LADManagment/labs.jsp?lab=2");
        }
        else if(labNumber.equals("3")){
            response.sendRedirect("/LADManagment/labs.jsp?lab=3");
        }
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
