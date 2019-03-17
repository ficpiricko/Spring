package bas.stanica.web.controller;



import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bas.stanica.model.Prevoznik;
import bas.stanica.service.PrevoznikService;
import bas.stanica.support.PrevoznikDTOToPrevoznik;
import bas.stanica.support.PrevoznikToPrevoznikDTO;
import bas.stanica.web.dto.PrevoznikDTO;

@RestController
@RequestMapping(value="/api/prevoznici")
public class ApiPrevoznikController {
	
	@Autowired
	private PrevoznikToPrevoznikDTO toDTO;
	
	@Autowired
	private PrevoznikDTOToPrevoznik toPrevoznik;
	
	@Autowired
	private PrevoznikService prevoznikService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<PrevoznikDTO>> getAll(
			@RequestParam(value="pageNum", defaultValue="0") int pageNum){
		
		List<Prevoznik> prevozniciList = null;
		
		prevozniciList = prevoznikService.findAll();

	
		return new ResponseEntity<>(
				toDTO.convert(prevozniciList),
				HttpStatus.OK);
	}
		
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<PrevoznikDTO> add(
			@Validated @RequestBody PrevoznikDTO prevoznikDTO){
		
		Prevoznik savedPrevoznik = prevoznikService.save(
				toPrevoznik.convert(prevoznikDTO));
		
		return new ResponseEntity<>(
				toDTO.convert(savedPrevoznik), 
				HttpStatus.CREATED);
	}
	
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
