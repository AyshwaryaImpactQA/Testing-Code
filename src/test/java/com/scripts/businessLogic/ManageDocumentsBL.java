package com.scripts.businessLogic;

import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageDocumentsPL;

public class ManageDocumentsBL extends Driver {

	ManageDocumentsPL docPage = PageFactory.initElements(driver,
			ManageDocumentsPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToDocumentsTM() throws Exception {
		commonLib.click(docPage.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(docPage.getSubMenuDocumentsTM(), "Documents Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void navigateToDocumentsDA() throws Exception {
		commonLib.click(docPage.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(docPage.getSubMenuDocumentsDA(), "Documents Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void verifyMandatoryFields(String userType) throws Exception {
		commonLib.logOnInfo("Verify Mandatory Details",
				"Adding document without entering mandatory details");
		if (userType.equalsIgnoreCase("TM")) {
			navigateToDocumentsTM();
		} else if (userType.equalsIgnoreCase("DA")) {
			navigateToDocumentsDA();
		}
		commonLib.click(docPage.getLinkAddDocument(), "Link Add Document");
		commonLib.waitForPageToLoad();
		commonLib.click(docPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(docPage.getErrorMessage())) {
			commonLib
					.logOnSuccess("Verify Mandatory Details",
							"Document without entering mandatory details can not be added");
		} else {
			commonLib.logOnError("Verify Mandatory Details",
					"Document without entering mandatory details added");
		}
	}

	public void addDocument(String userType, String district, String school,
			String docName) throws Exception {
		commonLib.logOnInfo("Add Document", "Adding a new document");
		commonLib.click(docPage.getLinkAddDocument(), "Link Add Document");
		commonLib.waitForPageToLoad();
		if (userType.equalsIgnoreCase("TM")) {
			commonLib.typeText(docPage.getTxtBoxDistrict(), district,
					"District TxtBox");
			Thread.sleep(2000);
			commonLib.click(docPage.getFirstOptionDistrict(),
					"First Option District");
		}
		commonLib.typeText(docPage.getTxtBoxAddDocName(), docName,
				"Document Name TxtBox");
		if (commonLib.isDisplayed(docPage.getRadioBtnAllSchools())) {
			commonLib.click(docPage.getRadioBtnAllSchools(),
					"All School Radio Btn");
		}
		osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			commonLib.typeText(docPage.getFileUpload(),
					System.getProperty("user.dir")
							+ "\\src\\test\\resources\\Logout.png",
					"Upload File");
		} else {
			commonLib.typeText(docPage.getFileUpload(),
					System.getProperty("user.dir")
							+ "/src/test/resources/Logout.png", "Upload File");
		}
		commonLib.waitForPageToLoad();
		commonLib.click(docPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(docPage.getBtnSuccess())) {
			commonLib.logOnSuccess("Add Document",
					"Document added successfully");
			commonLib.click(docPage.getBtnSuccess(), "Success Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Add Document", "Document not added");
		}
	}

	public void searchDocument(String docName) throws Exception {
		commonLib.logOnInfo("Search Document",
				"Searching newly created document");
		commonLib.typeText(docPage.getTxtBoxDocumentName(), docName,
				"Document Name TxtBox");
		commonLib.click(docPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.getText(docPage.getRowDocument()).equals(docName)) {
			commonLib.logOnSuccess("Search Document", "Document '" + docName
					+ "' found successfully");
		} else {
			commonLib.logOnError("Search Document", "Document '" + docName
					+ "' not found");
		}
	}

	public void editDocument() throws Exception {
		commonLib.logOnInfo("Edit Document", "Editing newly created document");
		commonLib.click(docPage.getIconEdit(), "Edit Icon");
		commonLib.waitForPageToLoad();
		commonLib.click(docPage.getBtnUpdate(), "Update Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(docPage.getBtnEditSuccess(),
				"Edit Success Btn")) {
			commonLib.logOnSuccess("Edit Document",
					"Newly created document edited");
			commonLib.click(docPage.getBtnEditSuccess(), "Edit Success Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Edit Document",
					"Newly created document not edited");
		}
	}

	public void deActivateDocument() throws Exception {
		commonLib.logOnInfo("Deactivate Document",
				"De-activating newly created document");
		commonLib.click(docPage.getIconActivateDeactivate(),
				"Activate Deactivate Icon");
		commonLib.waitForPageToLoad();
		if (commonLib
				.getAttribute(docPage.getIconActivateDeactivate(), "title")
				.equals("Activate")) {
			commonLib.logOnSuccess("Deactivate Document",
					"Document de-activated successfully");
		} else {
			commonLib.logOnError("Deactivate Document",
					"Document not de-activated");
		}
	}

	public void deleteDocument() throws Exception {
		commonLib.logOnInfo("Delete Document",
				"Deleting newly created document");
		commonLib.click(docPage.getIconDelete(), "Delete Icon");
		//commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		//commonLib.click(docPage.getBtnConfirmDelete(), "Confirm Delete Btn");
		commonLib.acceptAlert();
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(docPage.getMsgNoRecordFound())) {
			commonLib.logOnSuccess("Delete Document",
					"Document deleted successfully");
		} else {
			commonLib.logOnError("Delete Document", "Document not deleted");
		}

	}

	public void viewAttachment() throws Exception {
		commonLib.logOnInfo("View Attachment",
				"Viewing attachment with document");
		commonLib.click(docPage.getIconAttachment(), "Attachment Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(docPage.getBtnClose())) {
			commonLib.logOnSuccess("View Attachment",
					"Attachment opened successfully");
			commonLib.click(docPage.getBtnClose(), "Clsoe Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("View Attachment", "Attachment not found");
		}
	}

}
