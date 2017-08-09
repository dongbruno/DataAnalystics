function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

var localPortfolioname = GetQueryString('portfolioname');

$(document).ready( function () {
  url="getTickersFromPortfolio?username=admin&portfolioName="+localPortfolioname;
  console.log(url)
    var table = $('#default_stocks').DataTable({
      "ajax": {
         "url": "getTickersFromPortfolio?username=admin&portfolioName="+localPortfolioname,
          "dataSrc": ""
       },
      "columnDefs":[
      { //自定义组件
          targets: 5,
          render: function (data, type, row, meta) {
              return '<a type = "button" href="portfolioDay.html" class="btn btn-default">view</a><button class="btn btn-default" data-toggle="modal" data-target="#myModal">add</button>';
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
         {"data" : "changepercent"} 
         ],
    });

  
});
