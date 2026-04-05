package tests;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest extends TestBase {

@Test
    void  successfulFillFromTest()
{
open ("/text-box");
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
}




