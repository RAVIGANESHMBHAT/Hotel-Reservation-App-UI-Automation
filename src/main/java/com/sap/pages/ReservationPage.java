package com.sap.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReservationPage {
    WebDriver driver = null;
    JavascriptExecutor jsExecutor = null;

    @BeforeTest
    public void setUpTest() {
        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\I524764\\Documents\\Projects\\DevOps Class Project\\DevOps Git Folder\\DevOps-Assignment\\UI Automation\\Driver_server\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();

        jsExecutor = (JavascriptExecutor)driver;
    }

    @Test
    public void signUpMethod() throws InterruptedException {
        // Launch Website
        driver.navigate().to("https://hotelreservation-nettlesome-vacillator.cfapps.eu10.hana.ondemand.com/");

        //Maximize the browser
        driver.manage().window().maximize();
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

        WebElement roomsButton = driver.findElement(By.linkText("Rooms"));
        roomsButton.click(); //.sendKeys(Keys.ENTER)
        Thread.sleep(2000);
        WebElement servicesButton = driver.findElement(By.linkText("Services"));
        servicesButton.click();
        Thread.sleep(2000);
        WebElement homeButton = driver.findElement(By.linkText("Home"));
        homeButton.click();
        Thread.sleep(2000);

        //click on Your Reservations button ans see all the created reservations
        WebElement yourReservationsButton = driver.findElement(By.linkText("Your Reservations"));
        yourReservationsButton.click();
        Thread.sleep(2000);
//        WebElement reservationsListButton = driver.findElement(By.linkText("Reservations list"));
//        reservationsListButton.click();
//        Thread.sleep(2000);
//        WebElement yourReservationButton = driver.findElement(By.linkText("Your Reservations"));
//        yourReservationButton.click();
//        Thread.sleep(2000);

        //create a new Reservation
        WebElement newReservationButton = driver.findElement(By.linkText("New Reservation"));
        newReservationButton.click();
        Thread.sleep(4000);

        //scroll down the page to see the Submit button on the down
        jsExecutor.executeScript("scroll(0, 500);");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.cssSelector(".sub-btn"));
        submitButton.click();
        Thread.sleep(2000);

        //fill the required fields to create the reservation
        Select roomType = new Select(driver.findElement(By.name("room")));
        roomType.selectByVisibleText("Family Deluxe");
        Thread.sleep(1000);
        WebElement periodOfStay = driver.findElement(By.id("stay-per"));
        periodOfStay.clear();
        periodOfStay.sendKeys("3");
        Thread.sleep(1000);
        WebElement numberOfRooms = driver.findElement(By.id("room_number"));
        numberOfRooms.clear();
        numberOfRooms.sendKeys("2");
        Thread.sleep(1000);
        WebElement numberOfPersons = driver.findElement(By.id("person_number"));
        numberOfPersons.clear();
        numberOfPersons.sendKeys("3");
        Thread.sleep(1000);
        WebElement numberOfChildren = driver.findElement(By.id("child_number"));
        numberOfChildren.clear();
        numberOfChildren.sendKeys("1");
        Thread.sleep(1000);
        Select openBuffet = new Select(driver.findElement(By.name("openBuffet")));
        openBuffet.selectByVisibleText("No");
        //openBuffet.selectByIndex(1);
        Thread.sleep(1000);
        WebElement arrivalDate = driver.findElement(By.id("dateTime_arr"));
        arrivalDate.sendKeys("01072021");
        Thread.sleep(2000);
        //WebElement submitButton = driver.findElement(By.cssSelector(".sub-btn"));
        submitButton.click();
        Thread.sleep(2000);

        //update the reservation informations
        WebElement yourReservationButton = driver.findElement(By.linkText("Your Reservations"));
        yourReservationButton.click();
        Thread.sleep(2000);
        WebElement updateButton = driver.findElement(By.cssSelector(".btn-info"));
        updateButton.click();
        Thread.sleep(2000);
        WebElement numberOfRoom = driver.findElement(By.id("room_number"));
        numberOfRoom.clear();
        numberOfRoom.sendKeys("3");
        Thread.sleep(2000);
        WebElement updateAndSubmitButton = driver.findElement(By.cssSelector(".sub-btn"));
        updateAndSubmitButton.click();
        Thread.sleep(2000);
        WebElement deleteButton = driver.findElement(By.cssSelector(".btn-danger"));
        deleteButton.click();
        Thread.sleep(2000);
        Alert al = driver.switchTo().alert();
        al.accept();
        Thread.sleep(2000);

        WebElement backHomeButton = driver.findElement(By.linkText("Back Home"));
        backHomeButton.click();
        Thread.sleep(2000);
        WebElement signOutButton = driver.findElement(By.linkText("Sign Out"));
        signOutButton.click();
    }

    @AfterTest
    public void tearDownTest() {
        //close browser
        driver.close();
        driver.quit();
        System.out.println("Reservations Test completed successfully");
    }

}
