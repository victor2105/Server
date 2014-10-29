#Protocole d'Application

## Ajouter un couple
> requete:
> ajouter nom surnom
> reponse:
> ok | erro:[...]

## Modifier un surnom
> requete:
> modifier nom surnom newsurnom
> reponse:
> ok | erro:[...]

# Supprimer un surnom
> requete:
> supprimer nom surnom
> reponse:
> ok | erro:[...]

# Lister un ensemble de association nom liste de surnom
> requete:
> lister [nom1, nom2, ..., nomN]
> reponse:
> [
>     {nom1, [surnom1, surnom2, ... surnomn]}
>     {nom2, [surnom1, surnom2, ... surnomn]}
>     {...}
>     {nomN, [surnom1, surnom2, ... surnomn]}
> ]


# Protocole de la sérialisation
## Chaine
> - "id_cmd | parametre1 | parametre2 | ... | parametreN"
