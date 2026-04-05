package tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest extends TestBase {

    @Test
    void successfulFillFromTest() {
        open("/one-page-form/text-box.html");
        $("[id=userName]").setValue("Ruslan Kamin");
        $("[id=userEmail]").setValue("ruslankamin@gmail.ru");
        $("[id=currentAddress]").setValue("firs address 1");
        $("[id=permanentAddress]").setValue("second address 2");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("Ruslan Kamin"));
        $("[id=output] [id=email]").shouldHave(text("ruslankamin@gmail.ru"));
        $("[id=output] [id=currentAddress]").shouldHave(text("firs address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));
    }



    @Test

void fillingOutTheForm()
    {
        open("/one-page-form/text-box.html");
        $("#userName").setValue("Ruslan");
        $("#submit").click();

        $("[id=output] [id=name]").shouldHave(text("Ruslan"));

    }

    @Test

    void negativeEmailTest()
    {
        open("/text-box");
        $("#userName").setValue("Ruslan");
        $("#userEmail").setValue("ruslankamin.ru");
        $("#submit").click();

        $(".field-error").shouldHave(visible);
    }

}









