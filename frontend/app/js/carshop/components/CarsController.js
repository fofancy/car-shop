export default function carsController($scope, CarsHttpService) {
    var self = this;

    self.filter = {
        title: ""
    }

    function init() {
        self.getCarsToPurchase();
    }


    $scope.$watch(function () {
        return self.filter.brand;
    }, function (newVal, oldval) {
        self.getCarsToPurchase();
    })


    self.getCarsToPurchase = function () {
        CarsHttpService.getCars ({
                brandBeginsWith: self.filter.brand
            },
            function (result) {
                self.currentCars = result.data;
            },
            function(rejection) {
                alert(rejection)
            }
        )
    }

    self.buyCar = function (index) {
        CarsHttpService.buyCar(
            self.currentCars[index],
            function() {
                alert('Cars was succesfully bought');
                
                self.getCarsToPurchase();
            },
            function(err) {
                console.log(err);
                alert('Something went wrong')
            }
        )
    }

    self.getCarsInfomration = function () {
        return self.currentCars ? 
        self.currentCars.map(ctp => ctp.car) :
        {}
    }

    console.log(self.currentCars);
    
    init();
}