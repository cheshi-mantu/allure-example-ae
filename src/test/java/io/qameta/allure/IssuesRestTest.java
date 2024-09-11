package io.qameta.allure;

import io.qameta.allure.model.Parameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;
import java.util.stream.Stream;


@Owner("egorivanov")
@Feature("Parameterized tests")
public class IssuesRestTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @Story("Simple parameterized test")
    @DisplayName("Simple parameterised test")
    @Tags({@Tag("parameter"), @Tag("simple")})
    @ParameterizedTest(name = "({argumentsWithNames})")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void useCaseParameterizedTest(@Param("Note") String note) {
        steps.createIssueWithTitle(OWNER, REPO, note);
        steps.closeIssueWithTitle(OWNER, REPO, note);
    }


    @Story("Parameterized test with dynamic parameter marked as excluded")
    @DisplayName("Parameterised test with dynamic parameter")
    @Tags({@Tag("parameter"), @Tag("dynamic"), @Tag("excluded")})
    @ParameterizedTest(name = "({argumentsWithNames})")
    @Description("@Param(value = \"Title\", excluded = true \n allows having a dynamic parameter which is not being used in hashes to get history ID")
    @MethodSource("epochTimestamps")
    public void useCaseDynamicParameterExcluded(@Param(value = "Title", excluded = true) long epochTimestamp) {
        Date date = new Date(epochTimestamp);
        String note = date.toString();
        steps.createIssueWithTitle(OWNER, REPO, note);
        steps.closeIssueWithTitle(OWNER, REPO, note);
    }

    @Story("Parameterized test with dynamic parameter")
    @DisplayName("Parameterised test with parameter marked as Hidden")
    @Tags({@Tag("parameter"), @Tag("dynamic"), @Tag("hidden")})
    @Description("@Param(value = \"Title\", mode = Parameter.Mode.HIDDEN \n allows having a dymanic parameter in test, that is hidden from UI and \n" +
            "is not used the history ID calculations")
    @ParameterizedTest(name = "({argumentsWithNames})")
    @MethodSource("epochTimestamps")
    public void useCaseHiddenParameterTest(@Param(value = "Title", mode = Parameter.Mode.HIDDEN) long epochTimestamp) {
        Date date = new Date(epochTimestamp);
        String note = date.toString();
        steps.createIssueWithTitle(OWNER, REPO, note);
        steps.closeIssueWithTitle(OWNER, REPO, note);
    }

    @Story("Dynamic parameter")
    @DisplayName("Parameterised test with dynamic parameter")
    @Microservice("Report")
    @Tags({@Tag("parameter"), @Tag("dynamic")})
    @Description("If reran this test will leave 'In progress' test results in Allure TestOps launch.\n This parameter " +
            "is dynamic and breaks the calculation of historyId.")
    @ParameterizedTest(name = "({argumentsWithNames})")
    @MethodSource("epochTimestamps")
    public void shouldGenerateInProgressTestResultsIfRestarted(@Param(value = "HashOrSomething") long epochTimestamp) {
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
