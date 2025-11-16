package Util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListner implements ITestListener {



        @Override
        public void onTestFailure(ITestResult result) {
            saveScreenshot();
        }

        @Attachment(value = "Screenshot on Failure", type = "image/png")
        public byte[] saveScreenshot() {
            return ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
        }
    }


