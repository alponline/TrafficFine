package com.trafficfine.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.trafficfine.entity.Infraction;
import com.trafficfine.service.TrafficFineService;

@Controller
public class TrafficFineController {

	static final Logger logger = Logger.getLogger(TrafficFineController.class);
	
	@Autowired
	TrafficFineService trafficFineService;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	  public String form() {
	    return "index";
	  }
	
	/**
	 * 
	 * @param initialDate
	 * @param finalDate
	 * @return
	 */
	@RequestMapping(value = "/api/infracao/busca", method = RequestMethod.GET)
	public ResponseEntity<List<Infraction>> listAllTrafficFine(
			@RequestParam(value = "dataInicial") @DateTimeFormat(pattern = "dd/MM/yy") Date dataInicial, 
			@RequestParam(value = "dataFinal") @DateTimeFormat(pattern = "dd/MM/yy") Date dataFinal) {
		List<Infraction> infractions = this.trafficFineService.findByRange(
				dataInicial, dataFinal);
		if (infractions.isEmpty()) {
			return new ResponseEntity<List<Infraction>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Infraction>>(infractions, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param infraction
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/api/infracao/", method = RequestMethod.POST)
	public ResponseEntity<Void> createInfraction(
			@RequestBody Infraction infraction, UriComponentsBuilder ucBuilder) {
		logger.info("Creating infraction: " + infraction.getPlaca());

		if (trafficFineService.isInfractionExist(infraction)) {
			logger.info("A infraction with license plate "
					+ infraction.getPlaca() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		trafficFineService.saveInfraction(infraction);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/")
				.buildAndExpand(infraction.getId()).toUri());
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
}
