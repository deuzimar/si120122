package test;
import org.junit.*;

import exception.InvalidLinkException;

import blog.Blog;
public class TestaBlog {
	private Blog meuBlog;
	@Before
	public void setUp(){
		meuBlog = new Blog();
		meuBlog.novoUsuario("Tester");
	}
	@Test
	public void testaCriacaoDeLink(){
		try {
			meuBlog.posta("http://youtube.com");
			meuBlog.posta("https://google.com");
		} catch (InvalidLinkException e) {
			Assert.fail("Os link eram validos");
		}
		try{
			meuBlog.posta("youtube.com");
			Assert.fail("O link e invalido");
		}catch(InvalidLinkException e){}
		try{
			meuBlog.posta("www.nempareceinvalido.com");
			Assert.fail("O link e invalido");
		}catch(InvalidLinkException e){}
	}
}
