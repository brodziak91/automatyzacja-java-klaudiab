package wordpress;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.pageWordpress.WordpressHomePage;
import wordpress.pageWordpress.WordpressPostPage;

/**
 * Created by brodziak on 2017-05-31.
 */
public class WordpressCommentAnswerTest extends TestBaseWordpress {

    @Test
    public void addAnswerToComment()throws Exception{
        String commentText = "Hello World! 2" + System.currentTimeMillis();
        String answerText = commentText + " Replay";
        String email = "klaudia.brodziak91@gmail.com";
        String name = "Klaudia Brodziak";
        String pattern = "4";

        WordpressHomePage wordpressPage = new WordpressHomePage(this.driver);
        wordpressPage.goToWordpressPage();

        wordpressPage.clickOnResultContaining(pattern);

        WordpressPostPage note = new WordpressPostPage(this.driver);

        note.addComment(commentText, email, name);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//article[@class='comment-body']//p[text()='"+commentText+"']"))));

        note.addAnswer(commentText, answerText, email, name);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//article[@class='comment-body']//p[text()='"+answerText+"']"))));

        //do zmiany - 3 asercje: 1 tekst, 2 - pod komentarzem, wcięcie
        Assert.assertTrue("Answer is added", note.hasAnswer(commentText, answerText));

    }
}
