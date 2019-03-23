package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    private Kassapaate paate;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
    }
    
    @Test
    public void alkurahatOikein() {
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void alkuEdullistenMyynnitOikein() {
        assertTrue(paate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void alkuMaukkaidenMyynnitOikein() {
        assertTrue(paate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void edullisestaVaihtorahaaOikein() {
        assertTrue(paate.syoEdullisesti(250) == 10);
    }
    
    @Test
    public void maukkaastaVaihtorahaaOikein() {
        assertTrue(paate.syoMaukkaasti(410) == 10);
    }

    @Test
    public void edullisenKateisostoKasvattaaSaldoa() {
        paate.syoEdullisesti(240);
        assertTrue(paate.kassassaRahaa() == 100240);
    }
    
    @Test
    public void maukkaanKateisostoKasvattaaSaldoa() {
        paate.syoMaukkaasti(400);
        assertTrue(paate.kassassaRahaa() == 100400);
    }
    
    @Test
    public void edullisenKateisostoKasvattaaOstomaaraa() {
        paate.syoEdullisesti(240);
        assertTrue(paate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void maukkaanKateisostoKasvattaaOstomaaraa() {
        paate.syoMaukkaasti(400);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void epaonnistunutEdullisenKateisostoPalauttaaKaiken() {
        assertTrue(paate.syoEdullisesti(20) == 20);
    }
    
    @Test
    public void epaonnistunutMaukkaanKateisostoPalauttaaKaiken() {
        assertTrue(paate.syoMaukkaasti(20) == 20);
    }

    @Test
    public void epaonnistunutEdullisenKateisostoEiKasvataSaldoa() {
        paate.syoEdullisesti(42);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void epaonnistunutMaukkaanKateisostoEiKasvataSaldoa() {
        paate.syoMaukkaasti(42);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void epaonnistunutEdullisenKateisostoEiKasvataMyytyjenMaaraa() {
        paate.syoEdullisesti(24);
        assertTrue(paate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void epaonnistunutMaukkaidenKateisostoEiKasvataMyytyjenMaaraa() {
        paate.syoMaukkaasti(40);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void edullisenOnnistunutKorttiostoPalauttaaTrue() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void maukkaanOnnistunutKorttiostoPalauttaaTrue() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(paate.syoMaukkaasti(kortti));
    }

    @Test
    public void edullisenKorttiostoOttaaSaldoaKortilta() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 260);
    }
    
    @Test
    public void maukkaanKorttiostoOttaaSaldoaKortilta() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 100);
    }
    
    @Test
    public void edullisenKorttiostoKasvattaaOstomaaraa() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoEdullisesti(kortti);
        assertTrue(paate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void maukkaanKorttiostoKasvattaaOstomaaraa() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void epaonnistunutEdullisenKorttiostoEiVieSaldoa() {
        Maksukortti kortti = new Maksukortti(10);
        paate.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 10);
    }
    
    @Test
    public void epaonnistunutMaukkaanKorttiostoEiVieSaldoa() {
        Maksukortti kortti = new Maksukortti(10);
        paate.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 10);
    }

    @Test
    public void epaonnistunutEdullisenKorttiostoEiKasvataMyyntimaaraa() {
        Maksukortti kortti = new Maksukortti(10);
        paate.syoEdullisesti(kortti);
        assertTrue(paate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void epaonnistunutMaukkaanKorttiostoEiKasvataMyyntimaaraa() {
        Maksukortti kortti = new Maksukortti(10);
        paate.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 10);
    }
    
    @Test
    public void epaonnistunutEdullisenKorttiostoPalauttaaFalse() {
        Maksukortti kortti = new Maksukortti(10);
        assertTrue(!paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void epaonnistunutMaukkaanKorttiostoPalauttaaFalse() {
        Maksukortti kortti = new Maksukortti(10);
        assertTrue(!paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void ostoEiMuutaKassanSaldoa() {
        Maksukortti kortti = new Maksukortti(400);
        paate.syoEdullisesti(kortti);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void latausLisaaKortinSaldoa() {
        Maksukortti kortti = new Maksukortti(0);
        paate.lataaRahaaKortille(kortti, 10);
        assertTrue(kortti.saldo() == 10);
    }
    
    @Test
    public void latausLisaaKassanSaldoa() {
        Maksukortti kortti = new Maksukortti(0);
        paate.lataaRahaaKortille(kortti, 10);
        assertTrue(paate.kassassaRahaa() == 100010);
    }
    
    @Test
    public void negatiivinenLatausEiLisaaKortinSaldoa() {
        Maksukortti kortti = new Maksukortti(0);
        paate.lataaRahaaKortille(kortti, -10);
        assertTrue(kortti.saldo() == 0);
    }
    
    @Test
    public void negatiivinenLatausEiLisaaKassanSaldoa() {
        Maksukortti kortti = new Maksukortti(0);
        paate.lataaRahaaKortille(kortti, -10);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
}
