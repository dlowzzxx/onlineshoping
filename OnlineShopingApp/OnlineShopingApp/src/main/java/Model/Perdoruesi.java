package Model;

public class Perdoruesi {
	private int id;
	private String emri;
	private String mbiemri;
	private String adresa;
	private String email;
	private String nrTelefonit;
	private String emriPerdoruesit;
	private String fjalekalimi;
	private String roli;
	
	public Perdoruesi() {}
	
	public Perdoruesi(int id, String emri, String mbiemri, String adresa, String email, String nrT, String emriP, String fjalekalimi)
	{
		this.id = id;
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.adresa = adresa;
		this.email = email;
		nrTelefonit = nrT;
		emriPerdoruesit = emriP;
		this.fjalekalimi = fjalekalimi;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmri() {
		return emri;
	}
	public void setEmri(String emri) {
		this.emri = emri;
	}
	public String getMbiemri() {
		return mbiemri;
	}
	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNrTelefonit() {
		return nrTelefonit;
	}
	public void setNrTelefonit(String nrTelefonit) {
		this.nrTelefonit = nrTelefonit;
	}
	public String getEmriPerdoruesit() {
		return emriPerdoruesit;
	}
	public void setEmriPerdoruesit(String emriPerdoruesit) {
		this.emriPerdoruesit = emriPerdoruesit;
	}
	public String getFjalekalimi() {
		return fjalekalimi;
	}
	public void setFjalekalimi(String fjalekalimi) {
		this.fjalekalimi = fjalekalimi;
	}
	public String getRoli() {
		return roli;
	}
	public void setRoli(String roli) {
		this.roli = roli;
	}

}
