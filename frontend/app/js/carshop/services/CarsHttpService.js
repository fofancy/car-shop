export default function carsHttpService ($http) {
     function CarsHttpService() {

    }

    function getCars(requestParams, callbackSuccess, callbackReject) {
        var params = {};

        if(requestParams.brandBeginsWith)
            params['brand-begins-with'] = requestParams.brandBeginsWith;

        $http({
            method: 'GET',
            url: 'http://localhost:8081/api/cars-to-purchase',
            contentType: 'application/json', 
            params: params
        }).then(
            callbackSuccess,
            callbackReject
        );
    }

    function getInventoryCars(requestParams, callbackSuccess, callbackReject) {
        var MAX_VALUE = 2000000000

        var params = {
            'only-reserved' : false,
            'min-price' : 0,
            'max-price' : MAX_VALUE

        };

        if(requestParams.reserved) {            
            params['only-reserved'] = requestParams.reserved;
        }

        if(requestParams.minValue) {
            params['min-price'] = requestParams.minValue;
        }

        if(requestParams.maxValue) {
            params['max-price'] = requestParams.maxValue;
        }

        $http({
            method: 'GET',
            url: 'http://localhost:8081/api/inventory-items',
            contentType: 'application/json', 
            params: params
        }).then(
            callbackSuccess,
            callbackReject
        );
    }

    function getSoldCars(requestParams, callbackSuccess, callbackReject) {
        var params = {};

        $http({
            method: 'GET',
            url: 'http://localhost:8081/api/sold-cars',
            contentType: 'application/json', 
            data: params
        }).then(
            callbackSuccess,
            callbackReject
        );
    }

    function buyCar(car, callbackSuccess, callbackReject) {

        $http({
            method: 'POST',
            url: 'http://localhost:8081/api/inventory-items',
            contentType: 'application/json', 
            data: car
        }).then(
            callbackSuccess,
            callbackReject
        );
    }

    function sellCar(car, callbackSuccess, callbackReject) {

        $http({
            method: 'POST',
            url: 'http://localhost:8081/api/sold-cars',
            contentType: 'application/json', 
            data: car
        }).then(
            callbackSuccess,
            callbackReject
        );
    }




    CarsHttpService.prototype.getCars = getCars;
    CarsHttpService.prototype.buyCar = buyCar;
    CarsHttpService.prototype.sellCar = sellCar;
    CarsHttpService.prototype.getInventoryCars = getInventoryCars;
    CarsHttpService.prototype.getSoldCars = getSoldCars;

    return new CarsHttpService();
}