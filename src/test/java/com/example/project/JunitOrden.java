package com.example.project;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.sql.Driver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitOrden {

    static private WebDriver driver;

    @BeforeAll
    static void driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    @Order(2)
    void ingreso() {
        driver.findElement(By.name("user")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys("secret");
        driver.findElement(By.xpath("/html/body/center/div/form/table/tbody/tr[3]/td[2]/input")).click();
    }

    @Test
    @Order(3)
    void compra() {
        driver.findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[2]/td[4]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[2]/td[4]/input")).sendKeys("3");
        driver.findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[3]/td[4]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[3]/td[4]/input")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[4]/td[4]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"listing\"]/tbody/tr[4]/td[4]/input")).sendKeys("1");
        //agregar-limpiar-salir
        driver.findElement(By.xpath("//*[@id=\"available\"]/input[1]")).click();
    }

    @Test
    @Order(1)
    void registro() {
        driver.manage().window().maximize();
        driver.get("https://sahitest.com/demo/training/login.htm");
        driver.findElement(By.xpath("/html/body/center/div/a")).click();
        driver.findElement(By.name("username")).sendKeys("sebastian");
        driver.findElement(By.name("password")).sendKeys("sebastian");
        driver.findElement(By.name("password2")).sendKeys("sebastian");
        driver.findElement(By.xpath("/html/body/center/div/form/div/table/tbody/tr[4]/td[2]/input[1]")).click();
        driver.findElement(By.name("address")).sendKeys("Cl87N #8Bc - 92 Cs 7 Mz 16");
        driver.findElement(By.name("billaddress")).sendKeys("Cl87N #8Bc - 92 Cs 7 Mz 16");
        driver.findElement(By.xpath("/html/body/center/div/form/div/table/tbody/tr[7]/td[2]/select")).click();//Desplegar lista
        driver.findElement(By.xpath("/html/body/center/div/form/div/table/tbody/tr[7]/td[2]/select/option[2]")).click(); //seleccionar lista
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("/html/body/center/div/form/input[2]")).click(); // boton registrar
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("/html/body/center/div/a")).click();
    }

    @Test
    @Order(4)
    void salir() {
        driver.findElement(By.xpath("//*[@id=\"available\"]/input[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"available\"]/input[3]")).click();
    }
}
