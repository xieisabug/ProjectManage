<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>选择项目</title>

</head>

<body>

<div id="project-container" flex>

    <div class="project-container-sub">
        <p>您创建了以下项目：</p>
        <g:each in="${createProject}" var="project">
            <md-button class="md-raised" ng-href="<g:createLink controller="index" action="index" params="[id:project.id]"/>">${project.name}</md-button>
        </g:each>
    </div>

    <div class="project-container-sub">
        <p>您加入了以下项目：</p>
        <g:each in="${joinProject}" var="project">
            <md-button class="md-raised" ng-href="<g:createLink controller="index" action="index" params="[id:project.id]"/>">${project.name}</md-button>
        </g:each>
    </div>

    <div class="project-container-sub">
        <p>您还可以：</p>
        <md-button class="md-raised">创建项目</md-button>
    </div>


</div>

</body>

</html>