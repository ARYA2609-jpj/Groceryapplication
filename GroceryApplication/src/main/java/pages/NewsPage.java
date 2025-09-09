package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage  {
	public WebDriver driver;
	public NewsPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstile;
    public void clicknewstile() {
        newstile.click();
    }

    @FindBy(xpath="//a[@class='btn btn-rounded btn-danger' and @href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement addnewsbutton;
    public void clickaddnewsbutton() {
        addnewsbutton.click();
    }

    @FindBy(xpath="//textarea[@placeholder='Enter the news']")WebElement newsfield;
    public void enternews(String news) {
        newsfield.sendKeys(news);
    }

    @FindBy(xpath="//button[@name='create']")WebElement savenews;
    public void clicksavenews() {
        savenews.click();
    }

    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newsalert;
    public boolean isnewsadded() {
        return newsalert.isDisplayed();
    }
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstiles;

    public void clicknewstiles() {
        newstile.click();
    }

    @FindBy(xpath="//a[@class='btn btn-rounded btn-warning' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement resetfield;

    public void clickresetbutton() {
        resetfield.click();
    }

}
