# Vaatimusmäärittely

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
Käyttäjä valitsee oman roolinsa mukaisen kirjautumisen (student/teacher/admin) ja syöttää avautuvaan login-ikkunaan ID-numeronsa (10 numeroa) ja salasanansa. Aluksi vain Admin-tunnukset ovat luotuna ja admin-käyttäjä voi kirjautua sisään. Valitusta kirjautumistavasta voi palata kirjautumistavan valintaan.

### Kirjautumisen jälkeen

Admin-käyttäjä voi

* luoda uuden opiskelijan/opettajan tunnukset
  * avautuu pääikkuna, johon syötetään luotavan tunnuksen rooli, ID-numero ja salasana ja tunnus luodaan painamalla create
  * palata pääikkunaan
* poistaa opiskelijan/opettajan tunnukset 
  * palata pääikkunaan
* kirjautua ulos
 
Opiskelija-käyttäjä voi pääikkunassa

* tarkastella suorittamiaan opintoja
  * poistua takaisin opiskelijan pääikkunaan
* suunnitella tulevia opintojaan lisäämällä kurssin sen ID:n mukaan
  * poistua takaisin pääikkunaan
* kirjautua ulos

Opettaja-käyttäjä voi pääikkunassa

* lisätä uuden kurssin
  * kurssi tarvitsee nimen, koodin, aloituspäivämäärän ja opintopistemäärän
  * palata takaisin pääikkunaan 
* merkitä suorituksen opiskelijalle
  * suoritus tarvitsee nimen, kurssi-ID:n ja arvosanan
  * palata takaisin pääikkunaan
* tarkastella opiskelijan suorituksia
  * syöttämällä opiskelijan ID:n siirrytään opiskelijan suoritusnäkymään
    * palata takaisin
  * palata takaisin pääikkunaan
* kirjautua ulos
   

## Kehitysideoita
