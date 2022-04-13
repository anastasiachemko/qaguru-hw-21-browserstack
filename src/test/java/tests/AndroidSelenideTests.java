package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("selenide")
public class AndroidSelenideTests extends TestBase {

    @Test
    void searchTest() {
        step("Click 'Skip'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });
        step("Check search result", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void onboardingStepsTest() {

        step("Check that the text 'The Free Encyclopedia …in over 300 languages' is visible", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Click on 'Сontinue'", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'New ways to explore' is visible", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Click on 'Сontinue'", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'Reading lists with sync' is visible", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("Click on 'Сontinue'", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'Send anonymous data' is visible", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
    }
}

