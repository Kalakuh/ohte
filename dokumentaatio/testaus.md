# Testausdokumentti

## Yksikkö- ja integraatiotestaus

### DAO-luokat

`GenericDAO`-luokkaa on testattu `DeckDAO`:n kautta luomalla jokaisessa testissä väliaikainen tietokanta, joka poistetaan heti testin jälkeen. Samassa yhteydessä on testattu useimpia `DeckDAO`:n tietokantatoimintoja. Tällä hetkellä luokkia `UserDAO` ja `FlashcardDAO` ei ole kattavasti yksikkö- ja integraatiotestattu kuin manuaalisesti, sillä virheet tulevat nopeasti ilmi sovellusta käyttäessä ja `GenericDAO` on testattu huolella.

### Tietokantaobjektit

Luokan `DatabaseObject` perivien luokkien `User`, `Deck` ja `Flashcard` kaikki funktiot on testattu yksikkötestein. Ainoa puute `Deck`-luokan testikattavuudessa tulee siitä, että koodissa on varauduttu `SQLException`-poikkeuksen tapahtumiseen.

### ArrayUtil

Utiliteettiluokan `ArrayUtil` ainoaa apufunktiota `selectRandomSubsetOfSizeN` on testattu kattavasti erityyppisillä syöteparametreillä. Satunnaisuutta olisi voinut testata tilastollisin menetelmin, mutta se päätettiin jättää testauksen ulkopuolelle tällä kertaa.

### Testikattavuus

Testikattavuuden laskemiseen on käytetty JaCoCo-kirjastoa. Rivikattavuus on noin 74% ja haaraumakattavuus 84%. Testikattavuutta vähentää jonkin verran se, että jotkin rivit ja haaraumat vaatisivat `SQLException`-virheiden tapahtumista.

![JaCoCo](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/jacoco.png)

## Järjestelmätestaus

Järjestelmätestaus on hoidettu manuaalisesti käyden läpi kaikki määrittelydokumentin toiminnallisuudet erinäisiä virheellisiä arvoja kokeillen.

## Kehitettävää

* `GenericDAO`:n testaamisen voisi hoitaa luomalla testejä varten tynkäluokan.
* Testikattavuutta voisi vielä suurentaa DAO:jen osalta, vaikka niissä olevat virheet käyvätkin nopeasti ilmi.
