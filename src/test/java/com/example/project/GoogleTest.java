package com.example.project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {
    static private WebDriver driver;
    @BeforeAll
    static void antesTodo(){

        System.out.println("driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver","C:\\drivers\\win\\chromedriver.exe");
    }

    @Test// hace que el metodo sea un metodo de prueba
    void busquedaGoogle() {
        driver.get("https://www.mercadolibre.com.co/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"cb1-edit\"]")).sendKeys("galaxy a30");
        driver.findElement(By.xpath("//*[@id=\"cb1-edit\"]")).sendKeys(Keys.ENTER);
    }
}
