package wordpress;

import codesprinters.test01.pos.page.CodeSprintersPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.pageWordpress.WordpressHomePage;
import wordpress.pageWordpress.WordpressPostPage;

/**
 * Created by brodziak on 2017-05-30.
 */
public class WordpressTests extends TestBaseWordpress{

    private final String pattern = "3";

    @Test
    public void verifyAddingComment() throws Exception {

        String commentText = "Hello World! 2" + System.currentTimeMillis();
        String email = "klaudia.brodziak91@gmail.com";
        String name = "Klaudia Brodziak";

        WordpressHomePage wpPage = new WordpressHomePage(this.driver);

        wpPage.goToWordpressPage();
        wpPage.clickOnResultContaining(pattern);

        WordpressPostPage comment = new WordpressPostPage(this.driver);
        comment.addComment(commentText, email, name);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//article[@class='comment-body']//p[text()='"+commentText+"']"))));

        Assert.assertTrue("Comment is added", comment.hasComment(commentText));

    }

}
