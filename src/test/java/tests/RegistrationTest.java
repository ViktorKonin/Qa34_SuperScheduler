package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTest extends Configuration {

    @Test
    public void registrationSuccsess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        new LoginScreen(driver)
                .fillEmail("ralf" + i + "@gmail.com")
                .fillPassword("Ralf12345$")
                .submitRegistration()
                .skipWizard()
                .checkFabButtonPresentAssert()
                .openMenu()
                .logOut();


    }
}
