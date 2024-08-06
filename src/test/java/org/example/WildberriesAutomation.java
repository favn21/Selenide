package org.example;

import com.codeborne.selenide.*;
import org.example.api.WebDriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class WildberriesAutomation {
    @Test
    public void testAddProductToCart() {
        WebDriverConfig.setUp();
        open("https://www.wildberries.ru/");

        $(By.id("searchInput")).setValue("мобильный телефон").pressEnter();

        SelenideElement firstProduct = $$(".product-card").first().shouldBe(Condition.visible);
        firstProduct.click();

        SelenideElement addToCartButton = $(By.className("btn-main"))
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled);

        addToCartButton.click();

        sleep(10000);
        SelenideElement cartLink = $(By.xpath("//a[@href='/lk/basket']"))
                .shouldBe(Condition.visible);

        cartLink.click();

        $(By.className("basket-section")).shouldBe(Condition.visible);

        $(By.cssSelector(".accordion__list-item.list-item.j-b-basket-item"));

        closeWebDriver();
    }
}

