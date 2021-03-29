
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }

    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }

    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    
    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi() {
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        kortti.syoMaukkaasti();
        assertThat(kortti.toString(), is(equalTo("Kortilla on rahaa 2.5 euroa")));
    }
    
    @Test
    public void kortilleEiVoiLadataNegatiivistaSaldoa() {
        kortti.lataaRahaa(-100);
        assertThat(kortti.toString(), is(equalTo("Kortilla on rahaa 10.0 euroa")));
    }
    
    @Test
    public void syoEdullisestiOnnistuuKunSaldoaOnJuuriEdullisenVerran() {
        Maksukortti kortti2 = new Maksukortti(2.5);
        kortti2.syoEdullisesti();
        assertThat(kortti2.toString(), is(equalTo("Kortilla on rahaa 0.0 euroa")));
    }
    
    @Test
    public void syoMaukkaastiOnnistuuKunSaldoaOnJuuriMaukkaanVerran() {
        Maksukortti kortti3 = new Maksukortti(4.0);
        kortti3.syoMaukkaasti();
        assertThat(kortti3.toString(), is(equalTo("Kortilla on rahaa 0.0 euroa")));
    }
}
