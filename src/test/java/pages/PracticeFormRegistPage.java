package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.util.Calendar;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.gender;

public class PracticeFormRegistPage {
    CalendarComponent calendar = new CalendarComponent();

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private SelenideElement uploadPictureInput = $("#uploadPicture");


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

    public PracticeFormRegistPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormRegistPage setDateofBirth(String month, String day, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public PracticeFormRegistPage typeSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormRegistPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormRegistPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

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
