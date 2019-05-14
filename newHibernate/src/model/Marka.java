package model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity		//uvek treba dodati u xml fajlu
@Table (name = "moja_tabela_marki")
public class Marka {

	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	
	@Column(name = "id_marke")
	private int idMarke;

	@Column(name = "naziv_marke")
	private String nazivMarke;
	
	@Embedded
	private Adresa adresa;	//posto je private mora geter i seter
	
	@ManyToOne
	private User user;
	
	
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public int getIdMarke() {
		return idMarke;
	}
	public void setIdMarke(int idMarke) {
		this.idMarke = idMarke;
	}
	public String getNazivMarke() {
		return nazivMarke;
	}
	public void setNazivMarke(String nazivMarke) {
		this.nazivMarke = nazivMarke;
	}
	
	
	
}
