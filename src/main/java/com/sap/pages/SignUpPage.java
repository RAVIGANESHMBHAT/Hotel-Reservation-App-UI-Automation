package com.sap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpPage {
    WebDriver driver = null;

    @BeforeTest
    public void setUpTest() {
        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\I524764\\Documents\\Projects\\DevOps Class Project\\DevOps Git Folder\\Hotel Management App UI Automation\\Driver_server\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();
    }

    @Test
    public void signUpMethod() throws InterruptedException {
        // Launch Website
        driver.navigate().to("https://hotelreservation-nettlesome-vacillator.cfapps.eu10.hana.ondemand.com/");// https://hotelreservation-nettlesome-vacillator.cfapps.eu10.hana.ondemand.com/login-form-page http://localhost:8080/

        //Maximize the browser
        driver.manage().window().maximize();

        String expectedPageTitle = "Hotel Login";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualTitle);

        //try to login without registering the account
        WebElement email = driver.findElement(By.id("emailForLogin"));//By.xpath("//input[@placeholder='Email']")
        email.sendKeys("test@gmail.com");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("passwordForLogin"));
        password.sendKeys("test@123");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();
        Thread.sleep(2000);

        //register a new account
        WebElement signUpButton = driver.findElement(By.id("signUp"));
        signUpButton.click();
        Thread.sleep(1000);
        WebElement emailCreateAccount = driver.findElement(By.id("emailForCreateAccount"));
        emailCreateAccount.sendKeys("raviganesh@gmail.com");
        Thread.sleep(1000);
        WebElement usernameCreateAccount = driver.findElement(By.id("usernameId"));
        usernameCreateAccount.sendKeys("raviganesh");
        Thread.sleep(1000);
        WebElement passwordCreateAccount = driver.findElement(By.id("password"));
        passwordCreateAccount.sendKeys("test@123");
        Thread.sleep(1000);
        WebElement verifyPasswordCreateAccount = driver.findElement(By.id("password_two"));
        verifyPasswordCreateAccount.sendKeys("test@123");
        Thread.sleep(1000);
        WebElement submitButtonCreateAccount = driver.findElement(By.id("button_CreateAccount"));
        submitButtonCreateAccount.click();
        Thread.sleep(2000);

        //login to the registered account
        WebElement email1 = driver.findElement(By.id("emailForLogin"));
        email1.sendKeys("raviganesh@gmail.com");
        Thread.sleep(1000);
        WebElement password1 = driver.findElement(By.id("passwordForLogin"));
        password1.sendKeys("test@123");
        Thread.sleep(1000);
        WebElement submitButton1 = driver.findElement(By.id("submitButton"));
        submitButton1.click();
        Thread.sleep(2000);

        driver.close();
        driver.quit();
        System.out.println("Login Test completed successfully");
    }
}
