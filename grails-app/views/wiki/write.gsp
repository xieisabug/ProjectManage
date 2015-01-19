<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/1/17
  Time: 15:29
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${wiki.name}</title>
    <script type="text/javascript" src="/InterfaceManage/js/Markdown.Converter.js"></script>
    <script type="text/javascript" src="/InterfaceManage/js/Markdown.Sanitizer.js"></script>
    <script type="text/javascript" src="/InterfaceManage/js/Markdown.Editor.js"></script>
    <style type="text/css">
        .input_content {
            width: 95%;
            height: 700px;
            background: #1e1e1e;
            color: #fafafa;
        }
    </style>
</head>

<body >
<div layout="row">
    <div id="input_container" flex>
        <g:form controller="wiki" action="save">
            <div>
                <label for="name">名称</label>
                <g:textField name="name" id="name" value="${wiki.name}"/>
            </div>

            <div>
                <label for="content">内容</label>
                <g:textArea name="content" id="content" value="${wiki.content}" class="input_content"/>
            </div>
            <g:submitButton name="submit" value="提交"/>
        </g:form>
    </div>

    <div id="preview" flex style="overflow: scroll;">

    </div>
</div>

<script type="text/javascript">
    var converter = new Markdown.Converter();
    var content = document.getElementById('content');
    var preview = document.getElementById('preview');

    function convert() {
        var input = content.value;
        preview.innerHTML = converter.makeHtml(input);
    }

    content.oninput = convert;
    convert();

    var height = document.body.clientHeight;
    preview.style.height = height-88;

</script>
</body>
</html>