import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup{
    @Test
    public void userLogin(){
        PageLogin pageLogin = new PageLogin(driver);
        driver.get("http://automationpractice.com/");
        String name= pageLogin.doLogin();
        Assert.assertEquals(name,"Sazzad Hossain");
//   Assert.assertTrue(name.contains("Sazzad Hossain"), String.valueOf(true));
        Assert.assertTrue(pageLogin.btnLogOut.isDisplayed(), String.valueOf(true));
    }
}
