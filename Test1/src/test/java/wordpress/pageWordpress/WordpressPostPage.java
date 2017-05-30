package wordpress.pageWordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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



    public void addComment(String commentText, String email, String name){
        //wyszukujemy element
        WebElement commentField = driver.findElement(By.cssSelector(".comments-area #comment"));
        commentField.click();
        commentField.sendKeys(commentText);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement nameField = driver.findElement(By.id("author"));
        nameField.click();
        nameField.sendKeys(name);

        WebElement submit = driver.findElement(By.id("comment-submit"));
        submit.click();

    }

    public boolean hasComment(String commentText){
        List<WebElement> comment = driver.findElements(By.xpath("//article[@class='comment-body']//p[text()='"+commentText+"']"));
        return !comment.isEmpty();
    }


    public boolean hasName(String nameText){
        List<WebElement> name = driver.findElements(By.xpath("//article[@class='comment-body']//cite[text()='"+nameText+"'\"]"));
        return !name.isEmpty();
    }


}
