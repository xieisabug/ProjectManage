<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>项目管理</title>
    <meta name="layout" content="main"/>
    <style type="text/css" rel="stylesheet">
    </style>
</head>

<body>
    <div ng-controller="Product" style="width: 960px; margin: 0 auto;">

        <md-toolbar layout="row" style="margin-bottom: 20px; margin-top: 10px;">
            <div class="md-toolbar-tools md-red-theme">
                <md-button ng-click="addProduct($event)">新增项目</md-button>
            </div>
        </md-toolbar>

        <div layout="row" ng-show="isListPanel">
            <div flex="33" ng-repeat="product in productList" ng-click="productDetail(product)" style="cursor: pointer;">
                <md-card>
                    <img src="{{product.logo}}" class="md-card-image">
                    <md-card-content>
                        <h2 class="md-title">{{product.name}}</h2>
                        <p>
                            {{product.introduce}}
                        </p>
                    </md-card-content>
                </md-card>
            </div>
        </div>

        <div ng-show="!isListPanel">
            <div layout="row">
                <md-button ng-click="backToList()">返回</md-button>
            </div>
            <div layout="row">
                <div layout="row">
                    <md-text-float label="需求" ng-model="requirementContent" class="long" ></md-text-float>
                    <md-button ng-click="addRequirement()" class="md-raised" style="margin-top: 15px;">新增</md-button>
                </div>
            </div>
        </div>

    </div>
</body>
</html>