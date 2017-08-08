angular.module('myApp', []).controller('userCtrl', function($http, $scope) {
	console.log(1)
	$http.get("Json/test.json").success(function(data) {
		$scope.users = data;
		console.log(data);
	});


})