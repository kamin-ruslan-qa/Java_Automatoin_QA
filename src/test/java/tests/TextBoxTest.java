package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
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

$("").shouldHave(text("Ruslan Kamin"));
$("").shouldHave(text("ruslankamin@gmail.ru"));
$("").shouldHave(text("firs address 1"));
$("").shouldHave(text("second address 2"));
    }
}
