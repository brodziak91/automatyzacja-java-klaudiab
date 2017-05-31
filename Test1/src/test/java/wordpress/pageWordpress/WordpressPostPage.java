package wordpress.pageWordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by brodziak on 2017-05-30.
 */
public class WordpressPostPage extends PageObjectWordpress{

    public final static String WORDPRESS_POST_URL ="https://autotestjava.wordpress.com/2017/05/30/maecenas-nec-interdum/#respond";

    // Points of interest

    // -----------

    public WordpressPostPage(WebDriver drv) {
        super(drv);
    }



    public void addComment(String commentText, String email, String name) {

        //wyszukujemy element
        WebElement commentField = driver.findElement(By.cssSelector(".comments-area #comment"));

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(commentField));

        commentField.click();
        commentField.sendKeys(commentText);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.click();
        emailField.sendKeys(email);

        WebElement nameField = driver.findElement(By.id("author"));
        nameField.clear();
        nameField.click();
        nameField.sendKeys(name);

        WebElement submit = driver.findElement(By.id("comment-submit"));
        submit.click();


    }

    /*public void findComment(String currentComment){

        WebElement comment = driver.findElement(By.xpath("//div[@class='comment-content']/p[contains(text(),'\" + currentComment + \"')]/../../div//a[contains(@class, 'comment-reply')]\""));
        comment.click();
    }*/

    public void addAnswer(String commentText, String answerText, String email, String name) {

        WebElement comment = driver.findElement(By.xpath("//div[@class='comment-content']/p[text()='" + commentText + "']/../../div//a[contains(@class, 'comment-reply')]"));
        comment.click();
        //WebElement replayButton = driver.findElement(By.xpath("//div[@class='reply']//a"));
        //replayButton.click();
        addComment(answerText, email, name);
    }

    public boolean hasComment(String commentText){
        List<WebElement> comment = driver.findElements(By.xpath("//article[@class='comment-body']//p[text()='"+commentText+"']"));
        return !comment.isEmpty();
    }

    /*
    public boolean hasName(String nameText){
        List<WebElement> name = driver.findElements(By.xpath("//article[@class='comment-body']//cite[text()='"+nameText+"'\"]"));
        return !name.isEmpty();
    }*/

    public boolean hasAnswer(String commentText, String answerComment){
        List<WebElement> name = driver.findElements(By.xpath("//div[@class='comment-content']/p[text()='" + commentText + "']/../../..//ul[@class='children']//p[text()='" + answerComment + "']"));
        if (name!=null){
            return true;
        }else {
            return false;
        }
    }


}
