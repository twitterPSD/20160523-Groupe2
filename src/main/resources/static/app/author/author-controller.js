(function(angular) {
  var AuthorController = function($scope, Author) {
	Author.query(function(response) {
      $scope.authors = response ? response : [];
    });
    
    $scope.addAuthor = function(author) {
      new Author({
        firstname: author.firstname,
        lastname: author.lastname,
        email: author.email
      }).$save(function(author) {
        $scope.authors.push(author);
      });
      $scope.newAuthor = "";
    };
    
    $scope.updateAuthor = function(author) {
      author.$update();
    };
    
    $scope.deleteAuthor = function(author) {
      author.$remove(function() {
        $scope.authors.splice($scope.authors.indexOf(author), 1);
      });
    };
  };
  
  AuthorController.$inject = ['$scope', 'Author'];
  angular.module("myApp.controllers").controller("AuthorController", AuthorController);
}(angular));