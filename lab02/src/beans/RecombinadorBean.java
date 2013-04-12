package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import exception.NaoHaMaisLinhasException;
import exception.RecombinadorInexistente;

import sistema.Sistema;
import sistema.Texto;

@SessionScoped
@ManagedBean(name = "Recombinador")
public class RecombinadorBean {
	private String textoAtual;
	private Texto textoSelecionado;
	private String recombinadorAtual;
	private Sistema sistema;

	@PostConstruct
	public void init(){
		this.sistema = Sistema.getInstance();
		textoAtual = "";
	}
	
	
	
	public String getTextoAtual() {
		return textoAtual;
	}

	public void setTextoAtual(String currentText) {
		this.textoAtual = currentText;
	}

	public List<Texto> getTextos() {
		return sistema.getTextos();
	}


	public String getRecombinadorAtual() {
		return recombinadorAtual;
	}
	
	public void setRecombinadorAtual(String recombinadorAtual) {
		this.recombinadorAtual = recombinadorAtual;
	}

	public List<String> getRecombinadores() {
		recombinadorAtual = sistema.getRecombinadores().get(0);
		return sistema.getRecombinadores();
	}

	
	public String adicionaLinha() throws NaoHaMaisLinhasException{
		textoAtual = textoAtual + sistema.getNovaLinha() + "\n";
		return "";
	}
	
	public String verificaTextos(){
		FacesContext context = FacesContext.getCurrentInstance();  
        if(getTextos().isEmpty())   {
        	context.addMessage(null, new FacesMessage("Você não tem textos adicionados."));   
        return "";
        }
        textoAtual = getTextos().get(0).toString();
		return "paginaSelecionarTexto.xhtml";		
	}
	
	public String adicionaTexto(){
		sistema.novoTexto(textoAtual);
		textoAtual = "";
		return "index.xhtml";
	}
	
	public String voltar(){
		textoAtual = "";
		return "index.xhtml";
	}
	
	public String preparaRecombinacao() throws RecombinadorInexistente{
		sistema.preparaRecombinador(recombinadorAtual, textoSelecionado);
		this.textoAtual = "";
		return "paginaRecombinarTexto.xhtml";
	}


	public Texto getTextoSelecionado() {
		return textoSelecionado;
	}


	public void setTextoSelecionado(Texto textoSelecionado) {
		this.textoSelecionado = textoSelecionado;
	}
	
	public boolean isTemMaisLinhas(){
		return sistema.haLinhas();
	}
}
