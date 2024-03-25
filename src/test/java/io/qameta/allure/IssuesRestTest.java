package io.qameta.allure;

import io.qameta.allure.model.Parameter;
import io.qameta.allure.Param;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.parameter;

@Layer("rest")
@Owner("baev")
@Feature("Issues")
public class IssuesRestTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @Story("Close existing issue")
    @Microservice("Repository")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("second-pipe")})
    @ParameterizedTest(name = "Close issue via api")
    @ValueSource(strings = {"First Note", "Second Note", "Third Note", "Fourth note"})
    public void shouldDeleteUserNote(@Param(value = "Title", excluded = true) String title) {
//    public void shouldDeleteUserNote(@Param(mode = Parameter.Mode.) String title) {
        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.closeIssueWithTitle(OWNER, REPO, title);
    }


}
