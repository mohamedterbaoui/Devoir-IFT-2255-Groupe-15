# Feedback

## Révision 

- Échéancier mis à jour : Oui
- Diagrammes CU mis à jour 
  - Nouvel acteur: API de la ville : Non
  - Nouveau CU 
    - Consulter ou Chercher les entraves routières : Non, vous avez oublié ce CU
  - CU abandonné: 
    - Signaler un problème: Non, vous n'avez pas enlevé ce CU 
    - Partager son avis sur les travaux: Non, vous n'avez pas enlevé ce CU 
  - Corrections : Ok

- Diagrammes d'activités mis à jour : Très bien

- Analyse mis à jour 
  - Risques mis à jour: Oui
  - Besoins non-fonctionnels mis à jour: Oui
  - Solution de stockage et d'intégration mis à jour: Oui

## Architecture 

- Les utilisateurs sont bien identifiés : Oui
- Linteraction entre utilisateur et système est bien identifié : Pas clair...
- La frontière du système est claire et permet de distinguer les composantes du système des dépendances externes : Non

- La composantes principales sont bien identifiés 
 - Ce serait mieux si vous séparez les tâches du backend et frontend, et regrouper au besoin.

- Les relations entre composantes sont bien identifiées. 
 - Database: Manque du type de base de données
- Les services externes sont bien identifiés : Oui

- Les relations entre services externes et système sont bien identifiés : Non
  - Manque la distinction des ressources appelées dans l'API: JSON, XML
  - Quelle type de "Request" pour intéragir avec les API?

 - Je remarque que vous mentionnez l'utilisation du modèle C4 en trois couches, mais il est difficile de voir si vous les toutes regroupez ensemble.
 - Référez-vous à la correction de l'architecture donnée par le professeur dans la démo 8 pour ajuster votre diagramme.

## Diagramme de classe 

### Identification des entités 

- Classes
- Attributs (pertinence et type)
- Méthodes (pertinence et signature)
 - Méthode main() devrait être statique

### Identification des relations 

- Aucune multiplicité a été identifié
- Une relation d'agrégation qui pourrait être envisagée entre:
  - Projet et Entrave
  - Resident et WorkRequest
  - Notification et Resident
  - Resident et Projet
  - Projet et Intevenant
  - District et Street

### Cohésion et couplage 
 - C'est bien 

### Formalisme 

- Type des attributs absent
- Signature des méthodes absente
- Relation illégale
- Nommage portant à confusion ou éloigné des concepts de l'énoncé

## Diagramme de séquence 

### Formalisme et cohérence 

-  Bonne définition des objets et lignes de vie: Oui
-  Bon usage des flèches de message
 - Les messages de retour devraient être représentés par des flèches en pointillés.
-  Bon usage des fragments: 
  - Les frag
-  Méthode appelée existe
  - Plusieurs méthodes appelées n'existent pas
-  Méthode appelée présente la même signature (params + type de retour) 
  - Pas de type de retour

### Consulter les entraves 

-  Flux général est cohérent et représentatif du CU: OK
-  Récupération des entraves: Oui
- [ ] Filtre des entraves (optionnel): Non

### Soumettre une requête de travail 

-  Flux général est cohérent et représentatif du CU
  - Pour la fonction saveFailure dans l'application, souhaitez-vous enregistrer un log ou autre chose ? Je ne suis pas sure de comprendre
-  Entrée de données: Pas clair
-  Validation et traitement erreur: Non
-  Suivi d'une requête de travail: Non

### Consulter la liste des requêtes de travail 

-  Flux général est cohérent et représentatif du CU: Oui
  - Mal utilisation de "alt" ici! Les conditions ne sont pas clairement définies, il entraine des ambiguïtés dans la logique de décision.

-  Voir la liste des requêtes de travail: Oui
-  Accès à une requète de travail: Non
-  Soumettre sa candidature

## Discussion design 

-  considérations prises dans le design (abstraction, couplage et cohésion, encapsulation) pour favoriser l'évolution 
  - Couplage? Abstraction?
-  lien avec l'architecture ou style d'architecture (ex: MVC) et avantages de celles-ci : Non
-  intégration de l'application (modularité, flexibilité, interopérabilité) : Partiellement


# Implémentation 

## Fonctionnalités 

- [ ] Se connecter comme résident et intervenant  : Oui 
- [ ] Consulter les travaux en cours ou à venir   : Oui
- [ ] Consulter les entraves                      : Oui
- [X] Soumettre une requête de travail            : Non, l'application s'est fermée lorsque cette fonctionnalité a été sélectionnée.
- [ ] Consulter la liste des requêtes de travail  : Oui

## Robustesse & Utilisabilité 

- [ ] Possibilité de revenir en arrière : Partiellement
- [X] Informations présentées facile à lire : Non
  - La sortie de vos requêtes est brute, t.qu'elle est retournée par l'API, ce qui la rend difficile à lire.

## Code 

- [ ] Code n'est pas complètement différent de la conception : Bien
- [X] Code est réparti à travers plusieurs classes et facile à maintenir : Partiellement
  - Vos classes sont toutes regroupées dans un seul package, ce qui rend le projet difficile à maintenir. Elles ne sont pas organisées par responsabilité ou domaine fonctionnel, ce qui nuit à la lisibilité, à l'organisation globale et ne respecte pas pleinement les principes de la OOP. 
  - Exemple de structure:
    src/
    ├── controllers/
    │   ├── AuthController.java
    │   ├── IntervenantController.java
    │   ├── WorkRequestsController.java
    ├── models/
    │   ├── Intervenant.java
    │   ├── Entrave.java
    │   ├── Criteria.java
    ├── services/
    │   ├── CsvManager.java
    │   ├── FileOps.java
    │   ├── Hash.java
    ├── views/
    │   ├── AuthView.java
    │   ├── IntervenantView.java
    ├── utils/
    │   ├── HttpClientApi.java

- [ ] Code est facile à lire et comprendre : Bien

## Tests unitiaire  
- 3 membres, donc 9 tests
- Très bien

## Rapport et Git 

- Structure du rapport: Oui
- Échéancier clair (distribution des tâches) et mis à jour: Oui
- images s'affichant directement dans le rapport: Oui
- Lien Git et VPP fonctionnel:
  - Vous n'avez pas inclus de VPP cette fois-ci, mais cela me convient pour cette fois. Veuillez ne pas l'oublier pour le prochain devoir.
- Release créé pour le devoir 2: Oui

## Bonus 1: Exploitation de Git

- Commits réguliers et descriptifs de chaque membre: Partiellement
- Gestion de projet par les tickets: Oui
- Usage d'une branche pour le développement du code source: Oui

## Bonus 2: Architecture REST
- Non
  