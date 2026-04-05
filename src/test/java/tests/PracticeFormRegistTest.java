package tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormRegistTest extends TestBase {

@Test
    void registrationFormTest() {
    open("/automation-practice-form");
    $("[id=firstName]").setValue("Ruslan");
    $("[id=lastName]").setValue("Kamin");
    $("[id=userEmail]").setValue("ruslan@mail.ru");
    $("[id=gender-radio-1]").click();
    $("[id=userNumber]").setValue("89271111111");
    $("[id=dateOfBirthInput]").click();
    $(".react-datepicker__month-select").selectOption("August");
    $(".react-datepicker__year-select").selectOption("1994");
    $(".react-datepicker__day--025").click();
    $("[id=subjectsInput]").setValue("History").pressEnter();
    $("[id=hobbies-checkbox-1]").click();
    $("[id=uploadPicture]").uploadFromClasspath("Test.png");
}
}
