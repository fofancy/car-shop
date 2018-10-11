export default function carsController($scope, CarsHttpService) {
    var self = this;

    // self.filter = {
    //     title: ""
    // }

    function init() {
        self.getSoldCars();
    }


    // $scope.$watch(function () {
    //     return self.filter.title;
    // }, function (newVal, oldval) {
    //     self.getCars();
    // })


    self.getSoldCars = function () {
        CarsHttpService.getSoldCars(
            // {
            //     brandBeginsWith: self.filter.brand
            // },
            {},
            function (result) {
                self.currentCars = result.data;
            },
            function(rejection) {
                alert(rejection)
            }
        )
    }
    
    self.getCarsInfomration = function () {
        return self.currentCars ? 
        self.currentCars.map(ctp => {
            var car = ctp.car;
            car.saleDate = ctp.saleDate;
            return car;
        }) :
        {}
    }

    console.log(self.currentCars);
    
    init();
}