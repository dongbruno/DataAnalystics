var startDate = "";
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
    var table = $('#default_stocks').DataTable({
      "ajax": {
         //"url": "Json/test.json",
          "dataSrc": ""
       },
      "columnDefs":[
      { //自定义组件
          targets: 7,
          render: function (data, type, row, meta) {
              return '<a type = "button" href="portfolioDay.html" class="btn btn-default">view</a><button class="btn btn-default" data-toggle="modal" data-target="#myModal">add</button>';
          }
      },
          { "orderable": false, "targets": 7 },
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
         {"data" : "date"},  
         {"data" : "open"},
         {"data" : "high"},
         {"data" : "low"},  
         {"data" : "close"},  
         {"data" : "vol"}   
         ],
    });

  //添加新的portfolio 名字
  $('#add').on('click', function() {
    $('#myModal').modal('show');
  })


});


//angular 部分

angular.module('myApp', []).controller('userCtrl', function($http, $scope) {

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
  $scope.addTicker = function($event) {
    console.log($scope.choosedPort);
  }

})
