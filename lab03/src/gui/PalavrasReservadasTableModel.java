package gui;

import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class PalavrasReservadasTableModel extends AbstractTableModel {
	private Map<String, Integer> contagem;

	public PalavrasReservadasTableModel(Map<String, Integer> contagem) {
		this.contagem = contagem;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		switch (arg0) {
		case 0:
			return String.class;
		case 1:
			return Integer.class;
		default:
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int arg0) {
		switch (arg0) {
		case 0:
			return "Palavra";
		case 1:
			return "Aparições";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return contagem.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		 Object[] entries=contagem.entrySet().toArray();
	      Entry entry=(Map.Entry)entries[arg0];
	      if(arg1==0){
	    	  return entry.getKey();
	      }
		return entry.getValue();
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
	}

}
