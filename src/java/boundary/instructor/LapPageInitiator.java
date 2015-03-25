/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.instructor;

import java.io.IOException;
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
public class LapPageInitiator extends HttpServlet {

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
        String groupIdString = request.getParameter("group");
        request.getSession().setAttribute("groupId", groupIdString);
        int groupId = Integer.parseInt(groupIdString);
        String courseName = request.getParameter("course");
        request.getSession().setAttribute("courseName", courseName);
        
        dao.instructor.LapPageInitiator  ins = new dao.instructor.LapPageInitiator();
        ArrayList<Lab> labs = ins.getLabsOfCourseGroup(groupId, courseName);
        ArrayList<Student> students = ins.getStudentsOfGroup(groupId);
        
        boolean labStatus = LabController.isRunning(labs.get(0));
//                System.out.println(LabController.isRunning(labs.get(3)));
//                System.out.println(LabController.isRunning(labs.get(2)));
//                System.out.println(LabController.isRunning(labs.get(1)));
                for(Lab l:labs){
                request.getSession().setAttribute("labID",l.getLabId());
                }
                
        ArrayList<Student> studentsInAssesment = ins.getStudentsInAssementQueue(labs.get(0).getLabId());
        ArrayList<Student> studentsInDelivery = ins.getStudentsInDeliveryQueue(labs.get(0).getLabId());
        
        request.getSession().setAttribute("deStudents", studentsInAssesment);        
        request.getSession().setAttribute("asStudents", studentsInAssesment);
        request.getSession().setAttribute("labs", labs);
        request.getSession().setAttribute("students", students);
        request.getSession().setAttribute("labStatus", labStatus);
        request.getSession().setAttribute("labsNumber", labs.size());
                
        response.sendRedirect("/LADManagment/labs.jsp?lab="+labs.get(0).getLabId());
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
