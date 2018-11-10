'use strict'

angular.module('bar.services', []).factory('BarService',
    ["$http", "CONSTANTS", function ($http, CONSTANTS) {
        var service = {};
        service.getAllBars = function () {
            return $http.get(CONSTANTS.getAllBars);
        };
        service.getCountOfBars = function () {
            return $http.get(CONSTANTS.getAllBarsCount);
        };
        service.getBarByName = function (barName) {
            return $http.get(CONSTANTS.findBarByName + barName);
        };
        return service;
    }]);