export default function carsController($scope, CarsHttpService) {
    var self = this;

    self.filter = {
        reserved: false
    }

    function init() {
        self.getInventoryCars();
    }


    $scope.$watch(function () {
        return self.filter.reserved;
    }, function (newVal, oldval) {
        self.getInventoryCars();
    })

    $scope.$watch(function () {
        return self.filter.minValue;
    }, function (newVal, oldval) {
        self.getInventoryCars();
    })

    $scope.$watch(function () {
        return self.filter.maxValue;
    }, function (newVal, oldval) {
        self.getInventoryCars();
    })


    self.getInventoryCars = function () {
        CarsHttpService.getInventoryCars(
            {
                reserved: self.filter.reserved,
                minValue: self.filter.minValue,
                maxValue: self.filter.maxValue
            },
            function (result) {
                self.currentCars = result.data;
            },
            function(rejection) {
                alert(rejection)
            }
        )
    }

    self.sellCar = function (index) {
        CarsHttpService.sellCar(
            self.currentCars[index],
            function() {
                alert('Cars was succesfully sold');
                
                self.getInventoryCars();
            },
            function(err) {
                console.log(err);
                alert('Something went wrong')
            }
        )
    }

    self.getCarsInfomration = function () {
        return self.currentCars ? 
        self.currentCars.map(ctp => {
            var car = ctp.car;
            car.purchaseDate = ctp.purchaseDate;
            return car;
        }) : 
        {};
    }

    console.log(self.currentCars);
    
    init();
}