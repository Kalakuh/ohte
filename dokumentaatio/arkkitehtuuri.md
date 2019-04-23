# Arkkitehtuuri

## Ohjelmiston rakenne

Ohjelman rakenne koostuu viidestä pakkauksesta:

* `okti.db` sisältää tietokannan käyttöön tarvittavat luokat. Lisäksi siellä on määritelty luokka `DatabaseObject`, jonka tietokantaan talletettavat oliot perivät.
* `okti.domain` sisältää tietokantaan talletettavien olioiden luokat: pakan, opettelukortin ja käyttäjän.
* `okti.gui` sisältää kaiken käyttöliittymään rakentamiseen käytettävän koodin.
* `okti.event` sisältää käyttöliittymän tarvitsemien tapahtumakäsittelijöiden luokat.
* `okti.util` sisältää apuluokan, jota käytetään satunnaisen opettelukorttijoukon valitsemiseen.

## Luokkakaavio

![Luokkakaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/class.png)

## Tietokanta

![Tietokantakaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/relation.png)

## Päätoiminnallisuudet

### Uuden pakan luominen

Uuden pakan luominen tapahtuu aloitusnäkymässä seuraavasti:

![Uusi pakka](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/new_deck.png)

Uusi pakka -painikkeen painaminen aktivoi tapahtumakäsittelijän, joka kysyy `App`-luokan funktion avulla käyttäjältä pakan nimeä. Sen jälkeen tapahtumakäsittelijä pyytää `App`-luokan instanssilta `DeckDAO`-objektia, johon uusi pakka talletetaan. Tämän jälkeen tapahtumakäsittelijä selvittää uusimman pakan ID:n `DeckDAO`:lta, ja vaihtaa `App`-luokan avulla kohtauksen pakanmuokkauskohtaukseen, jossa avoinna ovat uuden pakan tiedot.
