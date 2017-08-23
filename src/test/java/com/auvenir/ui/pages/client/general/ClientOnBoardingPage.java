package com.auvenir.ui.pages.client.general;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;


public class ClientOnBoardingPage extends AbstractPage {

    public ClientOnBoardingPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//img[@class='header-auvenirLogo']")
    private WebElement eleAuvenirLogoImg;

    public WebElement getEleAuvenirLogoImg() {
        return eleAuvenirLogoImg;
    }

    @FindBy(xpath = "//input[@id='onboardCompanyName']")
    private WebElement eleCompanyNameTxtFld;

    public WebElement getEleCompanyNameTxtFld() {
        return eleCompanyNameTxtFld;
    }

    @FindBy(id = "link-onboarding-personaltitle")
    private WebElement elePERSONALTxt;

    public WebElement getElePERSONALTxt() {
        return elePERSONALTxt;
    }

    @FindBy(id = "link-onboarding-personalcircle")
    private WebElement elePERSONALImg;

    public WebElement getElePERSONALImg() {
        return elePERSONALImg;
    }

    @FindBy(id = "link-onboarding-businesstitle")
    private WebElement eleBUISNESSTxt;

    public WebElement getEleBUISNESSTxt() {
        return eleBUISNESSTxt;
    }

    @FindBy(id = "link-onboarding-businesscircle")
    private WebElement eleBUISNESSImg;

    public WebElement getEleBUISNESSImg() {
        return eleBUISNESSImg;
    }

    @FindBy(id = "link-onboarding-filestitle")
    private WebElement eleFILESTxt;

    public WebElement getEleFILESTxt() {
        return eleFILESTxt;
    }

    @FindBy(id = "link-onboarding-filescircle")
    private WebElement eleFILESImg;

    public WebElement getEleFILESImg() {
        return eleFILESImg;
    }

    @FindBy(id = "link-onboarding-securitytitle")
    private WebElement eleSECURITYTxt;

    public WebElement getEleSECURITYTxt() {
        return eleSECURITYTxt;
    }

    @FindBy(id = "link-onboarding-securitycircle")
    private WebElement eleSECURITYImg;

    public WebElement getEleSECURITYImg() {
        return eleSECURITYImg;
    }

    @FindBy(xpath = "//h3[contains(text(),'Please Confirm your Information')]")
    private WebElement elePleaseConfirmYourInfoTxt;

    public WebElement getElePleaseConfirmYourInfoTxt() {
        return elePleaseConfirmYourInfoTxt;
    }

    @FindBy(xpath = "//p[@class='auv-inputTitle'][contains(text(),'First and Last Name *')]")
    private WebElement eleFirstLastNameTxt;

    public WebElement getEleFirstLastNameTxt() {
        return eleFirstLastNameTxt;
    }

    @FindBy(xpath = "//input[@id='personal-name']")
    private WebElement eleFirstLastNameTxtFld;

    public WebElement getEleFirstLastNameTxtFld() {
        return eleFirstLastNameTxtFld;
    }

    @FindBy(xpath = "//p[@class='auv-inputTitle'][contains(text(),'Email Address *')]")
    private WebElement eleEmailAddressTxt;

    public WebElement getEleEmailAddressTxt() {
        return eleEmailAddressTxt;
    }

    @FindBy(xpath = "//input[@id='personal-email']")
    private WebElement eleEmailAddressTxtFld;

    public WebElement getEleEmailAddressTxtFld() {
        return eleEmailAddressTxtFld;
    }

    @FindBy(xpath = "//p[@class='auv-inputTitle'][contains(text(),'Phone Number *')]")
    private WebElement elePhoneNumberTxt;

    public WebElement getElePhoneNumberTxt() {
        return elePhoneNumberTxt;
    }

    @FindBy(xpath = "//input[@id='personal-phoneNumber']")
    private WebElement elePhoneNumberTxtFld;

    public WebElement getElePhoneNumberTxtFld() {
        return elePhoneNumberTxtFld;
    }

    @FindBy(xpath = "//img[@id='agreement-personal']")
    private WebElement eleIAgreeImg;

    public WebElement getEleIAgreeImg() {
        return eleIAgreeImg;
    }
    
    @FindBy(xpath = "//label[text()='I agree to the ']")
    private WebElement eleIAgreeTxt;

    public WebElement getEleIAgreeTxt() {
        return eleIAgreeTxt;
    }

