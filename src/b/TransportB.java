package b;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import da.TransportDA;
import e.Transpost;

public class TransportB {
private TransportDA da;
private DefaultTableModel model;
private List<Transpost> list;

	
	public TransportB() {
		// TODO Auto-generated constructor stub
		da = new TransportDA();
	}
	public DefaultTableModel model() {
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Bien So");
		model.addColumn("Loai");
		
		return model;
	}
	
	public DefaultTableModel getAllTrans() throws SQLException{
		list = da.getAll();
		model();
		
		for (Transpost transport: list) {
			String[] cells = new String[4];
			cells[0] = String.valueOf(transport.getId());
			cells[1] = transport.getName();
			cells[2] = transport.getBienso();
			cells[3] = transport.getLoai();
			model.addRow(cells);
		}
		
		return model;
	}
	public Transpost addTrans(Transpost transpost) throws SQLException {
		da.insertTrans(transpost.getId(), transpost.getName(), transpost.getBienso(), transpost.getLoai());
		return transpost;
	}
	
	

}
