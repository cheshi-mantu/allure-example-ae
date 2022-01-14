package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AuthenticationTests {
    @Test
    @AllureId("91363")
    @DisplayName("Successful auth with username and password")
    @Tag("smoke")
    @Feature("Authentication")
    @Story("Authentication via username and password")
    @Microservice("Authentication")
    @Owner("egorivanov")
    public void successfulAuthUserPassword() {
            step("Open log-in page ", ()->{
                Allure.attachment("Open page:", "https://testing.productname.org");
            });
            step("Click log-in button ");
            step("Enter credentials ", () -> {
                step("enter valid email ", ()->{
                    Allure.attachment("email:", "valid@email.com");
                });
                step("enter valid password ", ()->{
                    Allure.attachment("password:", "validP@ssword");
                });
                step("click ok ");
            });
            step("Check log-in is successful ", () -> {
                step("`User's avatar must be visible in the side menu", ()->{
                    step("Check <div> related to user menu is visible");
                });
            });
        }

}
