package com.md.utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.md.base.BaseClass;

public class ExtentManager {
 
 public static ExtentHtmlReporter htmlReporter;
 public static ExtentReports extent;
 public static ExtentTest test;
 
 public static void setExtent() {
  htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
  htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
  //htmlReporter.config().setDocumentTitle("Automation Test Report");
  //htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
  //htmlReporter.config().setTheme(Theme.DARK);
  
  extent = new ExtentReports();
  extent.attachReporter(htmlReporter);
  
  extent.setSystemInfo("HostName", "Localhost");
  extent.setSystemInfo("ProjectName", "Monitroing Dashboard");
  extent.setSystemInfo("Tester", "Siva");
  extent.setSystemInfo("OS", "Win8");
  extent.setSystemInfo("Browser", "Chrome");
 }
 public static void endReport() {
  extent.flush();
 }
}