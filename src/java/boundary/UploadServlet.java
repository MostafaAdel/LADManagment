package boundary;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.oreilly.servlet.MultipartRequest;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import logic.AssignmentController;
import org.apache.coyote.RequestGroupInfo;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import pojo.Lab;

/**
 *
 * @author Mostafa_ITI
 */
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath = "E:/new/";
    private final int maxFileSize = 1024 * 50;
    private final int maxMemSize = 1024 * 4;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
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
        PrintWriter out = response.getWriter();

        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");

       

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);
        factory.setRepository(new File(filePath));

        ServletFileUpload upload = new ServletFileUpload(factory);
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
            File file = new File("E:/new/" + name);
            int studentId = Integer.parseInt(request.getParameter("studentID"));
            byte[] buffer = new byte[content.available()];
            content.read(buffer);
            outStream = new FileOutputStream(file);
            outStream.write(buffer);
            outStream.close();

            assignmentController.uploadAssignment(lab, studentId, name, "E:/new/");
            response.sendRedirect("/LADManagment/welcomeStudent.jsp");
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
