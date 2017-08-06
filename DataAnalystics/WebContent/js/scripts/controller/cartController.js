define(['app'], function(app){
	app.controller('cartCtrl', function($scope, $http){
		$scope.cartStationery = $scope.$root.cartStationery;
		
		$scope.totalPrice = function(){
			var total = 0;
			angular.forEach($scope.cartStationery, function(item){
				if(item.quantity > 0 && item.quantity !==""){
					total += item.quantity*item.price;
				}
			});
			return total;
		}
		$scope.onblurs = function(quantity){
			$scope.$root.cartStationery.some(function(item, key){
				if(item.quantity < 1 || item.quantity ==""){
					var ans = confirm(item.name + "数量无效，是否移除该文具？");
					if(ans){
						$scope.remove(key);
					} else{
						item.quantity = 1;
					}
					return ;
				}
			})
		}
		
		$scope.totalQuantity = function(){
			var total = 0;
			angular.forEach($scope.cartStationery, function(item){
				if(item.quantity > 0 && item.quantity !==""){
					total += parseInt(item.quantity);
				}
			});
			$scope.$root.number = total;
			return total;
		}
		
		$scope.remove = function(index){
			$scope.cartStationery.splice(index, 1);
		}
		$scope.removeAll = function(){
			var index;
			for(index = $scope.cartStationery.length - 1; index >=0; index--){
				$scope.remove(index);
			}
		}
		
		
		
		$scope.submit = function(){
			var json_order = [];
			$scope.cartStationery.some(function(item, key){
				var strTemp = '{"stationeryId":' + item.stationeryId +',"quantity":'+item.quantity+'}';
				json_order.push(JSON.parse(strTemp));
			});
			
			$http({
				method: 'POST',
				url: 'submitOrders',
				data: JSON.stringify(json_order),
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(function(response){
				alert(response.data["result"]);
			}, function(err){
				alert(err);
			});
			$scope.removeAll();
		}
		$scope.reduce = function(index){
			if($scope.cartStationery[index].quantity !=1){
				$scope.cartStationery[index].quantity--;
			} else{
				var ans = confirm("是否移除该商品？");
				if(ans){
					$scope.remove(index);
				} else {
					$scope.cartStationery[index].quantity = 1;
				}
			}
		}
		
		$scope.add = function(index){
			$scope.cartStationery[index].quantity++;
		}
		$scope.$root.isNoteHide = $scope.$root.isNoteHide || false;
		$scope.hideNote = function(){
			$scope.$root.isNoteHide = true;
		}
	})
})