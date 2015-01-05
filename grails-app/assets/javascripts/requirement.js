app = angular.module('requirement', ['ngMaterial']);
app.controller('Product', function ($scope, $http, $mdDialog) {
    $scope.addProduct = function(ev) {
        $mdDialog.show({
            controller: AddProductController,
            templateUrl: '/InterfaceManage/addProductDialog.tmpl.html?t='+new Date(),
            targetEvent: ev
        }).then(function(newProduct){
            console.log(newProduct);
            $http.post('/InterfaceManage/Product/addProduct', newProduct)
                .success(function (response) {
                    console.log(response);
                    if(response.success) {
                    }
                });
        }, function(){

        });
    };

    function AddProductController($scope){
        $scope.newProduct = {
            name:"",
            introduce:"",
            logo:""
        };

        $scope.hide = function() {
            $mdDialog.hide();
        };
        $scope.cancel = function() {
            $mdDialog.cancel();
        };
        $scope.submit = function() {
            $mdDialog.hide($scope.newProduct);
        };
    }
});