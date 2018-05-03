package lab5.features;
import lab5.steps.serenity.EndUserSteps;
import lab5.steps.serenity.FamilyMemberEndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/FamilyBudgetTestData.csv")
public class AddMemberStoryDdt {
  @Managed(uniqueSession = true)
  public WebDriver webdriver;
  @ManagedPages(defaultUrl = "http://localhost:3000")
  public Pages pages;
  public String name;
  public String notice;

  @Qualifier
  public String getQualifier() {
    return name;
  }

  @Steps
  public FamilyMemberEndUserSteps endUser;
  @Issue("#FAMILYBUDGET-1")
  @Test
  public void createMemberTestDDT() {
    endUser.is_the_home_page();
    endUser.create_member(getName());
    endUser.should_see_notice(getNotice());
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getNotice() {
    return notice;
  }
  public void setNotice(String notice) {
    this.notice = notice;
  }
}