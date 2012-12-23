package blog;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import exception.InvalidLinkException;


import tempo.IntervaloDeTempo;


@SessionScoped
@ManagedBean(name="blog")
public class BlogBean {

	private String endereco = "Inicie com http:// ou https://";
	private Blog blog = new Blog();
	
	public String postaLink(){
		try {
			blog.posta(endereco);
			return "ImDaBest";
		} catch (InvalidLinkException e) {
			return e.getMessage();
		}
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<Link> getUltimasPostagens(){
		return blog.getUltimosLinksPostados();
	}
	
	public String getTempoEntrePostagens(){
		IntervaloDeTempo intervalo = blog.getTempoMedioEntrePostagens();
		if (intervalo == null){
			return "Não houve postagens suficientes.";
		}else {
			return String.format("%.1f %s", intervalo.getValor(),intervalo.getUnidade().toString());
		}
	}	
	public String getSiteMaisPostado(){
		String site =blog.getSiteMaisPostado();
		if(site.equals("")){
			return "Nenhum site foi postado.";
		}
		return site;
	}
}
