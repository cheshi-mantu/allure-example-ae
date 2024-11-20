package io.qameta.allure;

import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@Feature("Authentication")
@Owner("egorivanov")
@Layer("web")
public class AuthenticationTests {
    @BeforeEach
    public void shouldAuthWithUsernameAndPassword() {
            step("Open log-in page ", ()->{
                Allure.attachment("Open page:", "https://demo.testops.cloud");
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
    @Test
    @AllureId("XXXXX")
    @DisplayName("Successful authentication with username and password")
    @Tags({@Tag("web"), @Tag("smoke"), @Tag("critical")})
    @Microservice("testops")
    @JiraIssue("AE-22")
    @JiraIssue("AE-13")
    @Story("Built-in authentication tests")
    public void shouldCreateProjectForAuthenticatedUser() {
        step("Click Create Project Button", ()->{
        });
        step("Add name for the project", () -> {
            step("Generate random string");
            step("Paste random string content to the project creation form field with ID = name");
        });
        step("Click Submit button", () -> {        });
        step("Check creation of the project is successful", () -> {
            step("User is forwarded to New project with generated name", ()->{
                step("User sees the header Test cases");
            });
        });
    }


}
