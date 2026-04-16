package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {


    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement permanentAddressInput = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");



    public TextBoxPage openPage(){
        open("/one-page-form/text-box.html");

        return this;
    }

    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage typeCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage typePermanentAddressInput(String value) {
        permanentAddressInput.setValue(value);

        return this;
}
public TextBoxPage submitForm(){
        submitButton.click();

    return this;
}
public TextBoxPage checkField(String key, String value){
    outputResults.$(byId(key)).shouldHave(text(value));

    return this;
}
}