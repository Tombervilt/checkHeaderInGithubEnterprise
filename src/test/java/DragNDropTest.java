import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void dragNDropCommandTest() {
        open("/drag_and_drop");
        $("#column-a").shouldNotHave(text("B"));
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldNotHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldNotHave(text("A"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldNotHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
    @Test
    void actionsCommandTest() {
        open("/drag_and_drop");
        $("#column-a").shouldNotHave(text("B"));
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldNotHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldNotHave(text("A"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldNotHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
