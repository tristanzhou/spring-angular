'use strict';

angular.
  module('moodTrackerApp').
  config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
      //$locationProvider.hashPrefix('!');

      $routeProvider.
        when('/moodtracker', {
          template: '<mood-tracker></mood-tracker>'
        }).
        when('/teammood', {
          template: '<team-mood></team-mood>'
        }).
        otherwise('/moodtracker');

      $locationProvider.html5Mode(true);
    }
  ]);
