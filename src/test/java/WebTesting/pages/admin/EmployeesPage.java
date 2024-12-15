package WebTesting.pages.admin;

import WebTesting.pages.CommonPage;

public class EmployeesPage extends CommonPage {

    private String subdir = "erp/staff-list";
    private String header = "List All Employees";
    private String title = "Employees | HRSALE";

    private String addEmployees = "(//h5[normalize-space()='List All Employees']//following::div)//a[@href='#add_form']";
    private String inputFirstName = "//input[@placeholder='First Name']";
    private String inputLastName = "//input[@placeholder='Last Name']";
    private String contactNumber = "//input[@placeholder='Contact Number']";
    private String dropdownGender = "";
    private String inputEmail  = "";
    private String inputUserName = "";
    private String inputPassword = "";
    private String optionOfficeShift = "";
    private String optionRole = "";
    private String optionDepartment = "";
    private String inputBasicSalary = "";
    private String inputHourlyRate = "";
    private String optionPayslipType = "";
    private String buttonSave = "";


}
