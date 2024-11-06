package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaTest_Obj {
	WebDriver driver;
	
	public LumaTest_Obj(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath= "//div[@class='panel header']//a[text()='Create an Account']")
	private WebElement createAnAccount_Link;
	
	public WebElement getCeateAnAccount_Link() {
		return createAnAccount_Link;
	}
	
	@FindBy(xpath="//input[@id='firstname']")
	private WebElement firstName_Input;
	
	public WebElement getFirstName_Input() {
		return firstName_Input;
	}
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement lastName_Input;
	
	public WebElement getLastName_Input() {
		return lastName_Input;
	}
	
	@FindBy(xpath="//input[@id='email_address']")
	private WebElement email_Input;
	
	public WebElement getEmail_Input() {
		return email_Input;
	}
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password_Input;
	
	public WebElement getPassword_Input() {
		return password_Input;
	}
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	private WebElement confirmPassword_Input;
	
	public WebElement getConfirmPassword_Input() {
		return confirmPassword_Input;
	}
	
	@FindBy(xpath="//button[@class='action submit primary']")
	private WebElement createAnAccount_Button;
	
	public WebElement getCreateAnAccount_Button(){
		return createAnAccount_Button;
	}
	
	//After SignUp
	
	@FindBy(xpath="//button[@class='action switch']")
	private WebElement actionSwitch_DrpDwn;
	
	public WebElement   getActionSwitch_DrpDwn() {
		return actionSwitch_DrpDwn;
	}
	
	@FindBy(xpath="//li[@class='authorization-link']//a")
	private WebElement signOut_Link;
	
	public WebElement   getSignOut_Link() {
		return signOut_Link;
	}
	
	@FindBy(xpath="//ul[@class='header links']//li[@class='authorization-link']//a")
	private WebElement signIn_Link;
	
	public WebElement   getSignIn_Link() {
		return signIn_Link;
	}
	
	@FindBy(xpath="//div[@class='control']//input[@id='email']")
	private WebElement signInEmail_Input;
	
	public WebElement   signInEmail_Input() {
		return signInEmail_Input;
	}
	
	@FindBy(xpath="(//div[@class='control']//input[@id='pass'])[1]")
	private WebElement signInPassword_Input;
	
	public WebElement   signInPassword_Input() {
		return signInPassword_Input;
	}
	
	@FindBy(xpath="(//button[@name='send'])[1]")
	private WebElement signIn_SignIn_Btn;
	
	public WebElement   signIn_SignIn_Btn() {
		return signIn_SignIn_Btn;
	}
	
	

}
