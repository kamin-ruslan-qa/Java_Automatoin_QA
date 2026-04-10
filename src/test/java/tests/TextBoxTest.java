package tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;


public class TextBoxTest extends TestBase {

    @Test
    void successfulFillFromTest()
    {
        useQaGuru();
        open("/one-page-form/text-box.html");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(userEmail));
        $("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
        $("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));
    }



    @Test

void fillingOutTheForm()
    {
        useQaGuru();
        open("/one-page-form/text-box.html");
        $("#userName").setValue(firstName);
        $("#submit").click();

        $("[id=output] [id=name]").shouldHave(text(firstName));

    }

    @Test

    void negativeEmailTest()
    {
        useDemoqa();
        open("/text-box");
        $("#userName").setValue(firstName);
        $("#userEmail").setValue("ruslankamin.ru");
        $("#submit").click();

        $(".field-error").shouldHave(visible);
    }

}