package selenium;

/*
Çàâäàííÿ: Êîðèñòóâà÷ ââîäèòü (ç òåðì³íàëó) ïîøóêîâèé çàïèò. Ïðîãðàìà â³äêðèâàº â³êíî
Firefox, çàâàíòàæóº ñòîð³íêó Google, ââîäèòü ïîøóêîâèé çàïèò ³ íàòèñêàº “Ïîøóê”. Ï³ñëÿ
öüîãî â öèêë³, äëÿ êîæíîãî ðåçóëüòàòó ç ïåðøî¿ ñòîð³íêè: ïåðåéòè íà ñòîð³íêó, îòðèìàòè
çàãîëîâîê ïîòî÷íîãî â³êíà (â³í çàëåæèòü â³ä ñòîð³íêè), âèâåñòè éîãî â êîíñîëü, ïåðåéòè äî
³íøîãî ðåçóëüòàòó.
Â ê³íö³ ìàºìî îòðèìàòè ñïèñîê çàãîëîâê³â ñòîð³íîê â òåðì³íàë³.
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
ваывыв
import java.util.List;
import java.util.Scanner;

public class Main {

    public void startQueryTest(String query) {

        // Ñîçäàåì íîâûé ýêçåìïëÿð firefox äðàéâåðà
        // Äðàéâåð firefox ïîääåðæèâàåò javascript
        WebDriver driver = new FirefoxDriver();

        // Èñïîëüçóåì äðàéâåð äëÿ ñîåäèíåíèÿ ñ óêàçàííîé ñòðàíèöåé
        driver.get("http://www.google.com");

        // Íàõîäèì åëåìåíò ââîäà òåêñòà ïî åãî èìåíè
        WebElement element = driver.findElement(By.name("q"));

        // Ââîäèì ÷òî-òî äëÿ ïîèñêà
        element.sendKeys(query + "\n");

        // Òåïåðü ïîäàåì ôîðìó. WebDriver íàéäåò íàøó ôîðìó ïî åëåìåíòó
        element.submit();

        // Îæèäàåì ïîêà ñòðàíèöà google ïîêàæåò ðåçóëüòàò
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        // âñå ññûëêè êîòîðûå ïîñåòèì
        for (WebElement webElement : findElements) {
            System.out.println(webElement.getAttribute("href"));
            WebDriver lDrv = new FirefoxDriver();
            lDrv.get(webElement.getAttribute("href"));
            System.out.println(lDrv.getTitle());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter something to search for : ");
        String userQuery = sc.nextLine();
        new Main().startQueryTest(userQuery);
    }
}

