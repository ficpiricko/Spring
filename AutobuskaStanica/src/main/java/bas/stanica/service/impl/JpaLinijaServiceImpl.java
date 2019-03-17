package bas.stanica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import bas.stanica.model.Linija;
import bas.stanica.model.Rezervacija;
import bas.stanica.repository.LinijaRepository;
import bas.stanica.repository.RezervacijaRepository;
import bas.stanica.service.LinijaService;





@Service
public class JpaLinijaServiceImpl implements LinijaService{
	@Autowired
	private LinijaRepository linijaRepository;
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	@Override
	public Linija findOne(Long id) {
		// TODO Auto-generated method stub
		return linijaRepository.findOne(id);
	}

	@Override
	public Page<Linija> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return linijaRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Linija> search(String destinacija, Long prevoznikId,
			Double maksCena, int pageNum) {
		if(destinacija != null) {
			destinacija = '%' + destinacija + '%';
		}
		
		return linijaRepository.search(destinacija, prevoznikId, maksCena, new PageRequest(pageNum, 5));
	}

	@Override
	public Linija save(Linija linija) {
		// TODO Auto-generated method stub
		return linijaRepository.save(linija);
	}

	@Override
	public Linija delete(Long id) {
		Linija linija = linijaRepository.findOne(id);
		if(linija != null){
			linijaRepository.delete(linija);
		}
		
		return linija;
	}

	@Override
	public Rezervacija reserve(Long id) {
Linija l = findOne(id);
		
		if(l != null) {
			Rezervacija r = null;
			if(l.getBrojMesta() > 0) {
				r = new Rezervacija();
				r.setLinija(l);
				rezervacijaRepository.save(r);
				
				l.setBrojMesta(l.getBrojMesta() - 1);
				linijaRepository.save(l);
			}
			
			return r;
		}
		else {
			throw new IllegalArgumentException("Tried to reserve a ticket for non-existant line");
		}
	}	
	}
	
	

