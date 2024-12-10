package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
@FindBy(xpath="//a[@id='welcome']")
WebElement objlog;
@FindBy(xpath="//a[normalize-space()='Logout']")
WebElement objlogout;
public void logout() {
	objlog.click();
	Thread.sleep(5000);
	objlogout.click();
}
}
