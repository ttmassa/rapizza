# Bienvenue dans le projet Rapizza !
Bienvenue dans le référentiel GitHub du projet Rapizza ! Ce projet, développé en collaboration entre [ttmassa](https://github.com/ttmassa) et [trCVZ](https://github.com/trCVZ), est un gestionnaire d'entreprise de livraisons de pizzas nommé Rapizza, entièrement conçu en Java.

## Aperçu du Projet
Rapizza vise à simplifier la gestion des commandes, des livraisons et de l'inventaire pour une entreprise de livraison de pizzas. Avec une interface utilisateur conviviale et des fonctionnalités robustes, ce projet offre une solution complète pour les entreprises du secteur de la restauration rapide.

Voici la consigne du projet : 

On veut modéliser la gestion d'une entreprise de fabrication et de livraison de pizzas à domicile: la société RaPizz. Le client choisit sa pizza à partir d'un catalogue. Une pizza est caractérisée par son nom, les ingrédients qui la composent et son prix de base. Pour chaque pizza, il existe 3 tailles : "naine","humaine" et "ogresse. La naine est 1/3 moins chère que le prix de base, la pizza "humaine" coûte le prix de base et l' "ogresse" est 1/3 plus chère que le prix de base. Les pizzas sont livrées par des livreurs qui circulent en voiture ou à moto. Pour passer une commande de pizza, le client fournit son numéro de téléphone (qui va permettre de l’identifier) et le contenu de sa commande qu’on représente sous la forme d’une liste composée du nom d’une pizza, de sa taille et la quantité commandée. 

Le système commence par vérifier que le client existe dans la base des clients et conserve l’objet client qui lui correspond. Le système vérifie ensuite que la commande est faisable (elle peut être fabriquée dans un Point RaPizza qui fait toutes les pizzas spéciales demandées) puis crée la commande dans le système et en indique le numéro et le prix au client. Le mode de paiement est du type prépayé c'est-à-dire que le client est abonné au service de livraison de pizza et doit approvisionner son compte. On vérifie le solde du client avant de préparer et de livrer les pizzas. Une pizza gratuite sera livrée au bout de 10 pizzas achetées. Toute pizza livrée en plus de 30 minutes est gratuite (retard de livraison). A partir de cette description du cahier des charges "Livraison de commande de pizzas", on vous demande dans un premier temps d'élaborer le logiciel qui permet de l’automatiser.

## Objectif
L'objectif principal de Rapizza est de fournir une plateforme logicielle efficace et intuitive pour les entreprises de livraison de pizzas, permettant une gestion fluide des opérations quotidiennes. En combinant des fonctionnalités de commande, de suivi des livraisons et de gestion d'inventaire, Rapizza aspire à améliorer l'efficacité et la satisfaction de la clientèle pour les entreprises du secteur.

## Fonctionnalités Principales
- Gestion des commandes : Permet aux utilisateurs de passer des commandes de pizzas en ligne, avec différentes options de personnalisation.
- Suivi des livraisons : Offre un suivi en temps réel des livraisons en cours, avec des mises à jour sur l'état actuel des commandes.
- Gestion de l'inventaire : Permet aux entreprises de surveiller et de gérer leur inventaire de manière efficace, en automatisant les tâches de réapprovisionnement et de suivi des stocks.
  
## Technologies Utilisées
Le projet Rapizza est entièrement implémenté en Java, utilisant des concepts de programmation orientée objet pour assurer une structure modulaire et extensible. Il fait également usage de bibliothèques tierces pour des fonctionnalités spécifiques.

Nous sommes ravis de partager notre travail avec vous et nous espérons que Rapizza apportera une valeur ajoutée à votre expérience de développement et d'apprentissage.
