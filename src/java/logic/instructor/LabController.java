<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.instructor;

import dao.instructor.LabDao;
import dao.instructor.LabDaoImpl;
import dao.utility.DaoProvider;
import dto.AssignmentDto;
import dto.instructor.CourseDto;
import dto.instructor.GroupDto;
import dto.instructor.LabDto;
import dto.instructor.StudentDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import pojo.Lab;
import utility.InstructorUtility;

/**
 *
 * @author Hossam
 */
public class LabController {

    private LabDto labViewdto;
    private LabDao labDao;
    LabDaoImpl labDaoImpl = new LabDaoImpl();
    private int instructorId;

    /**
     *
     * @param labViewdto labViewDto that holds info about selected lab
     * @param instructorId current instructor id
     */
    public LabController(LabDto labViewdto, int instructorId) {
        this.labViewdto = labViewdto;
        this.instructorId = instructorId;
        labDao = DaoProvider.getLabDaoImpl();
    }

    public LabController() {
        
    }


    /**
     *
     * @return labViewDto that is currently selected
     */
    public LabDto getLabViewdto() {
        return labViewdto;
    }

    /**
     *
     * @return
     */
    public LabDao getLabDao() {
        return labDao;
    }

    /**
     *
     * @return
     */
    public int getInstructorId() {
        return instructorId;
    }

    /**
     *
     * @param labViewdto labViewDto that holds info about selected lab
     */
    public void setLabViewdto(LabDto labViewdto) {
        this.labViewdto = labViewdto;
    }

    /**
     *
     * @param labDao
     */
    public void setLabDao(LabDao labDao) {
        this.labDao = labDao;
    }

    /**
     * check if the current time is between the start date and the end date
     *
     * @return true if the lab is running or false otherwise
     */
    public boolean isRunning() {
        //get current time
        Date currentTime = new Date();
        boolean result = currentTime.after(this.labViewdto.getStartDate())
                && currentTime.before(this.labViewdto.getEndDate());
        return result;
    }

    /**
     * close an opened lab
     *
     */
    public void closeLab() {
        if (isRunning()) {
            labDao.closeLab(labViewdto);
        }
    }

    /**
     * enable upload if it is not enabled
     */
    public void enableUpload() {
        if (!labViewdto.isUploadEnabled() && isRunning()) {
            labDao.enableUpload(labViewdto);
        }
    }

    /**
     * gets next five labs after the current one in the group
     *
     * @return array list of lab view dto for the next five labs
     */
    public ArrayList<LabDto> getNextFiveLabs() {
        ArrayList<LabDto> nextFiveLabs;
        nextFiveLabs = labDao.getNextFiveLabs(labViewdto);
        return nextFiveLabs;
    }

    /**
     * shift queues for a certain lab
     *
     * @param shiftedToLab lab to shift queues for
     */
    public void shift(LabDto shiftedToLab) {
        if (labViewdto.getAssesmentQueue().getRequestAssesments().size() > 0
                || labViewdto.getDileveryQueue().getStudents().size() > 0) {
            labDao.shift(labViewdto, shiftedToLab);
        }
    }

    /**
     * return the studentDto object for the student with a specific name
     *
     * @param studentName to use for getting the student dto
     * @return studentDto for the student with this name
     */
    private StudentDto getStudent(String studentName) {
        ArrayList<StudentDto> students = getStudentsOfLab(labViewdto);
        for (StudentDto student : students) {
            if (student.getFulName().equals(studentName)) {
                return student;
            }
        }
        return null;
    }

    /**
     * get students of specific lab
     *
     * @param labDto lab to get its student
     * @return students in this lab
     */
    public ArrayList<StudentDto> getStudentsOfLab(LabDto labDto) {
        ArrayList<StudentDto> studentsOfLab = new ArrayList<>();

        CourseDto courseDto = labDto.getCourse();

        GroupDto groupDto = courseDto.getGroup();

        Set students = groupDto.getStudents();

        for (Object student : students) {
            StudentDto studentDto = (StudentDto) student;
            studentsOfLab.add(studentDto);
        }
        return studentsOfLab;
    }

