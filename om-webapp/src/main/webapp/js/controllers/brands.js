'use strict';

console.log('init brands');

angular.module('carApp').controller(
		'BrandListCtrl',
		function($scope, $log, $route, $location, dataFactory, sharedProperties) {
			console.log('init BrandCtrl');

			$scope.brand = null;
			$scope.brands = [];

			// navigation
			$scope.reloadPage = function() {
				$route.reload();
			};

			$scope.createNewBrand= function() {
				$location.path('/brand-creation');
			};

			$scope.updateExistingBrand = function($index) {
				sharedProperties.setIndex($index+1);
				$location.path('/brand-detail');
			};
			
			$scope.listBrands = function() {
				$location.path('/brand-list');
			}

			$scope.showSelectedElement = function(b) {
				$scope.index = b.id;
			};

			// add brand
			$scope.addBrand= function() {
				var brand = {
					name : $scope.brand.name,
				};
				$scope.brands.push(brand);
				$scope.insertBrand(brand);
				$scope.listBrands();
			}

			$scope.insertBrand = function(data) {
				dataFactory.insertBrand(data).success(function(data) {
					var len = $scope.brands.length;
					for (var i = 0; i < len; i++) {
						if ($scope.brands[i].id === undefined) {
							$scope.brands[i] = data;
							break;
						}
					}
				}).error(
						function(error) {
							$scope.status = 'Unable to create brand data: '
									+ error.message;
						});
			}

			// edit brand
			$scope.editBrand = function(brand) {
				var newBrand = {
						id : sharedProperties.getIndex(),
						name : brand.name,
					};
				$scope.updateBrand(newBrand);
				$scope.listBrands();
			}

			$scope.updateBrand = function(data) {
				dataFactory.updateBrand(data).success(function(data) {
					var len = $scope.brands.length;
					for (var i = 0; i < len; i++) {
						if (data.id === $scope.brands[i].id) {
							$scope.brands[i] = data;
							break;
						}
					}

				}).error(
						function(error) {
							$scope.status = 'Unable to update brand data: '
									+ error.message;
						});
			}

			// delete brand
			$scope.deleteBrand = function(id, index) {
				if (id === undefined) {
					$scope.brands.splice(index, 1);
					return;
				}
				dataFactory.deleteBrand(id).success(function(data) {
					$scope.brands.splice(index, 1);
					console.log("Delete", data, '@', index);
				}).error(
						function(error) {
							$scope.status = 'Unable to delete brand data: '
									+ error.message;
						});
			}

			// list brands
			$scope.getBrands = function() {
				dataFactory.getBrands().success(function(data) {
					$scope.brands = data;
					console.log(data)
				}).error(
						function(error) {
							$scope.status = 'Unable to load brand data: '
									+ error.message;
						});
			}
			$scope.getBrands();
		});
