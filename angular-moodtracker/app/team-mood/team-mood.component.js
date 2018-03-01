'use strict';

angular.
  module('teamMood', ["radialIndicator"]).
  component('teamMood', {
    templateUrl: 'team-mood/team-mood.template.html',
    controller: ['$scope', "$http", "$location",
      function MoodController($scope, $http, $location) {
      	var self = this;
      	$scope.title="Overall Team Mood";
				$scope.moodSize = moodSize;
				$scope.moods = moods;
				$scope.moodClasses = moodClasses;
				$scope.overallRating = $scope.moodSize;
				$scope.moodsOfToday = [];

				$http({method: "get", url: SERVER_URL.replace("localhost", $location.host()) + '/moods'})
							.then(function successCallback(response) {
						    if(response.data.success) {
						    	var totalRating = 0;
						    	$scope.moodsOfToday = response.data.payload;
						    	angular.forEach($scope.moodsOfToday, function(item, index) {
									  var moodRating = $scope.moodSize - $scope.moods.findIndex(mood => mood.mood==item.mood);
									  totalRating += moodRating;
									});
									if($scope.moodsOfToday.length == 0) {
										$scope.overallRating = $scope.moodSize;
									} else {
										$scope.overallRating = Math.floor(totalRating / $scope.moodsOfToday.length);
									}
									$('#indicatorContainer').radialIndicator(
					        	{radius : 180,
					        		percentage :false, 
					        		barColor: {
									      0: '#FF0000',
									      33: '#FFFF00',
									      66: '#0066FF',
									      100: '#33CC33'
									    },
									    initValue : ($scope.overallRating / $scope.moodSize) * 100
									  }
									);
						    }
							});
      }
    ]
  });
