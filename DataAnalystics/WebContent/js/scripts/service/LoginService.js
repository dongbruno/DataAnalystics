define([ 'app', 'service/common/ajaxService' ], function(app) {
	app.service('loginService', function($http, ajaxService) {
		var me = this;
		me.login = function(url, data, success) {
			ajaxService.ajaxPost(url, data, success);
		}

	});
});
