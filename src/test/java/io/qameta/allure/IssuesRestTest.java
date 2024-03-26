package io.qameta.allure;

import io.qameta.allure.model.Parameter;
import io.qameta.allure.Param;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;
import java.util.stream.Stream;

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
    @MethodSource("epochTimestamps")
    public void shouldDeleteUserNote(@Param(value = "HashOrSomething") long epochTimestamp) {
//    public void shouldDeleteUserNote(@Param(value = "Title", excluded = true) long epochTimestamp) {
//    public void shouldDeleteUserNote(@Param(mode = Parameter.Mode.) String title) {
        Date date = new Date(epochTimestamp);
        String note = date.toString();
        steps.createIssueWithTitle(OWNER, REPO, note);
        steps.closeIssueWithTitle(OWNER, REPO, note);
    }
    static Stream<Long> epochTimestamps() {
        long epochOne = System.currentTimeMillis();
        long epochTwo = System.currentTimeMillis() + 1000000; // Adding 1000 seconds for the second timestamp
        return Stream.of(epochOne, epochTwo);
    }

}
