package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmployee {
	WebDriver driver;
	public 	AddEmp(WebDriver driver)
	{
		this.driver=driver;
	}

@FindBy(xpath="//b[normalize-space()='PIM']")
WebElement PIM;
@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
WebElement objPath;
@FindBy(name="firstName")
WebElement objName;
@FindBy(name="middleName")
WebElement objSecondName;
@FindBy(name="lastName")
WebElement objLastName;
@FindBy(xpath="//input[@id='employeeId']")
WebElement objempid;
@FindBy(xpath="//input[@id='btnSave']")
WebElement objsave;
@FindBy(xpath="//input[@id='personal_txtEmployeeId']")
WebElement actid;

public boolean addEmp(String objName, String secondname,String Lastname) {
	Actions act = new Actions(driver);
	act.moveToElement(PIM).click().perform();
	act.moveToElement(objPath).click().perform();
	this.objName.sendKeys(objName);
	objSecondName.sendKeys(secondname);
	objLastName.sendKeys(Lastname);
	String empid = objempid.getAttribute("value");
	objsave.click();
	
	String actualid = actid.getAttribute("value");
	if(empid.equalsIgnoreCase(actualid)) {
		return true;
	}
	else
	{
		return false;
	}
}
}
