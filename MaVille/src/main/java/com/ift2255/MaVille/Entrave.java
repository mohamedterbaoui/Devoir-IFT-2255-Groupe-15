//Entrave.java
//IFT2255 - Équipe 15
// Classe Entrave

public class Entrave {
    int entraveId;
    String description;
    Date startDate;
    Date endDate;
    String entraveAddress;
    Project project;

    public Entrave(int id, String description, Date start, Date end, String address, Project project){
        this.entraveId = id;
        this.description = description;
        this.startDate = start;
        this.endDate = end;
        this.entraveAddress = address;
        this.project = project;
    }

    public Boolean isCompleted(){

    }

    public String getDescription() {
        return description;
    }

    public Date getEndDate() {
        return endDate;
    }
    
    public String getEntraveAddress() {
        return entraveAddress;
    }

    public int getEntraveId() {
        return entraveId;
    }

    public Project getProject() {
        return project;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEntraveAddress(String entraveAddress) {
        this.entraveAddress = entraveAddress;
    }

    public void setEntraveId(int entraveId) {
        this.entraveId = entraveId;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    
}
