package pages;

import org.openqa.selenium.By;

public class straitstimesHomePage {

    public static By loginLink =
            By.xpath("//li[@class='nav-login']//a[contains(@href,'ascript:;')]");

    public static By loginUserName =
            By.xpath("//li[@class='nav-login']//a[contains(text(),'taltest2')]");
    public static By MainArticleHeading =
            By.xpath("//div[@class='panel-pane pane-fieldable-panels-pane pane-uuid-6dfea2b9-e6bd-461d-94f8-6dadd562c11c hfix pane-bundle-container-headline']//h2[contains(text(),'op Stories')]");

    public static By MainArticleImage =
            By.xpath("//div[@class='borealis image-style-retina_large borealis-js borealis-wrapper loaded']//img[@class='borealis image-style-retina_large borealis-js img-responsive']");

    public static By MainArticleSummary =
            By.xpath("//a[@class='block-link']");
}
