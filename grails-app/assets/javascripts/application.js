app = angular.module('application', ['ngMaterial']);
app.controller('InterfaceObject', function ($scope, $http, $mdDialog) {
    $scope.category = [];
    $scope.interface = [];
    $scope.currentCategory = null;

    $http.get('/InterfaceManage/interfaceObject/getCategory').success(function (response) {
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

    $scope.deleteInterfaceObject = function (ev, interfaceObject, index) {
        var confirm = $mdDialog.confirm()
            .title('删除接口?')
            .content('您确定要删除 ' + interfaceObject.name + ' 吗？')
            .ariaLabel('Lucky day')
            .ok('确定')
            .cancel('取消')
            .targetEvent(ev);
        $mdDialog.show(confirm).then(function() {
            $http.post('/InterfaceManage/interfaceObject/deleteInterfaceObject', {id: interfaceObject.id})
                .success(function (response) {
                    if(response.success) {
                        $scope.interface.splice(index, 1);
                    }
                });
        }, function() {

        });
    };

    function DialogController($scope){
        $scope.newInterface = {
            name:'',
            link:'',
            method:'POST',
            returnExample:'',
            remark:'',
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
app.controller('InterfaceView',function($scope, $http, $mdDialog){
    $scope.category = [];
    $scope.data = {
        selectedIndex:0
    };

    $http.get('/InterfaceManage/interfaceView/getCategory').success(function (response) {
        if (response && response.length != 0) {
            $scope.category = response;
            //console.log($scope.category);
        }
    });

    $scope.changeLink = function(interfaceObject, parentIndex, index, ev){
        $mdDialog.show({
            controller: ChangeLinkDialogController,
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
    function ChangeLinkDialogController($scope){
        $scope.newLink = '';

        $scope.hide = function() {
            $mdDialog.hide();
        };
        $scope.cancel = function() {
            $mdDialog.cancel();
        };
        $scope.submit = function() {
            $mdDialog.hide($scope.newLink);
        };
    }

});