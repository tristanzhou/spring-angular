'use strict';

var SERVER_URL = "http://localhost:8081";
var COOKIE_SUBMIT_DATE = "SUBMIT_DATE";
var moodSize = 5;
var moods = [{"mood": "HAPPY", "desc": "Happy"}, 
						{"mood": "NORMAL", "desc": "Just normal really"},
						{"mood": "MEH", "desc": "A bit \“meh\”"},
						{"mood": "GRUMPY", "desc": "Grumpy"},
						{"mood": "STRESS", "desc": "Stressed out – not a happy camper"}];
var moodClasses = {"HAPPY": "success", "NORMAL": "success", "MEH": "info", "GRUMPY": "warning", "STRESS": "danger"};

angular.module('moodTrackerApp', [
  'ngAnimate',
  'ngRoute',
  'ngMaterial',
  'moodTracker',
  'teamMood'
]);