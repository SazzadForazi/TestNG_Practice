import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup{
    @Test
    public void userReg(){
        driver.get("http://automationpractice.com/");
        PageLogin pageLogin = new PageLogin(driver);
        int id = (int)(Math.random()*(1000-1)+1);
        String email = "testuser"+id+"@test.com";
        String password ="testuser123";
        pageLogin.doReg(email,password);
    }
//    @Test
    public void userLogin() throws InterruptedException {
        PageLogin pageLogin = new PageLogin(driver);
        driver.get("http://automationpractice.com/");
        String name= pageLogin.doLogin();
//        Assert.assertEquals(name,"Sazzad Hossain");
        Assert.assertTrue(name.contains("Sazzad Hossain"), String.valueOf(true));
        Assert.assertTrue(pageLogin.btnLogOut.isDisplayed(), String.valueOf(true));

//        Thread.sleep(5000);
//        pageLogin.btnLogOut.click();
    }
}
