package com.hank.mhl.service;

import com.hank.mhl.DAO.EmployeeDAO;
import com.hank.mhl.domain.Employee;

public class EmployeeService {
    public EmployeeDAO employeeDAO = new EmployeeDAO();
    public Employee getEmployee(String empid, String pwd) throws Exception {
        return employeeDAO.querySingle("select * from employee where empid=? and pwd=SHA2(?,256)",Employee.class,empid,pwd);
    }
}
