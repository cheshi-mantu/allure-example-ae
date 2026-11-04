package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

@Epic("Allure TestOps Entities")
@Feature("Project")
@Owner("bugsbunny")
@Layer("e2e")
public class NewTestCreationWithAllMeta {
    @Test
    @Story("Creation of a project")
    @Microservice("reporting")
    @DisplayName("Successful creation of a project by authenticated user")
    @Tags({@Tag("e2e"), @Tag("smoke"), @Tag("critical"), @Tag("regress")})
    @JiraIssues({@JiraIssue("AD-1"), @JiraIssue("AD-5")})
    public void shouldBeAbleToCreateProject() {
        step("Open log-in page ", ()->{
            Allure.attachment("Open page:", "https://demo.testops.cloud");
        });
        step("Click log-in button ");
        step("Enter credentials ", () -> {
            step("enter valid email ", ()->{
                Thread.sleep(404);
                Allure.attachment("email:", "valid@email.com");
            });
            step("enter valid password ", ()->{
                Thread.sleep(500);
                Allure.attachment("password:", "validP@ssword");
            });
            step("click ok ");
        });
        step("Check log-in is successful ", () -> {
            Thread.sleep(945);
            step("`User's avatar must be visible in the side menu", ()->{
                step("Check <div> related to user menu is visible");
            });
        });
        step("Checking the creation if a new project", () -> {
            step("Click `Create new project`", ()-> {
                Thread.sleep(1234);
            });
            step("Enter New Project name");
            step("Enter the description");
            step("Click Submit", ()-> {
                Thread.sleep(2134);
            });
            step("Assert", () -> {
                Thread.sleep(945);
                step("User is redirected to new project");
                step("User sees the empty list of test cases");
            });
        });
    }

}