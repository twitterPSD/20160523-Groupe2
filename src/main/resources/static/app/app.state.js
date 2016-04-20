(function() {
    'use strict';

    angular
        .module('myApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function stateConfig($stateProvider,$urlRouterProvider) {
        
    	$urlRouterProvider.otherwise('/');
    	
    	$stateProvider
    	.state('home', {
            url:'/',
            templateUrl:'app/home/home.html'
         })
    	.state('items',{
        	url:'/item',
        	templateUrl:'app/item/item.html'
        })
        .state('authors',{
        	url:'/author',
        	templateUrl:'app/author/author.html'
        })
        ;
    }
})();