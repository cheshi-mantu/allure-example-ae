package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Project")
@Owner("egorivanov")
@Layer("web")
public class ProjectFeatureTests {
    @Test
    @AllureId("XXXXX")
    @DisplayName("Successful creation of a project by authenticated user")
    @Tags({@Tag("web"), @Tag("smoke"), @Tag("critical")})
    @Microservice("testops")
    @JiraIssue("AE-13")
    @JiraIssues({@JiraIssue("AE-13"), @JiraIssue("AE-22")})
    @Story("Creation of a project")
    public void shouldCreateProject() {
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
