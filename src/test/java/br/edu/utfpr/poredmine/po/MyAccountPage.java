/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.poredmine.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author JosielFaleiros
 */
public class MyAccountPage extends BasePage {
    
    WebElement flash_notice;
    
    
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    
    //Sua conta foi ativada. Você pode acessá-la agora.
    public String getSucessMessage() {
        return flash_notice.getText();
    }
    
}
