package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Authentication")
@Owner("egorivanov")
@Layer("web")
public class AuthenticationTests {
    @Test
    @AllureId("IDIDID")
    @DisplayName("Successful authentication with username and password")
    @Tags({@Tag("web"), @Tag("smoke"), @Tag("critical")})
    @Microservice("uaa")
    @Story("Built-in authentication tests")
    public void shouldAuthWithUsernameAndPassword() {
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
