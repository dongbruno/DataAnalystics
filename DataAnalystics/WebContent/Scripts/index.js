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
         "url": "Json/test.json",
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


  $('#search').on('click', function() {
    var tableUrl = table.ajax.url("Json/day.json");
    tableUrl.load();
  })  

  //添加新的portfolio 名字
  $('#create div').on('click', function() {
    // console.log($('#create input').val());
    $.ajax({
	   	type: 'get', 
	    url: 'localhost:8080/getDataBetweenDate/2016-01-02/2016-02-03' ,  
	//     data: {} , 
	    success: function(data) {

		}
    })
  })



  
});
