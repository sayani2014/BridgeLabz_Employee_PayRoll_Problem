/**
 * UC2 : Ability for Employee Payroll Service to retrieve the Employee Payroll from the database
 *
 * @author : SAYANI KOLEY
 * @since : 16.07.2021
 */

package com.sayani.test;

import com.sayani.model.EmployeePayrollData;
import com.sayani.service.EmployeePayrollService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EmployeePayrollServiceTest {

    /**
     * Purpose : To test whether the number of records present in the database matches with the expected value
     */

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(4, employeePayrollData.size());
    }
}
