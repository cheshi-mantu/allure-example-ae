package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.qameta.allure.Allure.step;

public class ManualTestsAsCode {

    @Test
    @AllureId("25846")
    @DisplayName("Successful auth with valid email and valid password")
    @Tags({@Tag("critical"), @Tag("regress"), @Tag("smoke"), @Tag("regular")})
    @Story("Authentication with email and password")
    @Owner("demo")
    @Manual
    @Feature("Authentication")
    public void successfulAuthUsernamePassword () {
        step("Open main page", ()->{
            Allure.attachment("Page URL", "http://page.to");
        });
        step("Click Log-in button");
        step("Enter valid credentials", () -> {
            step("Provide email", () -> {
                Allure.attachment("email", "valid@email.com");
             });
            step("Provide password", () -> {
                Allure.attachment("email", "validP@$$word");
             });
        });
        step("Click OK");
        step("Check user is authenticated", () -> {
            step("User name is to be in the header section", ()->{
//                File tempFile = new File("src/test/resources/png/add-group2project.png");

                FileInputStream pngFile = new FileInputStream("src/test/resources/png/add-group2project.png");
                Allure.addAttachment( "file.png", pngFile);;
                //screenshot to be attached
            });
        });
    }

}
