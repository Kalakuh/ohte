# Arkkitehtuuri

## Ohjelmiston rakenne

Ohjelman rakenne koostuu viidestä pakkauksesta:

* `okti.db` sisältää tietokannan käyttöön tarvittavat luokat. Lisäksi siellä on määritelty luokka `DatabaseObject`, jonka tietokantaan talletettavat oliot perivät.
* `okti.domain` sisältää tietokantaan talletettavien olioiden luokat: pakan, opettelukortin ja käyttäjän.
* `okti.gui` sisältää kaiken käyttöliittymään rakentamiseen käytettävän koodin.
* `okti.event` sisältää käyttöliittymän tarvitsemien tapahtumakäsittelijöiden luokat.
* `okti.util` sisältää apuluokan, jota käytetään satunnaisen opettelukorttijoukon valitsemiseen.

## Käyttöliittymä

Käyttöliittymä sisältää viisi erilaista näkymää

* __Rekisteröitymisnäkymä__ uuden tunnuksen rekisteröimistä varten.
* __Kirjautumisnäkymä__ tunnuksella kirjautumista varten.
* __Päänäkymä__ pakkojen luontiin, tuontiin, viemiseen, muokkaamiseen, harjoitteluun ja poistamiseen.
* __Muokkausnäkymä__ pakan korttien luontiin ja poistamiseen.
* __Harjoittelunäkymä__ pakan harjoittelemiseen.

Kaikki näkymät on toteutettu luokan `AppScene` perivinä luokkina, jotka toteuttavat `Scene`-olion palauttavan `createScene()`-funktion. Käyttöliittymän ylläpito tapahtuu luokassa `okti.gui.App`.

Pakkauksessa `okti.event` on tapahtumakäsittelijöitä, jotka reagoivat näkymissä tapahtuviin painalluksiin ja näppäimistöön.

## Sovelluslogiikka

Sovellus rakentuu luokkien `User`, `Deck` ja `Flashcard` ympärille, jotka perivät luokan `DatabaseObject`.

![Looginen datamalli](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/data_model.png)

Luokka `App` pitää yllä sovelluksen tilaa, sisältäen tiedon tämänhetkisestä näkymästä, kirjautuneesta käyttäjästä ja tiedon käsittelyyn käytettävistä DAO-objekteista.

Käyttöliittymän objekteihin liittyy tapahtumakäsittelijöitä, joille sovelluksen `App`-olio annetaan parametrina, jolloin ne voivat muokata sovelluksen tilaa ja esimerkiksi päästä käsiksi tietokantaan DAO-olioiden kautta.

Luokkien suhteita kuvaava pakkauskaavio:

![Pakkauskaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/architecture.png)

## Tietokantakaavio

Tietokanta sisältää seuraavat tietokantataulut:

![Tietokantakaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/relation.png)

Ohjelma luo taulut automaattisesti jos tietokantaa ei vielä ole, eli tietokantatiedostoa ei tarvitse kopioida mistään.

## Päätoiminnallisuudet

### Uuden pakan luominen

Uuden pakan luominen tapahtuu aloitusnäkymässä seuraavasti:

![Uusi pakka](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/new_deck.png)

Uusi pakka -painikkeen painaminen aktivoi tapahtumakäsittelijän, joka kysyy `App`-luokan funktion avulla käyttäjältä pakan nimeä. Sen jälkeen tapahtumakäsittelijä pyytää `App`-luokan instanssilta `DeckDAO`-objektia, johon uusi pakka talletetaan. Tämän jälkeen tapahtumakäsittelijä selvittää uusimman pakan ID:n `DeckDAO`:lta, ja vaihtaa `App`-luokan avulla kohtauksen pakanmuokkauskohtaukseen, jossa avoinna ovat uuden pakan tiedot.

### Pakan muokkaus

Kun käyttäjä on muokkausnäkymässä hän voi lisätä kortin seuraavasti: 

![Uusi kortti](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/new_card_sequence.png)

Lisää kortti -painikkeen painaminen aktivoi tapahtumakäsittelijän, joka kysyy `App`-luokan avulla käyttäjältä kortin kysymystä ja vastausta. Jos kumpikaan annetuista merkkijonoista ei ole tyhjä, tapahtumakäsittelijä pyytää `App`-luokan instanssilta `FlashcardDAO`-objektin, jonne uusi opettelukortti talletetaan. Lopuksi tapahtumakäsittelijä päivittää näkymän luomalla `DeckScene`-objektin uusiksi.

## Arkkitehtuurin heikkoudet

Tapahtumakäsittelijät `ImportDeckButtonClickedEventHandler` ja `ExportDeckButtonClickedEventHandler` toteuttavat luokan sisällä tiedostoon luvun ja kirjoittamisen, minkä voisi sinänsä eriyttää omiksi luokikseen. Nykyisen tavan vaatima koodi oli kuitenkin sen verran lyhyt ja luokkien nimistä käy ilmi mitä luokka tekee, joten tämä jätettiin tällä kertaa toteuttamatta.

Lisäksi koska `App`-objekteja voi olla vain yksi, voisi sen toteuttaa Sigleton-toteutuksella.
