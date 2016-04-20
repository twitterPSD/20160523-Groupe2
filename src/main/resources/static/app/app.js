(function(angular) {
  angular.module("myApp.controllers", []);
  angular.module("myApp.services", []);
  angular.module("myApp", ["ngResource","ui.router", "myApp.controllers", "myApp.services"]);
}(angular));