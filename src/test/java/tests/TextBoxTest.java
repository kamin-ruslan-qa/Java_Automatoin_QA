package tests;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.FinalComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    FinalComponent finalComponent = new FinalComponent();

    @Test
    void successfulFillFromTest()
    {
        useQaGuru();
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddressInput(currentAddress)
                .typePermanentAddressInput(permanentAddress)
                .submitForm();


        textBoxPage.checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);

    }

    @Test

void fillingOutTheForm()
    {
        useQaGuru();
        textBoxPage.openPage()
                .typeUserName(firstName)
                .submitForm();

        textBoxPage.checkField("name", firstName);

    }

    @Test

    void negativeEmailTest()
    {
        useQaGuru();
        textBoxPage.openPage()
                .typeUserName(firstName)
                .typeUserEmail(inCorrectEmail)
                .submitForm();

        finalComponent.fieldErrorShouldBeVisible();
    }

}