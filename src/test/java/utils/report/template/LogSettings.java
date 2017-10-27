package utils.report.template;

public abstract class LogSettings {
	protected static Boolean displayCallerClass = true;
	protected static String logTimeFormat = "hh:mm:ss";
	protected static String logDateFormat = "mm-dd-yyyy";
	protected static String logDateTimeFormat = logDateFormat + " " + logTimeFormat;
}
