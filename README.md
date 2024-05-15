## Projet de Loterie Java EE

Ce projet Java EE est une application de loterie permettant aux utilisateurs de saisir leur nom via un formulaire web. Les résultats de la loterie sont stockés dans une base de données MySQL, ce qui permet une consultation ultérieure des résultats.

### Fonctionnalités principales :

- Saisie du nom de l'utilisateur via un formulaire web.
- Stockage des résultats dans une base de données MySQL.
- Gestion d'une liste noire pour bloquer certains utilisateurs.
- Mise à jour automatique du gain en cas de saisie multiple du même nom.
- Possibilité pour l'utilisateur de supprimer un nom de la base de données.

### Étapes de déploiement :

1. Clonez le dépôt GitHub sur votre machine locale.
2. Importez le projet dans votre IDE préféré.
3. Configurez une base de données MySQL locale et créez une table pour stocker les résultats de la loterie.
4. Mettez à jour les informations de connexion à la base de données dans la servlet `GreetingServlet.java`.
5. Exécutez l'application dans votre serveur d'application Java EE préféré.

### Structure du projet :

- `src/main/java`: Contient la servlet `GreetingServlet.java`.
- `src/main/webapp`: Contient les fichiers HTML et JSP pour l'interface utilisateur.
- `src/main/webapp/WEB-INF`: Contient le fichier de configuration `web.xml`.

### Prérequis :

- JDK 8 ou supérieur
- Maven
- Serveur d'application Java EE (Tomcat, WildFly, etc.)
- MySQL Server

### Auteurs :

- AOUAD https://github.com/aouadayoub
