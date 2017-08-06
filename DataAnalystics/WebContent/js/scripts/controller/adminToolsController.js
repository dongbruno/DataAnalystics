define(['app'], function(app){
	app.controller('adminToolsCtrl', function($scope, $http){
		$scope.setDeadline = function(){
			$http.get("setDeadline?deadline="+dateform.date.value).then(function(response){
				alert(response.data["result"]);
			}, function(err){
				alert(err);
			})
		}
		$scope.setNote = function(){
			$http.get("setNote?note="+noteform.note.value).then(function(response){
				alert(response.data["result"]);
			}, function(err){
				alert(err);
			})
		}
		
		$scope.searchOrdersBySoeid = function(){
			$http.get("searchOrdersBySoeid?soeid="+soeidform.soeidForSerch.value,{
				"Accept": "application/json;charset=utf-8",
				"Accept-Charset": "charset=utf-8"
			}).then(function(response){
				$scope.ordersBySoeid = response.data;
			}, function(err){
				console.log(err);
			})
		}
		
		$scope.download = function(dlType, location){
			var url = "download/"+dlType+"/"+location;
			window.location.href = url;
		}
		
	})
})