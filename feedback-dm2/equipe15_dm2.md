# Feedback

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
-  Bon usage des fragments: Oui
- Plusieurs méthodes appelées n'existent pas
-  Méthode appelée présente la même signature (params + type de retour) 
  - Pas de type de retour

### Consulter les entraves 

-  Flux général est cohérent et représentatif du CU: OK
-  Récupération des entraves: Oui
- Filtre des entraves (optionnel): Non

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
  