'use strict';

trafficFinneApp.controller('TrafficFineController', ['$scope','TrafficFineService', function($scope, TrafficFineService){
		var self = this;
		
		self.Infraction = {
			id: null,
			placa: '',
			data_hora: null,
			local: '',
			dataInicial: null,
			dataFinal: null
		};

		self.listAllTrafficFine = function(dataInicial,dataFinal){
			TrafficFineService.listAllTrafficFine(dataInicial,dataFinal)
				.then(function(errResponse){
					console.error('Error');
				});
		};

		self.listAllTrafficFine = function(Infraction){
			TrafficFineService.createInfraction(Infraction)
				.then(function(errResponse){
					console.error('Error');
				});
		};

}]);
