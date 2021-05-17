package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SuccessfulAuthorizationTests {
    @Test
    @AllureId("12266")
    @DisplayName("Successfully authorize a user with email and password")
    @Tags({@Tag("smoke"), @Tag("api"), @Tag("regular")})
    @JiraIssue("AE-1")
    @Story("Authorize a user with email and password")
    @Feature("Authorization")
    @Microservice("Auth")
    @Owner("egorivanov")
    void successfulAuthorizationEmailPassword() {
        step("Arrange: Open https://somehost.org", () -> {
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

