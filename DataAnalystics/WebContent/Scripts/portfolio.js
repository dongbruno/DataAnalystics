function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

var localPortfolioname = GetQueryString('portfolioname');
var localQuantity = GetQueryString('quantity');

$('#pName').html(localPortfolioname);
$('#pNumber').html(localQuantity);

$(document).ready( function () {
    var table = $('#default_stocks').DataTable({
      "ajax": {
         "url": "getRecordsFromPortfolio?username=admin&portfolioName="+localPortfolioname,
          "dataSrc": ""
       },
      "columnDefs":[
      { //自定义组件
          targets: 5,
          render: function (data, type, row, meta) {
              return '<button class="btn btn-default toView">view</button><button class="btn btn-default delete">delete</button>';
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

    $("#default_stocks").delegate(".toView","click",function(){
      window.location.href = 'portfolioDay.html?fromDate=2016-01-04 09:30&toDate=2016-01-11 09:30&ticker=' + $(this).parents('tr').find('td:first').html();
    });


    //删除
    $("#default_stocks").delegate(".delete","click",function(){
      $(this).parents('tr').remove();
      $.ajax({
        url: 'deleteTickerFromPortfolio',
        data: {
          username: 'admin',
          portfolioName: localPortfolioname,
          ticker: $(this).parents('tr').find('td:first').html()
        }
      })
    });
    
});
