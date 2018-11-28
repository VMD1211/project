package b;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import da.AreaDA;
import e.Area;
import e.Transpost;

public class AreaB {
	private AreaDA da;
	

	public AreaB() {
		da = new AreaDA();
	}

	public int getQuantity(Area area) throws SQLException {
		int quantity = da.getQuantity(area.getArea());
		return quantity;
	}
	public Area deleteQuantity(Area area) throws SQLException {
		da.deleteQuan(area.getArea());
		return area;
	}
	public Area addQuantity(Area area) throws SQLException {
		da.addQuan(area.getArea());
		return area;
	}

}
