'use strict';

console.log('init cars');

angular.module('carApp').controller(
		'CarListCtrl',
		function($scope, $log, $route, $location, dataFactory, sharedProperties) {
			console.log('init CarCtrl');

			$scope.car = null;
			$scope.cars = [];

			// navigation
			$scope.reloadPage = function() {
				$route.reload();
			};

			$scope.createNewCar = function() {
				$location.path('/car-creation');
			};

			$scope.updateExistingCar = function($index) {
				sharedProperties.setIndex($index+1);
				$location.path('/car-detail');
			};
			
			$scope.listCars = function() {
				$location.path('/car-list');
			}

			$scope.showSelectedElement = function(c) {
				$scope.index = c.id;
			};

			// add car
			$scope.addCar = function() {
				var car = {
					model : $scope.car.model,
					brandId : $scope.car.brandId,
					priceId : $scope.car.priceId
				};
				$scope.cars.push(car);
				$scope.insertCar(car);
				$scope.listCars();
			}

			$scope.insertCar = function(data) {
				dataFactory.insertCar(data).success(function(data) {
					var len = $scope.cars.length;
					for (var i = 0; i < len; i++) {
						if ($scope.cars[i].id === undefined) {
							$scope.cars[i] = data;
							break;
						}
					}
				}).error(
						function(error) {
							$scope.status = 'Unable to create car data: '
									+ error.message;
						});
			}

			// edit car
			$scope.editCar = function(car) {
				var newCar = {
						id : sharedProperties.getIndex(),
						model : car.model,
						brandId : car.brandId,
						priceId : car.priceId
					};
				$scope.updateCar(newCar);
				$scope.listCars();
			}

			$scope.updateCar = function(data) {
				dataFactory.updateCar(data).success(function(data) {
					var len = $scope.cars.length;
					for (var i = 0; i < len; i++) {
						if (data.id === $scope.cars[i].id) {
							$scope.cars[i] = data;
							break;
						}
					}

				}).error(
						function(error) {
							$scope.status = 'Unable to update car data: '
									+ error.message;
						});
			}

			// delete car
			$scope.deleteCar = function(id, index) {
				if (id === undefined) {
					$scope.cars.splice(index, 1);
					return;
				}
				dataFactory.deleteCar(id).success(function(data) {
					$scope.cars.splice(index, 1);
					console.log("Delete", data, '@', index);
				}).error(
						function(error) {
							$scope.status = 'Unable to delete car data: '
									+ error.message;
						});
			}

			// list cars
			$scope.getCars = function() {
				dataFactory.getCars().success(function(data) {
					$scope.cars = data;
					console.log(data)
				}).error(
						function(error) {
							$scope.status = 'Unable to load car data: '
									+ error.message;
						});
			}
			$scope.getCars();
		});
