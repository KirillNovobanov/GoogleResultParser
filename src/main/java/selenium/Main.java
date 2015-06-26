package selenium;

/*
��������: ���������� ������� (� ��������) ��������� �����. �������� ������� ����
Firefox, ��������� ������� Google, ������� ��������� ����� � ������� ������. ϳ���
����� � ����, ��� ������� ���������� � ����� �������: ������� �� �������, ��������
��������� ��������� ���� (�� �������� �� �������), ������� ���� � �������, ������� ��
������ ����������.
� ���� ���� �������� ������ ��������� ������� � �������.
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Scanner;

public class Main {

    public void startQueryTest(String query) {

        // ������� ����� ��������� firefox ��������
        // ������� firefox ������������ javascript
        WebDriver driver = new FirefoxDriver();

        // ���������� ������� ��� ���������� � ��������� ���������
        driver.get("http://www.google.com");

        // ������� ������� ����� ������ �� ��� �����
        WebElement element = driver.findElement(By.name("q"));

        // ������ ���-�� ��� ������
        element.sendKeys(query + "\n");

        // ������ ������ �����. WebDriver ������ ���� ����� �� ��������
        element.submit();

        // ������� ���� �������� google ������� ���������
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        // ��� ������ ������� �������
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

