package codesprinters.test01.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

/**
 * Created by brodziak on 2017-05-29.
 */
public class BasicTest {

    @Test
    public void verifyIfGoogleFindsCodeSprinters() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\brodziak\\Desktop\\Automatyzacja\\geckodriver.exe");

        //Initialize Firefox driver; Web driver to interfejs,
        WebDriver driver = new FirefoxDriver();

        //czyścimy cookiesy
        driver.manage().deleteAllCookies();

        //czeka maksymalnie 3s aż element się pojawi
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        //czas na zamknięcie wątków podczas ładowania strony; czeka najwyżej 10s żeby się skończyły, 10s na załadowanie stronki
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //do responsywnosści; możemy wskazać rozmiar
        driver.manage().window().maximize();

        //Otwieramy stronkę Google.com
        driver.get("http://www.google.com");


        //WebElement to wszystko to co możemy znaleźć na stronce; mamy WebElement o nazwie googleSearchBox do którego WebDriver wrzuci nam element o name="q" o ile go znajdzie
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        //wpisujemy tekst "code sprinters"
        googleSearchBox.sendKeys("Code Sprinters");
        //wciskamy ENTER
        googleSearchBox.sendKeys(Keys.ENTER);

        //szukamy stronki w wynikach po xpath
        WebElement codeSprinters = driver.findElement(By.xpath("//a[text()='Code Sprinters -']"));
        //klikamy na niego
        codeSprinters.click();

        Thread.sleep(5000); //opóźnienie żeby stronka się załadowała - pierwszy problem
        //sprawdzamy jaki mamy URL
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL); //testowo, tego nie robimy

        //assert sprawdzający czy jesteśmy na odpowiedniej stronie
        Assert.assertEquals(currentURL, "http://agileszkolenia.pl/");

        Thread.sleep(5000); //nie robimy tego w testach, tylko ćwiczeniowo żeby zobaczyć że działa

        //wyczyszczenie cacha; quit() - usuwa drivera z cacha
        if(driver!=null){
            driver.quit();
        }



    }

}
