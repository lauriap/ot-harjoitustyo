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
        assertEquals(10, kortti.saldo());      
    }
    
    @Test
    public void latausToimiiOikein() {
        kortti.lataaRahaa(10);
        assertEquals(20, kortti.saldo());      
    }
    
    @Test
    public void saldoPieneneeOikeinKunRahaaOnTarpeeksi() {
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());      
    }
    
    @Test
    public void saldoEiMuutuKunRahaaEiOleTarpeeksi() {
        kortti.otaRahaa(15);
        assertEquals(10, kortti.saldo());      
    }
    
    @Test
    public void palauttaaTrueKunRahaaOnTarpeeksi() {
        assertEquals(true, kortti.otaRahaa(5));      
    }
    
    @Test
    public void palauttaaFalseKunRahaaEiOleTarpeeksi() {
        assertEquals(false, kortti.otaRahaa(15));      
    }
    
}
