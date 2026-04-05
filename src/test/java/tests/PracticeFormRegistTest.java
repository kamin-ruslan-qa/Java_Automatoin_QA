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
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("[id=firstName]").setValue("Ruslan");
        $("[id=lastName]").setValue("Kamin");
        $("[id=userEmail]").setValue("ruslan@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("8927123456");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--025").click();
        $("[id=subjectsInput]").setValue("History").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFromClasspath("test.txt");
        $("[id=currentAddress]").setValue("Moscow");
        $("[id=state").click();
        $("[id=stateCity-wrapper]").$(byText("NCR")).click();
        $("[id=city]").click();
        $("[id=stateCity-wrapper]").$(byText("Noida")).click();
        $("#submit").click();


        $("[id=resultBody]").shouldHave(text("Ruslan Kamin"));
        $("[id=resultBody]").shouldHave(text("ruslan@mail.ru"));
        $("[id=resultBody]").shouldHave(text("Male"));
        $("[id=resultBody]").shouldHave(text("8927123456"));
        $("[id=resultBody]").shouldHave(text("1994-08-25"));
        $("[id=resultBody]").shouldHave(text("History"));
        $("[id=resultBody]").shouldHave(text("Sports"));
        $("[id=resultBody]").shouldHave(text("test.txt"));
        $("[id=resultBody]").shouldHave(text("Moscow"));
        $("[id=resultBody]").shouldHave(text("NCR Noida"));

    }

    @Test
    void onlyRequiredFieldsTest()
    // регистрация с обязательными полями
    {
        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Kamin");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("8927123456");
        $("#submit").click();

        $("#resultBody").shouldHave(text("Ruslan Kamin"));
        $("#resultBody").shouldHave(text("Male"));
        $("#resultBody").shouldHave(text("8927123456"));

    }


    @Test
    void negativeScriptOnTheNameTest() {
        //негативный сценарий 1

        open("/one-page-form/automation-practice-form.html");
        $("[aria-label='Close']").click();
        $("#firstName").setValue("Ruslan");
        $("#submit").click();

        $("#resultModal").shouldNotBe(visible);
    }

    @Test
    void negativeScriptOnTheEmailTest() {
        //негативный сценарий 2

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
