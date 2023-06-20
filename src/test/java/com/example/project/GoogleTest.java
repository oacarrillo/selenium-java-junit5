package com.example.project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {
    static private WebDriver driver;

    @BeforeAll
    static void antesTodo(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test// hace que el metodo sea un metodo de prueba
    void busquedaGoogle() {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(1960, 824));
        driver.findElement(By.name("q")).sendKeys("cantantes de rock");
        driver.findElement(By.xpath("(//input[@name=\'btnK\'])[2]")).click();
    }

    @Test// hace que el metodo sea un metodo de prueba
    void busquedaGoogleNew() {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(1960, 824));
        driver.findElement(By.name("q")).sendKeys("cantantes de cumbia");
        driver.findElement(By.xpath("(//input[@name=\'btnK\'])[2]")).click();
    }

    @AfterAll
    static void despuesTodo(){
        driver.quit();
        System.out.println("final");
    }
}
