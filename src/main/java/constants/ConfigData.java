package constants;

import helpers.PropertiesHelpers;

public class ConfigData {
    public static Boolean HEADLESS = false;
    public static String URL = PropertiesHelpers.getValue("URL");
}
