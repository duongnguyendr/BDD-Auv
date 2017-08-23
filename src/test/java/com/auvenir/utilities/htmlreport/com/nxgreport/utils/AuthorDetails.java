package com.auvenir.utilities.htmlreport.com.nxgreport.utils;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class AuthorDetails {
    private String authorName = "Unknown";
    private String creationDate = "Unknown";
    private String version = "Unknown";

    public AuthorDetails() {
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
