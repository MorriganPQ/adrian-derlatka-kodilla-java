package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private static final String XPATH_BIRTH_DATE = "//div[contains(@class, \"_58mq\") and contains(@class, \"_5dbb\")]/div[2]/span/span";
    public static final String XPATH_DAY = XPATH_BIRTH_DATE + "/select[1]";
    public static final String XPATH_MONTH = XPATH_BIRTH_DATE + "/select[2]";
    public static final String XPATH_YEAR = XPATH_BIRTH_DATE + "/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement comboDay = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(comboDay);
        selectDay.selectByIndex(25);

        WebElement comboMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(comboMonth);
        selectMonth.selectByIndex(5);

        WebElement comboYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(comboYear);
        selectYear.selectByIndex(21);
    }
}
