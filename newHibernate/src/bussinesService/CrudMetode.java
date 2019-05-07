package bussinesService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Marka;

public class CrudMetode {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public void ubaciMarku(String nazivMarke, String zemlja) {
		
		Marka marka = new Marka();
		marka.setNazivMarke(nazivMarke);
		//marka.setZemlja(zemlja); ovo je bilo bez klase Adresa
		
		Session sesija = sf.openSession();
		sesija.beginTransaction(); //pocinje transakciju
		try {
			sesija.save(marka);	//ovde snima fiat i marka

			sesija.getTransaction().commit();	//komituje ako uspe
			System.out.println("Uspesno ubaceno");
		} catch (Exception e){
			sesija.getTransaction().rollback();	//rollback ako ne uspe
			System.out.println("Neuspesno ubaceno");
		}
		finally {
			sesija.close();
		}
		
	}
	
	public Marka vratiMarku(int id) {
		
		Session sesija = sf.openSession();
		Marka marka = null;
		sesija.beginTransaction();
		
		try {
			marka = sesija.get(Marka.class, id);
			sesija.getTransaction().commit();
			return marka;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		}
		finally {
			sesija.close();
		}
	}

	public boolean azurirajZemlju(int idMarke, String zemlja) {
		Marka marka = vratiMarku(idMarke);//metoda koja vraca marku mora da se poziva kao prva linija koda
		//jer u toj metodi se na kraju sesija zatvara, i ako je ne pozovemo kao prvu liniju koda, onda ce se
		//zatvoriti i izaci iz metode bez da odradi ostali deo. Iako se sesija zatvara, mi je otvaramo
		//u novom redu "Session sesija = sf.openSession();"
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		
		try {

			if(marka != null) {
				//marka.setZemlja(zemlja);
				sesija.update(marka);//update
				sesija.getTransaction().commit();//mora da se ubaci u if-u jer ako udje u if - izvrsava ga i ne cita dalje
				System.out.println("Update uspeo.");
				return true;
			}
			else {
				sesija.getTransaction().commit();
				System.out.println("Nije uspeo update.");
				return false;
			}

		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;//posto je u try-u ubacen return(ili u if-u ili u else-u), mora i u catch-u da se ubaci return
		}
		finally {
			sesija.close();
		}
	}
	
	
	public boolean obrisiMarku(int idMarke) {
		Marka marka = vratiMarku(idMarke);//metoda koja vraca marku mora da se poziva kao prva linija koda
		
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		
		try {

			if(marka != null) {
				sesija.delete(marka);//delete
				sesija.getTransaction().commit();//mora da se ubaci u if-u jer ako udje u if - izvrsava ga i ne cita dalje
				System.out.println("Delete uspeo.");
				return true;
			}
			else {
				sesija.getTransaction().commit();
				System.out.println("Nije uspeo delete.");
				return false;
			}

		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;//posto je u try-u ubacen return(ili u if-u ili u else-u), mora i u catch-u da se ubaci return
		}
		finally {
			sesija.close();
		}
	}
	
	
	
}
