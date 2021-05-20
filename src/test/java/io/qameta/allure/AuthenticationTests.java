package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
@Layer("web")
@Owner("egorivanov")
public class AuthenticationTests {
    @Test
    @AllureId("12308")
    @DisplayName("Successful authentication with valid username (email) and valid password")
    @Tags({@Tag("critical"), @Tag("smoke")})
    @Story("Plain authentication")
    @Feature("Authentication")
    @Microservice("Authentication")

    void plainSuccessfulAuthTestUnameAndPassowrd() {

        step("Open https://somehost.org", () -> {
            //open https://somehost.org
        });
        step("Act: enter log-in information", () -> {
            step("locate email field by id '#email', enter valid email", () -> {
                //selenium locate id #email
                // sendKeys email@email.com
                Allure.addAttachment("email", "email@email.com");
            });
            step("locate password field by id '#password', enter valid password", () -> {
                //selenium locate id #password
                // selenium sendkeys
                Allure.addAttachment("password", "iddqd");
            });
            step("Click log-in button by id #btn-login", () -> {
                //selenium click the log-in button
            });
        });
        step("Assert: user has logged in", () -> {
            step("Selenuim to locate '.rct-title'", () -> {
                //'.rct-title' should exist in the page
            });
            step("Selenuim to check '.rct-title' content is email@email.com", () -> {
                //'.rct-title' should have text is email@email.com"
            });
        });
    }
}
