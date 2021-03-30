# Vaatimusmäärittely opintojen seurantajärjestelmä -sovellukselle

## Sovelluksen tarkoitus
Sovellus on opiskelijoille ja opettajille tarkoitettu opintojen seurantajärjestelmä. Opiskelija kirjautuu sisään järjestelmään ja näkee kaikki suorittamansa opintonsa. Opiskelija voi myös suunnitella tulevia opintojaan. 

Opettaja voi kirjautua samaan järjestelmään ja tarkastella opiskelijoiden opintojen edistymistä. Opettaja luo kurssit, jotka opiskelija voi suorittaa ja antaa niistä myös suoritukset.

## Käyttäjät
Sovelluksella on kolme käyttäjäroolia: opiskelija, opettaja ja pääkäyttäjä. Vain pääkäyttäjä voi luoda opiskelijan ja opettajan käyttäjätunnukset.

## Käyttöliittymäluonnos

![K1](https://github.com/tuulipo/Kuvat/blob/main/k%C3%A4ytt%C3%B6liittymap1.PNG)
![K2](https://github.com/tuulipo/Kuvat/blob/main/k%C3%A4ytt%C3%B6liittymap2.PNG)
![K3](https://github.com/tuulipo/Kuvat/blob/main/k%C3%A4ytt%C3%B6liittymap3.PNG)
![K4](https://github.com/tuulipo/Kuvat/blob/main/k%C3%A4ytt%C3%B6liittymap4.PNG)
![K5](https://github.com/tuulipo/Kuvat/blob/main/k%C3%A4ytt%C3%B6liittymap5.PNG)

## Toiminnallisuus

### Kirjautuminen
Käyttäjä valitsee oman roolinsa mukaisen kirjautumisen (student/teacher/admin) ja syöttää avautuvaan login-ikkunaan ID-numeronsa (4 numeroa) ja salasanansa (4 kirjainta), ja sitten kirjautua sisään painamalla *LOGIN*. Aluksi vain Admin-tunnukset ovat luotuna ja admin-käyttäjä voi kirjautua sisään. Valitusta kirjautumistavasta voi palata kirjautumistavan valintaan painamalla *BACK*.

### Kirjautumisen jälkeen

Admin-käyttäjä voi

* luoda uuden opiskelijan/opettajan tunnukset
  * avautuu pääikkuna, johon syötetään luotavan tunnuksen rooli, ID-numero sekä salasana, ja tunnus luodaan painamalla *CREATE*
  * palata pääikkunaan painamalla *BACK*
* poistaa opiskelijan/opettajan tunnukset 
  * palata pääikkunaan painamalla *BACK*
* kirjautua ulos painamalla *LOGOUT*
 
Opiskelija-käyttäjä voi pääikkunassa

* tarkastaa suorittamansa opintopistemäärän ja keskiarvon
* tarkastella suorittamiaan opintoja painamalla *COMPLETED STUDIES*
  * poistua takaisin opiskelijan pääikkunaan painamalla *BACK*
* suunnitella tulevia opintojaan painamalla *PLANNED STUDIES* 
  * lisätä kurssin syöttämällä sen ID:n ja painamalla *ADD*
  * poistua takaisin pääikkunaan painamalla *BACK*
* kirjautua ulos painamalla *LOGOUT*

Opettaja-käyttäjä voi pääikkunassa

* siirtyä lisäämään uutta kurssia painamalla *ADD A NEW COURSE*
  * kurssi tarvitsee nimen, koodin, aloituspäivämäärän ja opintopistemäärän, hyväksytään painamalla *ADD*
  * palata takaisin pääikkunaan painamalla *BACK*
* merkitä suorituksen opiskelijalle
  * suoritus tarvitsee nimen, kurssi-ID:n ja arvosanan ja se hyväksytään painamalla *ADD*
  * palata takaisin pääikkunaan painamalla *BACK*
* tarkastella opiskelijan suorituksia painamalla *STUDENTS' RECORDS*
  * syöttämällä opiskelijan ID:n siirrytään opiskelijan suoritusnäkymään painamalla *SEARCH*
    * palata takaisin painamalla *BACK*
  * palata takaisin pääikkunaan painamalla *BACK*
* kirjautua ulos painamalla *LOGOUT*
   

## Kehitysideoita
* Opiskelija voisi ilmoittautua kursseille
* Opettaja voisi muokata ja poistaa kursseja sekä määrittää niille maksimiosallistujamäärän
* Opiskelijoille ja opettajille voisi antaa mahdollisuuden vaihtaa salasanansa
