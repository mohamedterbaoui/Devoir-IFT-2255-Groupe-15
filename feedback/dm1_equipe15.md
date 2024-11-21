# Barème de correction
 - Il est à noter que des points seront de nouveau déduits si le problème de débordement (overflow) dans votre rapport persiste pour les prochains devoirs.

## Glossaire 

### Termes importants 

 Très bien votre glossaire. Il vous manque quelques termes importants.
- Code de la ville: Non
- Type de travaux, Travaux: Oui, mais vous avez manqué les types de travaux

## Diagramme de cas d'utilisation 


### Identification des acteurs 
- Utilisateur général : Pas d'utilisateur général

### Cas d'utilisation 

- Vous n'avez pas le nombre minimum requis de cas d'utilisation(Entre 15 et 20)
   - Participer à la planification des travaux: Le nom de ce CU n'est pas pertinent. 
   - Recevoir des notifications personnalisés: Je ne vois pas ce CU dans le diagramme mais il existe dans le scénario??? De toute façon, le nom de ce CU n'est pas approprié.
- Vous avez tenté d'utiliser les "include", mais ce sont des utilisations non-pertinent.
- "Consulter les travaux en cours ou à venir" et "Ajouter des filtre de recherche" sont des cas "extend" de Rechercher des travaux
   - Il faudrait avoir un relation entre l'inscription com intervenant et la ville
   - Le sens "extend" pour Afficher les notifications et "Personnaliser les préférence de notifications" devrait être inversé.
   - La relation include entre "Consulter la liste de projet" et "MAJ les informations d'un chantier" devrait être un relation Extend.
   - Vous pouvez modifier votre diagramme en utilisant la correction du prof.

- Cas manquants:
 - Répondre à une candidature
 - Soumettre un requête de travail
 - Modifier le profil
 - Soumettre sa candidature
 - Modifier un projet
 - Envoyer une notification
 - Il est à noter que L'intervenant peut aussi afficher les notifications
 - Lorsque vous ajoutez les CU, faites attention aux relations include/extend.

## Scenarios 
  - Parfois la numérotations pour des scénarios alternatifs n'a aucun sens
  - Il faudrait alterner le rôle de chaque source lorsque vous élaborez les scénarios.
 
 - Consulter les travaux en cours ou à venir (avec include et extend): Dans votre diagramme, il y a un "include" vers Rechercher des travaux, mais je n'ai pas vu que vous avez traité ce cas dans le scénario. Même chose pour le cas extend
 - Ajouter des filtres: Vous n'avez pas fait ce CU. 
 - Afficher les notifications: Vous n'avez pas fait ce CU. 
 - Personnalise les préférences: Vous n'avez pas fait ce CU. 
 - S'inscrire comme intervenant: Il faudrait avoir aussi un étape de vérification avec la ville.
 - Consulter la liste des requêtes de travail: Vous n'avez pas indiqué le cas include dans votre scénario

 - Il est à noter que si vous avez déjà indiqué dans les préconditions que les utilisateurs doivent être connectés à la plateforme, il n'est pas nécessaire de répéter cette étape de connexion dans le scénario principal.
 - Il est à noter que même si un CU est un include ou un extend dans/vers un autre CU, même si vous avez mentionné ce CU dans le scénario.

## Diagramme d'activités 

- Soumettre une requête de travail: Une boucle infinie potentielle si le résident commet des erreurs de manière répétée lors de la soumission des informations. 
 - "Le système demande si l'utilisateur veut poursuivre", ce serait mieux si vous utilisez un noeuds de décision ici. 
Retour au menu principal, et ensuite ? Vous devez indiquer que le flux ou l'activité est terminé ; vous ne pouvez pas le laisser en suspens ainsi.
- Signaler problème à la ville: Une boucle infinie potentielle si le résident commet des erreurs de manière répétée lors de la soumission des informations.
- Vous devriez revoir tous les boucles infinies potentielles dans vos diagramme et les cas en suspens.
- Pour tous les diagrammes: Comment on pourrait retourner au menu principal sans quitter l'application?
 
## Analyse 

### Risques 
- Le risque 4 est plutôt un besoin non-fonctionnel qu'un risque.

### Besoins non fonctionnels 
  - Très bien vos besoins

### Besoins matériels, solution de stockage et solution d'intégration 

- Matériels nécessaires 
  - Considération pour le déploiement du programme: Il vous manque les considérations spécifiques pour le déploiement de votre application. On voudrait comprendre comment l'application sera installée, mise à jour et maintenue en production.
  - Matériel et interface utilisateur: Vous avez omis l'interface utilisateur
  - Analyse de cout: Vous avez omis ce critère

- Solutions de stockage 
  - Type de données et stockage adapté: Vous avez omis de préciser quels types de données vous voulez stocker.
  - Architecture de stockage (partagée, distribuée, etc.): Vous avez comparé d'utilisation d'une DB interne avec le stockage sur le Cloud en termes de contrôle, de performances, de sécurité, et de flexibilité. Cependant, il serait utile de préciser si le stockage dans le Cloud sera centralisé ou distribué, et comment l'infrastructure sera structurée pour gérer les données et les utilisateurs de manière efficace
  - Sécurité des données ou autre considérations: Ce serait mieux si vous pensez à l'encryption des informations sensibles
  - Exemple ou procédure concrète illustrant la solution de stockage: Non, pas d'exemple

- Solutions d'intégration 
  - Considération dans la conception: On ne sait pas encore comment ces services seront intégrés (ex: via des API REST ou des échanges de données)
  - Clarté de l'explication de l'intégration: L'intégration est expliquée de manière claire, mais reste superficielle
  - Exemple ou procédure concrète illustrant la solution d'intégration: Vous pouvez illustrer avec un exemple précis, comme un flux de données montrant comment MaVille recevra des informations de géolocalisation ou enverra des notifications via une API tierce, aiderait à rendre l'explication plus concrète.

## Prototype 
  - Avec le fichier .jar

## Git 

- Très bien

## Rapport 
  - Le diagramme d'échéancier n'est pas accessible!
  - Échéancier clair montrant la distribution des tâches: Inaccessible donc impossible de vérifier.
 - Votre description du projet était un peu courte. Cela devrait contenir le contexte, problèmes à résoudre, et des propositions.
 - Le contenu du rapport subit un overflow au-delà des limites de l'écran!