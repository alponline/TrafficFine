'use strict';

trafficFinneApp.factory('TrafficFineService',['$http','$q',function($http, $q){
	return{
		listAllTrafficFine: function(dataInicial, dataFinal){
			return $http.get('http://localhost:8080/TrafficFine/api/infracao/busca/'+dataInicial+dataFinal)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while fetching Infraction');
								return $q.reject(errResponse);
							}

						);
		},
		createInfraction: function(Infraction){
			return $http.post('http://localhost:8080/TrafficFine/api/infracao/', Infraction)
					.then(
							function(response){
								return response.data;
							},
							function(errResponse){
								console.error('Error while creating Infraction');
								return $q.reject(errResponse);
							}

						);
		}
	};
}])