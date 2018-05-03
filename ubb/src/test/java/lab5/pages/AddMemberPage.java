package lab5.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://localhost:3000/members/new")
public class AddMemberPage extends PageObject {

    @FindBy(name="member[name]")
    private WebElementFacade memberName;

    @FindBy(name="commit")
    private WebElementFacade createButton;

    public void enterName(String name) {
        memberName.type(name);
    }

    public void createMember() {
        createButton.click();
    }

    public String getNotice() {
        WebElementFacade definitionList = find(By.id("notice"));
        return definitionList.getText();
    }
}