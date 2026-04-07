package tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class PracticeFormRegistTest extends TestBase {

    @Test
    void registrationFormTest()
    // Полная форма регистрации
    {
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Kamin");
        $("#userEmail").setValue("ruslan@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8927123456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Test.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();


        $("#resultBody").shouldHave(text("Ruslan Kamin"));
        $("#resultBody").shouldHave(text("ruslan@mail.ru"));
        $("#resultBody").shouldHave(text("Male"));
        $("#resultBody").shouldHave(text("8927123456"));
        $("#resultBody").shouldHave(text("1994-08-25"));
        $("#resultBody").shouldHave(text("History"));
        $("#resultBody").shouldHave(text("Sports"));
        $("#resultBody").shouldHave(text("Test.jpg"));
        $("#resultBody").shouldHave(text("Moscow"));
        $("#resultBody").shouldHave(text("NCR Noida"));

    }

    @Test
    void onlyRequiredFieldsTest()
    // регистрация с обязательными полями
    {
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Kamin");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8927123456");
        $("#submit").click();

        $("#resultBody").shouldHave(text("Ruslan Kamin"));
        $("#resultBody").shouldHave(text("Male"));
        $("#resultBody").shouldHave(text("8927123456"));

    }


    @Test
    void negativeScriptOnTheNameTest() {
        //негативный сценарий 1
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Ruslan");
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
    }

    @Test
    void negativeScriptOnTheEmailTest() {
        //негативный сценарий 2
        useQaGuru();
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Kamin");
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
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Kamin");
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
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Kamin");
        $("#userEmail").setValue("ruslan@mail.ru");
        $("#userNumber").setValue("8927");
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
    }
}
