package com.ift2255.MaVille;
/**Classe qui accepte les données cru de l'API
 * 
 */
public class ApiResponse {
    /**
     * Code retourné par l'API
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
     * Constructeur de réponse qui 
     * @param statusCode
     * @param message
     * @param body
     */
    public ApiResponse(int statusCode, String message, String body) {
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Status Code: " + statusCode + ", Message: " + message + ", Body: " + body;
    }
}
