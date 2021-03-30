
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void kassassaAluksiOikeaMaaraRahaa() {
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void myytyjenMaukkaidenLounaidenMaaraAluksiOikea() {
        assertTrue(kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void myytyjenEdullistenLounaidenMaaraAluksiOikea() {
        assertTrue(kassa.edullisiaLounaitaMyyty()==0);
    }
    
    @Test
    public void syoEdullisestiKassaOttaaJaAntaaOikeanMaaranKateistaRahaaTakaisin() {
        //antaa oikean määrän rahaa takaisin
        assertTrue(kassa.syoEdullisesti(300)==60);
        //ottaa oikean määrän rahaa kassaan
        assertTrue(kassa.kassassaRahaa()==100240);
    }
    
    @Test
    public void syoMaukkaastiKassaOttaaJaAntaaOikeanMaaranKateistaRahaaTakaisin() {
        //antaa oikean määrän rahaa takaisin
        assertTrue(kassa.syoMaukkaasti(500)==100);
        //ottaa oikean määrän rahaa kassaan
        assertTrue(kassa.kassassaRahaa()==100400);
    }
    
    @Test
    public void edullisiaMyytyOikeaMaaraKunTarpeeksiKateista() {
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(500);
        assertTrue(kassa.edullisiaLounaitaMyyty()==4);
    }
    
    @Test
    public void maukkaitaMyytyOikeaMaaraKunTarpeeksiKateista() {
        kassa.syoMaukkaasti(500);
        kassa.syoMaukkaasti(500);
        kassa.syoMaukkaasti(500);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==3);
    }
    
    @Test
    public void syoEdullisestiKassaAntaaOikeanMaaranRahaaTakaisinKunEiTarpeeksiRahaaJaLounaidenMaaraEiMuutu() {
        assertTrue(kassa.syoEdullisesti(200)==200);
        assertTrue(kassa.edullisiaLounaitaMyyty()==0);
    }
    
    @Test
    public void syoMaukkaastiKassaAntaaOikeanMaaranRahaaTakaisinKunEiTarpeeksiRahaaJaLounaidenMaaraEiMuutu() {
        assertTrue(kassa.syoMaukkaasti(300)==300);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void syoEdullisestiVeloittaaKortiltaKunTarpeeksiRahaa() {
        assertTrue(kassa.syoEdullisesti(kortti)==true);
        assertTrue(kassa.edullisiaLounaitaMyyty()==1);
    }
    
    @Test
    public void syoMaukkaastiVeloittaaKortiltaKunTarpeeksiRahaa() {
        assertTrue(kassa.syoMaukkaasti(kortti)==true);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==1);
    }
    
    @Test
    public void syoMaukkaastiEiVeloitaKortiltaTaiKasvataMyytyjaKunEiOleTarpeeksiRahaa() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertTrue(kassa.syoMaukkaasti(kortti)==false);
        assertTrue(kortti.saldo()==200);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==2);
    }
    
    @Test
    public void syoEdullisestiEiVeloitaKortiltaTaiKasvataMyytyjaKunEiOleTarpeeksiRahaa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertTrue(kassa.syoEdullisesti(kortti)==false);
        assertTrue(kortti.saldo()==40);
        assertTrue(kassa.edullisiaLounaitaMyyty()==4);
    }
    
    @Test
    public void kassassaOlevaRahamaaraEiMuutuKortillaOstettaessa() {
        kassa.syoEdullisesti(kortti);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void lataaRahaaKortilleKasvattaaKassaaOikein() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertTrue(kortti.saldo()==2000);
        assertTrue(kassa.kassassaRahaa()==101000);
    }
    
    @Test
    public void lataaRahaaKortilleEiLataaJosSummaNegatiivinen() {
        kassa.lataaRahaaKortille(kortti, -10);
        assertTrue(kortti.saldo()==1000);
        assertTrue(kassa.kassassaRahaa()==100000);
    }

}
