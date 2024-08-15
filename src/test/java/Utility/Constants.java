package Utility;

import BaseUtil.baseUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants extends baseUtil {

    public static SimpleDateFormat reportDate = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
    public static Date date = new Date();
    // Report constants
    public static final String filePath = System.getProperty("user.dir");
    //for failed and success screenshots file path
    public static String fScreenshotFilepath = filePath + "/FailedScreenshots/" + getFormattedFeatureFileName() +"_"+ reportDate.format(date) + "/";
    public static String sScreenshotFilepath = filePath + "/Screenshots/" + getFormattedFeatureFileName() +"_"+ reportDate.format(date) + "/";

}
