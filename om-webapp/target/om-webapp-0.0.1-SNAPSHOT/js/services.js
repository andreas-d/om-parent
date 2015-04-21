'use strict';

/* Services */

var services = angular.module('carServices', ['ngResource']);

services.factory('CarsFactory', function ($resource) {
    return $resource('http://localhost:8080/OrderManagementBackend/cars', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    });
});

services.factory('CarFactory', function ($resource) {
    return $resource('http://localhost:8080/OrderManagementBackend/cars/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    });
});


//var carServices = angular.module('carServices', ['ngResource']);
//
//carServices.factory(
//        'Cars', ['$resource',
//            function ($resource) {
//                return $resource('http://localhost:8080/OrderManagementBackend/service/getAllCars', {}, {
//                    query: {method: 'GET', isArray: true}
//                });
//            }],
//        'SaveCar', ['$resource',
//            function ($resource) {
//                return $resource('http://localhost:8080/OrderManagementBackend/service//saveCar/:model/:brand_id/:price_id');
//            }],
//        'Brands', ['$resource',
//            function ($resource) {
//                return $resource('http://localhost:8080/OrderManagementBackend/service/getAllBrands', {}, {
//                    query: {method: 'GET', isArray: true}
//                });
//            }]);
