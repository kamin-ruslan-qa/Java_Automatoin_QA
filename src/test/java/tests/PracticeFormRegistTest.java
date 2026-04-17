package tests;
import org.junit.jupiter.api.Test;
import pages.PracticeFormRegistPage;
import pages.components.FinalComponent;
import static tests.testdata.TestData.*;


public class PracticeFormRegistTest extends TestBase {

PracticeFormRegistPage practiceFormRegistPage = new PracticeFormRegistPage();
FinalComponent finalComponent = new FinalComponent();

    @Test
    void registrationFormTest()
    // Полная форма регистрации
    {
        useQaGuru();
        practiceFormRegistPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(day,month,year)
                .typeSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(upload)
                .typecurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm();



        finalComponent.chekResult("Student Name", firstName + " " + lastName)
                .chekResult("Student Email", userEmail)
                .chekResult("Gender", gender)
                .chekResult("Mobile", userNumber)
                .chekResult("Date of Birth", dateOfBirth)
                .chekResult("Subjects", subjects)
                .chekResult("Hobbies", hobbies)
                .chekResult("Picture", upload)
                .chekResult("Address", currentAddress)
                .chekResult("State and City", state + " " + city);

    }

    @Test
    void onlyRequiredFieldsTest()
    // регистрация с обязательными полями
    {
        useQaGuru();
        practiceFormRegistPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .submitForm();

        finalComponent.chekResult("Student Name", firstName + " " + lastName)
                .chekResult("Gender", gender)
                .chekResult("Mobile", userNumber);

    }


    @Test
    void negativeScriptOnTheNameTest() {
        //негативный сценарий 1
        useQaGuru();
        practiceFormRegistPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .submitForm();

        finalComponent.modalShouldNotBeVisible();
    }

    @Test
    void negativeScriptOnTheEmailTest() {
        //негативный сценарий 2
        useQaGuru();
        practiceFormRegistPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(inCorrectEmail)
                .submitForm();

        finalComponent.modalShouldNotBeVisible();
    }

    @Test
    void negativeScriptOnTheCheckingEmailTest()

    {
        //негативный сценарий 3
        useQaGuru();
        practiceFormRegistPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(inCorrectEmail)
                .submitForm();

        finalComponent.modalShouldNotBeVisible();
    }


    @Test
    void negativeScriptOnTheMobile()
    {
        //негативный сценарий 4
        useQaGuru();
        practiceFormRegistPage.openPage()
                .closeBanner()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .typeUserNumber(incorrectPhoneNumber)
                .submitForm();

        finalComponent.modalShouldNotBeVisible();
    }
}
