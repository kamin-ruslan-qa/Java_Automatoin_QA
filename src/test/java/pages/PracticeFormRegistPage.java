package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.gender;

public class PracticeFormRegistPage {

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("##userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");


    public PracticeFormRegistPage openPage() {
        open("/one-page-form/automation-practice-form.html");

        return this;
    }

    public PracticeFormRegistPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormRegistPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormRegistPage typeEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormRegistPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }
}

//    public PracticeFormRegistPage submitForm(){
//
//    }
//    public PracticeFormRegistPage checkField (){
//
//    }
//}
