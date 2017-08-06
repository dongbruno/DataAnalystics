define([], function () {
    return {
        defaultRoute: '/show/stationery',
        routes: {
            'show': {
                templateUrl: 'views/show.html',
                url: '/show',
                dependencies: ['controller/navigationBarController'],
                allowAnonymous: true
            },
            'show.stationery': {
                templateUrl: 'views/show-stationery.html',
                url: '/stationery',
                dependencies: ['controller/stationeryController', 'filter/shortNameFilter'],
                allowAnonymous: true
            },
            'show.order': {
                templateUrl: 'views/show-order.html',
                url: '/order',
                dependencies: ['controller/orderController', 'filter/shortNameFilter'],
                allowAnonymous: true
            }, 
            'show.adminTools': {
                templateUrl: 'views/show-adminTools.html',
                url: '/adminTools',
                dependencies: ['controller/adminToolsController', 'filter/shortNameFilter'],
                allowAnonymous: true
            },
            'show.cart':{
            	 templateUrl: 'views/show-cart.html',
                 url: '/cart',
                 dependencies: ['controller/cartController', 'filter/shortNameFilter'],
                 allowAnonymous: true
            }
            
            
        }
    };
});