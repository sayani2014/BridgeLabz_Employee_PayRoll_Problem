package com.sayani.service;

import com.sayani.model.EmployeePayrollData;

import java.util.List;

public class EmployeePayrollService {
    EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();

    public enum IOService {
        DB_IO
    }

    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {
    }

    /**
     * Purpose : To get the list of employee payroll from the database
     * @param ioService
     * @return
     */

    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
        if(ioService.equals(IOService.DB_IO))
            this.employeePayrollList = employeePayrollDBService.readData();
        return this.employeePayrollList;
    }
}
