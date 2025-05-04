package Model;

public class ShportaBlerjes {
	private int id;
	private int idProduktit;
	private String emriPerdoruesit;
	
	public ShportaBlerjes() {}
	
	public ShportaBlerjes(int id, int idP, String eP)
	{
		this.id = id;
		idProduktit = idP;
		emriPerdoruesit = eP;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProduktit() {
		return idProduktit;
	}
	public void setIdProduktit(int idProduktit) {
		this.idProduktit = idProduktit;
	}
	public String getEmriPerdoruesit() {
		return emriPerdoruesit;
	}
	public void setEmriPerdoruesit(String emriPerdoruesit) {
		this.emriPerdoruesit = emriPerdoruesit;
	}
	
	
}
