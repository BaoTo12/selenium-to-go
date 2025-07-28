package com.chibao.automation;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class Guru99Test {

    private static WebDriver webDriver;

    // DDT
    public static Object[][] initData(){
        return new Object[][]{{"mngr626236", "bevyjeb"}, {"mngr626247", "UtenErU"}};
    }

    @ParameterizedTest
    @MethodSource("initData")
    public void testGuru99LoginGivenManagerAccountsShowsWelcomeMessages(String user, String pass) throws InterruptedException {
        webDriver.get("https://demo.guru99.com/V4/");

        WebElement userTextBox = webDriver.findElement(By.xpath("//input[@name='uid']"));
        userTextBox.sendKeys(user);
        WebElement passTextBox = webDriver.findElement(By.xpath("//input[@name='password']"));
        passTextBox.sendKeys(pass);
        WebElement logiButton = webDriver.findElement(By.xpath("//input[@name='btnLogin']"));
        logiButton.click();
        // Navigate to another browser may be affected by the bandwidth
        // "Wait" term is very important when testing
        Thread.sleep(3000);
        WebElement messageTag = webDriver.findElement(By.cssSelector("tr[class='heading3'] td"));
        String expectedMsg = "Manger Id : " + user;
        String actualMsg = messageTag.getText();

        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    public void testGuru99LoginGivenManagerAccountShowsWelcomeMessage() throws InterruptedException {
        webDriver.get("https://demo.guru99.com/V4/");

        WebElement userTextBox = webDriver.findElement(By.xpath("//input[@name='uid']"));
        userTextBox.sendKeys("mngr626236");
        WebElement passTextBox = webDriver.findElement(By.xpath("//input[@name='password']"));
        passTextBox.sendKeys("bevyjeb");
        WebElement logiButton = webDriver.findElement(By.xpath("//input[@name='btnLogin']"));
        logiButton.click();
        // Navigate to another browser may be affected by the bandwidth
        // "Wait" term is very important when testing
        Thread.sleep(3000);
        WebElement messageTag = webDriver.findElement(By.cssSelector("tr[class='heading3'] td"));
        String expectedMsg = "Manger Id : mngr626236";
        String actualMsg = messageTag.getText();

        assertEquals(expectedMsg, actualMsg);
    }

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() throws InterruptedException {

        Thread.sleep(5000);
        webDriver.quit();
    }
}