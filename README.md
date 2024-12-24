# MaVille

## Description
Une application pour la gestion des travaux publics et privés à Montréal. Elle facilite la communication entre les résidents et les intervenants pour réduire les perturbations et améliorer la mobilité.

---

## Fonctionnalités par rôle

### Résident :
- Créer un compte
- Se connecter/déconnecter
- Modifier ses préférences horaires
- Voir ses notifications  
  - Afficher le nombre de nouvelles notifications (non lues) dans le menu
- Consulter les travaux en cours
- Consulter les travaux à venir (3 prochains mois)
- Chercher ou filtrer les travaux par quartier
- Consulter les entraves engendrées par un travail
- Chercher ou filtrer les entraves par rue
- Soumettre une requête de travail
- Faire le suivi d'une requête de travail
- Consulter les requêtes de travail

### Intervenant :
- Créer un compte
- Se connecter/déconnecter
- Soumettre/Soustraire sa candidature
- Faire le suivi de sa candidature
- Soumettre un projet  
  - Envoyer une notification aux résidents du quartier
- Modifier le statut d'un projet  
  - Envoyer une notification aux résidents du quartier

---

## Organisation du répertoire
- **index.html** : Rapport du projet en HTML.
- **/prototype** : Contient le prototype de l'application (Devoir 1).
- **/MaVille** : Code source de l'application complète (Devoir 2 & 3).
- **/images** : Diagrammes et illustrations du rapport.
- **/feedback** : Commentaires de l'auxiliaire sur le projet.

---

## Données incluses
- Comptes de test pour les résidents :
  - alice@example.com / test
  - bob.johnson@example.com / hashedpassword2
  - charlie.brown@example.com / hashedpassword3
- Comptes de test pour les intervenants :
  - john.doe@example.com / password123
  - jane.smith@example.com / password456

Les utilisateurs peuvent tester les fonctionnalités en se connectant avec ces comptes.

---

## Instructions d'installation
1. **Prérequis :**
   - Java (JDK 17+)
   - Maven
2. **Cloner le dépôt :**
   ```bash
   git clone https://github.com/<ton-github>/Devoir-IFT-2255-Groupe-15.git
   cd Devoir-IFT-2255-Groupe-15
