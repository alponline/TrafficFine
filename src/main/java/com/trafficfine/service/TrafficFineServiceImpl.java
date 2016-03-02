package com.trafficfine.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trafficfine.entity.Infraction;

@Service("TrafficFineService")
@Transactional
public class TrafficFineServiceImpl implements TrafficFineService {

	private static List<Infraction> infractions;

	static {
		infractions = populateInfractions();
	}

	public List<Infraction> findByRange(Date initialDate, Date finalDate) {
		List<Infraction> listInfractions = new ArrayList<Infraction>();
		for (Infraction infraction : infractions) {
			if (infraction.getData_hora().after(initialDate)
					&& infraction.getData_hora().before(finalDate)) {
				listInfractions.add(infraction);
			}
		}
		return listInfractions;
	}

	public void saveInfraction(Infraction infraction) {
		infractions.add(infraction);
	}

	public boolean isInfractionExist(Infraction infraction) {
		return findByInfraction(infraction.getPlaca()) != null;
	}

	private static List<Infraction> populateInfractions() {
		List<Infraction> infractions = new ArrayList<Infraction>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");

		Date date1, date2, date3;
		try {

			date1 = formato.parse("01/02/16");
			date2 = formato.parse("20/02/16");
			date3 = formato.parse("02/03/16");

			infractions.add(new Infraction(1, "AAA - 1111", date1,
					"R. A, 01 - SP"));
			infractions.add(new Infraction(2, "BBB - 2222", date2,
					"R. B, 02 - SP"));
			infractions.add(new Infraction(3, "CCC - 3333", date3,
					"R. C, 03 - SP"));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return infractions;
	}

	public Infraction findByInfraction(String placa) {
		for (Infraction infraction : infractions) {
			if (infraction.getPlaca().equalsIgnoreCase(placa)) {
				return infraction;
			}
		}
		return null;
	}

}
