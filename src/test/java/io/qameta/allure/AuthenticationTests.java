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
    @Microservice("uaa")
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
                step("Users full name must be present in the deader", ()->{
                    //check content of the header for username
                });
            });
        }

}
