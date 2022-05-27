import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends Setup{
    @Test(priority = 1)
    public void userReg() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        PageLogin pageLogin = new PageLogin(driver);
        int id = (int)(Math.random()*(1000-1)+1);
        String email = "testuser"+id+"@test.com";
        String password ="testuser123";
        pageLogin.doReg(email,password);
        Assert.assertTrue(pageLogin.btnLogOut.isDisplayed(), String.valueOf(true));
        Utils utils=new Utils();
        utils.saveData(email,password);
    }
    @Test(priority = 2)
    public void userLogin() throws InterruptedException,IOException, ParseException {
        PageLogin pageLogin = new PageLogin(driver);
        driver.get("http://automationpractice.com/");
      Utils utils=new Utils();
      utils.readData(utils.getLatestUser()-1);
        String name= pageLogin.doLogin(utils.getEmail(),utils.getPassword());
        Assert.assertTrue(name.contains("Test User"));

        Thread.sleep(5000);
        pageLogin.btnLogOut.click();
    }
}
