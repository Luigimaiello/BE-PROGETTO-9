package esercizio.enetity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="film")
public class Film {

	//define fields
	@Id
	@Column(name="titolo")
	private String titolo;
	@Column(name="anno")
	private String anno;
	@Column(name="regista")
	private String regista;
	@Column(name="tipo")
	private String tipo;
	@Column(name="incasso")
	private double incasso;
	
	//define constructors
	public Film() {
		
	}
	
}
