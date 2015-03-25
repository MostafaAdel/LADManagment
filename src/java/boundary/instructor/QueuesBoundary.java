/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.instructor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Student;

/**
 *
 * @author azza
 */
public class QueuesBoundary extends HttpServlet {

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
        response.setContentType("text/xml");
        String labNumber =request.getParameter("labKey");
        String accumlate = "";
//        accumlate+= "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
        dao.instructor.LapPageInitiator insa = new dao.instructor.LapPageInitiator();
        ArrayList<Student> studentsInAssesment = insa.getStudentsInAssementQueue(Integer.parseInt(labNumber));
        accumlate +="<rootElement>";
        accumlate += ("<assist>");
        for(Student st : studentsInAssesment){
            accumlate += ("<st1>");
            accumlate += ("<id>");
            accumlate += (st.getStudentId());
            accumlate += ("</id>");
            accumlate += ("<name>");
            accumlate += (st.getUserName());
            accumlate += ("</name>");
            accumlate += ("</st1>");
        }
        accumlate += ("</assist>");
        
         ArrayList<Student> studentsInDelivery = insa.getStudentsInDeliveryQueue(Integer.parseInt(labNumber));
        accumlate += ("<delive>");
        for(Student st2 : studentsInDelivery){
            accumlate += ("<st2>");
            accumlate += ("<id>");
            accumlate += (st2.getStudentId());
            accumlate += ("</id>");
            accumlate += ("<name>");
            accumlate += (st2.getUserName());
            accumlate += ("</name>");
            accumlate += ("</st2>");
        }
        accumlate += ("</delive>");
        accumlate +="</rootElement>";
        response.getWriter().print(accumlate);
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
