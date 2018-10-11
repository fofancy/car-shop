import './styles/app.css'
import 'bootstrap/dist/css/bootstrap.css'
import angular from 'angular'
import ngRoute from 'angular-route'

import carShop from './js/carshop/CarShopModule'

import routeConfig from './app.routes'

export default angular
    .module('app', [ngRoute, carShop]) 
    .config(routeConfig)
    .name;


