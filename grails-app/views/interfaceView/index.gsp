<!DOCTYPE html>
<html>
<head>
    <title>接口测试</title>
    <meta name="layout" content="main"/>

</head>

<body>
<div ng-controller="InterfaceView">
    <md-tabs md-selected="data.selectedIndex"  style="width: 960px; margin: 0 auto;">
        <md-tab ng-repeat="c in category" label="{{c.name}}" layout="row">
            <div ng-repeat="interfaceObject in c.interfaceObjects" flex="33">
                <md-card>
                    <div class="card">
                        <div>接口名：{{interfaceObject.name}}</div>

                        <div>接口方法类型：{{interfaceObject.method}}</div>

                        <div>接口地址：{{interfaceObject.link}}</div>

                        <div>接口简介：{{interfaceObject.remark}}</div>

                        <div>
                            <form action="/InterfaceManage/interfaceView/testInterface" method="post">
                                <input type="hidden" name="interfaceId" value="{{i.id}}"/>
                                <md-text-float ng-repeat="p in interfaceObject.params" label="{{ p.name + '  ' + p.remark}}" name="{{p.name}}">
                            </form>
                        </div>
                    </div>
                </md-card>
            </div>
        </md-tab>
    </md-tabs>
</div>

%{--<g:each in="${categorys}" var="category" status="index">
    <div class="title <g:if test="${index == 0}">hover_tab</g:if>">
        ${category.name}
    </div>
</g:each>
<g:each in="${categorys}" var="category" status="index">
    <div class="content" <g:if test="${index != 0}">style="display:none"</g:if>>
        <g:each in="${category.interfaceObjects}" var="interfaceObject"
                status="interfaceIndex">
            <g:render template="item" model="[interfaceObject: interfaceObject]"></g:render>
        </g:each>
    </div>
</g:each>--}%
</body>
</html>
