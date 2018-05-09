/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.poredmine.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author JosielFaleiros
 */
public class RedMineMainPage extends BasePage {
    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div[2]/div[1]/p[2]/a")
    WebElement linkRegister;
    
    public RedMineMainPage(WebDriver driver) {
        super(driver);
    }
    
    public RegisterPage goToRegisterPage() {
        linkRegister.click();
        return new RegisterPage(driver);
    }
}
