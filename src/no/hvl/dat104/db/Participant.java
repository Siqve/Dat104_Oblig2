package no.hvl.dat104.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "Dat104_Obl2_Gr12", name = "participant")
public class Participant implements Comparable<Participant> {

	@Id
	private String phonenumber;

	@Column
	private String firstname;

	@Column
	private String surname;

	@Column
	private String sex;

	@Column
	private boolean paid;

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public int compareTo(Participant part) {
		String surnameThis = surname;
		String firstnameThis = firstname;
		String surnameOther = part.getSurname();
		String firstnameOther = part.getSurname();

		int surnameCompared = surnameThis.compareTo(surnameOther);
		int firstnameCompared = firstnameThis.compareTo(firstnameOther);

		if (surnameCompared == 0) {
			if (firstnameCompared == 0) {
				return 0;
			} else if (firstnameCompared > 0) {
				return 1;
			} else {
				return -1;
			}
		} else if (surnameCompared > 1) {
			return 1;
		} else {
			return -1;
		}
	}

}
