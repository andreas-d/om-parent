'use strict';

// Declare app level module which depends on views, and components
var carApp = angular.module('carApp', ['ngRoute']);

carApp.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
        $routeProvider.
                when('/car-list', {templateUrl: 'partials/car-list.html', controller: "CarListCtrl"}).
                when('/car-detail/:id', {templateUrl: 'partials/car-detail.html', controller: "CarDetailController"}).
                when('/car-creation', {templateUrl: 'partials/car-creation.html', controller: "CarCreationController"}).
                otherwise({redirectTo: '/car-list'
                });
    }]);