    /**
     * update the selectedStudent record to add notification for delivery with
     * the name of the instructor
     *
     * @param studentName
     */
    public void notifyDelivery(String studentName) {
        if (isRunning()) {
            StudentDto selectedStudent = getStudent(studentName);
            labDao.notifyDelivery(selectedStudent, instructorId);
        }
    }

    /**
     * update the selectedStudent record to add notification for assistance with
     * the name of the instructor
     *
     * @param studentName selected student name
     */
    public void notifyAssistance(String studentName) {
        if (isRunning()) {
            StudentDto selectedStudent = getStudent(studentName);
            labDao.notifyAssistance(selectedStudent, instructorId);
        }
    }

    /**
     * get the assignments of a specific student
     *
     * @param studentName selected student name
     * @return the assignments of the selected student
     */
    public ArrayList<AssignmentDto> getAssignementOfStudent(String studentName) {
        if (!isRunning()) {
            StudentDto selectedStudent = getStudent(studentName);
            Set assignments = selectedStudent.getAssignments();

            ArrayList<Object> assignmentObjects = InstructorUtility.fromSetToArrayList(assignments);

            ArrayList<AssignmentDto> assignmentDtos = new ArrayList<>();

            for (Object obj : assignmentObjects) {
                AssignmentDto assign = ((AssignmentDto) obj);
                assignmentDtos.add(assign);
            }
            return assignmentDtos;
        }
        return null;
    }

    public Lab getActiveLab(String studentName) {

        return labDaoImpl.getActiveLab(studentName);
    }

    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////new methods////////////////////
    //////////////////////////////////////////////////////////////////
    /**
     * check if the current time is between the start date and the end date
     * 
     * @return true if the lab is running or false otherwise
     */
    public static boolean isRunning(Lab lab){
         System.out.println(lab.getStartDate());
         System.out.println(lab.getEndDate());
         System.out.println(new Date());
        //get current time
        Date currentTime = new Date();
        boolean result = currentTime.after(lab.getStartDate()) 
                            && currentTime.before(lab.getEndDate());
        return result;
    }
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.instructor;

import dao.instructor.LabDao;
import dao.instructor.LabDaoImpl;
import dao.utility.DaoProvider;
import dto.AssignmentDto;
import dto.instructor.CourseDto;
import dto.instructor.GroupDto;
import dto.instructor.LabDto;
import dto.instructor.StudentDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import pojo.Lab;
import utility.InstructorUtility;

/**
 *
 * @author Hossam
 */
public class LabController {

    private LabDto labViewdto;
    private LabDao labDao;
    LabDaoImpl labDaoImpl = new LabDaoImpl();
    private int instructorId;

    /**
     *
     * @param labViewdto labViewDto that holds info about selected lab
     * @param instructorId current instructor id
     */
    public LabController(LabDto labViewdto, int instructorId) {
        this.labViewdto = labViewdto;
        this.instructorId = instructorId;
        labDao = DaoProvider.getLabDaoImpl();
    }

    public LabController() {
        
    }


    /**
     *
     * @return labViewDto that is currently selected
     */
    public LabDto getLabViewdto() {
        return labViewdto;
    }

    /**
     *
     * @return
     */
    public LabDao getLabDao() {
        return labDao;
    }

    /**
     *
     * @return
     */
    public int getInstructorId() {
        return instructorId;
    }

    /**
     *
     * @param labViewdto labViewDto that holds info about selected lab
     */
    public void setLabViewdto(LabDto labViewdto) {
        this.labViewdto = labViewdto;
    }

    /**
     *
     * @param labDao
     */
    public void setLabDao(LabDao labDao) {
        this.labDao = labDao;
    }

