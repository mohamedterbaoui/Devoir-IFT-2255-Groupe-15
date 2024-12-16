package com.ift2255.MaVille;

public enum WorkRequestStatusEnum {
    NOT_YET_STARTED("En attente"),
    IN_PROGRESS("En cours"),
    COMPLETED("Terminé");

    private final String label;

    // Constructeur existant
    WorkRequestStatusEnum(String label) {
        this.label = label;
    }

    // Constructeur par défaut
    WorkRequestStatusEnum() {
        this("En attente");
    }

    /**
     * Returns the string representation of the work request status.
     *
     * @return the label that describes the current status of the work request.
     */
    public String toString() {
        return label;
    }
}