import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageLogin {
    @FindBy(className = "login")
    WebElement btnLogin;
    @FindBy(id = "email")
    WebElement textEmail;
    @FindBy(id = "passwd")
    WebElement textPassword;
    @FindBy(id = "SubmitLogin")
    WebElement btnSubmit;
    @FindBy(className = "logout")
    WebElement btnLogOut;
    @FindBy(className="header_user_info")
    List<WebElement> lblUserName;
    WebDriver driver;

    public PageLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String doLogin(){
        btnLogin.click();
        textEmail.sendKeys("forazi@gmail.com");
        textPassword.sendKeys("forazi@gmail.com");
        btnSubmit.click();
        return lblUserName.get(0).getText();
    }
}
