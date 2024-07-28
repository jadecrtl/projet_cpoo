# cpoo-project2

## Jeu de la Vie et automates cellulaires

#### Le Jeu de la Vie est une simulation mathématique créée par John Conway.Ce projet permet d'appliquer le Jeu de la Vie à partir d'un fichier et de renvoyer un fichier contenant les différentes étapes générées par ce jeu.

#### Ce projet est réalisé en Java et la version de java utilisée est java 17.

# Compilation du projet : 

### Pour compiler le projet, suivez ces étapes :

1. Placez-vous à la racine du répertoire 'projet-Jade-cpoo'.  

2. Dans le terminal, exécutez la commande 'mvn test'.

3. Après l'exécution de cette commande, le projet sera compilé et les fichiers de tests seront lancés, indiquant à la fin le nombre de tests validés.

# Exécution du projet : 

### Vous avez deux options pour exécuter le projet :

### Option 1 : Utilisation du shell de déploiement

1. Assurez-vous d'être à la racine du répertoire 'projet-Jade-cpoo'.

2. Dans le terminal, exécutez la commande './JeuDeLaVie.sh'.

3. Le shell de déploiement exécutera les commandes nécessaires pour vous permettre d'interagir directement avec le programme.

4. Suivez les instructions à l'écran pour fournir les informations nécessaires, telles que le chemin vers le fichier que vous souhaitez transformer en grille.

    a. Des exemples de fichiers sont disponibles dans le répertoire 'projet-Jade-cpoo/src/main/java/resources/' que vous pouvez utiliser pour tester.

    b. Par exemple, vous pouvez saisir dans le terminal : 'src/main/java/resources/clock-step0.life' pour appliquer le Jeu de la Vie à ce fichier.

5. Fournissez également le nombre maximum d'itérations que le Jeu de la Vie doit effectuer pour éviter une exécution indéfinie.

    C'est une sécurité pour éviter qu'il continue indéfiniment.  
    Le Jeu de la Vie peut arriver à un état stable mais aussi donner lieu à des oscillations périodiques ou à des structures infiniment changeantes.

6. Enfin, indiquez le nom du fichier dans lequel vous souhaitez sauvegarder les résultats.

7. Le programme se terminera en affichant un message indiquant que le fichier résultat a été créé et fermé avec succès.

8. Vous pourrez retrouver à la racine du répertoire 'projet-Jade-cpoo' le fichier résultat contenant chaque étape du Jeu de la Vie appliqué au fichier de base.

### Option 2 : Exécution pas à pas

1. Assurez-vous d'être à la racine du répertoire 'projet-Jade-cpoo'.

2. Dans le terminal, exécutez la commande 'mvn package'.

3. Cela créera un fichier nommé 'Jeu-de-la-vie-1.0-SNAPSHOT.jar' dans le répertoire 'target'.

4. Placez-vous dans le répertoire 'target' et exécutez la commande suivante dans le terminal : 'java -jar Jeu-de-la-vie-1.0-SNAPSHOT.jar'.

5. Suivez les instructions à l'écran pour fournir les informations nécessaires, similaires à l'option précédente où vous utilisez le shell de déploiement.

# Fonctionnalités implémentées et choix techniques

## Les fonctionnalités du package 'principal'

### Ce package regroupe les classes principale nécessaire à chaque élément du projet

- La classe Cellule représente chaque cellule de la grille. Elle possède un identifiant, un état vivant (1) ou mort (0) ainsi qu'une liste d'identifiants de cellules voisines.

- La classe Grille représente une grille composée de cellules et possède des méthodes permettant de manipuler la grille.

- La classe Automate représente la partie du projet qui prend une grille et lui applique le Jeu de la Vie.

- La classe JeuDeLaVie représente la classe principale du projet. Elle permet de lire les données à partir d'un fichier pour créer une grille, d'appliquer le Jeu de la Vie à l'aide de l'Automate, puis de générer un fichier résultat contenant chaque itération du jeu.

## Les fonctionnalités du package 'utils'

### Ce package regroupe les classes nécessaire à l'affichage et l'intéraction dans la console   

