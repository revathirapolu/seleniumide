import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


/**
 * Created by ACER on 12/10/2014.
 */


public class AdminSmokeTestSuite {
    static WebDriver driver;

    @BeforeClass
    public static void openBrowser()
    {
        System.out.println("Opening the Browser");
        driver = new FirefoxDriver();
        String baseUrl ="http://insoftt.trial47.orangehrmlive.com/";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser()
    {
        System.out.println("Closing the Browser");
        driver.quit();
    }

    @Before
    public void login()
    {
        System.out.println("Logging In ");
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("admin");
        WebElement password =driver.findElement(By.id("txtPassword"));
        password.sendKeys("Insoft12");
        WebElement loginButton =driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @After
    public void logout()
    {
        System.out.println("Logging out");
        WebElement welcome =driver.findElement(By.id("welcome"));
        welcome.click();
        WebElement logout= driver.findElement(By.linkText("Logout"));
        logout.click();
    }

    @Test
    public void addJobTitle()
    {
        Assert.assertEquals("Welcome Admin",driver.findElement(By.id("welcome")).getText());
        System.out.println("Adding Job Title");
        WebElement adminMenu= driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminMenu.click();
        WebElement jobMenu= driver.findElement(By.id("menu_admin_Job"));
        jobMenu.click();
        WebElement jobTitle= driver.findElement(By.id("menu_admin_viewJobTitleList"));
        jobTitle.click();
        WebElement addButton =driver.findElement(By.id("btnAdd"));
        addButton.click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Test Architect"); //Change this for next iteration
        driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("Takes care of End to End Testing Architecture requirments");
        driver.findElement(By.id("jobTitle_note")).sendKeys("Level 2 in organisation");
        driver.findElement(By.id("btnSave")).click();
        //Checkpoint whether the Job title is added
        Assert.assertTrue(driver.findElement(By.linkText("Test Architect")).isDisplayed());//Change this for next iteration

    }

    @Test
    public void addSalaryComponent()
    {
        System.out.println("Adding Salary component");
        Assert.assertEquals("Welcome Admin",driver.findElement(By.id("welcome")).getText());
        System.out.println("Adding Salary Component");
        WebElement adminMenu= driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminMenu.click();
        WebElement jobMenu= driver.findElement(By.id("menu_admin_Job"));
        jobMenu.click();
        driver.findElement(By.id("menu_admin_viewSalaryComponentList")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("salary_component_name")).sendKeys("Housing Allowance");
        driver.findElement(By.id("salary_component_type_1")).click();
        driver.findElement(By.id("salary_component_add_to_total_payable")).click();
        driver.findElement(By.id("salary_component_value_type_2")).click();
        driver.findElement(By.id("btnSave")).click();

        //Checkpoint to see Salary component is Added Succesfully
        Assert.assertTrue(driver.findElement(By.linkText("Housing Allowance")).isDisplayed());
    }

    @Test
    public void addPayGrades()
    {

        Assert.assertEquals("Welcome Admin",driver.findElement(By.id("welcome")).getText());
        System.out.println("Adding Paygrades");
        WebElement adminMenu= driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminMenu.click();
        WebElement jobMenu= driver.findElement(By.id("menu_admin_Job"));
        jobMenu.click();
        WebElement payGrades = driver.findElement(By.id("menu_admin_viewPayGrades"));
        payGrades.click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("payGrade_name")).sendKeys("Grade1");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("btnAddCurrency")).click();
        driver.findElement(By.id("payGradeCurrency_currencyName")).sendKeys("GBP - Pound Sterling");
        driver.findElement(By.id("payGradeCurrency_minSalary")).sendKeys("20000");
        driver.findElement(By.id("payGradeCurrency_maxSalary")).sendKeys("30000");
        driver.findElement(By.id("btnSaveCurrency")).click();
        driver.findElement(By.id("menu_admin_Job")).click();
        driver.findElement(By.id("menu_admin_viewPayGrades")).click();

        //Checkpoint to see if the pay grade is added.
        Assert.assertTrue(driver.findElement(By.linkText("Grade1")).isDisplayed());

    }

    @Test
    public void addEmploymentStatus()
    {
        Assert.assertEquals("Welcome Admin",driver.findElement(By.id("welcome")).getText());
        System.out.println("Adding Employment Status");
        WebElement adminMenu= driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminMenu.click();
        WebElement jobMenu= driver.findElement(By.id("menu_admin_Job"));
        jobMenu.click();
        driver.findElement(By.id("menu_admin_employmentStatus")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("empStatus_name")).sendKeys("Apprenticeship");
        driver.findElement(By.id("btnSave")).click();
        //Checkpoint to see if the Employment Status is added
        Assert.assertTrue(driver.findElement(By.linkText("Apprenticeship")).isDisplayed());


    }

    @Test
    public void addJobCategories()
    {
        Assert.assertEquals("Welcome Admin",driver.findElement(By.id("welcome")).getText());
        System.out.println("Adding Job Categories");
        WebElement adminMenu= driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminMenu.click();
        WebElement jobMenu= driver.findElement(By.id("menu_admin_Job"));
        jobMenu.click();
        driver.findElement(By.id("menu_admin_jobCategory")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("jobCategory_name")).sendKeys("Quality Assurance");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_admin_Job")).click();
        driver.findElement(By.id("menu_admin_jobCategory")).click();
         //Checkpoint to see if Job category is added
        Assert.assertTrue(driver.findElement(By.linkText("Quality Assurance")).isDisplayed());
     }

    @Test
    public void addWorkShifts()
    {
        Assert.assertEquals("Welcome Admin",driver.findElement(By.id("welcome")).getText());
        System.out.println("Adding Work Shifts");
        WebElement adminMenu= driver.findElement(By.id("menu_admin_viewAdminModule"));
        adminMenu.click();
        WebElement jobMenu= driver.findElement(By.id("menu_admin_Job"));
        jobMenu.click();
        driver.findElement(By.id("menu_admin_workShift")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("workShift_name")).sendKeys("Part Time");
        driver.findElement(By.id("workShift_workHours_from")).sendKeys("16:00");
        driver.findElement(By.id("workShift_workHours_to")).sendKeys("23:00");
        driver.findElement(By.id("btnSave")).click();
        //Checkpoint to see if Work Shift is added
        Assert.assertTrue(driver.findElement(By.linkText("Part Time")).isDisplayed());

    }

   }
