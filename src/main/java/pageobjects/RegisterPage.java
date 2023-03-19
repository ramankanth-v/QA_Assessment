package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.UserAction;
import java.util.List;

public class RegisterPage {

    WebDriver driver;
    private UserAction userAction;


    public RegisterPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
        userAction = new UserAction(driver);


    }

    @FindBy(id="firstName")
    private WebElement firstNameField;

    @FindBy(id="lastName")
    private WebElement lastNameField;

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='flag-dropdown countryDropdown']")
    private WebElement selectCountry;

    @FindBy(xpath = "//input[@class='form-control phoneInput']")
    private WebElement phoneNumberField;

    @FindBy(id="organization")
    private WebElement companyName;

    @FindBy(id="role")
    private WebElement selectRoleOption;

    @FindBy(xpath = "//div[@class='flex flex-wrap mt-4']//label[@for='largeCompany']//input[@id='largeCompany']")
    private WebElement companySizeOption;

    @FindBy(xpath = "//div[@class='flex flex-wrap mt-4']//input[@value='2 - 10']")
    private WebElement responsibilitySize;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;



    public void enterFirstName(String firstNameText){

        userAction.typeTextIntoElement(firstNameField,firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterLastName(String lastNameText){

        userAction.typeTextIntoElement(lastNameField,lastNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public  void enterEmail(String emailText){

        userAction.javaScriptScroll(emailField,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        userAction.typeTextIntoElement(emailField,emailText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void selectCountryOption(){

        userAction.javaScriptScroll(selectCountry,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        userAction.clickOnElement(selectCountry,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

        List<WebElement> countryList = driver.findElements(By.xpath("//ul[@class='country-list ']//li"));
        for(int i=0; i<countryList.size();i++){

            if(countryList.get(i).getText().contains("India")){

                countryList.get(i).click();
                break;
            }

        }
    }
    public void enterPhoneNo(String telephoneText){

        userAction.typeTextIntoElement(phoneNumberField,telephoneText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void enterCompanyName(String companyText){

        userAction.typeTextIntoElement(companyName,companyText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void selectRole(String roleValue){

        userAction.selectOptionInDropdown(selectRoleOption,roleValue,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickCompanySize(){

       userAction.clickOnElement(companySizeOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickSubmitButton(){

        submitButton.click();
    }

    public void selectResponceSize(){

        userAction.javaScriptScroll(responsibilitySize,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        userAction.clickOnElement(responsibilitySize,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

}

