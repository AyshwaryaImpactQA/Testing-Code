package utils.report.template.markup;

import utils.report.template.support.FileReaderEx;
import utils.report.template.support.FileWriterEx;

class Scripts {
	private String filePath;

	public void insertJS(String script) {
		script = "<script type='text/javascript'>" + script + "</script>";
		String markup = FileReaderEx.readAllText(filePath).replace(ExtentMarkup.getPlaceHolder("customscript"),
				script + ExtentMarkup.getPlaceHolder("customscript"));

		FileWriterEx.write(filePath, markup);
	}

	public Scripts setFile(String filePath) {
		this.filePath = filePath;
		return this;
	}

	public Scripts() {
	}

	public Scripts(String filePath) {
		this.filePath = filePath;
	}
}
