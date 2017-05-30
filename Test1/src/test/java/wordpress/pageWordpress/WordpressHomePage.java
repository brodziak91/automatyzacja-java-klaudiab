package wordpress.pageWordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by brodziak on 2017-05-30.
 */
public class WordpressHomePage extends PageObjectWordpress{

    public final static String WORDPRESS_URL ="https://autotestjava.wordpress.com/";
    // Points of interest

    // -----------

    public WordpressHomePage(WebDriver drv) {
        super(drv);
    }

    public void goToWordpressPage(){
        driver.get(WORDPRESS_URL);
    }


    public void clickOnResultContaining(String pattern){

        //wyszukujemy element
        WebElement element = driver.findElement(
                resultWithPattern(pattern)
        );
        //klikamy na niego
        element.click();
    }


    //private methods
    private By resultWithPattern(String pattern){
        return By.xpath("(//article)["+pattern+"]//span[@class='comments-link']");
    }


}
