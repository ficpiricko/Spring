package bas.stanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bas.stanica.model.Rezervacija;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

}
