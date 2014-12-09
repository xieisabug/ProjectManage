app = angular.module('application', ['ngMaterial']);
app.controller('InterfaceObject', function ($scope, $http) {
    $scope.category = [];
    $scope.interface = [];
    $scope.currentCategory = null;

    $http.get('/InterfaceManage/interfaceObject/getCategory').success(function (response) {
        console.log(response);
        if (response && response.length != 0) {
            $scope.category = response;
            $scope.interface = $scope.category[0].interfaceObjects;
            $scope.currentCategory = $scope.category[0];
        }
    });

    $scope.changeCategory = function(category){
        console.log(category);
        $scope.interface = category.interfaceObjects;
        $scope.currentCategory = category;
    }
});