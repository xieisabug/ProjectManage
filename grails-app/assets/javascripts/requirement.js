app = angular.module('requirement', ['ngMaterial']);
app.controller('Product', function ($scope, $http, $mdDialog) {
    $scope.addProduct = function(ev) {
        $mdDialog.show({
            controller: AddProductController,
            templateUrl: '/InterfaceManage/changeLinkDialog.tmpl.html?t='+new Date(),
            targetEvent: ev
        }).then(function(newLink){
            interfaceObject.link = newLink;
            $http.post('/InterfaceManage/interfaceObject/changeLink', interfaceObject)
                .success(function (response) {
                    console.log(response);
                    console.log(interfaceObject);
                    console.log(index);
                    if(response.success) {
                        $scope.category[parentIndex].interfaceObjects[index] = interfaceObject;
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