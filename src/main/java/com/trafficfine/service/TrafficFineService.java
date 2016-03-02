package com.trafficfine.service;

import java.util.Date;
import java.util.List;

import com.trafficfine.entity.Infraction;

public interface TrafficFineService {
	
	List<Infraction> findByRange(Date initialDate, Date finalDate);
	
	void saveInfraction(Infraction infraction);
	
	Infraction findByInfraction(String placa);
	
	public boolean isInfractionExist(Infraction infraction);
	
}
