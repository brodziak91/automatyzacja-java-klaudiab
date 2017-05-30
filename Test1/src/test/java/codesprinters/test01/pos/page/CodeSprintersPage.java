package codesprinters.test01.pos.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by brodziak on 2017-05-30.
 */
public class CodeSprintersPage extends PageObject{

    // URL CodeSprinters
    //public final static String CODESPRINTERS_URL = "http://agileszkolenia.pl/";
    public final static String CODESPRINTERS_URL ="https://www.facebook.com/CodeSprinters/";

    //public final static String CODESPRINTERS_PAGE_TITLE = "Code Sprinters -";
    public final static String CODESPRINTERS_PAGE_TITLE = "Code Sprinters - Home | Facebook";

    public CodeSprintersPage(WebDriver drv) {
        super(drv);
    }
}
