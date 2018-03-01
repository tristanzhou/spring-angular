'use strict';

angular.
  module('moodTracker', ["ngMaterial", "ngCookies", "radialIndicator"]).
  component('moodTracker', {
    templateUrl: 'mood-tracker/mood-tracker.template.html',
    controller: ['$scope', '$mdDialog', '$rootElement', "$cookies", "$filter", "$http", "$location",
      function MoodController($scope, $mdDialog, $rootElement, $cookies, $filter, $http, $location) {
      	$scope.moods = moods;
				$scope.title = "How are you feeling today?";
				
				$scope.showInfo = function(infoTitle, info, closeCallBack) {
					$scope.infoTitle = infoTitle;
					$scope.info = info;
					$mdDialog.show({
					  templateUrl: 'mood-tracker/info.template.html',
					  parent: $rootElement,
					  scope: $scope,
					  preserveScope: true,
					  clickOutsideToClose: true,
					  onRemoving: closeCallBack
					});
				}

				$scope.openMoodMessage = function(mood) {
					$scope.mood = mood;

					var lastSubmitDate = $cookies.get(COOKIE_SUBMIT_DATE);
					var today = $filter('date')(new Date(), "yyyy-MM-dd");

					if(today == lastSubmitDate) {
						$scope.showInfo("Oops", "Sorry, you have already submitted your response for today, try again tomorrow!");
					} else {
						$mdDialog.show({
					    templateUrl: 'mood-tracker/mood-tracker-message.template.html',
					    parent: $rootElement,
					    scope: $scope,
					    preserveScope: true,
					    clickOutsideToClose: true
					  });
					}
				};

				$scope.error = "";
				$scope.messageMaxLength = 350;
				$scope.message = "";
				$scope.messageLeft = $scope.messageMaxLength;

				$scope.messageChange = function() {
					$scope.messageLeft = $scope.messageMaxLength - $scope.message.length;
				};

				$scope.cancel = function() {
					$mdDialog.cancel();
				};

				$scope.send = function() {
					$scope.error = "";
					if($scope.message.length > $scope.messageMaxLength) {
						$scope.error = "It's really a long story, maybe we could talk more about it later...";
					} else {
						$http({method: "post",
									url: SERVER_URL.replace("localhost", $location.host()) + '/moods',
									params: {
										'trackDate': $filter('date')(new Date(), "yyyy-MM-dd"),
										'mood': $scope.mood,
										'message': $scope.message
									}})
							.then(function successCallback(response) {
						    if(response.data.success) {
						    	$cookies.put(COOKIE_SUBMIT_DATE, $filter('date')(new Date(), "yyyy-MM-dd"));
						    	$scope.showInfo("Great", "Thanks for your sharing!", function () { $location.path("/teammood"); });
						    }
							});
					}
				};
      }
    ]
  });
