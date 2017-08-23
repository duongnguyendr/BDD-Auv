package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.engagement.AuditorTeamPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by thuan.duong on 6/16/2017.
 */
public class AuditorTeamService extends AbstractService {

    AuditorTeamPage auditorTeamPage;

    public AuditorTeamService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorTeamPage = new AuditorTeamPage(getLogger(), getDriver());
    }

/*    public void clickEngagementTeamMenu() {
        auditorTeamPage.clickEngagementTeamMenu();
    }*/

    public void deleteAllMemberInEngagement() {
        auditorTeamPage.deleteAllMemberInEngagement();
    }

    public void clickInviteMember() {
        auditorTeamPage.clickInviteMember();
    }

    public void inputInviteNewMemberInfo(String fullName, String email, String roleMember) {
        auditorTeamPage.inputInviteNewMemberInfo(fullName, email, roleMember);
    }

    public void verifyAddNewInvitedMember(String fullName, String roleMember) {
        auditorTeamPage.verifyAddNewInvitedMember(fullName, roleMember);
    }

    public void deleteMemberInEngagementByName(String fullNameMember) {
        auditorTeamPage.deleteMemberInEngagementByName(fullNameMember);
    }

    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - Start
     */
    public void verifyMemberIsShownInTeamList(String memberFullName, String roleInFirm) {
        auditorTeamPage.verifyMemberIsShownInTeamList(memberFullName, roleInFirm);
    }
    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - End
     */
}
