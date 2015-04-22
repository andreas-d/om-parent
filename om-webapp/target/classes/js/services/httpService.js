'use strict';

/* Controllers */

var app = angular.module('carApp').factory('dataFactory', ['$http', function($http) {
		console.log("init dataFactory");
		var urlBase = 'rest';
		
		var dataFactory = {};
		
		dataFactory.getCars = function () {
            return $http.get(urlBase + '/car/all');
        };

        dataFactory.getCar = function (id) {
            return $http.get(urlBase + '/car/' + id);
        };

        dataFactory.insertCar = function (id) {
            return $http.post(urlBase + '/car/create', id);
        };

        dataFactory.updateCar = function (id) {
            return $http.post(urlBase + '/car/update', id)
        };

        dataFactory.deleteCar = function (id) {
            return $http.delete(urlBase + '/car/delete/' + id);
        };
		
        dataFactory.getPrices = function () {
            return $http.get(urlBase + '/price/all');
        };

        dataFactory.getPrice = function (id) {
            return $http.get(urlBase + '/price/' + id);
        };
        
        dataFactory.insertPrice = function (id) {
            return $http.post(urlBase + '/price/create', id);
        };

        dataFactory.updatePrice = function (id) {
            return $http.post(urlBase + '/price/update', id)
        };

        dataFactory.deletePrice = function (id) {
            return $http.delete(urlBase + '/price/delete/' + id);
        };
        
        dataFactory.getBrands = function () {
            return $http.get(urlBase + '/brand/all');
        };
        
        dataFactory.getBrand = function (id) {
        	return $http.get(urlBase + '/brand/' + id);
        };
        
        dataFactory.insertBrand = function (id) {
            return $http.post(urlBase + '/brand/create', id);
        };

        dataFactory.updateBrand = function (id) {
            return $http.post(urlBase + '/brand/update', id)
        };

        dataFactory.deleteBrand = function (id) {
            return $http.delete(urlBase + '/brand/delete/' + id);
        };
        
        return dataFactory;
    }]);

app.service('sharedProperties', function () {
    var index = 0;

    return {
        getIndex: function () {
            return index;
        },
        setIndex: function(value) {
        	index = value;
        }
    };
});