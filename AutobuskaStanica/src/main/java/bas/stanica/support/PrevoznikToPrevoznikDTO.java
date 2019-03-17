package bas.stanica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bas.stanica.model.Prevoznik;
import bas.stanica.web.dto.PrevoznikDTO;

@Component
public class PrevoznikToPrevoznikDTO implements Converter<Prevoznik,PrevoznikDTO> {

	@Override
	public PrevoznikDTO convert(Prevoznik prevoznik) {

		PrevoznikDTO dto = new PrevoznikDTO();
		
		dto.setId(prevoznik.getId());
		dto.setNaziv(prevoznik.getNaziv());
		dto.setAdresa(prevoznik.getAdresa());
		dto.setPib(prevoznik.getPIB());
		
		return dto;
	}
	
	public List<PrevoznikDTO> convert(List<Prevoznik> prevoznici){
		List<PrevoznikDTO> dtoList = new ArrayList<>();
		
		for(Prevoznik prevoznik: prevoznici){
			dtoList.add(convert(prevoznik));
		}
		
		return dtoList;
	}


}
