package Page.objects;

import org.openqa.selenium.By;

public class GenericActionObject {


    public static By USERNAME_LOCATOR = By.id("user-name");
    public static By PASSWORD_LOCATOR =By.id("password");

    public static By LOGIN_BTN = By.id("login-button");

    public By priceDetails = By.xpath("//div[@class='inventory_details_price']");

    public By priceItem = By.xpath("//div[text()='%s']");

    public static By cartIcon = By.xpath("//*[@class='shopping_cart_link']");

    public By priceBand(String price){
        return By.xpath("//div[@class='item_pricebar']/div[text()='"+price+"']");
    }

    public By actualPrice = By.xpath("//div[@class='inventory_item_price']");

    public By linkText(String text){

        return By.xpath("//div[text()='"+text+"']");
    }

    public By headerContent(String strText){
        return By.xpath("//*[@class='title'][text()='"+strText+"']");
    }

    public By paraContent(String paraText){
        return By.xpath("//*[text()='"+paraText+"']");
    }

    public By actionButton(String btn){
        return By.xpath("//button[text()='"+btn+"'] | //a[text()='"+btn+"'] | //input[@value='"+btn+"']");
    }


}
