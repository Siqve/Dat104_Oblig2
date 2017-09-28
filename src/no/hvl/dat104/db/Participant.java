package no.hvl.dat104.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig2", name = "deltaker")
public class Participant {
	
	@Id
	public String phonenumber;
	
	@Column
	public String firstname;
	
	@Column
	public String surname;
	
	@Column
	public String sex;
	
	@Column
	public boolean paid;
}
