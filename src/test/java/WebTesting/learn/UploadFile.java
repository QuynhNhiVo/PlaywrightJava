package WebTesting.learn;

import com.microsoft.playwright.FileChooser;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile extends BaseTestDemo {

    private Path[] file = {Path.of(System.getProperty("user.dir") + "/src/test/resources/files/e2979156c736d9d5f25ce2169207998c.jpg")};
    @Test
    public void uploadFileTest_setInputFiles(){
        System.out.println(System.getProperty("user.dir") + "/src/test/resources/files/e2979156c736d9d5f25ce2169207998c.jpg");
        page.navigate("https://the-internet.herokuapp.com/upload");
        page.locator("//input[@id='file-upload']").setInputFiles(file);
    }

    @Test
    public void uploadFileTest_FileChooser(){
        page.navigate("https://the-internet.herokuapp.com/upload");
        FileChooser fileChooser = page.waitForFileChooser(()-> page.locator("//div[@id='drag-drop-upload']").click());
        fileChooser.setFiles(file);
    }
}
