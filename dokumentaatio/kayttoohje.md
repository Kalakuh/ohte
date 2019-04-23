# Käyttöohje

Lataa aluksi [okti.jar](https://github.com/Kalakuh/ohte/releases/tag/viikko6).

## Ohjelman käynnistäminen

Kun olet kansiossa, johon ohjelma on tallennettu, sen voi käynnistää komennolla

``` 
java -jar okti.jar
```

## Sisäänkirjautuminen

### Uuden tunnuksen luominen

Painamalla kirjautumisvalikossa sinistä _"Ei tunnusta? Luo sellainen tästä!"_-linkkiä pääset luomaan uutta tunnusta. Syötettyäsi käyttäjänimen ja salasanan paina _"Luo tunnus"_-painiketta luodaksesi tunnuksen. Jos käyttäjänimi on jo jollain käytössä koneellasi tai jokin muu virhe tapahtuu, antaa ohjelma virheilmoituksen. Tunnuksen luomisen onnistuttua ohjelma ohjaa sinut päävalikkoon.

### Olemassa olevalla tunnuksella kirjautuminen

Syöttämällä kirjautumisvalikossa käyttäjätunnuksesi ja salasanasi ja painamalla _"Kirjaudu sisään"_-painiketta ohjelma kirjaa sinut sisälle ohjelmaan ja ohjaa sinut päävalikkoon. Mikäli salasana ja käyttäjätunnus eivät täsmää, antaa järjestelmä virheilmoituksen.

## Päävalikko

### Uuden pakan luominen

Uuden pakan voi luoda painamalla _"Uusi pakka"_-painiketta ja syöttämällä uuden pakan nimen. Sinut ohjataan muokkausvalikkoon.

### Pakan tuominen

Voit tuoda pakan painamalla _"Tuo pakka"_-painiketta ja hakemalla koneeltasi `.dck`-tyyppisen tiedoston. Valittuasi sen ohjelma tuo pakan järjestelmään.

### Pakalla harjoittelu

Painamalla pakan nimeä ohjelma ohjaa sinut kyseisen pakan harjoittelutilaan.

### Pakan muokkaus

Painamalla pakan alla olevaa _Muokkaa_-nappia ohjelma ohjaa sinut kyseisen pakan muokkausvalikkoon.

### Pakan poisto

Painamalla pakan alla olevaa _Poista_-nappia ohjelma poistaa kyseisen pakan.

### Pakan vieminen

Painamalla pakan alla olevaa _Vie_-nappia ohjelma avaa ikkunan, johon voit antaa pakalle haluamasi tiedostonimen. Tämän jälkeen ohjelma vie pakan kyseiseen `.dck`-tiedostoon.

## Muokkausvalikko

### Päävalikkoon palaaminen

Päävalikkoon voi palata painamalla vasemmassa ylälaidassa olevaa _"Palaa päävalikkoon"_-painiketta.

### Kortin lisääminen

Pakkaan voi lisätä kortin painamalla ohjelman ylälaidassa olevaa _"Lisää kortti"_-painiketta. Syötettyäsi kortin kysymyksen ja vastauksen ohjelma lisää kyseisen kortin pakkaan.

### Kortin poistaminen

Kortin voi poistaa painamalla korttilistauksen oikeassa laidassa olevaa _Poista_-nappia poistettavan kortin kohdalta.

## Harjoittelutila

### Päävalikkoon palaaminen

Päävalikkoon voi palata painamalla vasemmassa ylälaidassa olevaa _"Palaa päävalikkoon"_-painiketta.

### Kortin kääntäminen

Kortin voi kääntää painamalla välilyöntiä.

### Seuraavaan korttiin siirtyminen

Jos koet osanneesi kortin, siirry seuraavaan korttiin oikealla nuolinäppäimellä. Jos et koe osaavasi sitä vielä, paina vasenta nuolinäppäintä, jolloin ohjelma lisää kortin vielä harjoiteltavien joukkoon ja ohjaa sinut seuraavaan korttiin. Jos session kaikki kortit on käyty läpi, ohjaa ohjelma sinut takaisin päävalikkoon.
