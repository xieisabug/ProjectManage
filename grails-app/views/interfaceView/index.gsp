<!DOCTYPE html>
<html>
<head>
    <title>接口测试</title>
    <meta name="layout" content="main"/>

</head>

<body>
<div ng-controller="InterfaceView">
    <md-tabs md-selected="data.selectedIndex">
        <md-tab ng-repeat="c in category" id="tab{{$index}}" aria-controls="tab{{$index}}-content">
            {{c.name}}
        </md-tab>
    </md-tabs>
    <ng-switch on="data.selectedIndex" class="tabpanel-container">
        <div ng-repeat="c in category" role="tabpanel" id="tab{{$index}}-content" aria-labelledby="tab{{$index}}"
             ng-switch-when="{{$index}}" md-swipe-left="next()" md-swipe-right="previous()">
            <md-card ng-repeat="i in c.interfaceObjects">
                <div class="card">
                    <div>接口名：{{i.name}}</div>

                    <div>接口方法类型：{{i.method}}</div>

                    <div>接口地址：{{i.link}}</div>

                    <div>接口简介：{{i.remark}}</div>

                    <div>
                        <form action="/InterfaceManage/interfaceView/testInterface" method="post">
                            <input type="hidden" name="interfaceId" value="{{i.id}}"/>
                            <md-text-float ng-repeat="p in i.params" label="{{ p.name + '  ' + p.remark}}" name="{{p.name}}">
                        </form>
                    </div>
                </div>
            </md-card>
        </div>
    </ng-switch>
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
