package model;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {

	private String banujOperatera;

	public String getBanujOperatera() {
		return banujOperatera;
	}

	public void setBanujOperatera(String banujOperatera) {
		this.banujOperatera = banujOperatera;
	}
	
	
}
