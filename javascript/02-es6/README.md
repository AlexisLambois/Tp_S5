# TP 1 - ES6

## Objectifs
Passer à la dernière version d'ECMAScript pour du JS moderne. Utiliser notamment la POO et l'héritage.

## Préparatifs
NB : Pour coder en ES6 et bénéficier d'un support sur tous les navigateurs nous allons utiliser [Babel](https://babeljs.io/). En revanche pour des questions de simplicité de mise en place (et éviter les problèmes de droits) nous utiliserons Babel dans sa version destinée au prototypage, la compilation se fera au runtime (cad. dans le navigateur de l'internaute) mais dans un "vrai" projet, il vous faudra installer babel avec npm.
1. Inclure le JS runtime de babel dans la page html juste **après** le `main.js`
1. Modifier l'attribut `type` de la balise `<script>` du `main.js` :
	```html
	<script type="text/babel" src="js/main.js"></script>
	```
1. Recharger la page dans le navigateur, le code doit continuer de fonctionner comme avant sauf que cette fois, c'est babel qui charge votre JS et le convertit en ES5 (ce qui pour l'heure n'a aucun effet particulier puisque votre code est déjà en ES5 !)

## Instructions
### Syntaxe de base ES6
1. Remplacer toutes les déclarations de variables par des `const` sauf pour les variables dont on va modifier la valeur.
1. Utiliser les template strings pour remplacer les concaténations de chaînes.
1. Vérifier dans le navigateur que le code continue de fonctionner (sinon utiliser l'onglet "Sources" des devtools et notamment les breakpoints) !
### Classes & héritage
1. Créer une classe `Component` ayant les caractéristiques suivantes :
	+ le constructeur prend en paramètre
		- une chaîne nommée `tag` et stocké en variable membre `this.tag`
		- un Array nommé `children` et stocké en variable membre `this.children`
	+ la classe dispose d'une méthode `render()` qui retourne une chaîne de caractères correspondant à une balise dont le type correspond à l'attribut `tag` passé dans le constructeur. ex: si `tag` vaut "div" alors on générera une chaîne `<div></div>`. à l'intérieur de la balise on insérera le résultat de l'appel à la méthode `renderChildren` (cf. ci-dessous)
	+ la méthode `renderChildren` retourne une chaîne de caractère dont le résultat dépend du contenu du tableau `children`. La méthode parcourt tous les `children` et ajoute le rendu de l'enfant à la valeur retournée. Pour chaque enfant la méthode teste :
		- si l'enfant est lui même une instance de Component, elle retourne un le résultat de l'appel à la méthode `render` du Component. Utiliser pour cela l'opérateur `instanceof` cf. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/instanceof
		- si l'enfant est une chaîne de caractères, la chaîne est ajoutée telle qu'elle dans le résultat retourné
	si le tableau children est vide, on retourne une chaîne vide
		- sinon soit le résultat de l'appel à la fonction render de chaque Component enfant
1. Instancier un Component de type `h1` avec comme enfant juste un texte `"JSTube"` et afficher le résultat de l'appel à la méthode `render()` dans la page html.
1. Créer une classe `VideoThumbnail` qui hérite de la classe `Component` :
	+ le constructeur prend en paramètre un objet nommé `video` dont le format correspond à celui d'un élément du tableau `videos`(cad. propriétés title, thumbnail, video)
	+ la méthode render() retourne un code du type :
	```html
	<div class="thumbnail">
		<img src="images/nom de la thumbnail">
		<h2>title de la video</h2>
	</div>
	```
1. dans le main.js, modifier le parcours du tableau `videos` pour utiliser la classe `VideoThumbnail` afin de rendre les vignettes de la liste.
