export default function routeConfig($routeProvider, $locationProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "views/cars-unpurchased.html"
        })
        .when("/inventory", {
            templateUrl: "views/inventory.html"
        })
        .when("/sold-cars", {
            templateUrl: "views/sold-cars.html"
        })

    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}