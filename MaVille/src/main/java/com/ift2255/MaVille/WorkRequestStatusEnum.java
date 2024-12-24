package com.ift2255.MaVille;

public enum WorkRequestStatusEnum {
    NOT_YET_STARTED("En attente"),
    IN_PROGRESS("En cours"),
    COMPLETED("Terminé");

    private final String label;

    /**
     * Constructeur pour initialiser un statut de demande de travaux avec un label spécifique.
     *
     * Ce constructeur permet de créer une instance de l'énumération WorkRequestStatusEnum en attribuant
     * une étiquette (label) qui représente le statut de la demande de travaux.
     *
     * @param label L'étiquette qui représente le statut de la demande de travaux.
     */

    WorkRequestStatusEnum(String label) {
        this.label = label;
    }

    /**
     * Constructeur par défaut pour initialiser un statut de demande de travaux avec l'étiquette "En attente".
     *
     * Ce constructeur crée une instance de l'énumération WorkRequestStatusEnum avec l'étiquette par défaut
     * "En attente", ce qui peut être utilisé lorsqu'aucun statut spécifique n'est fourni.
     */

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