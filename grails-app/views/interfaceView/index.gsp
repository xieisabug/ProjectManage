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
                <md-card ng-repeat="interfaceObject in c.interfaceObjects" flex="30" style="float: left;">
                    <div class="card">
                        <div class="field">接口名：{{interfaceObject.name}}</div>

                        <div class="field">接口方法类型：{{interfaceObject.method}}</div>

                        <div class="field">接口地址：{{interfaceObject.link}}</div>

                        <div class="field">接口返回示例：{{interfaceObject.returnExample}}</div>

                        <div class="field">接口返回说明：{{interfaceObject.remark}}</div>

                        <div class="field">
                            <form action="/InterfaceManage/interfaceView/testInterface" method="post">
                                <input type="hidden" name="interfaceId" value="{{interfaceObject.id}}"/>
                                <div style="display: inline-block">
                                    <label ng-repeat="p in interfaceObject.params" style="display: block; color: tomato;">
                                        {{ p.name + ' : ' + p.remark}}
                                        <input name="{{p.name}}" type="text">
                                    </label>
                                </div>
                                <input type="submit" name="submit" value="测试">
                            </form>
                        </div>
                    </div>
                </md-card>
        </md-tab>
    </md-tabs>
</div>
</body>
</html>
