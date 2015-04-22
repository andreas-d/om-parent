'use strict';

console.log('init prices');

angular.module('carApp').controller(
		'PriceListCtrl',
		function($scope, $log, $route, $location, dataFactory, sharedProperties) {
			console.log('init PriceCtrl');

			$scope.price = null;
			$scope.prices = [];

			// navigation
			$scope.reloadPage = function() {
				$route.reload();
			};

			$scope.createNewPrice= function() {
				$location.path('/price-creation');
			};

			$scope.updateExistingPrice = function($index) {
				sharedProperties.setIndex($index+1);
				$location.path('/price-detail');
			};
			
			$scope.listPrices = function() {
				$location.path('/price-list');
			}

			$scope.showSelectedElement = function(p) {
				$scope.index = p.id;
			};

			// add price
			$scope.addPrice= function() {
				var price = {
					price : $scope.price.price,
				};
				$scope.prices.push(price);
				$scope.insertPrice(price);
				$scope.listPrices();
			}

			$scope.insertPrice = function(data) {
				dataFactory.insertPrice(data).success(function(data) {
					var len = $scope.prices.length;
					for (var i = 0; i < len; i++) {
						if ($scope.prices[i].id === undefined) {
							$scope.prices[i] = data;
							break;
						}
					}
				}).error(
						function(error) {
							$scope.status = 'Unable to create price data: '
									+ error.message;
						});
			}

			// edit price
			$scope.editPrice = function(price) {
				var newPrice = {
						id : sharedProperties.getIndex(),
						price : price.price,
					};
				$scope.updatePrice(newPrice);
				$scope.listPrices();
			}

			$scope.updatePrice = function(data) {
				dataFactory.updatePrice(data).success(function(data) {
					var len = $scope.prices.length;
					for (var i = 0; i < len; i++) {
						if (data.id === $scope.prices[i].id) {
							$scope.prices[i] = data;
							break;
						}
					}

				}).error(
						function(error) {
							$scope.status = 'Unable to update price data: '
									+ error.message;
						});
			}

			// delete price
			$scope.deletePrice = function(id, index) {
				if (id === undefined) {
					$scope.prices.splice(index, 1);
					return;
				}
				dataFactory.deletePrice(id).success(function(data) {
					$scope.prices.splice(index, 1);
					console.log("Delete", data, '@', index);
				}).error(
						function(error) {
							$scope.status = 'Unable to delete price data: '
									+ error.message;
						});
			}

			// list prices
			$scope.getPrices = function() {
				dataFactory.getPrices().success(function(data) {
					$scope.prices = data;
					console.log(data)
				}).error(
						function(error) {
							$scope.status = 'Unable to load price data: '
									+ error.message;
						});
			}
			$scope.getPrices();
		});
