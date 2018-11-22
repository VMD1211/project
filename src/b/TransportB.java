package b;

import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.swing.table.DefaultTableModel;

import da.TransportDA;
import e.Transpost;;

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
		model.addColumn("TimeIn");
		return model;
	}

	public DefaultTableModel getAllTrans() throws SQLException {
		list = da.getAll();
		model();
		
		for (Transpost transport : list) {
			String[] cells = new String[5];
			cells[0] = String.valueOf(transport.getId());
			cells[1] = transport.getName();
			cells[2] = transport.getBienso();
			cells[3] = transport.getLoai();
			cells[4] = String.valueOf(transport.getTimeIn());
			model.addRow(cells);
		}

		return model;
	}

	public Transpost addTrans(Transpost transpost) throws SQLException {
		da.insertTrans(transpost.getId(), transpost.getName(), transpost.getBienso(), transpost.getLoai(),
				transpost.getTimeIn());
		return transpost;

	}

	public Transpost deleteTrans(Transpost transpost) throws SQLException {
		da.deleteTrans(transpost.getId());
		return transpost;
	}
	
	public Transpost setTimeOut(Transpost transpost) throws SQLException {
		da.setTimeOut(transpost.getTimeOut(), transpost.getId());
		return transpost;
	}
	
	public long tinh (long d1, long d2) {
		Long tongTime = (d2-d1)/(60*60*1000);
		return tongTime;
		
	}

}
