package JavaCommands;

import Constants.ApplicationConstatnt;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SeleniumCommands {

    public String methodFailureMessage = null;
    public WebDriver driver;

    public static WebDriver getWebdriver() {
        return ApplicationConstatnt.driverMap.get(Thread.currentThread().threadId());
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void browserNavigation(String action, String URL) {

        try {
            String browserAction = action.toUpperCase();

            switch (browserAction) {

                case "BACK":
                    getWebdriver().navigate().back();
                    break;

                case "FORWARD":
                    getWebdriver().navigate().forward();
                    break;

                case "REFRESH":
                    getWebdriver().navigate().refresh();

                case "NAVIGATE":
                    getWebdriver().navigate().to(URL);

                default:
                    methodFailureMessage = "Selected action is not Present in list";
                    System.out.println(methodFailureMessage);
                    break;
            }
        } catch (Exception e) {
            methodFailureMessage = "Unable to Perform Action" + action + "because of an Exception" + e.getMessage();

        }

    }

    public void launchWebsite(String Url) {
        getWebdriver().navigate().to(Url);
    }

//    public void findElements(By locator) {
//
//        try {
//            getWebdriver().findElement(locator);
//        } catch (Exception e) {
//            methodFailureMessage = "Unable to Find Element" + locator + "Expressions is Failing" + e.getMessage();
//        }
//    }

    public void SendInput(By ele, String input) {

        try {
            getWebdriver().findElement(ele).sendKeys(input);
        } catch (Exception e) {
            methodFailureMessage = "Unable to send Data";
        }
    }

    public void clickElement(By element) {
        getWebdriver().findElement(element).click();
    }

    public String getText(By element) {
        WebElement element1 = getWebdriver().findElement(element);
        return element1.getText();
    }

    public WebElement findElement(By locator) throws Exception {
        WebElement element = null;
        try {
            element = getWebdriver().findElement(locator);
        } catch (Exception e) {
            methodFailureMessage = "FindElement method failed because of exception " + e.getMessage();
            throw new Exception(methodFailureMessage);
        }
        return element;
    }

    public List<WebElement> Elements(By locator) throws Exception {
        List<WebElement> elements = null;
        try {
            elements = getWebdriver().findElements(locator);
        } catch (Exception e) {
            methodFailureMessage = "FindElements method failed because of exception " + e.getMessage();
            throw new Exception(methodFailureMessage);
        }
        return elements;
    }

    public void highlightText(By element){
        //Create object of a JavascriptExecutor interface
        try {
            JavascriptExecutor js = (JavascriptExecutor) getWebdriver();
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 1px solid black;');", findElement(element));
        } catch (Exception exception) {
            System.out.println("Element couldn't be highlighted");
        }

    }


}






