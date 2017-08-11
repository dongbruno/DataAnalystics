function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

var localFromDate = GetQueryString('fromDate');
var localtoDate = GetQueryString('toDate');
var localTiker = GetQueryString('ticker');

$('#tName').html(localTiker);
$.ajax({
    url: 'getDataBetweenDateByMinute/2016-01-04%2009:30/2016-01-11%2009:30/abbv',
    // data: {
    //     fromDate: '2016-01-04',
    //     toDate: '2016-03-05',
    //     ticker: 'a'
    // },
    success: function(data) {
        console.log(data)
    }
})
//初始K线图
$.get('getDataBetweenDateByDay/2016-01-04/2016-03-24/abbv', function (rawData) {
	writeK(rawData, "d");
});

//通过day minute按钮改变K线图横坐标
$('#day').on('click', function() {
    $('#minute').removeClass('btn-success');
    $(this).addClass('btn-success');
	$.get('getDataBetweenDateByDay/2016-01-04/2016-03-24/abbv', function (rawData) {
		writeK(rawData, "d");
	});
})

//通过day minute按钮改变K线图横坐标
$('#minute').on('click', function() {
    $('#day').removeClass('btn-success');
    $(this).addClass('btn-success');
	$.get('getDataBetweenDateByMinute/2016-01-04%2009:30/2016-01-11%2009:30/abbv', function (rawData) {
		writeK(rawData, "m");
	});
})



