$(document).ready( function () {
    var table = $('#default_stocks').DataTable({
      "ajax": {
         "url": "getDataBetweenDate/2016-01-04/2016-01-13",
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


  //添加新的portfolio 名字
  $('#create div').on('click', function() {
    console.log($('#create input').val());
    // $.ajax() {
    //   url: '',
    //   type: 'get',
    //   data: {

    //   },
    //   success: function(data) {}
    // }
  })



  
});
