package stepDefinition;

import Constants.ApplicationConstatnt;
import Page.actions.GenericAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SwagLabs_StepDefinition extends GenericAction {

    GenericAction genericAction = new GenericAction();

    @Given("Navigate to the {string} Ecommerce Website")
    public void navigate_to_the_ecommerce_webiste(String url) throws Exception {
        // Write code here that turns the phrase above into concrete actions
       genericAction.navigateToUrl(url);
    }


    @And("Login to the Ecommerce Website as {string}")
    public void loginToTheEcommerceWebsiteAs(String applicationUser) {
        genericAction.loginCredentials(applicationUser);
    }

    @And("Click on the item {string}")
    public void clickOnTheItem(String str) {
        genericAction.clickLinkText(str);
    }

    @And("Verify the Page Header is {string}")
    public void verifyThePageHeaderIs(String strText) throws Exception {
        genericAction.verifyPageHeader(strText);

    }

    @Then("Verify the product item is {string}")
    public void verifyTheProductItemIs(String item) {
        genericAction.verifyPageContent(item);

    }

    @And("Verify the product item description is {string}")
    public void verifyTheProductItemDescriptionIs(String description) {
        genericAction.verifyPageContent(description);

    }

    @And("Click on the {string} button")
    public void clickOnTheButton(String btn) {
        genericAction.clickButton(btn);
    }

    @And("Wait for {string} seconds")
    public void waitForSeconds(String seconds) throws InterruptedException {
        int milliSeconds = Integer.parseInt(seconds) * 1000;
        Thread.sleep(milliSeconds);
    }

    @And("Get the Inventory item price {string}")
    public void getTheInventoryItemPrice(String price) {
    }

    @And("Click on the Shopping cart icon on the top right corner")
    public void clickOnTheShoppingCartIconOnTheTopRightCorner() {
        genericAction.clickOnIcon();

    }

    @And("Get the Inventory item price details {string}")
    public void getTheInventoryItemPriceDetails(String item) {
        String price ="";
        if(item.equalsIgnoreCase("Sauce Labs Backpack")) {
            price = genericAction.getPriceDetails();
            ApplicationConstatnt.globalDataMap.put(item, price);
            System.out.println(price);
        }
        else {
            System.out.println("Incorrect item Name");
        }
    }


    @And("Verify the Price band of {string}")
    public void verifyThePriceBandOf(String itemName) {
        genericAction.verifyPrice(itemName);


    }

    @And("Fill the below data")
    public void fillTheBelowData(DataTable dt) {
        genericAction.dataTable(dt);

    }
}
