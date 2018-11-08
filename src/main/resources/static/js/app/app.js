'use strict'

var barApp = angular.module('bar', ['ui.bootstrap', 'bar.controllers',
    'bar.services']);
barApp.constant("CONSTANTS", {
    getAllBars: "/api/getAllBars",
    getAllBarsCount: "/api/getCount",
    findBarByName: "/api/findBarByName/"
});