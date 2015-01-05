<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>项目管理</title>
    <meta name="layout" content="requirement"/>
</head>

<body>
    <div ng-controller="Product">

        <md-toolbar layout="row" style="margin-bottom: 20px;">
            <div class="md-toolbar-tools md-red-theme">
                <md-button class="md-raised md-primary" md-theme="green"
                           style="width: 100px; height:30px; margin-right: 5px;" ng-click="home()">主页</md-button>
                <md-button style="width: 100px; height:30px;" ng-click="addProduct($event)">新增项目</md-button>
            </div>
        </md-toolbar>

        <md-card>
            <img src="img/washedout.png" class="md-card-image">
            <h2>Paracosm</h2>
            <p>
                The titles of Washed Out's breakthrough song and the first single from Paracosm share the
                two most important words in Ernest Greene's musical language: feel it. It's a simple request, as well...
            </p>
        </md-card>
    </div>
</body>
</html>