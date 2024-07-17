package Page.actions;

import Constants.ApplicationConstatnt;
import JavaCommands.SeleniumCommands;
import Page.objects.GenericActionObject;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class GenericAction extends SeleniumCommands {

    GenericActionObject genericActionObject = new GenericActionObject();

    public void navigateToUrl(String portal) {
        if (portal.equalsIgnoreCase("SWAGS LABS")) {
            browserNavigation("NAVIGATE", ApplicationConstatnt.PORTAL_URL);
        } else {
            System.out.println("URL is Not Found");
        }
    }

    public void loginCredentials(String Users) {
        String username = "", password = "";
        if (Users.equalsIgnoreCase("Standard User")) {
            username = ApplicationConstatnt.USERNAME;
            password = ApplicationConstatnt.PASSWORD;
        } else {
            System.out.println("Login Credentials are Incorrect");
        }

        SendInput(GenericActionObject.USERNAME_LOCATOR, username);
        SendInput(GenericActionObject.PASSWORD_LOCATOR, password);
        clickElement(GenericActionObject.LOGIN_BTN);

    }

    public void clickLinkText(String text) {

        clickElement(genericActionObject.linkText(text));
    }

    public void clickOnIcon() {
        clickElement(GenericActionObject.cartIcon);
    }

    public String getPriceDetails() {
        return getText(genericActionObject.priceDetails);

    }

    public void verifyPrice(String priceOfItem) {
        if (priceOfItem.equalsIgnoreCase("Sauce Labs Backpack")) {
            highlightText(genericActionObject.priceBand(ApplicationConstatnt.globalDataMap.get(priceOfItem).split("\\$")[1]));

            String exceptedData = ApplicationConstatnt.globalDataMap.get(priceOfItem);
            String actualData = String.valueOf(getText(genericActionObject.actualPrice));
            Assert.assertEquals(actualData, exceptedData);

        } else {
            System.out.println("The Price is Not Present");
        }

    }

    public void verifyPageContent(String text) {
        highlightText(genericActionObject.paraContent(text));

    }

    public void verifyPageHeader(String header) throws Exception {
        highlightText(genericActionObject.headerContent(header));
    }

    public void clickButton(String btn) {
        clickElement(genericActionObject.actionButton(btn));
    }


    public void dataTable(DataTable dt) {
        List<Map<String, String>> formEntry = dt.asMaps(String.class, String.class);

        String fieldName = "";
        String value = "";

        for (int i = 0; i < formEntry.size(); i++) {

            fieldName = formEntry.get(i).get("Field Name");

            value = formEntry.get(i).get("Value");

            String path = "//input[@placeholder='" + formEntry.get(i).get("Field Name") + "']";
            SendInput(By.xpath(path), value);

        }
    }

    public void addCart(String items){

        clickElement(genericActionObject.productItem(String.valueOf(items)));
    }

    public void add_MultipleProduct_ToCart(List<String> productNames){

        productNames.forEach(this::addCart);

    }

    public void verify_txt(String txt){

        highlightText(genericActionObject.text(txt));
    }


}
