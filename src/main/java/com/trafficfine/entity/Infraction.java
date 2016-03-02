package com.trafficfine.entity;

import java.io.Serializable;
import java.util.Date;

public class Infraction implements Serializable {

	private static final long serialVersionUID = -7937782423837596995L;
	private long id;
	private String placa;
	private Date data_hora;
	private String local;
	
	public Infraction(long id, String placa, Date data_hora, String local) {
		this.id = id;
		this.placa = placa;
		this.data_hora = data_hora;
		this.local = local;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getData_hora() {
		return data_hora;
	}
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((data_hora == null) ? 0 : data_hora.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) 
			return false;
		if (!(obj instanceof Infraction)) 
			return false;
		Infraction other = (Infraction) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Infraction [id=" + id + ", placa=" + placa + ", data_hora="
				+ data_hora + ", local=" + local + "]";
	}
}
