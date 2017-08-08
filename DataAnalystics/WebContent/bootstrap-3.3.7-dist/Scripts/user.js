angular.module('myApp', []).controller('portfolioCtrl', function($http, $scope) {
  console.log(1)
  $http.get("Json/portfolio.json").success(function(data) {
    $scope.portfolios = data;
    console.log(data);
  });

  $scope.conut = function(stocks) {
    return stocks.length;
  }

  $scope.delete = function(stocks) {
    return stocks.length;
  }


})