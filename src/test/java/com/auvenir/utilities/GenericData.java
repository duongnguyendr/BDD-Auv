package com.auvenir.utilities;

/**
 * Created by thuan.duong on 7/7/2017.
 */
public class GenericData {
    public enum UserStatus {
        ONBOARDING("Onboarding"),
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        LOCKED("Locked"),
        WAITLISTED("Wait Listed"),
        PENDING("Pending");

        public String value;

        private UserStatus(String value) {
            this.value = value;
        }
    }

    public enum UserRole {
        Client("CLIENT"),
        Auditor("AUDITOR"),
        Admin("ADMIN"),
        SuperAdmin("SUPER ADMIN");

        public String value;

        private UserRole(String value) {
            this.value = value;
        }
    }

    public enum RoleCompanyMember {
        PARTNER("Partner"),
        IT("IT"),
        MANAGER("Manager"),
        AUDITJUNIOR("Audit Junior"),
        MANAGINGPARTNER("Managing Partner"),
        AUDITSENIOR("Audit Senior"),
        CONSULTANT("Consultant"),
        SENIORMANAGER("Senior Manager");

        public String value;

        private RoleCompanyMember(String value) {
            this.value = value;
        }
    }
}