    /**
     * check if the current time is between the start date and the end date
     *
     * @return true if the lab is running or false otherwise
     */
    public boolean isRunning() {
        //get current time
        Date currentTime = new Date();
        boolean result = currentTime.after(this.labViewdto.getStartDate())
                && currentTime.before(this.labViewdto.getEndDate());
        return result;
    }

    /**
     * close an opened lab
     *
     */
    public void closeLab() {
        if (isRunning()) {
            labDao.closeLab(labViewdto);
        }
    }

    /**
     * enable upload if it is not enabled
     */
    public void enableUpload() {
        if (!labViewdto.isUploadEnabled() && isRunning()) {
            labDao.enableUpload(labViewdto);
        }
    }

    /**
     * gets next five labs after the current one in the group
     *
     * @return array list of lab view dto for the next five labs
     */
    public ArrayList<LabDto> getNextFiveLabs() {
        ArrayList<LabDto> nextFiveLabs;
        nextFiveLabs = labDao.getNextFiveLabs(labViewdto);
        return nextFiveLabs;
    }

    /**
     * shift queues for a certain lab
     *
     * @param shiftedToLab lab to shift queues for
     */
    public void shift(LabDto shiftedToLab) {
        if (labViewdto.getAssesmentQueue().getRequestAssesments().size() > 0
                || labViewdto.getDileveryQueue().getStudents().size() > 0) {
            labDao.shift(labViewdto, shiftedToLab);
        }
    }

    /**
     * return the studentDto object for the student with a specific name
     *
     * @param studentName to use for getting the student dto
     * @return studentDto for the student with this name
     */
    private StudentDto getStudent(String studentName) {
        ArrayList<StudentDto> students = getStudentsOfLab(labViewdto);
        for (StudentDto student : students) {
            if (student.getFulName().equals(studentName)) {
                return student;
            }
        }
        return null;
    }

    /**
     * get students of specific lab
     *
     * @param labDto lab to get its student
     * @return students in this lab
     */
    public ArrayList<StudentDto> getStudentsOfLab(LabDto labDto) {
        ArrayList<StudentDto> studentsOfLab = new ArrayList<>();

        CourseDto courseDto = labDto.getCourse();

        GroupDto groupDto = courseDto.getGroup();

        Set students = groupDto.getStudents();

        for (Object student : students) {
            StudentDto studentDto = (StudentDto) student;
            studentsOfLab.add(studentDto);
        }
        return studentsOfLab;
    }

    /**
     * update the selectedStudent record to add notification for delivery with
     * the name of the instructor
     *
     * @param studentName
     */
    public void notifyDelivery(String studentName) {
        if (isRunning()) {
            StudentDto selectedStudent = getStudent(studentName);
            labDao.notifyDelivery(selectedStudent, instructorId);
        }
    }

    /**
     * update the selectedStudent record to add notification for assistance with
     * the name of the instructor
     *
     * @param studentName selected student name
     */
    public void notifyAssistance(String studentName) {
        if (isRunning()) {
            StudentDto selectedStudent = getStudent(studentName);
            labDao.notifyAssistance(selectedStudent, instructorId);
        }
    }

    /**
     * get the assignments of a specific student
     *
     * @param studentName selected student name
     * @return the assignments of the selected student
     */
    public ArrayList<AssignmentDto> getAssignementOfStudent(String studentName) {
        if (!isRunning()) {
            StudentDto selectedStudent = getStudent(studentName);
            Set assignments = selectedStudent.getAssignments();

            ArrayList<Object> assignmentObjects = InstructorUtility.fromSetToArrayList(assignments);

            ArrayList<AssignmentDto> assignmentDtos = new ArrayList<>();

            for (Object obj : assignmentObjects) {
                AssignmentDto assign = ((AssignmentDto) obj);
                assignmentDtos.add(assign);
            }
            return assignmentDtos;
        }
        return null;
    }

    public Lab getActiveLab(String studentName) {

        return labDaoImpl.getActiveLab(studentName);
    }

}
>>>>>>> 47d89df5014cd689881c6673ab374229c08df3d6
