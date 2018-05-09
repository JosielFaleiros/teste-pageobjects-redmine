package br.edu.utfpr.poredmine;


import br.edu.utfpr.poredmine.po.MyAccountPage;
import br.edu.utfpr.poredmine.po.RedMineMainPage;
import br.edu.utfpr.poredmine.po.RegisterPage;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JosielFaleiros
 */
public class PORedMineTest {
    
    private static String CHROMEDRIVER_LOCATION = "/home/kbig/Downloads/chromedriver_236_linux64/chromedriver";

    private static int scId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCATION);
    }

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //Opcao headless para MacOS e Linux
//        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.redmine.org/");
    }

    @After
    public void after() {
        driver.close();
    }
    
    @Test
    public void testUserRegistrationSuccess () {
        RedMineMainPage mainPage = new RedMineMainPage(driver);
        RegisterPage rp = mainPage.goToRegisterPage();
        String pass = buidRandomString();
        rp.setUser_login(buidRandomString())
                .setUser_password(pass)
                .setUser_password_confirmation(pass)
                .setUser_firstname(buidRandomString())
                .setUser_lastname(buidRandomString())
                .setUser_mail(buidRandomString() + "@email.com");
        
        MyAccountPage map = rp.enviarComSucesso();
        assertEquals("Your account has been activated. You can now log in.", map.getSucessMessage());
    }
    
    public String randomString(int length, String characterSet) {
        StringBuilder sb = new StringBuilder(); //consider using StringBuffer if needed
        for (int i = 0; i < length; i++) {
            int randomInt = new SecureRandom().nextInt(characterSet.length());
            sb.append(characterSet.substring(randomInt, randomInt + 1));
        }
        return sb.toString();
    }
    
    public String buidRandomString() {
        return randomString(8, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"); //charachterSet can basically be anything
    }
}
