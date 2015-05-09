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

import com.persistence.enums.*;

@Entity
public class Communication
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(max=100)
	private String value;
	
	@NotNull
	@Size(max=50)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private CommunicationType communicationtype;
	
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

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public CommunicationType getCommunicationtype()
	{
		return communicationtype;
	}

	public void setCommunicationtype(CommunicationType communicationtype)
	{
		this.communicationtype = communicationtype;
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
