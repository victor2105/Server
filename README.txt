Protocole d'Application :

##Introduction :
    Notre serveur et notre client doivent communiquer au moyen d’un protocole. Ce protocole fait circuler trois types de messages : requêtes, réponses et exceptions. Les requêtes sont les messages envoyés par le client. Les réponses et exceptions sont envoyées par le serveur.
	Notre serveur ne peut réaliser que cinq opérations : enregistrer un couple nom-surnom, ajouter un surnom à un nom, modifier un surnom, supprimer un surnom et lister un ensemble d’associations nom - liste de surnoms. Pour chaque opération, il y a une seule requête et réponse possible (hormis pour la suppression d'un surnom). Si la réponse n’est pas possible, le serveur envoie une exception.
	Ce document décrit le protocole de la manière suivante : nom de l’opération suivi de la forme sous laquelle sa requête doit être formulée, suivi des messages que le serveur peut envoyer.

##Operations :

*****Enregistrer un nom-surnom*****
Sert à ajouter un nouveau surnom et un nom associé dans la base de données.

Requête :
{ “type”: “enregistrer”, “parametres”: [“<nom>”,  “<surnom>” ] }

Réponse :
{ “nom”: “<nom>”, “surnoms”: [“<surnom>”]  }

Exceptions :
NicknameAlreadyUsedException
UnavailableNameException

*****Ajouter un surnom*****
Sert à ajouter un surnom à un nom qui est déjà sur la base de données.

Requête :
{ “type”: “ajouter”, “parametres”: [“<nom>”,  “<surnom2>” ] }

Réponse :
{ "nom": "<nom>", "surnoms": [ "<surnom>", "<surnom2>"] }

Exceptions :
NameNotFoundException
NicknameAlreadyUsedException

*****Modifier un surnom*****
Sert à remplacer un surnom existant dans la base de données par un autre surnom, entré en paramètre.

Requête :
{ “type”: “modifier”, “parametres”: [“<nom>”,  “<surnom2>” , “<newsurnom>” ] }

Réponse :
 { "nom": "nom", "surnoms": [ "<surnom1>", "<newsurnom>" ] }

Exceptions :
NameNotFoundException
NicknameAlreadyUsedException

*****Supprimer un surnom*****
Sert à supprimer un surnom affecté à un nom, tous deux entrés en paramètre. 

Avant :
 { "nom": "<nom>", "surnoms": [“<surnom1>”, “<surnom2>”] } 
{ "nom": "<nom>", "surnoms": [“<surnom1>”] } 

Requête :
{ “type”: “ajouter”, “parametres”: [ “<nom>”,  “<surnom1>” ] }

Réponse :
{ "nom": "<nom>", "surnoms": [ “<surnom2>” ] } 
{ “nom supprimé” } 

Exceptions :
NameNotFoundException
NicknameNotFoundException

*****Lister un ensemble d’associations nom - liste de surnoms*****
Sert à lister les associations nom - liste de surnoms pour les noms entrés en paramètre.

Requête :
{ “type”: “lister”, “parametres”: [“<nom1>”,  “<rnom2>” ,..., “<nomN>” ] }

Réponse :
[
{ "nom": "<nom1>", "surnoms": [“<surnom1>”, “<surnom2>”, ... “<surnomx>”]},
{ "nom": "<nom2>", "surnoms": [“<surnom1>”, “<surnom2>”, ... “<surnomy>”]},
{...},
{ "nom": "<nomN>", "surnoms": [“<surnom1>”, “<surnom2>”, ... “<surnomz>”]}
]

Exception :
NameNotFoundException

Liste d’Exceptions
Name Not Found Exception
{ "error": "Nom absent de la liste" }
Nickname Not Found Exception
{ “error”: “Surnom absent de la liste” }
Unavailable Name Exception
{ "error": "Nom indisponible" }

Nickname Already Used Exception

{ "error": "Surnom déjà attribué" }

