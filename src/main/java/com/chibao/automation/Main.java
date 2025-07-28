package com.chibao.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    // Test Case #1
    // Test Case Desc: Test Google Search Engine With a specific keyword: "JACK ĐOM ĐÓM"
    // Test steps:
    /*
        1. Open a random browser
        2. Enter url https://google.com
        3. Enter keywords into search box
        4. Hit enter to trigger the search engine
    */
    // Expected result: A list of web pages that contains the keyw ord
    public static void main(String[] args) throws InterruptedException {
        // Enter Testing App World
        // Nạp file điều khiển trình duyệt chrome vào trong máy ảo java, để nhận lệnh điều khiển trình duyệt
        System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");

        // Mở chế độ nào
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // anonymous tab
        options.addArguments("--lang=th-TH");

        WebDriver myBrowser = new ChromeDriver();

        // Vào trang bất kì
        myBrowser.get("https://www.google.com");
//        WebElement searchBox = myBrowser.findElement(By.name("q"));
        WebElement searchBox = myBrowser.findElement(By.xpath(""));
        searchBox.sendKeys("Jack 97");
        searchBox.submit();


        myBrowser.manage().window().maximize();


        // delay before quitting
        Thread.sleep(5000);

        // resolve leak memory
        myBrowser.quit();


    }

    // There are two types of testing methods
    // Firstly, Manual testers use their extremities to check the results of testing

    // Finally, Automate testers write code to automate the process of testing app, web, desktop app
    // Webapp: selenium, playwright, cypress(JS)
    // mobile, desktop: Appium


    // Automate testing uses another app to record manual testing

}