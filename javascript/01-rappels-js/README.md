# TP 1 - Rappels JavaScript

## Objectifs
Manipuler les fonctions et types de base de JavaScript pour générer en JavaScript l'interface d'une application web que nous appellerons au hasard "JSTube".<br>
Ce TP sera aussi l'occasion de manipuler les outils de debug du navigateur (devtools).

## Préparatifs
1. installer un serveur apache/php (sur windows [Apachefriends xampp](https://www.apachefriends.org/fr/index.html) ou [wampserver](http://www.wampserver.com/)) nécessaire pour faire tourner votre page web (utiliser toujours le protocole http pour tester vos développements et pas file://...)
2. Installer un éditeur de code optimisé pour le développement web : [VSCode](https://code.visualstudio.com/), [SublimeText](https://www.sublimetext.com/), [Atom](https://atom.io/), ...
3. créer un dossier pour ce TP dans un emplacement accessible en http (répertoire htdocs pour xampp) et y placer le contenu du dossier de démarrage fourni dans ce repo. Puis vérifier dans le navigateur que la page peut bien se charcher en y accédant en **http** (`http://localhost/chemin-vers-mon-dossier/index.html`)
4. Explorer le contenu du dossier de démarrage, le fichier `index.html` et surtout le fichier `main.js` : il contient déjà du code qui servira pour la suite du TP.

## Instructions
### Intégration du JS
1. **Inclure le fichier `main.js` dans le fichier `index.html` à l'aide d'une balise `<script>`.** <br>**NB :** *De manière générale et sauf cas particuliers, pour éviter que le chargement du fichier JS ne ralentisse l'affichage de la page html, les balises script sont placées en fin de fichier html, juste **avant** la balise fermante `</body>`*
1. **Tester la page pour vérifier que le js est correctement chargé** : Ouvrir les outils de développement de votre navigateur (touche F12 sur Chrome) et ouvrir le panneau "Console". Si le fichier `main.js` est correctement chargé, le texte 'youpi' doit s'afficher dans la console. En effet, le fichier main.js contient une instruction `console.log('youpi');`. La méthode `console.log` permet d'afficher du texte ou des variables dans la console. <br>**NB :** *Si ce texte ne s'affiche pas, c'est probablement que le fichier `main.js` n'est pas correctement intégré dans la page html. <br>Ouvrir le panneau "Network"/"Réseau" puis recharger la page en désactivant le cache navigateur(touche CTRL+F5, ou CTRL+SHIFT+R) s'assurer que le fichier main.js figure bien dans la liste des fichiers téléchargés.*
### Manipulation des chaînes
1. **Créer une variable nommée `html`.** Sa valeur initiale sera la concaténation de la chaine de caractères `'images/'` et de la valeur de la variable `file` (qui est déjà présente dans le fichier `main.js`)
1. **Sur une ligne suivante, modifier la valeur de la variable `html`** pour en faire une chaîne qui corresponde au code html d'une balise `a` ayant comme lien la valeur initiale de la variable `html`. Cette balise `a` devra contenir elle même une balise `img` dont la source sera la valeur initiale de la variable `html`. Afficher la valeur de la variable dans la console, le résultat obtenu devra être :
	```html
	<a href="images/catlaugh.jpg"><img src="images/catlaugh.jpg"></a>
	```
1. **Afficher le lien et l'image ainsi générés dans la page html** à l'aide de la méthode `querySelector` et de la propriété `innerHTML` :
	```js
	document.querySelector('.container').innerHTML = html;
	```

### Manipulation des tableaux et objets
Le fichier `main.js` contient un tableau d'objets littéraux nommé `videos`. Le but sera de parcourir ce tableau pour générer une page affichant les vignettes des vidéos contenues dans ce tableau avec pour chaque vignette : une image de la vidéo (propriété `thumbnail`) et un titre `<h2>` contenant le titre de la vidéo (propriété `title`). <br>
Vous utiliserez pour cela 3 méthodes différentes :
1. Utiliser une boucle `for`.
1. Utiliser la méthode `Array.foreach` cf. https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Objets_globaux/Array/forEach
1. Utiliser la méthode `Array.map` cf. https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Objets_globaux/Array/map et la méthode `Array.join` cf. https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Objets_globaux/Array/join
