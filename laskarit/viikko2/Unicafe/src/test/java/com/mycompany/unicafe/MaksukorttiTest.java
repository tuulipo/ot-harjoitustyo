package com.mycompany.unicafe;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertTrue(kortti.saldo()==1000);
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(1000);
        assertTrue(kortti.saldo()==2000);
    }
    
    @Test
    public void saldoVaheneeOikeinKunRahaaTarpeeksi() {
        kortti.otaRahaa(500);
        assertTrue(kortti.saldo()==500);
    }
    
    @Test
    public void saldoEiVaheneKunRahaaEiTarpeeksi() {
        assertTrue(kortti.otaRahaa(2000)==false);
    }
    
    @Test
    public void kortinSaldonTulostaminenToimii() {
        assertThat(kortti.toString(), is(equalTo("saldo: 10.0")));
    }
    
}
