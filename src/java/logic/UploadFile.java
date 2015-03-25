/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import dto.AssignmentDto;
import dto.StudentDto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import pojo.Lab;
import pojo.Student;

/**
 *
 * @author Fatemah
 */
@WebServlet(name = "UploadFile", urlPatterns = {"/UploadFile"})
@MultipartConfig
public class UploadFile extends HttpServlet {
    
    private boolean isMultipart;
    private String filePath;
    private final int maxFileSize = 1024 * 50;
    private final int maxMemSize = 1024 *4 ;
    
    
    @Override
    public void init(){
        
        filePath = "E:\\upload\\";
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        
        try (PrintWriter out = response.getWriter()) {
            if(!isMultipart){
                
               
	       out.print("<br/><span> <font color=red>Failed Upload File </font> </span>");  
	       RequestDispatcher rd=request.getRequestDispatcher("labPageAfter.jsp");  //Change to your page
	       rd.include(request, response);
               return;
            }
            
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File(filePath));
            
            
            ServletFileUpload upload =  new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            
            HttpSession httpSession = request.getSession();
            
           // Student student = (Student) httpSession.getAttribute("Student");
            Lab lab = (Lab) httpSession.getAttribute("labDto");
  
            AssignmentController assignmentController = new AssignmentController();
            
            
            
            //String status = request.getParameter("status"); // Retrieves <input type="text" name="status">
            Part uploadedFile = request.getPart("file"); // Retrieves <input type="file" name="uploadedFile">
            OutputStream outStream;
            try (InputStream content = uploadedFile.getInputStream()) {
                String name = uploadedFile.getSubmittedFileName();
                File file = new File("E:/upload/"+name);
                int studentId =Integer.parseInt( request.getParameter("studentID"));
                byte[] buffer = new byte[content.available()];
                content.read(buffer);
                outStream = new FileOutputStream(file);
                outStream.write(buffer);
                outStream.close();
                
                assignmentController.uploadAssignment(lab, studentId, name, "E:/upload/");
                
                out.print("<br/><span> <font color=blue>Your file uploaded successfully </font> </span>");  
	        RequestDispatcher rd=request.getRequestDispatcher("labPageAfter.jsp");  
	        rd.include(request, response);
            }
            
        }
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
