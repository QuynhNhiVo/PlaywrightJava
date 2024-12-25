package WebTesting.learn;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Upload_And_DownLoad_File extends BaseTestDemo {

    private Path[] file = {Path.of(System.getProperty("user.dir") + "/src/test/resources/files/e2979156c736d9d5f25ce2169207998c.jpg")};

    @Test
    public void uploadFileTest_setInputFiles() {
        System.out.println(System.getProperty("user.dir") + "/src/test/resources/files/e2979156c736d9d5f25ce2169207998c.jpg");
        page.navigate("https://the-internet.herokuapp.com/upload");
        page.locator("//input[@id='file-upload']").setInputFiles(file);
    }

    @Test
    public void uploadFileTest_FileChooser() {
        page.navigate("https://the-internet.herokuapp.com/upload");
        FileChooser fileChooser = page.waitForFileChooser(() -> page.locator("//div[@id='drag-drop-upload']").click());
        fileChooser.setFiles(file);
    }

    @Test
    public void downloadFileTest() {
        page.navigate("https://demoqa.com/upload-download");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("scs.png")));
        Download download = page.waitForDownload(() -> {
            page.click("//a[@id='downloadButton']");
        });
        //Save in folder /src/test/resources/files/ and suggest name
        download.saveAs(Paths.get(System.getProperty("user.dir")+"/src/test/resources/files/", download.suggestedFilename()));
        System.out.println(download.url());
        System.out.println(download.path());
    }

    @Test
    public void downloadFileTest_2() {
        page.navigate("https://demoqa.com/upload-download");
        Download download = page.waitForDownload(() -> {
            page.click("//a[@id='downloadButton']");
        });
        //Save in folder project
        download.saveAs(Paths.get("newFile.jpeg"));
        System.out.println(download.url());
        System.out.println(download.path().toString());
    }
}
