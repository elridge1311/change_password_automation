package Automation;

import PageObjects.Locators;
import base.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


@Test
public class passwords extends Hooks  {
    public passwords() throws IOException {
        super();
    }
//"auto_ll""auto_uu"
    String[] userNames = {"auto_md","auto_bcsr","auto_bcc","auto_bcsrm","auto_adj","auto_cont","auto_vp","auto_ccsr","auto_ccsrm","autoClaims_adj_JuniorA","autoClaims_adj_MiddleA","autoClaims_adj_SeniorA","autoClaims_adj_MiddleB","autoClaims_adj_SeniorB@gmail.com","autoClaims_adj_SeniorLimit","autoClaims_adj_SeniorLimitMgr"};
//    String[] userNames = {"auto_md"};
    static String oldPassword = "Oneshield3";
    static String newPassword = "Oneshield4";

    public void checkExistingPassword() throws IOException, InterruptedException {
        Locators locators = new Locators();
        locators.OldUIBtn().click();
        Thread.sleep(2000);
        for (String userName : userNames) {
            DataField(locators, userName, newPassword);
            locators.LoginBtn().click();
            Thread.sleep(2000);
            if (NotLoggedIn(locators, userName)) {
                ClearField(locators);
                Thread.sleep(5000);
                ChangePassword(locators, userName);
                Thread.sleep(5000);
            }
            else {
                LoggedIn(locators, userName);
            }
        }

    }

    @Parameters
    public void ClearField(Locators locators)
    {
        locators.PartnerNumber().clear();
        locators.Username().clear();
        locators.Password().clear();
    }

    @Parameters
    public void DataField(Locators locators, String username, String password)
    {
        locators.PartnerNumber().sendKeys("0");
        locators.Username().sendKeys(username);
        locators.Password().sendKeys(password);
    }

    @Parameters
    public boolean NotLoggedIn(Locators locators, String username) throws InterruptedException
    {
        String loginError = locators.LoginError().getText();
        loginError = loginError.substring(0,loginError.indexOf(" ")).trim();
        Thread.sleep(3000);
        if(loginError.equals("Please"))
        {
            ClearField(locators);
            DataField(locators, username, oldPassword);
            locators.LoginBtn().click();
            System.out.println();
            //System.out.println(username + " is not able to login with " + oldPassword + " and " + newPassword);
            Thread.sleep(2000);
            return true;
        }
        return false;
    }

    @Parameters
    public static void LoggedIn(Locators locators, String username) throws InterruptedException
    {
        Thread.sleep(2000L);
        String welcomeMessage = locators.WelcomeMessage().getText();
        welcomeMessage = welcomeMessage.substring(0,welcomeMessage.indexOf(" ")).trim();
        if (welcomeMessage.equals("Welcome"))
        {
            System.out.println();
            System.out.println(username + " is logged in with " + newPassword);
            locators.LogoutBtn().click();
            Thread.sleep(1000);
            locators.PopupOk().click();
            Thread.sleep(2000);
        }
    }


    public void ChangePassword(Locators locators, String username) throws InterruptedException
    {
        Thread.sleep(2000L);
        String PasswordMessage = locators.WelcomeMessage().getText();
        if (PasswordMessage.equals("The password has expired. Please reset your password."))
        {
            System.out.println();
            locators.CurrentPassword().sendKeys("0");
            //System.out.println(username);
            locators.ChangeUsername().sendKeys(username);
            Thread.sleep(2000);
           // System.out.println(oldPassword);
            locators.CurrentPassword().clear();
            locators.CurrentPassword().sendKeys(oldPassword);
            //System.out.println(newPassword);
            locators.NewPassword().sendKeys(newPassword);
            Thread.sleep(2000);
            locators.ConfirmPassword().sendKeys(newPassword);
            Thread.sleep(2000);
            locators.SaveBtn().click();
            Thread.sleep(3000);
            System.out.println(username + " password is changed to " + newPassword);
        }
    }


}

