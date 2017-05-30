package codesprinters.test01.pos;

import codesprinters.test01.pos.page.CodeSprintersPage;
import codesprinters.test01.pos.page.GooglePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by brodziak on 2017-05-30.
 */
public class CodeSprintersTests extends TestBase{

    private final String SEARCH_KEY = "Code Sprinters";

    @Test
    public void verifyIfGoogleFindsCodeSprinters() throws Exception {

        //GOOGLE PAGE
        //Otwieramy stronkę Google.com
        System.out.println("I'm going to " + GooglePage.GOOGLE_URL); //log
        GooglePage googlePage = new GooglePage(this.driver);

        /** Zastępujemy poniższą metodą
         googlePage.goToGoogle();

        //wyszukujemy na Googlu
        googlePage.searchOnGoogle(SEARCH_KEY);

        //click na danym wyniku
        googlePage.clickOnResultContaining(CodeSprintersPage.CODESPRINTERS_PAGE_TITLE);

        **/

        googlePage.googleFor(SEARCH_KEY, CodeSprintersPage.CODESPRINTERS_PAGE_TITLE);

        System.out.println("I'm leaving " + GooglePage.GOOGLE_URL); //log

        //Wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs(CodeSprintersPage.CODESPRINTERS_PAGE_TITLE));
        //Thread.sleep(5000); //opóźnienie żeby stronka się załadowała - pierwszy problem

        //CODESPRINTERS PAGE
        //sprawdzamy jaki mamy URL
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL); //testowo, tego nie robimy

        //ASSERTS
        //assert sprawdzający czy jesteśmy na odpowiedniej stronie
        Assert.assertEquals(currentURL, CodeSprintersPage.CODESPRINTERS_URL);
    }
}
