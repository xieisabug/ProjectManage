<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="application">
<head>
    <meta name="layout" content="main"/>
    <title>接口管理</title>
</head>

<body>
<div ng-controller="InterfaceObject" id="card-container">

    <md-toolbar layout="row" style="margin-bottom: 20px;">
        <div class="md-toolbar-tools">
            <md-button style="width: 100px; height:30px;" ng-click="addInterfaceObject($event)">添加接口</md-button>
        </div>
    </md-toolbar>

    <div layout="row">
        <md-whiteframe flex="20" id="category-list" class="md-whiteframe-z1">
            <md-button ng-repeat="item in category" ng-click="changeCategory(item)">{{item.name}}</md-button>
            <md-button ng-click="openAddCategoryDialog($event)">添加</md-button>
        </md-whiteframe>

        <div flex style="margin-left: 20px;">
            <md-list>
                <md-item ng-repeat="item in interface">
                    <div layout="row">
                        <div flex="30"><h3>{{item.name}}</h3></div>

                        <div flex><h4>{{item.method}}</h4></div>
                        <md-button class="md-raised md-primary" md-theme="red"
                                   style="width: 100px; height:30px; margin-right: 5px;" ng-click="deleteInterfaceObject($event, item, $index)">删除</md-button>
                        <md-button class="md-raised md-primary" style="width: 100px; height:30px;" ng-click="editInterfaceObject($event, item)">编辑</md-button>
                    </div>
                </md-item>
            </md-list>
        </div>
    </div>
</div>
</body>
</html>