/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.instructor;

import dao.instructor.LabDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.instructor.LabController;
import pojo.Lab;
import pojo.Student;

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
        try{
            labNumber = request.getParameter("lab");
        }catch(Exception ex){}
        
        LabDaoImpl ldi = new LabDaoImpl();
        ArrayList<Student> students = ldi.getStudentsOfGroup(Integer.parseInt((String) request.getSession().getAttribute("groupId")));
        request.getSession().setAttribute("students", students);
        dao.instructor.LapPageInitiator  ins = new dao.instructor.LapPageInitiator();
        ArrayList<Lab> labs = ins.getLabsOfCourseGroup(Integer.parseInt((String)request.getSession().getAttribute("groupId")), ((String)request.getSession().getAttribute("courseName")));
        Lab selectedLab = null;
        for(Lab labb : labs){
            if(labb.getLabId() == Integer.parseInt(labNumber)){
                selectedLab = labb;
                break;
            }
        }
        System.out.println(LabController.isRunning(selectedLab));
        if(LabController.isRunning(selectedLab))
            request.getSession().setAttribute("labStatus", true);
        else
            request.getSession().setAttribute("labStatus", false);
        
        
        
        dao.instructor.LapPageInitiator insa = new dao.instructor.LapPageInitiator();
        ArrayList<Student> studentsInAssesment = insa.getStudentsInAssementQueue(Integer.parseInt(labNumber));
        request.getSession().setAttribute("asStudents", studentsInAssesment);
        
         ArrayList<Student> studentsInDelivery = insa.getStudentsInDeliveryQueue(Integer.parseInt(labNumber));
        request.getSession().setAttribute("deStudents", studentsInAssesment);
        response.sendRedirect("/LADManagment/labs.jsp?lab="+labNumber);
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
