package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertTrue(kortti.saldo() == 10);      
    }
    
    @Test
    public void latausToimiiOikein() {
        kortti.lataaRahaa(10);
        assertTrue(kortti.saldo() == 20);      
    }
    
    @Test
    public void saldoVaheneeOtettaessaJosRahaaOn() {
        kortti.otaRahaa(5);
        assertTrue(kortti.saldo() == 5);      
    }
    
    @Test
    public void saldoEiVaheneOtettaessaJosRahaaEiOle() {
        kortti.otaRahaa(20);
        assertTrue(kortti.saldo() == 10);      
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosRahaaOn() {
        assertTrue(kortti.otaRahaa(5));      
    }
    
    @Test
    public void otaRahaaPalauttaaFalseJosRahaaEiOle() {
        assertTrue(!kortti.otaRahaa(20));      
    }
    
    @Test
    public void toStringToimii() {
        kortti.lataaRahaa(100);
        assertTrue(kortti.toString().equals("saldo: 1.10"));
    }
}
