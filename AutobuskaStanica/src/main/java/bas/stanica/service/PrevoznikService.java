package bas.stanica.service;

import java.util.List;

import bas.stanica.model.Prevoznik;



public interface PrevoznikService {
	Prevoznik findOne(Long id);
	List<Prevoznik> findAll();
	Prevoznik save(Prevoznik prevoznik);
	Prevoznik delete(Long id);
}
