'use strict';

console.log('init cars');
angular.module('carApp')
	.controller('CarListCtrl',function ($scope,$log,dataFactory) {
		console.log('init CarCtrl');
		
		$scope.cars = [];
		
        $scope.getCars = function() {
            dataFactory.getCars()
                .success(function (data) {
                    $scope.cars = data;
                	console.log(data)
                })
                .error(function (error) {
                    $scope.status = 'Unable to load car data: ' + error.message;
                });
        }
        
        $scope.getCars();
		
    });
