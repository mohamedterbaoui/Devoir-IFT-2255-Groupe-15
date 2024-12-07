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

    public String toString() {
        return label;
    }
}