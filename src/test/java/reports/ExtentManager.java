package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Final Project");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

        return extent;
    }
}