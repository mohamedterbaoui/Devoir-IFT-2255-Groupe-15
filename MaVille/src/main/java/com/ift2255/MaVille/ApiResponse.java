package com.ift2255.MaVille;
/**Classe qui accepte et organise les données de l'API
 * 
 */
public class ApiResponse {
    /**
     * Donne le code de reponse d'API
     */
    private final int statusCode;
    /**
     * Le header recu par l'API
     */
    private final String message;
    /**
     * Les données reçu par l'API
     */
    private final String body;
    /**
     * Constructeur de réponse qui stock les données reçu
     * @param statusCode le code de réponse
     * @param message Le format des données
     * @param body Les données eux-mêmes
     */
    public ApiResponse(int statusCode, String message, String body) {
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }
    /**
     * Retourne le code de reponse
     * @return Le code de réponse
     */
    public int getStatusCode() {
        return statusCode;
    }
    /**
     * Retourne le message de la réponse API
     * @return String qui indique une message
     */
    public String getMessage() {
        return message;
    }
    /**
     * Retourne le corps de la reponse API
     * @return Un string qui represent le corps de la reponse
     */
    public String getBody() {
        return body;
    }

    /**
     * La chaîne inclut le code de statut, le message et le corps associés à cet objet.
     *
     * @return une chaîne de caractères représentant l'objet sous la forme :
     *         "Status Code: <code de statut>, Message: <message>, Body: <corps>".
     */
    @Override
    public String toString() {
        return "Status Code: " + statusCode + ", Message: " + message + ", Body: " + body;
    }
}
