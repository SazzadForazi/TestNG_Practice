import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(id = "email_create")
    WebElement txtEmailReg;
    @FindBy(id = "SubmitCreate")
    WebElement btnSubmitReg;
    @FindBy(id="id_gender1")
    WebElement rb1;
    @FindBy(id="customer_firstname")
    WebElement txtFirstName;
    @FindBy(id="customer_lastname")
    WebElement txtLastName;
    @FindBy(id = "days")
    WebElement cbDate;
    @FindBy(id="months")
    WebElement cbMonths;
    @FindBy(id="years")
    WebElement cbYears;
    @FindBy(xpath = "//span[contains(text(),'Register')]")
    WebElement btnSubmitAccount;
    @FindBy(name="address1")
    WebElement txtAddress;
    @FindBy(name="city")
    WebElement txtCity;
    @FindBy(name="postcode")
    WebElement txtPostCode;
    @FindBy(name="id_state")
    WebElement cbState;
    @FindBy(name="phone_mobile")
    WebElement txtMobile;

    WebDriver driver;

    public PageLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   public void doReg(String email,String password){
        btnLogin.click();
        txtEmailReg.sendKeys(email);
        btnSubmitReg.click();
       rb1.click();
       txtFirstName.sendKeys("Test");
       txtLastName.sendKeys("User");
       textPassword.sendKeys(password);
       Select date=new Select(cbDate);
       date.selectByValue("5");
       Select month=new Select(cbMonths);
       month.selectByValue("3");
       Select year=new Select(cbYears);
       year.selectByValue("1990");
       txtAddress.sendKeys("Alabama");
       txtCity.sendKeys("Alabama");
       txtPostCode.sendKeys("10101");
       Select option=new Select(cbState);
       option.selectByVisibleText("Alabama");
       txtMobile.sendKeys("000000000000");
       btnSubmitAccount.click();
   }
    public String doLogin(){
        btnLogin.click();
        textEmail.sendKeys("forazi@gmail.com");
        textPassword.sendKeys("forazi@gmail.com");
        btnSubmit.click();
        return lblUserName.get(0).getText();
    }
}
