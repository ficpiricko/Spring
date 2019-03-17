package bas.stanica;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bas.stanica.model.Linija;
import bas.stanica.model.Prevoznik;
import bas.stanica.service.LinijaService;
import bas.stanica.service.PrevoznikService;

@Component
public class TestData {

	@Autowired
	private PrevoznikService prevoznikService;
	
	@Autowired
	private LinijaService linijaService;
	@PostConstruct
	public void init() {
		Prevoznik p = new Prevoznik ();
		p.setNaziv("Autoprevoz Cacak");
		p.setAdresa("32000 Cacak");
		p.setPIB("32000");
		
		prevoznikService.save(p);
		
		Linija l = new Linija ();
		l.setBrojMesta(2);
		l.setCenaKarte(1000.00);
		l.setDestinacija("Beograd");
		l.setPrevoznik(p);
		l.setVremePolaska("20:20");
		
		Linija l1 = new Linija ();
		l1.setBrojMesta(10);
		l1.setCenaKarte(1000.00);
		l1.setDestinacija("Beograd");
		l1.setPrevoznik(p);
		l1.setVremePolaska("20:20");
		
		Linija l2 = new Linija ();
		l2.setBrojMesta(20);
		l2.setCenaKarte(200.00);
		l2.setDestinacija("Kragujevac");
		l2.setPrevoznik(p);
		l2.setVremePolaska("10:00");
		
		Linija l3 = new Linija ();
		l3.setBrojMesta(30);
		l3.setCenaKarte(650.00);
		l3.setDestinacija("Beograd");
		l3.setPrevoznik(p);
		l3.setVremePolaska("12:30");
		
		Linija l4 = new Linija ();
		
		l4.setBrojMesta(11);
		l4.setCenaKarte(980.00);
		l4.setDestinacija("Novi Sad");
		l4.setPrevoznik(p);
		l4.setVremePolaska("20:00");
		
		linijaService.save(l);
		linijaService.save(l1);
		linijaService.save(l3);
		linijaService.save(l2);
		linijaService.save(l4);
		
		
		
		
	}
}
