'use strict';

// Declare app level module which depends on views, and components
var carApp = angular.module('carApp', ['ngRoute']);

carApp.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
        $routeProvider.
                when('/car-list', {templateUrl: 'partials/car-list.html', controller: "CarListCtrl"}).
                when('/car-detail', {templateUrl: 'partials/car-detail.html', controller: "CarListCtrl"}).
                when('/car-creation', {templateUrl: 'partials/car-creation.html', controller: "CarListCtrl"}).
                when('/price-list', {templateUrl: 'partials/price-list.html', controller: "PriceListCtrl"}).
                when('/price-detail', {templateUrl: 'partials/price-detail.html', controller: "PriceListCtrl"}).
                when('/price-creation', {templateUrl: 'partials/price-creation.html', controller: "PriceListCtrl"}).
                when('/brand-list', {templateUrl: 'partials/brand-list.html', controller: "BrandListCtrl"}).
                when('/brand-detail', {templateUrl: 'partials/brand-detail.html', controller: "BrandListCtrl"}).
                when('/brand-creation', {templateUrl: 'partials/brand-creation.html', controller: "BrandListCtrl"}).
                otherwise({redirectTo: '/car-list'
                });
    }]);