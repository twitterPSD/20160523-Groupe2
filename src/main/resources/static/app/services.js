(function(angular) {
  var ItemFactory = function($resource) {
    return $resource('/items/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  ItemFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Item", ItemFactory);
  
  var AuthorFactory = function($resource) {
	    return $resource('/authors/:id', {
	      id: '@id'
	    }, {
	      update: {
	        method: "PUT"
	      },
	      remove: {
	        method: "DELETE"
	      }
	    });
	  };
	  
	  ItemFactory.$inject = ['$resource'];
	  angular.module("myApp.services").factory("Author", AuthorFactory);
  
}(angular));