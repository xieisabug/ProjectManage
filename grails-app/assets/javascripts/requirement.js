app = angular.module('requirement', ['ngMaterial']);
app.controller('Product', function ($scope, $http, $mdDialog) {

    $scope.productList = [];
    $scope.isListPanel = true;
    $scope.currentProduct = {};

    $scope.requirementContent = '';

    $http.get('/InterfaceManage/product/listProduct').success(function(response){
        if(response && response.length) {
            $scope.productList = response;
        }
    });

    $scope.productDetail = function(product) {
        $scope.isListPanel = false;
        $scope.currentProduct = product;
    };

    $scope.backToList = function() {
        $scope.isListPanel = true;
    };

    $scope.addProduct = function(ev) {
        $mdDialog.show({
            controller: AddProductController,
            templateUrl: '/InterfaceManage/assets/addProductDialog.tmpl.html?t='+new Date(),
            targetEvent: ev
        }).then(function(newProduct){
            console.log(newProduct);
            $http.post('/InterfaceManage/Product/addProduct', newProduct)
                .success(function (response) {
                    console.log(response);
                    if(response.success) {
                        $scope.productList.push(newProduct);
                    }
                });
        }, function(){

        });
    };

    $scope.addRequirement = function(){
        $http.post('/InterfaceManage/Requirement/addRequirement', {detail: $scope.requirementContent, productId:$scope.currentProduct.id})
            .success(function (response) {
                console.log(response);
                if(response.success) {
                }
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