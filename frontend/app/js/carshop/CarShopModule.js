import angular from 'angular'

import carsController from './components/CarsController'
import inventoryController from './components/InventoryController'
import soldCarsController from './components/SoldCarsController'

import carsHttpService from './services/CarsHttpService'


export default angular
    .module('cars', [])
    .controller('CarsController', carsController)
    .controller('InventoryController', inventoryController)
    .controller('SoldCarsController', soldCarsController)
    .factory('CarsHttpService', carsHttpService)
    .name;
