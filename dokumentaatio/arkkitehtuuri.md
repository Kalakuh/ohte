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

## Luokkakaavio

![Luokkakaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/class.png)

## Tietokanta

![Tietokantakaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/relation.png)

## Päätoiminnallisuudet

### Uuden pakan luominen

Uuden pakan luominen tapahtuu aloitusnäkymässä seuraavasti:

![Uusi pakka](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/new_deck.png)

Uusi pakka -painikkeen painaminen aktivoi tapahtumakäsittelijän, joka kysyy `App`-luokan funktion avulla käyttäjältä pakan nimeä. Sen jälkeen tapahtumakäsittelijä pyytää `App`-luokan instanssilta `DeckDAO`-objektia, johon uusi pakka talletetaan. Tämän jälkeen tapahtumakäsittelijä selvittää uusimman pakan ID:n `DeckDAO`:lta, ja vaihtaa `App`-luokan avulla kohtauksen pakanmuokkauskohtaukseen, jossa avoinna ovat uuden pakan tiedot.
