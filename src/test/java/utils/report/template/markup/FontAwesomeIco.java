package utils.report.template.markup;

import java.util.HashMap;

import utils.report.template.LogStatus;

public class FontAwesomeIco {
	private static HashMap<LogStatus, String> map = new HashMap<LogStatus, String>();

	public static void override(LogStatus status, String icon) {
		map.put(status, icon);
	}

	public static String get(LogStatus status) {
		if (map.containsKey(status))
			return map.get(status);

		String s = status.toString().toLowerCase();

		if (s.equals(new String("fail"))) {
			return "times-circle-o";
		}
		if (s.equals(new String("error"))) {
			return "exclamation-circle";
		}
		if (s.equals(new String("fatal"))) {
			return "exclamation-circle";
		}
		if (s.equals(new String("pass"))) {
			return "check-circle-o";
		}
		if (s.equals(new String("info"))) {
			return "info-circle";
		}
		if (s.equals(new String("warning"))) {
			return "warning";
		}
		if (s.equals(new String("skip"))) {
			return "chevron-circle-right";
		}

		return "question";
	}
}
