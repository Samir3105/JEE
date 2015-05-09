package com.persistence.entities;
import java.sql.Timestamp;

import javax.persistence.Entity; 
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.persistence.enums.Kind;

@Entity
public class Address
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(max=100)
	private String street;
	
	@NotNull
	@Size(max=100)
	private String city;
	
	@NotNull
	@Size(max=10)
	private String zip;
	
	@NotNull
	@Size(max=50)
	private String country;
	
	@Enumerated(EnumType.STRING)
	private Kind kind;
	
	@Version
	private  Timestamp lastChanged;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public Kind getKind()
	{
		return kind;
	}

	public void setKind(Kind kind)
	{
		this.kind = kind;
	}
	
	
}
