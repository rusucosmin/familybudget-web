package lab5.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import lab5.steps.serenity.EndUserSteps;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Before
    public void set_driver() {
        System.setProperty("webdriver.chrome.driver", "/Users/rusucosmin/drivers/chromedriver");
    }

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("apple");
        anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");
    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pear");
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
    }

    @Test
    public void searching_by_keyword_dog_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("dog");
        anna.should_see_definition("A mammal, Canis lupus familiaris, that has been domesticated for thousands of years, of highly variable appearance due to human breeding.");
    }

    @Test
    public void searching_by_keyword_cat_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("cat");
        anna.should_see_definition("An animal of the family Felidae");
    }
}