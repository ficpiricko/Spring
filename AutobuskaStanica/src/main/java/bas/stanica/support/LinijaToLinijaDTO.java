package bas.stanica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bas.stanica.model.Linija;
import bas.stanica.web.dto.LinijaDTO;

@Component
public class LinijaToLinijaDTO implements Converter<Linija, LinijaDTO> {

	@Override
	public LinijaDTO convert(Linija source) {
	LinijaDTO dto = new LinijaDTO();
		
		dto.setId(source.getId());
		dto.setVremePolaska(source.getVremePolaska());
		dto.setDestinacija(source.getDestinacija());
		dto.setPrevoznikId(source.getPrevoznik().getId());
		dto.setPrevoznikNaziv(source.getPrevoznik().getNaziv());
		dto.setBrojMesta(source.getBrojMesta());
		dto.setCenaKarte(source.getCenaKarte());
		
		
		return dto;
	}
	public List<LinijaDTO> convert(List<Linija> linije){
		List<LinijaDTO> linijeLista = new ArrayList<>();
		
		for(Linija linija: linije){
			linijeLista.add(convert(linija));
		}
		
		return linijeLista;
	}

}