- La classe AnsiColors définit les codes de couleurs ANSI qui seront utilisés ultérieurement dans la console.

- La classe Dialogue permet d'intéragir avec l'utilisateur dans la console en lui demandant de saisir soit un entier, soit une chaîne de caractères.

- La classe TerminalAffichage permet d'afficher du texte dans la console avec ou sans saut de ligne.

## Les fonctionnalités du package 'enums'

### Ce package regroupe uniquement des énumérations pouvant être appliqué à d'autres classes

- La classe Couleur représente chaque couleur ANSI pour un crayon ou un stabilo.

## Les choix techniques du projet

- Afin de prévenir toute régression compte tenu de la complexité du projet, j'ai utilisé les techniques du Test Driven Development (TDD). À chaque création d'un objet et l'ajout d'une nouvelle fonctionnalité, j'ai commencé par écrire les tests correspondants (qui étaient initialement en échec, affichant une couleur rouge car aucun code n'était encore écrit). Ensuite, j'ai implémenté le code jusqu'à ce que les tests passent (et deviennent de couleur verte).

- J'ai également utilisé les outils de GitLab, tels que les issues, pour organiser progressivement mes fonctionnalités.

- De plus, Maven m'a permis d'effectuer des tests continus en me permettant d'organiser et d'exécuter mes tests unitaires, ainsi que de créer un package du projet pour l'exécution du programme.

# Utilisation du programme et de ses tests

Dans la structure du projet Maven, vous trouverez sous le répertoire 'src/main/java' les packages contenant les classes constituant le projet, notamment la classe JeuDeLaVie.java qui est la classe principale du projet.

Dans le fichier 'pom.xml' à la racine du répertoire 'projet-Jade-cpoo', vous trouverez dans la balise 'properties' la ligne suivante :

```java
<main.class>principal.JeuDeLaVie</main.class>
```

Cette ligne indique quelle classe doit être utilisée comme classe principale et donc exécutée.

Pour les tests, vous les trouverez sous le répertoire 'test/main/java'.

Pour exécuter les tests, placez-vous à la racine du répertoire 'projet-Jade-cpoo' et exécutez la commande 'mvn test'. Cette commande permettra de recompiler toutes les classes du projet et d'exécuter les tests unitaires. Le nombre de tests validés sera affiché à la fin.

# Amélioration potentielles

Malgré les fonctionnalités implémentées avec succès dans ce projet, certaines améliorations auraient pu être réalisées avec plus de temps et de ressources.

1. Patron de conception Observer : Une amélioration potentielle aurait été d'implémenter le patron de conception Observer sur la classe Automate. Le patron Observer permet d'établir une relation de dépendance entre plusieurs objets, de sorte que lorsqu'un objet change d'état, tous les objets qui en dépendent sont notifiés et mis à jour automatiquement. Dans le contexte du Jeu de la Vie, chaque itération pourrait envoyer une notification à la méthode update de la classe AutomateObserver, qui serait chargée de dessiner la nouvelle grille dans le fichier. Cela permettrait une meilleure séparation des responsabilités et faciliterait l'extension du système.

2. Amélioration des performances : Une autre amélioration potentielle serait d'améliorer les performances des algorithmes utilisés dans l'Automate, en particulier lorsqu'une grille très grande est donnée en entrée. Actuellement, il peut y avoir un grand nombre de boucles d'itération, ce qui peut entraîner des ralentissements. Pour pallier cela, des techniques d'optimisation telles que la parallélisation des calculs ou l'utilisation de structures de données plus efficaces pourraient être explorées. Cela permettrait d'accélérer l'exécution du jeu de la vie pour des grilles de taille importante.

En conclusion, bien que certaines améliorations n'aient pas pu être implémentées en raison de contraintes de temps, le projet a été réalisé en suivant des pratiques de développement rigoureuses telles que le TDD et l'utilisation de GitLab pour l'organisation des fonctionnalités. Les fonctionnalités actuelles peuvent être utilisées avec succès, et les améliorations potentielles suggérées pourraient être explorées dans le cadre d'un développement futur du projet.