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
	private List<Area> list;

	public AreaB() {
		da = new AreaDA();
	}

	public int getQuantityCar() throws SQLException {
		int x = da.setQuantityCar();
		return x;
	}

	public int getQuantityMotor() throws SQLException {
		int x = da.setQuantityMotor();
		return x;
	}

	public int getQuantityBike() throws SQLException {
		int x = da.setQuantityBike();
		return x;
	}
	public Area deleteQuanCar(Area area) throws SQLException {
		da.deleteQuan("Car");
		area.setQuantityCar(area.getQuantityCar()-1);
		return area;
	}

}
