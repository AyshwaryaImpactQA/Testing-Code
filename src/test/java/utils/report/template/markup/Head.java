package utils.report.template.markup;

import utils.report.template.support.FileReaderEx;
import utils.report.template.support.FileWriterEx;
import utils.report.template.support.RegexMatcher;

class Head {
	private String filePath;

	public void addCustomStylesheet(String cssFilePath) {
		String link = "<link href='file:///" + cssFilePath + "' rel='stylesheet' type='text/css' />";

		if (cssFilePath.substring(0, 1).equals(new String(".")) || cssFilePath.substring(0, 1).equals(new String("/")))
			link = "<link href='" + cssFilePath + "' rel='stylesheet' type='text/css' />";

		String markup = FileReaderEx.readAllText(filePath).replace(ExtentMarkup.getPlaceHolder("customcss"),
				link + ExtentMarkup.getPlaceHolder("customcss"));

		FileWriterEx.write(filePath, markup);
	}

	public void addCustomStyles(String styles) {
		styles = "<style type='text/css'>" + styles + "</style>";
		String markup = FileReaderEx.readAllText(filePath).replace(ExtentMarkup.getPlaceHolder("customcss"),
				styles + ExtentMarkup.getPlaceHolder("customcss"));

		FileWriterEx.write(filePath, markup);
	}

	public void documentTitle(String title) {
		String docTitle = "<title>.*</title>";
		String html = FileReaderEx.readAllText(filePath);

		html = html.replace(RegexMatcher.getNthMatch(html, docTitle, 0), docTitle.replace(".*", title));

		FileWriterEx.write(filePath, html);
	}

	public Head setFile(String filePath) {
		this.filePath = filePath;
		return this;
	}

	public Head() {
	}

	public Head(String filePath) {
		this.filePath = filePath;
	}
}
