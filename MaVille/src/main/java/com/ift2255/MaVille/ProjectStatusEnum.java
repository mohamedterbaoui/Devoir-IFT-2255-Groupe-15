package com.ift2255.MaVille;

public enum ProjectStatusEnum {
    NOT_YET_STARTED("En attente"),
    IN_PROGRESS("En cours"),
    COMPLETED("Terminé");

    private final String label;

    ProjectStatusEnum(String label) { // Correction du nom du constructeur
        this.label = label;
    }

    /**
     * Returns the label of the project status.
     * @return the label representing the project status.
     */
    @Override // Ajout de l'annotation @Override pour plus de clarté
    public String toString() {
        return label;
    }
}
