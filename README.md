# Devoir-IFT-2255-Groupe-15

## Membres de l'équipe : 
  Thomas Bate | Jérémy Faubert | Mohamed Terbaoui

## MaVille
Une application de gestion des travaux publics et privés à Montréal, visant à améliorer la communication entre les résidents et les différents acteurs pour réduire les perturbations et faciliter la mobilité en ville.

## Organisation du répertoire
- **index.html** : Rapport du projet en format HTML.
- **/prototype** : Contient le code source du prototype de l'application développé en Java pour le devoir 1.
- **/MaVille** : Contient l'implémentation de l'application pour le devoir 2.
- **/images** : Contient les diagrammes utilisés dans le rapport.
- **/feedback** : Feedback continue de l'auxiliare sur le travail.

### Technologies utilisées

Notre application a été développée en utilisant plusieurs outils et bibliothèques pour assurer une gestion efficace et une organisation claire :

- **Maven** : Utilisé pour gérer le build et les dépendances du projet.  
- **Gson** : Employé pour traiter les fichiers JSON, notamment pour la sérialisation et la désérialisation des données.  
- **JUnit** : Utilisé pour écrire et exécuter les tests unitaires, garantissant la qualité et la robustesse du code.  
- **Architecture MVC** : Le projet est structuré selon le modèle MVC (Modèle-Vue-Contrôleur), permettant une séparation claire des responsabilités entre la logique métier, l'interface utilisateur et le contrôle des interactions. 

### Cas d'utilisation implémentés

L'application intègre les fonctionnalités suivantes :

1. **Se connecter comme résident et intervenant** : Permet aux utilisateurs de s'authentifier en fonction de leur rôle pour accéder à des interfaces adaptées.  
2. **Consulter les travaux en cours ou à venir** : Offre la possibilité de visualiser les travaux publics ou privés planifiés ou en cours.  
3. **Consulter les entraves** : Permet aux utilisateurs de consulter les perturbations causées par les travaux, facilitant ainsi la planification.  
4. **Soumettre une requête de travail** : Les résidents peuvent déposer des demandes concernant des travaux spécifiques dans leur quartier.  
5. **Consulter la liste des requêtes de travail** : Affiche les requêtes soumises et leur statut actuel.  

## Compte préconfigurés pour tester les prototype : 
- Résident : 
  > alice@mail.com  password123
  > bob@mail.com  securepass
  > caroline@mail.com  pass789
- Intervenant :
  > entrepriseA@mail.com  password123
  > entrepriseB@mail.com  securepass
  > entrepriseC@mail.com  pass789
