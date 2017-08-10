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
//绘制折线图
var myChart = echarts.init(document.getElementById('chart'));
var tickerArray = [];
var data = [];
var xAxisData = [];
var seriesData = [];
var seriesData1 = [];
var seriesData2 = [];
$.ajax({
  url: "getRecordsFromPortfolio?username=admin&portfolioName="+localPortfolioname,
  async: false,
  success: function(data) {
    for (var i = 0; i < data.length; i++) {
      tickerArray.push(data[i].ticker);
    };
  }
})
var option = {
    title: {
        text: 'line'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:[]
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '13%',
        containLabel: true
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: xAxisData
    },
    yAxis: {
        splitLine: {
            show: false
        },
        type: 'value'
    },    dataZoom: [
        {
            show: true,
            start: 0,
            end: 100,
        },
        {
            type: 'inside',
            start: 0,
            end: 100,
        }
    ],
    series: []
};
//获取数据
function getData(tickerName) {
  $.ajax({
    url: 'getDataBetweenDateByMinute/2016-01-04%2009:30/2016-03-04%2009:30/'+tickerName,
    success: function(data) {
      for (var i = 0; i < data.length; i++) {
        if (xAxisData.length <  data.length) {
          xAxisData.push(data[i].date+ ' ' +data[i].time);
        }
        seriesData.push(data[i].close);
      };
      var item = {
              name: tickerName,
              type:'line',
              data:seriesData
      };
      seriesData = [];
      option.legend.data.push(tickerName);
      option.series.push(item);
      myChart.setOption(option);
    }
  })
}

//开始画图

for (var i = 0; i < tickerArray.length; i++) {
  getData(tickerArray[i]);
}
//加载完数据一次性画图



