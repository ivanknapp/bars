'use strict';

var module = angular.module('bar.controllers', ['ngRoute'])
    .controller("SearchController", ["$scope", "BarService",
        function ($scope, BarService, $route, $routeParams, $location) {
            $scope.barName = null;
            $scope.allBarsCount = null;

            BarService.getCountOfBars().then(function (value) {
                $scope.allBarsCount = value.data;
            }, function (reason) {
                console.log("error occured");
            }, function (value) {
                console.log("no callback");
            });

            $scope.findBarByName = function () {
                BarService.getBarByName($scope.barName).then(function (value) {
                    $scope.allBars = value.data;
                    $scope.allBarsCount = $scope.allBars.length;
                }, function (reason) {
                    console.log("error occured");
                }, function (value) {
                    console.log("no callback");
                });
            };
        }])

    .controller('getController', function ($scope, $routeParams, BarService) {
        $scope.name = 'getController';
        $scope.params = $routeParams;
        $scope.bar = null;
        $scope.findBarById = function () {
            BarService.getBarById($routeParams.barId).then(function (value) {
                $scope.bar = value.data;
            }, function (reason) {
                console.log("error occured");
            }, function (value) {
                console.log("no callback");
            });
        };
        findBarById()
    })
    .config(function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/findById/:barId', {
                templateUrl: 'restaraunt.html',
                controller: 'getController'
            });

        // configure html5 to get links working on jsfiddle
        // $locationProvider.html5Mode(true);
    });