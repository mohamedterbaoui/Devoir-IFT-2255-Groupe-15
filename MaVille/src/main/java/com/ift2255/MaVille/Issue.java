//Issue.java
//IFT2255 - Équipe 15
// Classe issue
package com.ift2255.MaVille;

public class Issue {
    String issueType;
    String description;
    Date sendingDate;
    
    public Issue(String issueType, String description, Date sendingDate){
        this.issueType = issueType;
        this.description = description;
        this.sendingDate = sendingDate;
    }

    public String getDescription() {
        return description;
    }
    
    public String getIssueType() {
        return issueType;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

}
