#Protocole d'Application

## Ajouter un couple
>requete:
> - ajouter nom surnom

>reponse:
> - { "nom": "nom", "surnom": "surnom" }

>ou
> - UnavailableNameException

## Modifier un surnom
>requete:
> - modifier nom surnom newsurnom

>reponse:
> - [ { "nom": "nom", "surnoms": [ "surnom1", "surnom2", "newsurnom" ] } ]

>ou
> - NameNotFoundException

## Supprimer un surnom
>requete:
> - supprimer nom surnom

>reponse:
> - [ { "nom": "nom", "surnoms": [] } ]

>ou
> - NameNotFoundException

## Lister un ensemble de association nom liste de surnom
>requete:
> - lister [nom1, nom2, ..., nomN]

>reponse:
> - [
> -   { "nom": "nom1", "surnoms": [surnom1, surnom2, ... surnomn]},
> -   { "nom": "nom2", "surnoms": [surnom1, surnom2, ... surnomn]},
> -   {...},
> -   { "nom": "nomN", "surnoms":[surnom1, surnom2, ... surnomn]}
> - ]

>ou
> - NameNotFoundException


# Protocole de la sérialisation
## Chaine
> - "id_cmd | parametre1 | parametre2 | ... | parametreN"

#Exceptions
## Name Not Found Exception
> - { "error": "Nom n'est pas sur la list" }

## Unavailable Name Exception
> - { "error": "Nom indisponible" }
