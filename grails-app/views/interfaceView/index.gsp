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
                                <input type="hidden" name="interfaceId" value="{{interfaceObject.id}}"/>
                                <div>
                                    <label ng-repeat="p in interfaceObject.params">
                                        {{ p.name + ' : ' + p.remark}}
                                        <input name="{{p.name}}" type="text">
                                    </label>
                                </div>
                                <input type="submit" name="submit" value="测试">
                            </form>
                        </div>
                    </div>
                </md-card>
            </div>
        </md-tab>
    </md-tabs>
</div>
</body>
</html>
