package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.engagement.AuditorTeamPage;
import com.auvenir.ui.pages.common.FilePage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 04/08/2017.
 */
public class AuditorFileService extends AbstractService {

    private FilePage filePage;

    public AuditorFileService(Logger logger, WebDriver driver) {
        super(logger, driver);
        filePage = new FilePage(getLogger(), getDriver());
    }

    public void navigateToFilesTab() {
        filePage.navigateToFilesTab();
    }

    public void verifyUserDownloadFileInFileTab(String fileName, String uploaderName, String toDoName) {
        filePage.verifyUserDownloadFileInFileTab(fileName, uploaderName, toDoName);
    }
}
