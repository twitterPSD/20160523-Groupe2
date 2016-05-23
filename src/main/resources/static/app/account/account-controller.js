(function(angular) {
  var AccountController = function($scope, Account) {
	Account.query(function(response) {
      $scope.accounts = response ? response : [];
    });
    
    $scope.addAccount = function(account) {
      new Account({
        firstname: account.firstname,
        lastname: account.lastname,
        email: account.email,
        password: account.password
      }).$save(function(account) {
        $scope.accounts.push(account);
      });
      $scope.newAccount = "";
    };
    
    $scope.updateAccount = function(account) {
      account.$update();
    };
    
    $scope.deleteAccount = function(account) {
      account.$remove(function() {
        $scope.accounts.splice($scope.accounts.indexOf(account), 1);
      });
    };
  };
  
  AccountController.$inject = ['$scope', 'Account'];
  angular.module("myApp.controllers").controller("AccountController", AccountController);
}(angular));