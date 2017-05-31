package wordpress;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by brodziak on 2017-05-30.
 */

//klasy abstrakcyjne nie są parsowane, tym się zabezpieczamy; każda klasa która dziedziczy po TestBase wykona @before
public abstract class TestBaseWordpress {

    protected WebDriver driver;
    private final String PROPERTY_NAME = "webdriver.gecko.driver"; //final pole klasy, nie można jej zmienić
    private final String DRIVER_PATH = "C:\\Users\\brodziak\\Desktop\\Automatyzacja\\geckodriver.exe";



    @Before
    public void testSetUp(){
        System.setProperty(PROPERTY_NAME, DRIVER_PATH);

        //Initialize Firefox driver; Web driver to interfejs
        driver = new FirefoxDriver();

        //czyścimy cookiesy
        driver.manage().deleteAllCookies();

        //czeka maksymalnie 3s aż element się pojawi
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        //czas na zamknięcie wątków podczas ładowania strony; czeka najwyżej 10s żeby się skończyły, 10s na załadowanie stronki
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //do responsywnosści; możemy wskazać rozmiar
        driver.manage().window().maximize();
    }

    @After
    public void testTearDown(){
        //wyczyszczenie cacha; quit() - usuwa drivera z cacha
        if(driver!=null){
            driver.quit();
        }
    }

}
