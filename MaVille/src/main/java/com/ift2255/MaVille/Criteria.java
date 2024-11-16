//Criteria.java
//IFT2255 - Équipe 15
//Classe Criteria
package com.ift2255.MaVille;

public class Criteria {
    String searchName;
    ProjectType projectType;
    District district;
    Date startDate;
    Date endDate;

    public Criteria(String name, ProjectType type, District district, Date startDate, Date endDate){
        this.searchName = name;
        this.projectType = type;
        this.district = district;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public District getDistrict() {
        return district;
    }
    
    public Date getEndDate() {
        return endDate;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public String getSearchName() {
        return searchName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
}
