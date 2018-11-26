package e;

import java.sql.Time;

public class Transpost {
	private int id;
	private String name;
	private String bienso;
	private String loai;
	private Time timein, timeout;
	private int total;

	public Transpost() {

	}

	public Transpost(int id, String name, String bienso, String loai, Time timein, Time timeout, int total) {
		super();
		this.id = id;
		this.name = name;
		this.bienso = bienso;
		this.loai = loai;
		this.timein = timein;
		this.timeout = timeout;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBienso() {
		return bienso;
	}

	public void setBienso(String bienso) {
		this.bienso = bienso;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Time getTimeIn() {
		return timein;
	}

	public void setTimeIn(Time time) {
		this.timein = time;
	}

	public Time getTimeOut() {
		return timeout;
	}

	public void setTimeOut(Time time) {
		this.timeout = time;
	}

}
