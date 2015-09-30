<!DOCTYPE html>
<html>
<head>
    <title>接口测试</title>
    <meta name="layout" content="main"/>

</head>

<body>
<div ng-controller="InterfaceView" flex>
    <md-tabs md-dynamic-height md-border-bottom md-selected="data.selectedIndex"  style="width: 960px; margin: 0 auto; ">
        <md-tab ng-repeat="c in category" label="{{c.name}}" layout="row">
            <md-content class="md-padding">
                <md-card ng-repeat="interfaceObject in c.interfaceObjects" style="float: left; width: 293px;">
                    <md-card-content>
                        <div class="field">接口名：{{interfaceObject.name}}</div>

                        <div class="field">接口方法类型：{{interfaceObject.method}}</div>

                        <div class="field">接口地址：{{interfaceObject.link}} <md-button ng-click="changeLink(interfaceObject,$parent.$index, $index)" class="md-primary md-raised">修改地址</md-button></div>

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
                    </md-card-content>
                </md-card>
            </md-content>
        </md-tab>
    </md-tabs>
</div>
</body>
</html>
