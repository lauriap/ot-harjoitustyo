/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lauri
 */
public class KassapaateTest {
    
    public KassapaateTest() {
    }
    
    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuPaateOlemassa() {
        assertTrue(paate!=null);      
    }
    
    @Test
    public void luodullaPaatteellaOikeaMaaraRahaa() {
        assertEquals(100000, paate.kassassaRahaa());      
    }
    
    @Test
    public void luodullaPaatteellaNollaMyytyaLounasta() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kassaKasvaaOikeinKunMaksuOnRiittava() {
        paate.syoMaukkaasti(500);
        assertEquals(100400, paate.kassassaRahaa()); 
    }
    
    @Test
    public void vaihtorahaaOikeinKunMaksuOnRiittava() {
        paate.syoMaukkaasti(500);
        assertEquals(100, paate.syoMaukkaasti(500)); 
    }
    
    @Test
    public void lounaidenMaaraKasvaaKunMaksuOnRiittava() {
        paate.syoMaukkaasti(500);
        paate.syoEdullisesti(500);
        assertEquals(1, paate.maukkaitaLounaitaMyyty()); 
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kassaEiKasvaKunMaksuEiOleRiittava() {
        paate.syoMaukkaasti(100);
        assertEquals(100000, paate.kassassaRahaa()); 
    }
    
    @Test
    public void rahatPalautetaanKunMaksuEiOleRiittava() {
        assertEquals(100, paate.syoMaukkaasti(100)); 
    }
    
    @Test
    public void lounaidenMaaraEiKasvaKunMaksuOnRiittava() {
        paate.syoMaukkaasti(100);
        paate.syoEdullisesti(100);
        assertEquals(0, paate.maukkaitaLounaitaMyyty()); 
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoToimiiEdulliselleLounaalle() {
        assertTrue(paate.syoEdullisesti(kortti));
        assertEquals(760, kortti.saldo());
    }
    
    @Test
    public void korttiostoToimiiMaukkaalleLounaalle() {
        assertTrue(paate.syoMaukkaasti(kortti));
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void korttiostoToimiiKunRahatEiRiita() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertFalse(paate.syoMaukkaasti(kortti));
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void kunKorttiostoEiToimiLounaidenMaaraEiMuutu() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassaEiMuutuKunKortillaOstaa() {
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void rahanLatausKortilleOnnistuuKunSummaOnYliNolla() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, paate.kassassaRahaa());
        assertEquals(1100, kortti.saldo());
    }
    
    @Test
    public void eiTehdaMitaanKunYritetaanLadataNegatiivistaMaaraaKortille() {
        paate.lataaRahaaKortille(kortti, -5);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(1000, kortti.saldo());
    }
}
