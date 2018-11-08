'use strict'

var module = angular.module('bar.controllers', []);
module.controller("SearchController", ["$scope", "BarService",
    function ($scope, BarService) {
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
            }, function (reason) {
                console.log("error occured");
            }, function (value) {
                console.log("no callback");
            });
        };

    }]);