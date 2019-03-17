package bas.stanica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bas.stanica.model.Rezervacija;
import bas.stanica.web.dto.RezervacijaDTO;

@Component
public class RezervacijaToRezervacijaDTO implements Converter<Rezervacija, RezervacijaDTO>{

	@Override
	public RezervacijaDTO convert(Rezervacija source) {
RezervacijaDTO dto = new RezervacijaDTO();
		
		dto.setId(source.getId());
		
		return dto;
	}
	
	public List<RezervacijaDTO> convert(List<Rezervacija> rezervacije){
		List<RezervacijaDTO> lista = new ArrayList<>();
		
		for(Rezervacija rezervacija: rezervacije){
			lista.add(convert(rezervacija));
		}
		
		return lista;
	}

}
