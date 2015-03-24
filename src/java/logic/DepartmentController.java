/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.DepartmentDAOImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Mostafa_ITI
 */
public class DepartmentController {

    DepartmentDAOImpl dAOImpl = new DepartmentDAOImpl();

    public Iterator<Object[]> getAllDepartments() {
        Iterator<Object[]> departments = dAOImpl.getDepartmentNames();
        return departments;
    }
}
