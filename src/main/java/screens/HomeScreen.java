package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;

    public boolean isFabAddPresent(){
        //check
        should(fabAdd,10);
        return fabAdd.isDisplayed();
    }
    @FindBy(xpath = "")
    MobileElement fabAdd;
    @FindBy
    MobileElement burgerMenu;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logOutBtutton;

    public HomeScreen openMenu(){
        burgerMenu.click();
        return this;
    }

    public LoginScreen logOut(){
        logOutBtutton.click();
        return new LoginScreen(driver);
    }

    public HomeScreen checkFabButtonPresentAssert(){
        should(fabAdd,10);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }
}
