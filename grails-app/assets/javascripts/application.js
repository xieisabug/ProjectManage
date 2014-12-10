app = angular.module('application', ['ngMaterial']);
app.controller('InterfaceObject', function ($scope, $http, $mdDialog, $window) {
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

    $scope.home = function(){
        window.location = '/InterfaceManage/';
    };

    $scope.changeCategory = function (category) {
        console.log(category);
        $scope.interface = category.interfaceObjects;
        $scope.currentCategory = category;
    };

    $scope.addInterfaceObject = function (ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: '/InterfaceManage/dialog.tmpl.html?t='+new Date(),
            targetEvent: ev
        }).then(function(newInterfaceObject){
            newInterfaceObject.categoryId = $scope.currentCategory.id;
            $http.post('/InterfaceManage/interfaceObject/addInterfaceObject', newInterfaceObject)
                .success(function (response) {
                    console.log(response);
                    if(response.success) {
                        $scope.interface.push(newInterfaceObject)
                    }
                });
        }, function(){

        });
    };

    $scope.deleteInterfaceObject = function (interfaceObject) {
        $http.post('/InterfaceManage/interfaceObject/deleteInterfaceObject', {id: interfaceObject.id})
            .success(function (response) {
                console.log(response);
            });
    };

    function DialogController($scope){
        $scope.newInterface = {
            name:'',
            link:'',
            method:'',
            params:[
            ]
        };
        $scope.paramName="";
        $scope.paramRemark="";

        $scope.hide = function() {
            $mdDialog.hide();
        };
        $scope.cancel = function() {
            $mdDialog.cancel();
        };
        $scope.add = function() {
            $mdDialog.hide($scope.newInterface);
        };
        $scope.addParam = function(){
            $scope.newInterface.params.push({name:$scope.paramName, remark:$scope.paramRemark});
            $scope.paramName = "";
            $scope.paramRemark = "";
        };
        $scope.deleteNewInterface = function(item) {
            $scope.newInterface.params.splice(item,1);
        }
    }
});