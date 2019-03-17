package bas.stanica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bas.stanica.model.Prevoznik;
import bas.stanica.service.PrevoznikService;
import bas.stanica.web.dto.PrevoznikDTO;

@Component
public class PrevoznikDTOToPrevoznik implements Converter<PrevoznikDTO, Prevoznik> {
	@Autowired
	private PrevoznikService prevoznikService;
	@Override
	public Prevoznik convert(PrevoznikDTO source) {

		Prevoznik prevoznik = null;
		
		if(source.getId() != null) {
			prevoznik = prevoznikService.findOne(source.getId());
		}
		else {
			prevoznik = new Prevoznik();
		}
		
		prevoznik.setNaziv(source.getNaziv());
		prevoznik.setAdresa(source.getAdresa());
		prevoznik.setPIB(source.getPib());

		
		return prevoznik;
	}
	public List<Prevoznik> convert(List<PrevoznikDTO> prevoznikDTOs){
		List<Prevoznik> ret = new ArrayList<>();
		
		for(PrevoznikDTO prevoznikDTO : prevoznikDTOs){
			ret.add(convert(prevoznikDTO));
		}
		
		return ret;
	}
}


