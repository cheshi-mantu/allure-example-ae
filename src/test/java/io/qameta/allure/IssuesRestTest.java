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
@Owner("egoriavanov")
@Feature("TestsParameters")
public class IssuesRestTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @Story("Dynamic excluded param")
    @Microservice("Repository")
    @Tags({@Tag("parameter"), @Tag("dynamic"), @Tag("showcase")})
    @ParameterizedTest(name = "should show dynamic parameter but ignore it in history ID calcs")
    @MethodSource("epochTimestamps")
    public void shouldDeleteUserNote(@Param(value = "Title", excluded = true) long epochTimestamp) {
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
