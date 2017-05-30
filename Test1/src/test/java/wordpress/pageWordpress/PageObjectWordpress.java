package wordpress.pageWordpress;

import org.openqa.selenium.WebDriver;

/**
 * Created by brodziak on 2017-05-30.
 */
public abstract class PageObjectWordpress {

    protected WebDriver driver;

    public PageObjectWordpress(WebDriver drv){
        this.driver = drv;
    }

}
