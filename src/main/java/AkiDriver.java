import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AkiDriver {
    static WebDriver driver;
    Map<Integer,String> answers = new HashMap<Integer, String>();

    public AkiDriver()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        answers.put(1,"a_yes");
        answers.put(2,"a_no");
        answers.put(3,"a_dont_know");
        answers.put(4,"a_probably");
        answers.put(5,"a_probably_not");
        driver.get("https://ru.akinator.com/");
        driver.findElement(By.cssSelector("[href='/game']")).click();
    }

    public String getQuestion() {
        String question;
        question = driver.findElement(By.cssSelector("p.question-text")).getText();
        return question;
    }

    public String getProposal() {
        String proposal;
        proposal = driver.findElement(By.cssSelector("span.proposal-title")).getText();
        return proposal;
    }

    public void sendAnswer(int key) throws InterruptedException
    {
        driver.findElement(By.cssSelector("a[id='"+ answers.get(key) +"']")).click();
    }

    public void sendProposalAnswer(int ans)
    {
        if(ans == 1)
        {
            driver.findElement(By.cssSelector("a[id='a_propose_yes']")).click();
            return;
        }
        driver.findElement(By.cssSelector("a[id='a_propose_no']")).click();
    }

    public void sendContinueAnswer(int ans)
    {
        if(ans == 1)
        {
            driver.findElement(By.cssSelector("a[id='a_continue_yes']")).click();
            return;
        }
        driver.findElement(By.cssSelector("a[id='a_continue_no']")).click();
    }

    public boolean checkContinue()
    {
        try
        {
            return driver.findElement(By.cssSelector("div.aki-formulaire")).isEnabled();
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean checkProposal()
    {
        try
        {
            return driver.findElement(By.cssSelector("div.bubble-propose-container")).isEnabled();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean checkWin()
    {
        try
        {
            return driver.findElement(By.cssSelector("div.bubble-win")).isEnabled();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void off()
    {
        driver.quit();
    }
}