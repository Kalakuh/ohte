# OKTI (OpetteluKorTtIsovellus)

## Sovelluksen tarkoitus

Sovelluksen on tarkoitus olla oppimista edistävä sovellus, jossa käyttäjä voi luoda pakkoja opettelukorteista (engl. flash card) ja testata osaamistaan niillä. Lisäksi luotuja pakkoja voi viedä ja tuoda tiedostomuodossa. Jotta moni käyttäjä voi käyttää samaa ohjelmaa ilman että muiden pakat ovat tiellä, niin käyttäjät voivat myös kirjautua järjestelmään.

## Suunnitellut toiminnallisuudet

### Ennen kirjautumista

* Käyttäjä voi luoda käyttäjätunnuksen
  * Käyttäjätunnuksen tulee olla uniikki paikallisesti ja salasanan täytyy olla yli kahdeksanmerkkinen
* Käyttäjä voi kirjautua tunnuksillaan sisään ja pääsee aloitusnäkymään

### Aloitusnäkymä

* Aloitusnäkymässä käyttäjä voi luoda uuden pakan ja pääsee muokkausnäkymään
* Aloitusnäkymästä käyttäjä pääsee muokkaamaan pakkoja muokkausnäkymässä
* Aloitusnäkymässä käyttäjä voi valita pakan harjoittelua varten
* Aloitusnäkymässä käyttäjä voi poistaa pakan
* Aloitusnäkymässä käyttäjä voi viedä pakan tiedostoon
* Aloitusnäkymässä käyttäjä voi tuoda pakan tiedostosta

### Muokkausnäkymä

* Muokkausnäkymässä käyttäjä voi lisätä pakkaan uuden opettelukortin
* Muokkausnäkymässä käyttäjä voi muokata pakassa olevaa opettelukorttia
* Muokkausnäkymässä käyttäjä voi poistaa pakassa olevan opettelukortin
* Muokkausnäkymässä käyttäjä voi muuttaa pakan nimeä
* Muokkausnäkymästä käyttäjä voi poistua aloitusnäkymään

### Testausnäkymämä

* Testausnäkymässä käyttäjä näkee kortin valitusta pakasta
* Testausnäkymässä käyttäjä voi kääntää näkyvillä olevan kortin
* Testausnäkymässä käyttäjä voi vastata osasiko kortin ja siirtyä seuraavaan
* Testausnäkymästä käyttäjä voi poistua aloitusnäkymään halutessaan
* Testeusnäkymästä käyttäjä siirretään aloitusnäkymään kun harjoittelu on valmis

## Jatkokehitysideoita

* Mahdollisuus sijoittaa kortteihin tekstin lisäksi kuvia
