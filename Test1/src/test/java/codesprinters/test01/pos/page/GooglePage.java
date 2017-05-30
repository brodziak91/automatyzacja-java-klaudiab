package codesprinters.test01.pos.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by brodziak on 2017-05-30.
 */
public class GooglePage extends PageObject {

    // URL Googla
    public final static String GOOGLE_URL = "http://www.google.com";

    // Points of interest
    private final By SEARCH_FIELD = By.name("q"); //By to klasa Selenium

    // -----------

    //konstruktor musi być z parenta
    public GooglePage(WebDriver drv) {
        super(drv);
    }

    public void goToGoogle(){
        driver.get(GOOGLE_URL);
    }

    public void searchOnGoogle(String query){
        //WebElement to wszystko to co możemy znaleźć na stronce; mamy WebElement o nazwie googleSearchBox do którego WebDriver wrzuci nam element o name="q" o ile go znajdzie
        WebElement googleSearchBox = driver.findElement(SEARCH_FIELD);
        //wpisujemy tekst "code sprinters"
        googleSearchBox.sendKeys(query);
        //wciskamy ENTER
        googleSearchBox.sendKeys(Keys.ENTER);
    }

    public void clickOnResultContaining(String pattern){

        //wyszukujemy element
        WebElement element = driver.findElement(
                resultWithPattern(pattern)
        );
        //klikamy na niego
        element.click();
    }

    //Metoda zastępująca powyższe
    public void googleFor(String what, String where){
        this.goToGoogle();
        this.searchOnGoogle(what);
        this.clickOnResultContaining(where);
    }

    //private methods
    private By resultWithPattern(String pattern){
        return By.xpath("//a[text()='" + pattern + "']");
    }

}
