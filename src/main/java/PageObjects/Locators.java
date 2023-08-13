package PageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Locators extends BasePage {

    public WebDriver driver;

    By OldUIBtn = By.id("employeePortal");
    By PartnerNumber = By.cssSelector("[role] [data-ref] > [role='presentation']:nth-of-type(2) .x-form-text-default");
    By Username = By.cssSelector("[role] [role='presentation']:nth-of-type(3) .x-form-text-default");
    By Password = By.cssSelector("[role] [role='presentation']:nth-of-type(4) .x-form-text-default");
    By LoginError = By.cssSelector("[osviewid='mode_1_msg_1']");
    By LoginBtn = By.cssSelector(".x-btn-button-default-small");
    By WelcomeMessage = By.cssSelector("[osviewid='mode_1_msg_1']");
    By LogoutBtn = By.id("osBtn113401-btnInnerEl");
    By PopupOk = By.cssSelector(".x-toolbar-footer [hidefocus='on']:nth-of-type(1) .x-btn-button-default-small");
    By ChangeUsername = By.cssSelector("[role] tr:nth-of-type(1) [data-ref] > [role='presentation']:nth-of-type(2) .x-form-text-default");
    By CurrentPassword = By.cssSelector("[role] tr:nth-of-type(1) [role='presentation']:nth-of-type(3) .x-form-text-default");
    By NewPassword = By.cssSelector("[role] [role='presentation']:nth-of-type(4) .x-form-text-default");
    By ConfirmPassword = By.cssSelector("[role] [role='presentation']:nth-of-type(5) .x-form-text-default");
    By SaveBtn = By.cssSelector("#footer-panel [hidefocus='on']:nth-of-type(1) .x-btn-inner-default-small");

    public Locators() throws IOException { super(); }

    public WebElement OldUIBtn() { this.driver = getDriver(); return driver.findElement(OldUIBtn); }
    public WebElement PartnerNumber() { this.driver = getDriver(); return driver.findElement(PartnerNumber); }
    public WebElement Username() { this.driver = getDriver(); return driver.findElement(Username); }
    public WebElement Password() { this.driver = getDriver(); return driver.findElement(Password); }
    public WebElement LoginError() { this.driver = getDriver(); return driver.findElement(LoginError); }
    public WebElement LoginBtn() { this.driver = getDriver(); return driver.findElement(LoginBtn); }
    public WebElement WelcomeMessage() { this.driver = getDriver(); return driver.findElement(WelcomeMessage); }
    public WebElement LogoutBtn() { this.driver = getDriver(); return driver.findElement(LogoutBtn); }
    public WebElement PopupOk() { this.driver = getDriver(); return driver.findElement(PopupOk); }
    public WebElement ChangeUsername() { this.driver = getDriver(); return driver.findElement(ChangeUsername); }
    public WebElement CurrentPassword() { this.driver = getDriver(); return driver.findElement(CurrentPassword); }
    public WebElement NewPassword() { this.driver = getDriver(); return driver.findElement(NewPassword); }
    public WebElement ConfirmPassword() { this.driver = getDriver(); return driver.findElement(ConfirmPassword); }
    public WebElement SaveBtn() { this.driver = getDriver(); return driver.findElement(SaveBtn); }



}
