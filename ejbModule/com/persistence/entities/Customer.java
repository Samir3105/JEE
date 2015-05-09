package com.persistence.entities;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.persistence.enums.Gender;
import com.persistence.enums.Relationship;

/*
 * OPTIMISTISCHE - PESSIMISTISCHE SPERRUNG >> man muss sich für eine Art des LOCKING's entscheiden
 * JPA ist kein O/R-Mapping Framework, lediglich die Schicht darüber
 * Bean bildet Datenbankzugriffe ab
 * EntityManager für CRUD
 * 
 * 4.06 >> benannte abfragen
 */

@Entity // Kennzeichnet eine Klasse als Entität
@NamedQuery(name="GetAll", query="SELECT c FROM Customer c") 
public class Customer
{
	public static final String QUERY_GETALL = "Customer.GetAll";
	@Id //definiert Attribut als Primärschlüssel
	@GeneratedValue(strategy=GenerationType.AUTO) // id wird generiert
	private int id;
	
	@NotNull // aus validation.constraints package
	@Size(min=1, max=50)
	private String firstName;
	
	@NotNull 
	@Size(min=1, max=50)
	private String lastName;
	private Gender gender;
	private Relationship relationship;
	private Date birthday;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true) // cascade >> wird Adresse hinzugefügt soll automatisch gespeichert werden
	private List<Address> addresses;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true) // orphanRemoval=true >> wird Hauptdatensatz gelösche wird auch der untergeordnete Datensatz gelöscht
	private List<Communication> communications;
	
	// optimistic locking >>  soll bei update oder delete herangezogen werden >> kann auf datenbankebene umgangen werden
	@Version
	private  Timestamp lastChanged;
	
	
	public List<Address> getAddresses()
	{
		return addresses;
	}
	public void setAddresses(List<Address> addresses)
	{
		this.addresses = addresses;
	}
	public List<Communication> getCommunications()
	{
		return communications;
	}
	public void setCommunications(List<Communication> communications)
	{
		this.communications = communications;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public Gender getGender()
	{
		return gender;
	}
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}
	public Relationship getRelationship()
	{
		return relationship;
	}
	public void setRelationship(Relationship relationship)
	{
		this.relationship = relationship;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	
	

}
