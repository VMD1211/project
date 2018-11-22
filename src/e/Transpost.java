package e;

import java.sql.Time;

public class Transpost {
	private int id;
	private String name;
	private String bienso;
	private String loai;
	private Time timein, timeout;

	public Transpost() {

	}

	public Transpost(int id, String name, String bienso, String loai, Time timein) {
		super();
		this.id = id;
		this.name = name;
		this.bienso = bienso;
		this.loai = loai;
		this.timein = timein;
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
