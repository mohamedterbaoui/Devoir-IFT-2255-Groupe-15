package com.ift2255.MaVille;

public enum ProjectStatusEnum {
    NOT_YET_STARTED("En attente"),
    IN_PROGRESS("En cours"),
    COMPLETED("Terminé");

    private final String label;

    ProjectStatusEnum(String label) {
        this.label = label;
    }

    /**
     * Returns the label of the project status.
     * @return the label representing the project status.
     */
    @Override 
    public String toString() {
        return label;
    }
}