    @FindBy(xpath = "//a[text()='privacy statement']")
    private WebElement elePrivacyStatementLnk;

    public WebElement getElePrivacyStatementLnk() {
        return elePrivacyStatementLnk;
    }

    @FindBy(xpath = "//a[text()='terms of service']")
    private WebElement eleTOSLnk;

    public WebElement getEleTOSLnk() {
        return eleTOSLnk;
    }

    @FindBy(xpath = "//button[@id='personal-coninueBtn']")
    private WebElement eleContinueBtn;

    public WebElement getEleContinueBtn() {
        return eleContinueBtn;
    }

    @FindBy(xpath = "//div[@id='personal-emptyPic']")
    private WebElement eleCameraImg;

    public WebElement getEleCameraImg() {
        return eleCameraImg;
    }

    @FindBy(xpath = "//button[@id='uploadCoverBtn']")
    private WebElement eleUploadPhotoBtn;

    public WebElement getEleUploadPhotoBtn() {
        return eleUploadPhotoBtn;
    }

    @FindBy(xpath = "//h3[contains(text(),'Please Confirm your Business Information')]")
    private WebElement elePleaseConfirmBuisnessTxt;

    public WebElement getElePleaseConfirmBuisnessTxt() {
        return elePleaseConfirmBuisnessTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Business Name *')]")
    private WebElement eleBuisnessNameTxt;

    public WebElement getEleBuisnessNameTxt() {
        return eleBuisnessNameTxt;
    }

    @FindBy(id = "business-name")
    private WebElement eleBuisnessNameTxtFld;

    public WebElement getEleBuisnessNameTxtFld() {
        return eleBuisnessNameTxtFld;
    }

    @FindBy(xpath = "//p[contains(text(),'Fiscal Year End *')]")
    private WebElement eleFiscalYearTxt;

    public WebElement getEleFiscalYearTxt() {
        return eleFiscalYearTxt;
    }

    @FindBy(id = "fiscal-year-end")
    private WebElement eleFiscalYearTxtFld;

    public WebElement getEleFiscalYearTxtFld() {
        return eleFiscalYearTxtFld;
    }

    @FindBy(xpath = "//p[contains(text(),'Accounting Framework *')]")
    private WebElement eleAccountingFrameTxt;

    public WebElement getEleAccountingFrameTxt() {
        return eleAccountingFrameTxt;
    }

    @FindBy(id = "accounting-framework")
    private WebElement eleAccountingFrameTxtFld;

    public WebElement getEleAccountingFrameTxtFld() {
        return eleAccountingFrameTxtFld;
    }

    @FindBy(xpath = "//div[@id='onboarding-business-container']//button[text()='Continue']")
    private WebElement eleBuisnessContinueBtn;

    public WebElement getEleBuisnessContinueBtn() {
        return eleBuisnessContinueBtn;
    }

    @FindBy(id = "business-emptyPic")
    private WebElement eleBuisnessCameraImg;

    public WebElement getEleBuisnessCameraImg() {
        return eleBuisnessCameraImg;
    }

    @FindBy(xpath = "//button[text()='Update Photo']")
    private WebElement eleBuisnessUploadBtn;

    public WebElement getEleBuisnessUploadBtn() {
        return eleBuisnessUploadBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'Integrate with your File Storage')]")
    private WebElement eleIntegrateFileTxt;

