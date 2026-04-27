package tests;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.FinalComponent;
import tests.testdata.TestData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    FinalComponent finalComponent = new FinalComponent();
    TestData testData = new TestData();

    @Test
    void successfulFillFromTest()
    {
        useQaGuru();
        textBoxPage.openPage()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddressInput(testData.currentAddress)
                .typePermanentAddressInput(testData.permanentAddress)
                .submitForm();


        textBoxPage.checkField("name", testData.userName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.permanentAddress);

    }

    @Test

void fillingOutTheForm()
    {
        useQaGuru();
        textBoxPage.openPage()
                .typeUserName(testData.firstName)
                .submitForm();

        textBoxPage.checkField("name", testData.firstName);

    }

    @Test

    void negativeEmailTest()
    {
        useQaGuru();
        textBoxPage.openPage()
                .typeUserName(testData.firstName)
                .typeUserEmail(testData.inCorrectEmail)
                .submitForm();

        finalComponent.fieldErrorShouldBeVisible();
    }

}