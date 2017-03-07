'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){

  //  var REST_SERVICE_URI = 'http://localhost:8080/SpringBoot/user';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser,
        updateUser:updateUser,
        deleteUser:deleteUser
    };

    return factory;

    function fetchAllUsers() {
             
        var url="/SpringBoot/user";
			
			return $http.get(url).then(function(response) {
		        return response.data;
		});
        
    }

  function createUser(user) {
        var deferred = $q.defer();
        $http.post('/SpringBoot/user/', user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put('/SpringBoot/user/'+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteUser(id) {
        var deferred = $q.defer();
        $http.post('/SpringBoot/user/'+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    

}]);
