package test;
import org.junit.*;

import exception.InvalidLinkException;

import tempo.IntervaloDeTempo;
import tempo.UnidadeDeTempo;

import blog.LinhaDoTempo;
public class TestaLinhaDoTempo {

	private LinhaDoTempo ldt;
	@Before
	public void setUP(){
		ldt = new LinhaDoTempo();
	}

	@Test 
	public void testaTempoMedioEntrePostagens(){
		IntervaloDeTempo intervalo;
		Assert.assertNull(ldt.getTempoMedioEntrePostagens());
		
		ldt.posta("http://google.com",21,9,2012,23,45);
		ldt.posta("http://google.com",21,9,2012,23,50);
		ldt.posta("http://google.com",21,9,2012,23,55);
		intervalo = ldt.getTempoMedioEntrePostagens();
		Assert.assertEquals(intervalo.getValue(), 5f, 0.001);
		Assert.assertEquals(UnidadeDeTempo.Minutos,intervalo.getUnidade());
		
		ldt.posta("http://google.com",22,9,2012,23,45);
		intervalo = ldt.getTempoMedioEntrePostagens();
		Assert.assertEquals(intervalo.getValue(), 8f, 0.001);
		Assert.assertEquals(UnidadeDeTempo.Horas,intervalo.getUnidade());
		
		ldt.posta("http://google.com",29,9,2012,23,45);
		intervalo = ldt.getTempoMedioEntrePostagens();
		Assert.assertEquals(intervalo.getValue(), 2f, 0.001);
		Assert.assertEquals(UnidadeDeTempo.Dias,intervalo.getUnidade());
	}
	
	@Test
	public void testaSiteMaisLinkado() throws InvalidLinkException{
		ldt.posta("https://google.com/blabalbalb");
		Assert.assertEquals("google.com", ldt.getSiteMaisPostado());
		
		ldt.posta("https://youtube.com/comoAcharOSiteMaisPostadoEmJava");
		ldt.posta("https://youtube.com/notFound");
		Assert.assertEquals("youtube.com", ldt.getSiteMaisPostado());
		
		ldt.posta("https://tiny.url.com/notFound");
		ldt.posta("https://tiny.url.com/yesFound");
		ldt.posta("https://tiny.url.com/maybeFound");
		Assert.assertEquals("tiny.url.com", ldt.getSiteMaisPostado());
		
		ldt.posta("https://www.youtube.com/yesFound");
		ldt.posta("https://www.youtube.com/maybeFound");
		Assert.assertEquals("youtube.com", ldt.getSiteMaisPostado());
	}
}
