/**
 * UC1 : Ability to create a payroll service database and have java program connect to database
 * UC2 : Ability for Employee Payroll Service to retrieve the Employee Payroll from the database
 * UC3 : Ability to update the salary i.e. the base pay for Employee Terissa to 3000000.00 and sync it with Database
 * UC4 : Ability to update the salary i.e. the base pay for Employee Terissa to 5000000.00 and sync it with Database using JDBC PreparedStatement
 * Refractor UC4 : Make Payroll DB Service Object as Singleton
 *
 * @author : SAYANI KOLEY
 * @since : 17.07.2021
 */

package com.sayani.test;

import com.sayani.exception.EmployeePayrollException;
import com.sayani.model.EmployeePayrollData;
import com.sayani.service.EmployeePayrollService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EmployeePayrollServiceTest {
    EmployeePayrollService employeePayrollService = null;

    @Before
    public void setUp() throws Exception {
        employeePayrollService = new EmployeePayrollService();
    }

    /**
     * Purpose : To test whether the number of records present in the database matches with the expected value
     */

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(4, employeePayrollData.size());
    }

    /**
     * Purpose : To test whether the salary is updated in the database and is synced with the DB
     *           - Read the values from the database
     *           - Update the salary in the database
     *           - Test whether the database is correctly synced or not
     */

    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Terissa", 3000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terissa");
        Assert.assertTrue(result);
    }

    /**
     * Purpose : To test whether the salary is updated in the database and is synced with the DB using JDBC PreparedStatement
     *           - Read the values from the database
     *           - Update the salary in the database
     *           - Test whether the database is correctly synced or not
     */

    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDBUsingPreparedStatement() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalaryUsingPreparedStatement("Terissa", 5000000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terissa");
        Assert.assertTrue(result);
    }
}
