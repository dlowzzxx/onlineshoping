package Model;

public class Produkti {
	private int id;
	private String emri;
	private String kodi;
	private String detajet;
	private int cmimi;
	private int sasia;
	private String foto;

	public Produkti() {}

	public Produkti(int id, String emri, String kodi, String detajet, int cmimi, int sasia, String f) {
		this.id = id;
		this.emri = emri;
		this.kodi = kodi;
		this.detajet = detajet;
		this.cmimi = cmimi;
		this.sasia = sasia;
		foto = f;//this.foto=foto;String foto
	}

	public Produkti(int id, String emri, String kodi, String detajet, int cmimi, int sasia) {
		this.emri = emri;
		this.kodi = kodi;
		this.detajet = detajet;
		this.cmimi = cmimi;
		this.sasia = sasia;
		this.id = id;
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

	public String getKodi() {
		return kodi;
	}

	public void setKodi(String k) {
		kodi = k;
	}

	public String getDetajet() {
		return detajet;
	}

	public void setDetajet(String d) {
		detajet = d;
	}

	public int getCmimi() {
		return cmimi;
	}

	public void setCmimi(int c) {
		cmimi = c;
	}

	public int getSasia() {
		return sasia;
	}

	public void setSasia(int sasia) {
		this.sasia = sasia;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String f) {
		foto = f;
	}
}
