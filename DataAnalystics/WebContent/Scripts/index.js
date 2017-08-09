var startDate = "";
var choosedStock = "";
//判断search是否可用
function searchValid() {
  if ($('#stock').val() && $('#startDate').val() && $('#endDate').val()) {
    $('#search').removeAttr('disabled');
  } else {
    $('#search').attr('disabled', 'disabled');
  }
}

laydate({
    elem:'#startDate',
    min:'2016-01-04 ', 
    max:'2016-03-24 ',
    istoday: true ,
    choose: function(data) { //选择日期完毕的回调
      searchValid();
      laydate({
          elem:'#endDate', 
          min: data,
          max:'2016-03-24 ',
          istoday: true ,
          choose: function() {
            searchValid();
          } 
      });
    }
});

laydate({
    elem:'#endDate', 
    min: startDate,
    max:'2016-03-24 ',
    istoday: true,
    choose: function() {
      searchValid();
    }
});

$('#stock').on('blur', function() {
  searchValid();
})

$(document).ready( function () {

  var stockData = [{"changepercent":"-5.39%","ticker":"acas","change":"0.77","close":13.51,"open":14.28},{"changepercent":"-3.25%","ticker":"ace","change":"3.70","close":110.08,"open":113.78},{"changepercent":"-2.56%","ticker":"acn","change":"2.61","close":99.26,"open":101.87},{"changepercent":"-3.98%","ticker":"adbe","change":"3.66","close":88.3,"open":91.96},{"changepercent":"-8.53%","ticker":"ads","change":"23.19","close":248.56,"open":271.75},{"changepercent":"-15.61%","ticker":"adsk","change":"9.41","close":50.89,"open":60.3}];
  var table = $('#default_stocks').DataTable({
      "ajax": {
          "url": "getDataBetweenDate/2016-01-04/2016-01-13",
          "dataSrc": "",
          "success": function(data) {
            loadData = data; 
          }
       },
      "paging": false,
      "searching": false,
      "retrieve": true,
      "bDestroy": true,
      "columnDefs":[
      { //自定义组件
          targets: 5,
          render: function (data, type, row, meta) {
            console.log(loadData)
              return '<button class="btn btn-default toView">view</button><button class="btn btn-default add" id="add" ng-click="showPortfolio()">add</button>';
          }
      },
          { "orderable": false, "targets": 5 },
      ],
      "oLanguage": {
        "oPaginate": {
          "sFirst": "First",
          "sPrevious": "Previous",
          "sNext": "Next",
          "sLast": "Last"
        }
      },
      "columns": [   
         {"data" : "ticker"},  
         {"data" : "open"},  
         {"data" : "close"},
         {"data" : "change"},
         {"data" : "changepercent"},   
         ],
    });

    //添加新的portfolio 名字
  $('#search').on('click', function() {
      var searchUrl = 'searchDataBetweenDate/'+$('#startDate').val()+'/'+$('#endDate').val()+'/'+$('#stock').val();
      var tableUrl = table.ajax.url(searchUrl);
      console.log(searchUrl)
      tableUrl.load();
  })

  $("#default_stocks").delegate("toView","click",function(){
    alert(1);
    window.location.href = 'portfolioDay.html?fromDate=2016-01-04 09:30&toDate=2016-01-11 09:30&ticker=' + $(this).parents('tr').find('td:first').html();
  });

});


//angular 部分

angular.module('myApp', []).controller('userCtrl', function($http, $scope) {
  $scope.choosedStock = "ss";
  $scope.showPortfolio = function() {
    $http.get("/getPortfolioName?username=admin").success(function(data) {
      $scope.portfolios = data;
    });
  }

  $scope.createPortfolio = function() {

    //先检测是否有重复的portfolio name
    for(var i = 0; i < $scope.portfolios.length; i++) {
      if ($scope.portName == $scope.portfolios[i]) {
        alert("repeat portfolio name");
        return;
      }
    }
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

  $scope.conutIndex = function(portfolio) {
    return $scope.portfolios.indexOf(portfolio);
  }
  $scope.addTicker = function() {
    $http({
      method: 'GET',
      url:'/addTickerToPortfolio',
      params: {
        username: "admin",
        portfolioName: $scope.choosedPort,
        ticker: choosedStock
      }
    }).then(function successCallback(response) {
        alert("add suceessfully");
    })
  }

  $("#default_stocks").delegate(".add","click",function(){
    $("#myModal").modal('show');
    $scope.showPortfolio()
    choosedStock = $(this).parents('tr').find('td:first').html();
    console.log(choosedStock)
  });

})


