const marketService = 'http://localhost:8100/ui';
// (function () {
//     angular.module('cloud-market-app', ['ngRoute'])
//         .config(function config($routeProvider, $locationProvider) {
//             $routeProvider
//                 .when('/', {
//                     templateUrl: 'main_page/main_page.html',
//                     controller: 'mainPageController'
//                 })
//                 .when('/product', {
//                     templateUrl: 'product/product.html',
//                     controller: 'productController'
//                 })
//                 .otherwise({
//                     redirectTo: '/'
//                 });
//         });
//
// })();

angular.module('cloud-market-app', ['ui.bootstrap']).controller('indexController', function ($rootScope, $scope, $http) {
    $scope.itemsPerPage = 5;
    $scope.totalElements = 0;
    $scope.totalPages = 0;
    $scope.currentPage = 1;
    $scope.inputForm = {id: null, title: null, price: null};

    let updateCatalog = function (pageIndex = 1, pageSize = 5) {
        $http({
            url: marketService + '/products',
            method: 'GET',
            params: {
                p: Math.floor(pageIndex - 1),
                ps: pageSize
            }
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data.content;
            $scope.totalElements = response.data.totalElements;
            $scope.totalPages = response.data.totalPages;
        });
    };

    updateCatalog($scope.currentPage, $scope.itemsPerPage);

    $scope.firstPage = function () {
        console.log('first page');
        $scope.currentPage = 1;
        updateCatalog($scope.currentPage, $scope.itemsPerPage);
    }
    $scope.previousPage = function () {
        if ($scope.currentPage > 1) {
            $scope.currentPage--;
            updateCatalog($scope.currentPage, $scope.itemsPerPage);
        }
        console.log('previous page: ' + $scope.currentPage);
    }
    $scope.nextPage = function () {
        if ($scope.currentPage < Math.ceil($scope.totalElements / $scope.itemsPerPage)) {
            $scope.currentPage++;
            updateCatalog($scope.currentPage, $scope.itemsPerPage);
        }
        console.log('next page: ' + $scope.currentPage);
    }
    $scope.lastPage = function () {
        $scope.currentPage = Math.ceil($scope.totalElements / $scope.itemsPerPage);
        console.log('last page: ' + $scope.currentPage);
        updateCatalog($scope.currentPage, $scope.itemsPerPage);
    }
});