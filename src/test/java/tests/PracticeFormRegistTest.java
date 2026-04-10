package tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;


public class PracticeFormRegistTest extends TestBase {

    @Test
    void registrationFormTest()
    // Полная форма регистрации
    {
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(upload);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(City)).click();
        $("#submit").click();


        $("#resultBody").shouldHave(text(firstName + " " + lastName));
        $("#resultBody").shouldHave(text(userEmail));
        $("#resultBody").shouldHave(text(gender));
        $("#resultBody").shouldHave(text(userNumber));
        $("#resultBody").shouldHave(text("1994-08-25"));
        $("#resultBody").shouldHave(text(subjects));
        $("#resultBody").shouldHave(text(hobbies));
        $("#resultBody").shouldHave(text(upload));
        $("#resultBody").shouldHave(text(currentAddress));
        $("#resultBody").shouldHave(text(state + " " + City));

    }

    @Test
    void onlyRequiredFieldsTest()
    // регистрация с обязательными полями
    {
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#resultBody").shouldHave(text(firstName + " " + lastName));
        $("#resultBody").shouldHave(text(gender));
        $("#resultBody").shouldHave(text(userNumber));

    }


    @Test
    void negativeScriptOnTheNameTest() {
        //негативный сценарий 1
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
    }

    @Test
    void negativeScriptOnTheEmailTest() {
        //негативный сценарий 2
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("ruslanmailru");
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
    }

    @Test
    void negativeScriptOnTheCheckingEmailTest()

    {
        //негативный сценарий 3
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("ruslanmail.ru");
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
    }


    @Test
    void negativeScriptOnTheMobile()
    {
        //негативный сценарий 4
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue("8927");
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
    }
}
