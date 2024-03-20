import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;




public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Artem");
        $("#lastName").setValue("Artemov");
        $("#userEmail").setValue("a.artemov@list.ru");
        $(byText("Other")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("[value='1998']").click();
        $(".react-datepicker__month").click();
        $("[value='3']").click();
        $(byText("15")).click();

        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("image.png");
        $("#currentAddress").setValue("Pushkin street 15");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Artem Artemov"));
        $(".table-responsive").shouldHave(text("a.artemov@list.ru"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("15 April,1998"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("Pushkin street 15"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));




    }
}
