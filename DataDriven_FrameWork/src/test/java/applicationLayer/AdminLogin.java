package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {

	@FindBy(name="txtUsername")
		WebElement objUser;
	@FindBy(name="txtPassword")
         WebElement objPwd;
		@FindBy(xpath="//input[@id='btnLogin']")
		WebElement objLogin;
		public void adminlogin(String admin , String pwd) {
			objUser.sendKeys("admin");
			objPwd.sendKeys("pwd");
			objLogin.click();
		}
}
