angular.module('myApp', []).controller('portfolioCtrl', function($http, $scope) {
  $scope.chooseName="ss";
  $http.get("/getPortfolioName?username=admin").success(function(data) {
    $scope.portfolios = data;
  });

  $scope.conut = function(stocks) {
    return stocks.length;
  }

  $scope.delete = function(target) {
    index = this.$index;
    $http({
      method: 'GET',
      url:'/deletePortfolioName',
      params: {
        portfolioName: this.portfolio.portfolioname,
        username: "admin"
      }
    }).then(function successCallback(response) {
        alert("delete successfully");
        console.log(index)
        $scope.portfolios.splice(index, 1);
    })
  }
  //check repeat
  $scope.checkRepeat =function() {
    for (var i = 0; i < $scope.portfolios.length; i++) {
      if ( $scope.portfolios[i].portfolioname == $scope.portName) {
        alert('repeat portfolioName');
        return;
      }
    }
    $scope.createPortfolio();
  }
  $scope.createPortfolio = function() {
  if (!$scope.portName) {
    alert('input is null');
    return;
  }
  $http({
      method: 'GET',
      url:'/createPortfolioName',
      params: {
        portfolioName: $scope.portName,
        username: "admin"
      }
    }).then(function successCallback(response) {
      $scope.portfolios.push({"quantity": 0,"portfolioname": $scope.portName});
      $scope.portName = '';
    })
  }



})