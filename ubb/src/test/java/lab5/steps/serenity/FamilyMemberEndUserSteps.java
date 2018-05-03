package lab5.steps.serenity;

import lab5.pages.AddMemberPage;
import lab5.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class FamilyMemberEndUserSteps {

    AddMemberPage addMemberPage;

    @Step
    public void enters(String name) {
        addMemberPage.enterName(name);
    }

    @Step
    public void start_create() {
      addMemberPage.createMember();
    }

    @Step
    public void should_see_notice(String notice) {
      assertThat(addMemberPage.getNotice(), containsString(notice));
    }

    @Step
    public void is_the_home_page() {
      addMemberPage.open();
    }

    @Step
    public void create_member(String name) {
      enters(name);
      start_create();
    }
}