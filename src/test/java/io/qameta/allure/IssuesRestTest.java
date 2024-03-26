package io.qameta.allure;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;


@Layer("rest")
@Owner("egoriavanov")
@Feature("Tests Parameters")
public class IssuesRestTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @Story("Dynamic excluded parameter")
    @Microservice("Report")
    @Tags({@Tag("parameter"), @Tag("dynamic"), @Tag("excluded")})
    @ParameterizedTest(name = "should show dynamic parameter but ignore it in history ID calculations")
    @MethodSource("epochTimestamps")
    public void shouldIgnoreDynamicParametersInTesgResults(@Param(value = "Title", excluded = true) long epochTimestamp) {
        Date date = new Date(epochTimestamp);
        String note = date.toString();
        steps.createIssueWithTitle(OWNER, REPO, note);
        steps.closeIssueWithTitle(OWNER, REPO, note);
    }
    static Stream<Long> epochTimestamps() {
        long epochOne = System.currentTimeMillis();
        long epochTwo = System.currentTimeMillis() + 1000123;
        return Stream.of(epochOne, epochTwo);
    }

}
