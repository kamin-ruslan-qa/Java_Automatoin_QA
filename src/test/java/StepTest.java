import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.WebSteps;


public class StepTest {
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тест с Steps")
    @Tag("test")
    @Owner("kamin-ruslan-qa")
    public void testIssueSearchSteps() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.clickSearchButton();
        steps.searchRepository();
        steps.clickIssues();
        steps.existIssues();
    }
}