# Arkkitehtuuri

## Luokkakaavio

![Luokkakaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/class.png)

## Tietokantakaavio

![Tietokantakaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/relation.png)

## Päätoiminnallisuudet

### Uuden pakan luominen

Uuden pakan luominen tapahtuu aloitusnäkymässä seuraavasti:

![Uusi pakka](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/new_deck.png)

Uusi pakka -painikkeen painaminen aktivoi tapahtumakäsittelijän, joka kysyy `App`-luokan funktion avulla käyttäjältä pakan nimeä. Sen jälkeen tapahtumakäsittelijä pyytää `App`-luokan instanssilta `DeckDAO`-objektia, johon uusi pakka talletetaan. Tämän jälkeen tapahtumakäsittelijä selvittää uusimman pakan ID:n `DeckDAO`:lta, ja vaihtaa `App`-luokan avulla kohtauksen pakanmuokkauskohtaukseen, jossa avoinna ovat uuden pakan tiedot.
