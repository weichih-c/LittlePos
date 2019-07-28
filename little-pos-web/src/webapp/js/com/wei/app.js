var appController = angular.module('controllers', [])
var appService = angular.module('services', [])

var app = angular.module('myApp',
 ['services',
  'controllers'
 ]);