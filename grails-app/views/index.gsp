<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>工具集</title>
</head>

<body>
<div id="card-container" layout="row">
    <md-card id="interface-card" flex>
        <h2>接口工具</h2>
        <ul>
            %{--TODO 改成button--}%
            <li><g:link controller="category">类别管理</g:link></li>
            <li><g:link controller="interfaceObject">接口管理</g:link></li>
            <li><g:link controller="interfaceView">查看接口</g:link></li>
        </ul>
    </md-card>
    <span flex></span>
    <span flex></span>
</div>
</body>
</html>
