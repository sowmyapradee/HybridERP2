package DriverScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationLayer.AddEmployee;
import config.Base;
import utils.ExcelFileUtil;

public class AppTest extends Base{

	String InputPath = "C:\\Users\\tanvi\\OneDrive\\Desktop\\Java practice\\NewEclipse\\DataDriven_FrameWork\\FileInput\\Employee.xlsx";
    String OutPutPath ="C:\\Users\\tanvi\\OneDrive\\Desktop\\Java practice\\NewEclipse\\DataDriven_FrameWork\\FileOutput\\output.xlsx";
    ExtentReports report;
    ExtentTest Logger;
    String SheetName = "EmpData";
    @Test
    public void StartTest() throws Throwable {
    	report = new ExtentReports("C:\\Users\\tanvi\\OneDrive\\Desktop\\Java practice\\NewEclipse\\DataDriven_FrameWork\\target");
    	ExcelFileUtil xl = new ExcelFileUtil(InputPath);
    	int rc = xl.countRow(SheetName);
    
    	for(int i = 1 ; i < rc ; i++) {
    		Logger = report.startTest("test started");
        	Logger.assignAuthor("sowmya");
    		String Firstname = xl.getData(SheetName,i,0);
    		String Middlename = xl.getData(SheetName,i,1);
    		String Lastname = xl.getData(SheetName,i,2);
    		Logger.log(LogStatus.INFO, "Test Case Execution starts here");
    		AddEmployee addemp = PageFactory.initElements(driver, AddEmployee.class);
    		boolean testresult = addemp.addEmp(Firstname, Middlename, Lastname);
    		if(testresult) {
    			Logger.log(LogStatus.PASS, "Adding of employee is successful");
    			xl.createData(SheetName, i, 3, OutPutPath, "PASS");
    		}
    		else
    		{
    			Logger.log(LogStatus.FAIL, "Adding of employee is failure");
    			xl.createData(SheetName, i, 3, OutPutPath, "FAIL");
    		}
    		report.endTest(Logger);
    		report.flush();
    		
    	
    	}
    }
    
}