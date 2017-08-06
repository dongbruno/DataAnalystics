define(
		[ 'app' ],
		function(app) {
			app
					.controller(
							'stationeryCtrl',
							function($scope, $http) {
								$scope.stationery = [];

								// alert($scope.$root.systemInfo.deadline+'now='+new
								// Date().getTime());
								$scope.$root.cartStationery = $scope.$root.cartStationery
										|| [];
								$scope.addToCart = function(newItem) {
									var isContained = $scope.$root.cartStationery
											.some(function(item, key) {
												if (item.stationeryId == newItem.stationeryId) {
													$scope.$root.cartStationery[key].quantity = $scope.$root.cartStationery[key].quantity || 1;
													$scope.$root.cartStationery[key].quantity = $scope.$root.cartStationery[key].quantity + 1;
													$scope.$root.number += 1;
													return true;
												}

											});
									if (!isContained) {
										newItem.quantity = 1;
										$scope.$root.cartStationery
												.push(newItem);
										$scope.$root.number += 1;

									}
								}
								$http.get(
												"getStationery",
												{
													"Accept" : "application/json;charset=utf-8",
													"Accept-Charset" : "charset=utf-8"
												}).then(function(response) {
											$scope.stationery = response.data;
										}, function(err) {
											console.log(err);
										});
								

								$scope.hideDeadline = function() {
									$scope.$root.isDeadlineHide = true;
								}

							});
		});