    public WebElement getEleIntegrateFileTxt() {
        return eleIntegrateFileTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Please select the directory where you keep your financial audit doucments and we will automatically sort them for you!')]")
    private WebElement elePleaseSelectTxt;

    public WebElement getElePleaseSelectTxt() {
        return elePleaseSelectTxt;
    }

    @FindBy(xpath = "//a[@class='files-storage-container']/div[text()='Google Drive']")
    private WebElement eleGoogleDriveTxt;

    public WebElement getEleGoogleDriveTxt() {
        return eleGoogleDriveTxt;
    }

    @FindBy(xpath = "//a[@class='files-storage-container']/img[@src='utilities/components/files/img/google-drive-logo-black.svg']")
    private WebElement eleGoogleDriveImg;

    public WebElement getEleGoogleDriveImg() {
        return eleGoogleDriveImg;
    }

    @FindBy(xpath = "//a[@class='files-storage-container']/div[text()='Local']")
    private WebElement eleLocalTxt;

    public WebElement getEleLocalTxt() {
        return eleLocalTxt;
    }

    @FindBy(xpath = "//input[@type='file']")
    private WebElement eleLocalImg;

    public WebElement getEleLocalImg() {
        return eleLocalImg;
    }

    @FindBy(xpath = "//button[text()='Skip']")
    private WebElement eleSkipBtn;

    public WebElement getEleSkipBtn() {
        return eleSkipBtn;
    }

    @FindBy(xpath = "//div[@id='onboarding-security-container']//button[text()='Skip']")
    private WebElement eleSecuritySkipBtn;

    public WebElement getEleSecuritySkipBtn() {
        return eleSecuritySkipBtn;
    }

    @FindBy(xpath = "//p[text()='Not ready to integrate right now?']")
    private WebElement eleNotReadyTxt;

    public WebElement getEleNotReadyTxt() {
        return eleNotReadyTxt;
    }

    @FindBy(xpath = "//p[text()='You can skip and find it in your settings later.']")
    private WebElement eleYouCanSkipTxt;

    public WebElement getEleYouCanSkipTxt() {
        return eleYouCanSkipTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Set Up')]")
    private WebElement eleSetUpTxt;

    public WebElement getEleSetUpTxt() {
        return eleSetUpTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Download the Auvenir')]")
    private WebElement eleDownloadtheAuvenirTxt;

    public WebElement getEleDownloadtheAuvenirTxt() {
        return eleDownloadtheAuvenirTxt;
    }

    @FindBy(xpath = "//button[contains(text(),'Text App Link')]")
    private WebElement eleTextAppLinkBtn;

    public WebElement getEleTextAppLinkBtn() {
        return eleTextAppLinkBtn;
    }

    @FindBy(id = "smsInputBox")
    private WebElement elePhoneNumberSmsInputTxtFld;

    public WebElement getElePhoneNumberSmsInputTxtFld() {
        return elePhoneNumberSmsInputTxtFld;
    }

    @FindBy(css = "img[class='register-mb-img']")
    private WebElement elePhoneImg;

    public WebElement getElePhoneImg() {
        return elePhoneImg;
    }

    @FindBy(css = "img[src='images/components/applestore.png']")
    private WebElement eleAppStoreImg;

    public WebElement getEleAppStoreImg() {
        return eleAppStoreImg;
    }

    @FindBy(css = "img[src='images/components/googlestore.png']")
    private WebElement eleGooglePlayImg;

    public WebElement getEleGooglePlayImg() {
        return eleGooglePlayImg;
    }


    @FindBy(xpath = "//label[contains(text(),'Skip Security')]//..//img[@src='images/icons/warning.svg']")
    private WebElement eleWarningImg;

    public WebElement getEleWarningImg() {
        return eleWarningImg;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]//..//..//img[@src='images/icons/x-small.svg']")
    private WebElement eleCloseImg;

    public WebElement getEleCloseImg() {
        return eleCloseImg;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]")
    private WebElement eleSkipSecurityTxt;

    public WebElement getEleSkipSecurityTxt() {
        return eleSkipSecurityTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'By choosing')]")
    private WebElement eleByChoosingTxt;

    public WebElement getEleByChoosingTxt() {
        return eleByChoosingTxt;
    }

    @FindBy(xpath = "//label[contains(text(),'defaulting to email')]//..//img")
    private WebElement eleIAmDefaultingChkBox;

    public WebElement getEleIAmDefaultingChkBox() {
        return eleIAmDefaultingChkBox;
    }

    @FindBy(xpath = "//label[contains(text(),'defaulting to email')]")
    private WebElement eleIAmDefaultingTxt;

    public WebElement getEleIAmDefaultingTxt() {
        return eleIAmDefaultingTxt;
    }

    @FindBy(xpath = "//label[contains(text(),'I take responsibility')]//..//img")
    private WebElement eleITakeResponsibilityChkBox;

    public WebElement getEleITakeResponsibilityChkBox() {
        return eleITakeResponsibilityChkBox;
    }

    @FindBy(xpath = "//label[contains(text(),'I take responsibility')]")
    private WebElement eleITakeResponsibilityTxt;

    public WebElement getEleITakeResponsibilityTxt() {
        return eleITakeResponsibilityTxt;
    }

    @FindBy(xpath = "//label[contains(text(),'I agree to Auvenir')]//..//img")
    private WebElement eleIAgreeToAuvenirChkBox;

    public WebElement getEleIAgreeToAuvenirChkBox() {
        return eleIAgreeToAuvenirChkBox;
    }

    @FindBy(xpath = "//label[contains(text(),'I agree to Auvenir')]")
    private WebElement eleIAgreeToAuvenirTxt;

    public WebElement getEleIAgreeToAuvenirTxt() {
        return eleIAgreeToAuvenirTxt;
    }

    @FindBy(className = "skip-security-link")
    private WebElement eleTermsAndConditionsSkipSecurityLnk;

    public WebElement getEleTermsAndConditionsSkipSecurityLnk() {
        return eleTermsAndConditionsSkipSecurityLnk;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]//..//..//input[@value='Cancel']")
    private WebElement eleCancelSkipSecurityBtn;

    public WebElement getEleCancelSkipSecurityBtn() {
        return eleCancelSkipSecurityBtn;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]//..//..//input[@value='Agree']")
    private WebElement eleAgreeSkipSecurityBtn;

    public WebElement getEleAgreeSkipSecurityBtn() {
        return eleAgreeSkipSecurityBtn;
    }

    @FindBy (xpath = "//img[@id='agreement-personal-cpa']")
    private WebElement agreePersonalCPAEle;

    /*@FindBy(xpath="//p[@id='onboard-introTitle']")
	private WebElement eleAuditSmarterTxt;
	public WebElement getEleAuditSmarterTxt(){
		return eleAuditSmarterTxt;
	}
	
	@FindBy(xpath="//div[@id='onboard-introBackground']/img")
	private WebElement eleOnboardIntroImg;
	public WebElement getEleOnboardIntroImg(){
		return eleOnboardIntroImg;
	}
			
	@FindBy(xpath="//div[@id='onboard-introBackground']//p[contains(text(),'Auvenir saves you time by automating mundane tasks carried')]")
	private WebElement eleAuvenirSavesYouTimeTxt;
	public WebElement getEleAuvenirSavesYouTimeTxt(){
		return eleAuvenirSavesYouTimeTxt;
	}
			
	@FindBy(xpath="//button[@id='startOnboardingBtn']")
	private WebElement eleGetStartedBtn;
	public WebElement getEleGetStartedBtn(){
		return eleGetStartedBtn;
	}
			
	@FindBy(xpath="//div[@id='onboardAboutYou-Bg']//p[contains(text(),'About You')]")
	private WebElement eleAboutYouTxt;
	public WebElement getEleAboutYouTxt(){
		return eleAboutYouTxt;
	}
			
	
			
	@FindBy(xpath="//span[contains(text(),'My Job Role')]")
	private WebElement eleMyJobRoleTxt;
	public WebElement getEleMyJobRoleTxt(){
		return eleMyJobRoleTxt;
	}
	
	@FindBy(xpath="//input[@id='onboardRole']")
	private WebElement eleMyJobRoleTxtFld;
	public WebElement getEleMyJobRoleTxtFld(){
		return eleMyJobRoleTxtFld;
	}

	@FindBy(xpath="//span[contains(text(),'Cell Phone')]")
	private WebElement eleCellPhoneTxt;
	public WebElement getEleCellPhoneTxt(){
		return eleCellPhoneTxt;
	}
			 
	@FindBy(xpath="//input[@id='onboardPhone']")
	private WebElement eleCellPhoneTxtFld;
	public WebElement getEleCellPhoneTxtFld(){
		return eleCellPhoneTxtFld;
	}

	@FindBy(xpath="//button[@id='aboutOnboardingBtn']")
	private WebElement eleContinueOnboardingBtn;
	public WebElement getEleContinueOnboardingBtn(){
		return eleContinueOnboardingBtn;
	}
		
	@FindBy(xpath="//p[text()='About Your Company']")
	private WebElement eleAboutYourCompanyTxt;
	public WebElement getEleAboutYourCompanyTxt(){
		return eleAboutYourCompanyTxt;
	}
	
	@FindBy(xpath="//span[text()='Company Name']")
	private WebElement eleCompanyNameTxt;
	public WebElement getEleCompanyNameTxt(){
		return eleCompanyNameTxt;
	}

	
	
	@FindBy(xpath="//span[text()='Industry']")
	private WebElement eleIndustryTxt;
	public WebElement getEleIndustryTxt(){
		return eleIndustryTxt;
	}

	@FindBy(xpath="//input[@id='onboardCompanyIndustry']")
	private WebElement eleIndustryTxtFld;
	public WebElement getEleIndustryTxtFld(){
		return eleIndustryTxtFld;
	}

	@FindBy(xpath="//span[text()='Fiscal Year End']")
	private WebElement eleFiscalYearEndTxt;
	public WebElement getEleFiscalYearEndTxt(){
		return eleFiscalYearEndTxt;
	}

	@FindBy(xpath="//input[@id='onboardCompanyYear']")
	private WebElement eleFiscalYearEndTxtFld;
	public WebElement getEleFiscalYearEndTxtFld(){
		return eleFiscalYearEndTxtFld;
	}
	
	@FindBy(xpath="//div[@class='cal-column cal-cell cal-currentMonth cal-slctd cal-today']")
	private WebElement eleFiscalYearEndCalDateSelect;
	public WebElement getEleFiscalYearEndCalDateSelect(){
		return eleFiscalYearEndCalDateSelect;
	}

	@FindBy(xpath="//div[@class='clear calendar onboardCompanyYear-tag']//div[@class='cal-row cal-nav']/i[@class='cal-btn cal-next cal-next-month fa fa-play']")
	private WebElement eleNextMonthBtn;
	public WebElement getEleNextMonthBtn(){
		return eleNextMonthBtn;
	}
	
	@FindBy(xpath="//button[@id='aboutCompanyOnboardingBtn']")
	private WebElement eleContinueCompanyOnboardBtn;
	public WebElement getEleContinueCompanyOnboardBtn(){
		return eleContinueCompanyOnboardBtn;
	}

	@FindBy(xpath="//p[text()='Setup Security']")
	private WebElement eleSetupSecurityTxt;
	public WebElement getEleSetupSecurityTxt(){
		return eleSetupSecurityTxt;
	}

	@FindBy(xpath="//p[contains(text(),'Download the Auvenir')]")
	private WebElement eleDownloadtheAuvenirTxt;
	public WebElement getEleDownloadtheAuvenirTxt(){
		return eleDownloadtheAuvenirTxt;
	}

	@FindBy(xpath="//p[text()='Setup Security']//..//div[@class='selected-flag']")
	private WebElement eleSelectFlagLst;
	public WebElement getEleSelectFlagLst(){
		return eleSelectFlagLst;
	}

	public String getFlag(){
		
		String flagXpath=driver.findElement(By.xpath("//div[@id='onboardDlApp']//div[@class='iti-flag ca']//following-sibling::div//preceding-sibling::div")).getAttribute("class");
		return flagXpath;
	}

	@FindBy(xpath="//p[text()='Setup Security']//..//li[@class='country']//span[@class='country-name']")
	private WebElement eleCountryNameSelectLst;
	public WebElement getEleCountryNameSelectLst(){
		return eleCountryNameSelectLst;
	}

	@FindBy(xpath="//p[text()='Setup Security']//..//li[@class='country']//span[@class='dial-code']")
	private WebElement eleCountryDialCodeSelectLst;
	public WebElement getEleCountryDialCodeSelectLst(){
		return eleCountryDialCodeSelectLst;
	}


	@FindBy(xpath="//p[text()='Setup Security']//..//li[@class='country']//div[@class='flag']")
	private WebElement eleCountryFlagSelectLst;
	public WebElement getEleCountryFlagSelectLst(){
		return eleCountryFlagSelectLst;
	}

	@FindBy(xpath="//p[contains(text(),'Setup Security')]/parent::div[@class='onboard-largeBG']/..//input[@id='numberToText_linkTexting_1']")
	private WebElement eleCountryCodePlaceHolderTxt;
	public WebElement getEleCountryCodePlaceHolderTxt(){
		return eleCountryCodePlaceHolderTxt;
	}

	@FindBy(xpath="//p[text()='Setup Security']//..//button[@id='sendButton_linkTexting_1']")
	private WebElement eleTextMeALinkBtn;
	public WebElement getEleTextMeALinkBtn(){
		return eleTextMeALinkBtn;
	}
			
	@FindBy(xpath="//img[@src='img/onboarding/phone1.jpg']")
	private WebElement eleIphoneImg;
	public WebElement getEleIphoneImg(){
		return eleIphoneImg;
	}
	
	@FindBy(xpath="//img[@src='img/onboarding/macApp.png']")
	private WebElement eleAppStoreImg;
	public WebElement getEleAppStoreImg(){
		return eleAppStoreImg;
	}
	
	@FindBy(xpath="//img[@src='img/onboarding/googleApp.png']")
	private WebElement eleGooglePlayImg;
	public WebElement getEleGooglePlayImg(){
		return eleGooglePlayImg;
	}
			
	@FindBy(xpath="//p[text()='Skip Security']")
	private WebElement eleSkipSecurityLnk;
	public WebElement getEleSkipSecurityLnk(){
		return eleSkipSecurityLnk;
	}
	
	@FindBy(xpath="//div[@id='onboardDlApp']//div[@class='flag-dropdown']//ul//li[@data-country-code='in']")
	private WebElement eleSelFirstFlag;
	public WebElement getEleSelFirstFlag(){
		return eleSelFirstFlag;
	}*/


    @FindBy(xpath = "//p[text()='Your client has been sent']")
    private WebElement eleYourClientHasBeenSentTxt;

    public WebElement getElYourClientHasBeenSentTxt() {
        return eleYourClientHasBeenSentTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Welcome to your Dashboard.')]")
    private WebElement eleWelcomeToDashboardTxt;

    public WebElement getEleWelcomeToDashboardTxt() {
        return eleWelcomeToDashboardTxt;
    }

    public String getCountryCode() {
        String countryCodeXP = getDriver().findElement(By.xpath("//p[contains(text(),'Setup Security')]/parent::div[@class='onboard-largeBG']/..//input[@id='numberToText_linkTexting_1']")).getAttribute("placeholder");
        return countryCodeXP;
    }


    public String getFlagDropDown() {
        String flagDropDownXP = getDriver().findElement(By.xpath("//div[@id='onboardDlApp']//div[@class='flag-dropdown']//ul")).getAttribute("class");
        return flagDropDownXP;
    }

    public String getCompanyNameText() {
        String companyNameText = getEleCompanyNameTxtFld().getText();
        return companyNameText;
    }

    public String getFiscalYearEndCalendar() {
        String fiscalEndYearCalendar = getDriver().findElement(By.xpath("//div[@class='onboard-inputContain']//div[@class='clear calendar onboardCompanyYear-tag']/div")).getAttribute("style");
        return fiscalEndYearCalendar;
    }

    public String getFiscalDate() {
        String fiscalDate = getDriver().findElement(By.xpath("//div[@class='cal-column cal-cell cal-currentMonth cal-slctd cal-today']")).getText();
        return fiscalDate;
    }

    public String getFiscalYearEndMonth() {
        String fiscalEndMonth = getDriver().findElement(By.xpath("//div[@class='clear calendar onboardCompanyYear-tag']//div[@class='cal-title']/span[@class='cal-month']")).getText();
        return fiscalEndMonth;
    }


    public String getFiscalYearEndYear() {
        String fiscalEndYear = getDriver().findElement(By.xpath("//div[@class='clear calendar onboardCompanyYear-tag']//div[@class='cal-title']/span[@class='cal-year']")).getText();
        return fiscalEndYear;
    }

    public WebElement getFinanceDay(int financeday) {
        WebElement financeDay = getDriver().findElement(By.xpath("(//div[@class='clear calendar onboardCompanyYear-tag']//div[text()='" + financeday + "'])[position()=1]"));
        return financeDay;
    }


    public int differenceInMonths(Date d1, Date d2) {
        Calendar futureDate = Calendar.getInstance();
        futureDate.setTime(d1);
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(d2);
        int difference = 0;
        if (currentDate.after(futureDate)) {
            while (currentDate.after(futureDate)) {

                futureDate.add(Calendar.MONTH, 1);
                if (currentDate.after(futureDate)) {
                    difference++;
                }
            }
        } else if (currentDate.before(futureDate)) {
            while (currentDate.before(futureDate)) {
                futureDate.add(Calendar.MONTH, -1);
                if (futureDate.before(currentDate)) {
                    difference--;
                }
            }
        }
        return difference;
    }


    public String getMonthShortName(int monthNumber) {
        String monthName = "";
        if (monthNumber >= 0 && monthNumber < 12)
            try {
                Calendar setCalendarMonth = Calendar.getInstance();
                setCalendarMonth.set(Calendar.MONTH, monthNumber);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMMMMMMM");
                simpleDateFormat.setCalendar(setCalendarMonth);
                monthName = simpleDateFormat.format(setCalendarMonth.getTime());
            } catch (Exception e) {
                if (e != null)
                    e.printStackTrace();
            }
        return monthName;
    }

    public void verifyClientOnBoardingPersonalStep(){
        getLogger().info("Verify Client On Boarding - Personal Information Step.");
        waitForVisibleElement(elePleaseConfirmYourInfoTxt, "Please Confirm your Information - Text");
        validateDisPlayedElement(elePleaseConfirmYourInfoTxt, "Please confirm your information - Text");
        validateElementText(elePleaseConfirmYourInfoTxt, "Please Confirm your Information");
        validateDisPlayedElement(eleAuvenirLogoImg, "Auvenir Logo");
        validateDisPlayedElement(elePERSONALTxt, "Personal Text");
        // Cannot find the element form old Code R1. Will update later
//        validateDisPlayedElement(eleBUISNESSTxt, "Buisness - Text");
//        validateDisPlayedElement(eleFILESTxt, "FILES Text");
        validateDisPlayedElement(eleSECURITYTxt, "SECURITY -Text");
        validateDisPlayedElement(elePERSONALImg, "PERSONAL Circle Image");
        // Cannot find the element form old Code R1. Will update later
//        validateDisPlayedElement(eleBUISNESSImg, "BUISNESS Circle Image");
//        validateDisPlayedElement(eleFILESImg, "FILES Circle Image ");
        validateDisPlayedElement(eleSECURITYImg, "SECURITY Circle Image");
        validateDisPlayedElement(eleFirstLastNameTxt, "First Name Last Name Text");
        validateDisPlayedElement(eleFirstLastNameTxtFld, "FirstName LastName TxtFld");
        validateDisPlayedElement(eleEmailAddressTxt, "Email Address - Text");
        validateDisPlayedElement(eleEmailAddressTxtFld, "Email Address Text Field");
        validateDisPlayedElement(elePhoneNumberTxt, "Phone Number - Text");
        validateDisPlayedElement(elePhoneNumberTxtFld, "Phone Number Text Field");
        validateDisPlayedElement(eleIAgreeImg, "I Agree - Image");
        validateDisPlayedElement(eleIAgreeTxt, "I Agree - Text");
        validateDisPlayedElement(eleCameraImg, "Camera Image");
        validateDisPlayedElement(eleUploadPhotoBtn, "Update Photo Button");
        validateDisPlayedElement(eleContinueBtn, "Continue button");
    }

    public void clickContinuePersonalInformationButton() {
        getLogger().info("Click Continue Button to confirm Personal Information.");
        clickElement(eleIAgreeImg, "Agree to the Privacy statament checkbox");
        clickElement(agreePersonalCPAEle, "Confirm a Chartered Professional Accountant checkbox");
        clickElement(eleContinueBtn, "Continue Button");
    }

    public void verifyClientOnBoardingBusinessStep() {
        getLogger().info("Verify Client On Boarding - Provide your Business Info Step.");
        waitForVisibleElement(elePleaseConfirmBuisnessTxt, "Please confirm your Business - Text");
        validateDisPlayedElement(elePleaseConfirmBuisnessTxt, "Please confirm your information - Text");
        validateElementText(elePleaseConfirmBuisnessTxt, "Please Confirm your Information");
        validateDisPlayedElement(eleBuisnessNameTxt, "Buisness Name Text");
        validateDisPlayedElement(eleBuisnessNameTxtFld, "Buisness Name Text Field");
        validateDisPlayedElement(eleFiscalYearTxt, "Fiscal Year End Text");
        validateDisPlayedElement(eleFiscalYearTxtFld, "Fiscal Year End Text Field");
        validateDisPlayedElement(eleAccountingFrameTxt, "Accounting Framework Text");
        validateDisPlayedElement(eleAccountingFrameTxtFld, "Accounting Framework Text Field");
        validateDisPlayedElement(eleBuisnessCameraImg, "Buisness Camera Image");
        validateDisPlayedElement(eleBuisnessUploadBtn, "Upload -Button");
        validateDisPlayedElement(eleBuisnessContinueBtn, "Continue button");
    }

    public void clickContinueBusinessInformationButton() {
        getLogger().info("Click Continue to confirm Business Information");
        clickElement(eleBuisnessContinueBtn, "Continue button");
    }

    public void verifyClientOnBoardingIntegrateFileStep(){
        getLogger().info("Verify Client On Boarding - Integrate File Step.");
        waitForVisibleElement(eleIntegrateFileTxt, "Integrate with your file storage - Text");
        validateDisPlayedElement(eleIntegrateFileTxt, "Integrate with your file storage - Text");
        validateElementText(eleIntegrateFileTxt, "Please Confirm your Information");
        validateDisPlayedElement(elePleaseSelectTxt, "Please select the directory - Text");
        validateDisPlayedElement(eleGoogleDriveTxt, "Google Drive - Text");
        validateDisPlayedElement(eleGoogleDriveImg, "Google Drive - Image");
        validateDisPlayedElement(eleLocalTxt, "Local - Text");
        validateDisPlayedElement(eleLocalImg, "Local Image");
        validateDisPlayedElement(eleSkipBtn, "Skip - Button");
        validateDisPlayedElement(eleNotReadyTxt, "Not ready to integrate - Text");
        validateDisPlayedElement(eleYouCanSkipTxt, "You can skip - Text");
    }

    public void clickSkipIntegrateFileButton() {
        getLogger().info("Click Skip Button");
        clickElement(eleSkipBtn, "Skip Button");
    }

    public void verifyClientOnBoardingSecurityStep() {
        getLogger().info("Verify Client On Boarding - Set Up Security");
        waitForVisibleElement(eleSetUpTxt, "Set Up Security - Text");
        validateDisPlayedElement(eleSetUpTxt, "Set Up Security - Text");
        validateElementText(eleSetUpTxt, "Set Up Security");
        validateDisPlayedElement(eleDownloadtheAuvenirTxt, "Download the auvenir - Text");
        validateDisPlayedElement(elePhoneNumberSmsInputTxtFld, "Phone Number - Text Fld");
        validateDisPlayedElement(eleTextAppLinkBtn, "Text App Link - Button");
        validateDisPlayedElement(elePhoneImg, "Phone Image");
        validateDisPlayedElement(eleAppStoreImg, "App Store Image");
        validateDisPlayedElement(eleGooglePlayImg, "Google Play Image");
        validateDisPlayedElement(eleSkipBtn, "Skip Button");
    }

    public void clickSkipSecurityButton() {
        getLogger().info("Click Skip Security Button.");
        clickElement(eleSecuritySkipBtn, "Skip button");
    }

    public void verifySkipSecurityPopUp() {
        getLogger().info("Verify Skip Security Popup.");
        waitForVisibleElement(eleSkipSecurityTxt, "Skip Security Text");
        validateDisPlayedElement(eleSkipSecurityTxt, "Skip Security Text");
        validateElementText(eleSkipSecurityTxt, "Skip Security");
        validateDisPlayedElement(eleWarningImg, "Warning Image");
        validateDisPlayedElement(eleCloseImg, "Close Image");
        validateDisPlayedElement(eleByChoosingTxt, "By Choosing Text");
        validateDisPlayedElement(eleIAmDefaultingChkBox, "I am Defaulting Check Box");
        validateDisPlayedElement(eleIAmDefaultingTxt, "I am Defaulting Text");
        validateDisPlayedElement(eleITakeResponsibilityChkBox, "I Take Responsibility Check Box");
        validateDisPlayedElement(eleITakeResponsibilityTxt, "I Take Responsibility Text");
        validateDisPlayedElement(eleIAgreeToAuvenirChkBox, "I Agree to Auvenir Check Box");
        validateDisPlayedElement(eleIAgreeToAuvenirTxt, "I Agree to Auvenir Text");
        validateDisPlayedElement(eleTermsAndConditionsSkipSecurityLnk, "Terms and Conditions Link");
        validateDisPlayedElement(eleCancelSkipSecurityBtn, "Cancel Button");
        validateDisPlayedElement(eleAgreeSkipSecurityBtn, "Agree Button");
    }

    public void clickSkipSecurityWarning() {
        getLogger().info("Click Skip the Security Warning Popup.");
        clickElement(eleIAmDefaultingChkBox, "I am defaulting checkbox");
        clickElement(eleITakeResponsibilityChkBox, "I take responsibility checkbox");
        clickElement(eleIAgreeToAuvenirChkBox, "I agree to Auvenir service checkbox");
        clickElement(eleAgreeSkipSecurityBtn, "Agree Button");
    }

    public void verifyDashBoardText(){
        getLogger().info("Click Skip the Security Warning Popup.");
        waitForVisibleElement(eleWelcomeToDashboardTxt, "Welcome to DashBoard - Text");
        validateDisPlayedElement(eleWelcomeToDashboardTxt, "Welcome to DashBoard - Text");
    }

}
	

