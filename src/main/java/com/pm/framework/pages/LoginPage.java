package com.pm.framework.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public boolean isLoginPageDisplayed(){
           return page.getByText("Login to your account").isVisible();
    }
    public void enterEmail(String email){
        page.getByPlaceholder("Email Address").first().fill(email);
    }
    public void enterPassword(String password){
        page.getByPlaceholder("password").fill(password);
    }

    public void LoginUser(String email,String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
    public void registerUser(String name,String email){
        page.getByPlaceholder("Name").fill(name);
        page.getByPlaceholder("EmailAddress").fill(email);
    }

    public void clickLogin(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login")).click();
    }
    public boolean ErrorMessageisVisible(){
        return page.getByText("Your email or password is incorrect!").isVisible();
    }
    public String getErrorMessage(){
        return page.getByText("Your email or password is incorrect!").textContent();
    }
}
