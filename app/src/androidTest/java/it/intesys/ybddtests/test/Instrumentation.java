package it.intesys.ybddtests.test;

import android.os.Bundle;

import androidx.test.runner.MonitoringInstrumentation;

import org.junit.runner.RunWith;

import java.io.File;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentationCore;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
        glue = "it.intesys.ybddtests",
        monochrome = true)
public class Instrumentation extends MonitoringInstrumentation {
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);
    @Override
    public void onCreate(Bundle arguments) {
        arguments.putString("plugin", "json:" + getAbsoluteFilesPath() + "/cucumber.json");
        // Uncomment the following lines if you want other report formats:
        // arguments.putString("plugin", "html:" + getAbsoluteFilesPath() + "/cucumber.html");
        // arguments.putString("plugin", "junit:" + getAbsoluteFilesPath() + "/cucumber.xml");
        // Create the report directory programmatically
        new File(getAbsoluteFilesPath()).mkdirs();
        super.onCreate(arguments);
        // Set any specific tags if needed
        String tags = "";
        if (!tags.isEmpty()) {
            arguments.putString("tags", tags.replaceAll(",", "--").replaceAll("\\s",""));
        }
        instrumentationCore.create(arguments);
        start();
    }
    @Override
    public void onStart() {
        super.onStart();
        waitForIdleSync();
        instrumentationCore.start();
    }
    private String getAbsoluteFilesPath() {
        File directory = getTargetContext().getExternalFilesDir(null);
        return new File(directory, "reports").getAbsolutePath();
        // The path to the report - sdcard/Android/data/.../reports
    }
}