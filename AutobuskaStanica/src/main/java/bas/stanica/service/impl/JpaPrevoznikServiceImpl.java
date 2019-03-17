package bas.stanica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bas.stanica.model.Prevoznik;
import bas.stanica.repository.PrevoznikRepository;
import bas.stanica.service.PrevoznikService;

@Service
public class JpaPrevoznikServiceImpl implements PrevoznikService {
	@Autowired
	private PrevoznikRepository prevoznikRepository;
	@Override
	public Prevoznik findOne(Long id) {
		// TODO Auto-generated method stub
		return prevoznikRepository.findOne(id);
	}

	@Override
	public List<Prevoznik> findAll() {
		// TODO Auto-generated method stub
		return prevoznikRepository.findAll();
	}

	@Override
	public Prevoznik save(Prevoznik prevoznik) {
		// TODO Auto-generated method stub
		return prevoznikRepository.save(prevoznik);
	}

	@Override
	public Prevoznik delete(Long id) {
		Prevoznik prevoznik = prevoznikRepository.findOne(id);
		if(prevoznik != null){
			prevoznikRepository.delete(prevoznik);
		}
		
		return prevoznik;
	}

}
