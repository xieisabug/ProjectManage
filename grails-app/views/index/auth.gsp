<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>登录</title>

</head>

<body>
<div id="login-container" flex ng-controller="Login">

        <md-card id="login-card" layout-align="center center">
            <md-content style="width: 300px;">

                <md-input-container>
                    <label>用户名</label>
                    <input ng-model="user.username" type="text">
                </md-input-container>
                <md-input-container>
                    <label>密码</label>
                    <input ng-model="user.password" type="password">
                </md-input-container>
            </md-content>
            <md-button class="md-fab md-primary md-hue-2" aria-label="Profile"
                       style="position: relative; bottom: -35px;" ng-click="login('${postUrl}')">
                <md-icon md-svg-icon="action:ic_done_24px"></md-icon>
            </md-button>
        </md-card>

</div>

</body>

</html>