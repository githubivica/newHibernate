package model;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bussinesService.CrudMetode;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		/*CrudMetode cm = new CrudMetode(); //4
		
		System.out.print("Unesi marku: ");
		String marka = scanner.nextLine();
		
		System.out.print("\nUnesi zemlju: ");
		String zemlja = scanner.nextLine();
		
		cm.ubaciMarku(marka, zemlja);*/
		
		/*System.out.print("Unesite id marke: ");
		int idMarke = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Unesite zemlju: ");
		String zemlja = scanner.nextLine();
		
		cm.azurirajZemlju(idMarke, zemlja);*/
		
		/*System.out.print("Unesite id marke: ");
		int idMarke = Integer.parseInt(scanner.nextLine());
		cm.obrisiMarku(idMarke);*/
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
			User user = new User();
			
			
			Session sesija = sf.openSession();
			sesija.beginTransaction(); //pocinje transakciju
			try {
				
				sesija.getTransaction().commit();	//komituje ako uspe
				System.out.println("Uspesno ubaceno");
			} catch (Exception e){
				sesija.getTransaction().rollback();	//rollback ako ne uspe
				System.out.println("Neuspesno ubaceno");
			}
			finally {
				sesija.close();
			}
			
			
		scanner.close();	
		}
		
	

}
