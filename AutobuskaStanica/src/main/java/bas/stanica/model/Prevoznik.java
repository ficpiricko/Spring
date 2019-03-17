package bas.stanica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Prevoznik {
	@GeneratedValue
	@Id
	@Column
	private Long id;
	@Column(unique=true)
	private String naziv;
	@Column
	private String adresa;
	@Column(unique=true)
	private String PIB;
	@OneToMany(mappedBy="prevoznik",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Linija> linije = new ArrayList<Linija>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getPIB() {
		return PIB;
	}
	public void setPIB(String pIB) {
		PIB = pIB;
	}
	public List<Linija> getLinije() {
		return linije;
	}
	public void setLinije(List<Linija> linije) {
		this.linije = linije;
	}
	
	
	public void addLinija(Linija linija) {
		if(linija.getPrevoznik() != this) {
			linija.setPrevoznik(this);
		}
		linije.add(linija);
	}
}
