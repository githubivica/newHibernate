package model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresa {

	private String zemlja;
	private String grad;
	private String ulica;
	
	public String getZemlja() {
		return zemlja;
	}
	public void setZemlja(String zemlja) {
		this.zemlja = zemlja;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	
	
	
}
