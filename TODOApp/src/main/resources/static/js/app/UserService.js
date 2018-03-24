
'use strict';
 
angular.module('crudApp').factory('UserService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
 
            var factory = {
                loadAllUsers: loadAllUsers,
                getAllUsers: getAllUsers,
                getUser: getUser,
                createUser: createUser,
                updateUser: updateUser,
                removeUser: removeUser
            };
 
            return factory;
 
            function loadAllUsers() {
                console.log('Fetching all users');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all users');
                            $localStorage.users = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading users');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function getAllUsers(){
                return $localStorage.users;
            }
 
            function getUser(id) {
                console.log('Fetching User with id :'+id);
                var deferred = $q.defer();
                $http.get("http://localhost:8080/todo/" + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully User with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading user with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function createUser(user) {
                console.log('Creating User');
                var deferred = $q.defer();
                $http.post("http://localhost:8080/todo", user)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating User : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function updateUser(user, id) {
                console.log('Updating Todo Task with id '+id);
                var deferred = $q.defer();
                $http.put("http://localhost:8080/updatetodostatus/" + id, user)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating User with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function removeUser(id) {
                console.log('Removing Todo Task with id '+id);
                var deferred = $q.defer();
                $http.delete("http://localhost:8080/todo/" + id)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing User with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
        }
    ]);