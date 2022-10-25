package CRA.cucumber.pom;

import my.first.selenium.project.pom.Demoqa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        File chromeDriver = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());

        WebDriver driver = new ChromeDriver();

        driver.get(PropertyReader.getProperty("demoqa.url.registration"));
        driver.manage().window().fullscreen();

        Demoqa demoqa = new Demoqa(driver);

        //enter first name method  wrong in this case for testing the Assert method
        demoqa.enterFirstName("");
        //enter last name method
        demoqa.enterLastName("Popescu");
        //enter email method
        demoqa.enterEmail("elena.popescu@gmail.com");
        //select gender
        WebElement radioButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[2]/label"));
        radioButton.click();
        //enter phone number method
        demoqa.enterPhoneNumber("0770123456");
        //select date of birth
        demoqa.enterDateOFBirth();
        Select selectMonthOfBirth = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")));
        selectMonthOfBirth.selectByVisibleText("March");
        Select selectYearOFBirth = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        selectYearOFBirth.selectByVisibleText("1998");
        WebElement exactDateOfBirth = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[5]"));
        exactDateOfBirth.click();
        //select subject method
        demoqa.enterSubject("Maths");
        //enter hobbies
        WebElement hobby1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div[2]/label"));
        hobby1.click();
        WebElement hobby2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div[3]/label"));
        hobby2.click();
        //enter picture method from local directory
        demoqa.enterPicture("C:\\Users\\ro_rpascu\\Desktop\\doggo.png");
        //enter address method
        demoqa.enterAddress("Street Something, Number Other");
        //select state method
        demoqa.selectState();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        demoqa.setSelectStateName("NCR");
        //select city method
        demoqa.selectCity();
        demoqa.selectCityName("Delhi");
        //press Submit button method
        demoqa.pressSubmitButton();
        //Assert method verification for the test
//        Assert.assertEquals("Something went wrong",
//                driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]", driver.findElement(By.id()))));
    }
}
