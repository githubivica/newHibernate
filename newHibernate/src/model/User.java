package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;

public class User {

	private int idUser;
	private String ime;
	private String prezime;
	
	
	@ElementCollection
	private List<Adresa> listaAdresa = new ArrayList<Adresa>();
	
	  
}
