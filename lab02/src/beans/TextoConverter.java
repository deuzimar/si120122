package beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.selectonelistbox.SelectOneListbox;

import sistema.Sistema;
import sistema.Texto;

@FacesConverter(value = "textoConverter" , forClass = Texto.class)
public class TextoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return Sistema.getInstance().achaTexto(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Texto) arg2).getIntroducaoDoTexto();
	}

}
