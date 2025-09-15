package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class NewsPage {
    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();   
    public NewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstile;

    public void clicknewstile() {
        pageUtility.clickonelement(newstile);  
    }

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement addnewsbutton;

    public void clickaddnewsbutton() {
        pageUtility.clickonelement(addnewsbutton);  
    }

    @FindBy(xpath = "//textarea[@placeholder='Enter the news']")WebElement newsfield;

    public void enternews(String news) {
        pageUtility.sendDataToElement(newsfield, news);  
    }

    @FindBy(xpath = "//button[@name='create']")WebElement savenews;

    public void clicksavenews() {
        pageUtility.clickonelement(savenews);  
    }

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement newsalert;

    public boolean isnewsadded() {
        return newsalert.isDisplayed();
    }

    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstiles;

    public void clicknewstiles() {
        pageUtility.clickonelement(newstile);  
    }

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-warning' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement resetfield;

    public void clickresetbutton() {
        pageUtility.clickonelement(resetfield);  
    }
}