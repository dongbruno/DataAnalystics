angular.module('myApp', []).controller('portfolioCtrl', function($http, $scope) {
  $scope.chooseName="ss";
  $http.get("/getPortfolioName?username=admin").success(function(data) {
    $scope.portfolios = data;
    console.log(data);
  });

  $scope.conut = function(stocks) {
    return stocks.length;
  }

  $scope.delete = function(target) {
    console.log(this.portfolio.portfolioname);
  }

  $scope.createPortfolio = function() {
  $http({
      method: 'GET',
      url:'/createPortfolioName',
      params: {
        portfolioName: $scope.portName,
        username: "admin"
      }
    }).then(function successCallback(response) {
      $scope.portfolios.push($scope.portName);
      $scope.portName = '';
    })
  }



})