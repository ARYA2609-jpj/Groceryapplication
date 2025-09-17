package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {
    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();
    WaitUtility waitutility= new WaitUtility();
    
    public NewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement addnewsbutton;

    public NewsPage clickaddnewsbutton() {
        pageUtility.clickonelement(addnewsbutton);
        return this;
    }

    @FindBy(xpath = "//textarea[@placeholder='Enter the news']")WebElement newsfield;

    public NewsPage enternews(String news) {
        pageUtility.sendDataToElement(newsfield, news);  
        return this;
    }

    @FindBy(xpath = "//button[@name='create']")WebElement savenews;

    public NewsPage clicksavebutton() {
        pageUtility.clickonelement(savenews);
        return this;
    }

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement newsalert;

    public boolean isnewsadded() {
        return newsalert.isDisplayed();
    }


    

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-warning' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement resetfield;

    public NewsPage clickresetbutton() {
        pageUtility.clickonelement(resetfield); 
        return this;
    }
}