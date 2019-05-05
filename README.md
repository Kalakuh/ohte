*This repository is for University of Helsinki's course [Ohjelmistotekniikka](https://github.com/mluukkai/ohjelmistotekniikka-kevat2019)*.

# OKTI

OKTI on oppista edistävä opettelukorttisovellus (*engl.* flash card). OKTIssa käyttäjä voi luoda ja ladata opettelukorttipakkoja, joita hän voi käyttää asioiden opettelemiseen ja joilla hän voi testata osaamistaan.

## Dokumentaatio

* [Vaatimusmäärittely](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [Käyttöohje](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/kayttoohje.md)
* [Työaikakirjanpito](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/tuntikirjanpito.md)
* [Arkkitehtuuri](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/arkkitehtuuri.md)
* [Testausdokumentti](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/testaus.md)
* [Tietokantakaavio](https://github.com/Kalakuh/ohte/blob/master/dokumentaatio/relation.png)

## Julkaisut

* [Loppupalautus](https://github.com/Kalakuh/ohte/releases/tag/release)
* [Viikko 6](https://github.com/Kalakuh/ohte/releases/tag/viikko6)
* [Viikko 5](https://github.com/Kalakuh/ohte/releases/tag/viikko5)

## Komentorivikomennot

### Testaus

Testit voi suorittaa komennolla

```
mvn test
```

Testikattavuusraportin saa komennolla

```
mvn jacoco:report
```

Kattavuusraportti löytyy tiedostosta `target/site/jacoco/index.html`

### Jar-tiedoston generointi

Jar-tiedoston voi luoda komennolla

```
mvn package
```

Jonka jälkeen generoitu tiedosto löytyy `target`-kansion alta

### Checkstyle

Tiedostoon checkstyle.xml määritellyt tarkistukset voi suorittaa komennolla 

```
mvn jxr:jxr checkstyle:checkstyle
```

Tarkistuksen tulokset löytyvät tiedostosta `target/site/checkstyle.html`

### JavaDoc

JavaDocin voi generoida komennolla

```
mvn javadoc:javadoc
```
