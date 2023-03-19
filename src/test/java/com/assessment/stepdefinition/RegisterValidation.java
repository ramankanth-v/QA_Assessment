package com.assessment.stepdefinition;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.RegisterPage;
import java.io.IOException;
import java.util.Map;

public class RegisterValidation {

    WebDriver driver;

    private static RegisterPage registerPage;



    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() throws IOException {


        driver = DriverFactory.getDriver();


    }

    @When("User enters the details into below fields")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) {

        Map<String,String> dataMap=dataTable.asMap(String.class,String.class);

        registerPage = new RegisterPage(driver);


        registerPage.enterFirstName(dataMap.get("firstName"));
        registerPage.enterLastName(dataMap.get("lastName"));
        registerPage.enterEmail(dataMap.get("email"));
        registerPage.selectCountryOption();
        registerPage.enterPhoneNo(dataMap.get("phone number"));
        registerPage.selectRole("Software Developer");
        registerPage.enterCompanyName(dataMap.get("company name"));


    }
    @And("User selects Role option, company size and responsibility")
    public void selectRoleOption(){

        registerPage.clickCompanySize();
        registerPage.selectResponceSize();
    }
    @And("User clicks on submit button")
    public void submitButton(){
        registerPage.clickSubmitButton();
    }
    @Then("User account should get created successfully")
    public void accountCreation(){

    }

}
