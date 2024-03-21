Projet 4 livraison de pizza
On veut modéliser la gestion d'une entreprise de fabrication et de livraison de pizzas à domicile:
la société RaPizz. Le client choisit sa pizza à partir d'un catalogue. Une pizza est caractérisée
par son nom, les ingrédients qui la composent et son prix de base. Pour chaque pizza, il existe
3 tailles : "naine","humaine" et "ogresse. La naine est 1/3 moins chère que le prix de base, la
pizza "humaine" coûte le prix de base et l' "ogresse" est 1/3 plus chère que le prix de base. Les
pizzas sont livrées par des livreurs qui circulent en voiture ou à moto. Pour passer une
commande de pizza, le client fournit son numéro de téléphone (qui va permettre de l’identifier)
et le contenu de sa commande qu’on représente sous la forme d’une liste composée du nom
d’une pizza, de sa taille et la quantité commandée.
Le système commence par vérifier que le client existe dans la base des clients et conserve l’objet
client qui lui correspond. Le système vérifie ensuite que la commande est faisable (elle peut
être fabriquée dans un Point RaPizza qui fait toutes les pizzas spéciales demandées) puis crée
la commande dans le système et en indique le numéro et le prix au client. Le mode de paiement
est du type prépayé c'est-à-dire que le client est abonné au service de livraison de pizza et doit
approvisionner son compte. On vérifie le solde du client avant de préparer et de livrer les pizzas.
Une pizza gratuite sera livrée au bout de 10 pizzas achetées. Toute pizza livrée en plus de 30
minutes est gratuite (retard de livraison). A partir de cette description du cahier des charges
"Livraison de commande de pizzas", on vous demande dans un premier temps d'élaborer le
logiciel qui permet de l’automatiser.
