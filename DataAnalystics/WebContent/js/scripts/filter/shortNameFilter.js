define(['app'], function(app){
	app.filter("shortName", function(){
		return function(x){
			var index = x.indexOf("(");
			return x.substring(0, index);
		}
	});
});