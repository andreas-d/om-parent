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
		
        dataFactory.getPrices = function (id) {
            return $http.get(urlBase + '/price/allpricesforcar/'+id);
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
        
        dataFactory.getBrands = function (id) {
            return $http.get(urlBase + '/brand/allbrandsforcar/'+id);
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
//		$scope.reloadPage = function () {
//            $route.reload();
//        };
//
//        // callback for ng-click 'editCar':
//        $scope.editCar = function (carId) {
//            $location.path('/car-detail/' + carId);
//        };
//
//        // callback for ng-click 'deleteCar':
//        $scope.deleteCar = function (carId) {
//            CarFactory.delete({id: carId});
//            $scope.cars = CarsFactory.query();
//        };
//
//        // callback for ng-click 'createCar':
//        $scope.createNewCar = function () {
//            $location.path('/car-creation');
//        };
//
//        $scope.cars = CarsFactory.query();
    }]);

//app.controller('CarDetailController', ['$scope', '$routeParams', 'CarFactory', '$location',
//    function ($scope, $routeParams, CarFactory, $location) {
//
//        $scope.car = CarFactory.show({id: $routeParams.id});
//
//        // callback for ng-click 'updateCar':
//        $scope.updateCar = function () {
//            CarFactory.update($scope.car.car);
//            $location.path('/car-list');
//        };
//
//        // callback for ng-click 'cancel':
//        $scope.cancel = function () {
//            $location.path('/car-list');
//        };
//
//
//    }]);
//
//app.controller('CarCreationController', ['$scope', 'CarsFactory', '$location',
//    function ($scope, CarsFactory, $location) {
//
//        $scope.car = null;
//
//        // callback for ng-click 'createCar':
//        $scope.createCar = function () {
//// CarsFactory.create($scope.car);
//        var newCar = CarsFactory.create($scope.car);
//
//
//        newCar.$save();
//            $location.path('/car-list');
//        };
//    }]);
// var carControllers = angular.module('carControllers', []);
//
// carControllers.controller('CarListController',
// function ($scope, $route, $http, Cars) {
// $scope.reloadPage = function () {
// $route.reload();
// };
//
// $scope.selectedModel = null;
// $scope.selectedBrand = null;
// $scope.brands = [];
// $scope.selectedPrice = null;
// $scope.prices = [];
//
// $http({
// method: 'GET',
// url: 'http://localhost:8080/OrderManagementBackend/service/getAllBrands',
// data: {applicationId: 1}
// }).success(function (result) {
// $scope.brands = result;
// });
//
// $http({
// method: 'GET',
// url: 'http://localhost:8080/OrderManagementBackend/service/getAllPrices',
// data: {applicationId: 1}
// }).success(function (result) {
// $scope.prices = result;
// });
//
// $scope.disableButton = true;
// $scope.allcars = Cars.query();
// $scope.showSelectedElement = function (c) {
// $scope.disableButton = false;
// $scope.selected = c;
// document.getElementById("btnEdit").disabled = "";
// document.getElementById("btnDelete").disabled = "";
// };
//            
// $scope.cancel = function() {
// $scope.selectedModel = null;
// $scope.selectedBrand = null;
// $scope.selectedPrice = null;
// };
//            
// $scope.saveCar = function() {
//                
// };
// });
//        
// carControllers.controller('Ctrl2',
// function ($scope, Cars) {
// $scope.allcars = Cars.query();
// $scope.showSelectedElement = function (c) {
// $scope.selected = c;
// };
// });
//        
// carControllers.controller('Ctrl3',
// function ($scope, Cars) {
// $scope.allcars = Cars.query();
// $scope.showSelectedElement = function (c) {
// $scope.selected = c;
// };
// });
