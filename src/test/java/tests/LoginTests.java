package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class LoginTests extends Configuration {

    @Test
    public void loginTestSuccess() {
//        boolean addPresent = new SplashScreen(driver)
//                .checkCurrencyVersion("0.0.3")
        boolean addPresent =  new LoginScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @AfterMethod
    public void postCondition(){
        //logout
        new HomeScreen(driver)
                .openMenu()
                .logOut();

    }

    @Test
    public void loginSuccessModel(){
       boolean addPresent = new LoginScreen(driver)
                .complexLogin(user)
                .isFabAddPresend();
        Assert.assertTrue(addPresent);
    }

    @Test
    public void loginNegativeModelWrongPassword(){
        new LoginScreen(driver)
                .complexLogin(user)
                .checkErrorMessage("Wrong email or password")
                .confirmError();//clk Ok btn

    }
}
