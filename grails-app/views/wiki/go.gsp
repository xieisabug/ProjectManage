<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/1/14
  Time: 11:20
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${wiki.name}</title>
    <script type="text/javascript" src="/InterfaceManage/js/Markdown.Converter.js"></script>
    <script type="text/javascript" src="/InterfaceManage/js/Markdown.Sanitizer.js"></script>
    <script type="text/javascript" src="/InterfaceManage/js/Markdown.Editor.js"></script>
</head>

<body>
<div id="content" flex style="overflow: scroll; width: 960px; margin: 0 auto;">
    ${wiki.content}
</div>
<div style="position: absolute; bottom: 100px; right: 100px;">
    <md-button class="md-raised md-primary" md-theme="green"
               style="width: 100px; height:30px; margin-right: 5px;" ng-href="<g:createLink controller="wiki" action="write" params="[name:wiki.name]"/> ">编辑</md-button>

</div>
<script type="text/javascript">
    var converter = new Markdown.Converter();
    var content = document.getElementById('content');

    var input = content.innerHTML;
    content.innerHTML = converter.makeHtml(input);

    var height = document.body.clientHeight;
    content.style.height = height-88;

    function write(){
        window.location = "/InterfaceManage/wiki/write?name=${wiki.name}";
    }
</script>
</body>
</html>