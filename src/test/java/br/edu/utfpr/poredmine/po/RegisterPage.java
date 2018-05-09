/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.poredmine.po;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author JosielFaleiros
 */
public class RegisterPage extends BasePage {
    WebElement user_login;
    WebElement user_password;
    WebElement user_password_confirmation;
    WebElement user_firstname;
    WebElement user_lastname;
    WebElement user_mail;
    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div[2]/form/input[3]")
    WebElement btnRegister;
    //select box
    WebElement user_language;

    public RegisterPage setUser_login(String user_login) {
        this.user_login.sendKeys(user_login);
        return this;
    }

    public RegisterPage setUser_password(String user_password) {
        this.user_password.sendKeys(user_password);
        return this;
    }

    public RegisterPage setUser_password_confirmation(String user_password_confirmation) {
        this.user_password_confirmation.sendKeys(user_password_confirmation);
        return this;
    }

    public RegisterPage setUser_firstname(String user_firstname) {
        this.user_firstname.sendKeys(user_firstname);
        return this;
    }

    public RegisterPage setUser_lastname(String user_lastname) {
        this.user_lastname.sendKeys(user_lastname);
        return this;
    }

    public RegisterPage setUser_mail(String user_mail) {
        this.user_mail.sendKeys(user_mail);
        return this;
    }

    public RegisterPage setUser_language(String user_language) {
        this.user_language.sendKeys(user_language);
        return this;
    }

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    
    public MyAccountPage enviarComSucesso() {
        btnRegister.click();
        return new MyAccountPage(driver);
    }
    
    public RegisterPage enviarComErro() {
        btnRegister.click();
        return this;
    }
}
