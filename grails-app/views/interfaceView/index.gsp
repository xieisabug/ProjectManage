<!DOCTYPE html>
<html>
<head>
<title>Welcome to Grails</title>
<style type="text/css" media="screen">
</style>
<asset:stylesheet src="mycss.css" />
<asset:javascript src="jquery-1.11.1.min.js" />
<asset:javascript src="myjs.js" />

</head>
<body>
	<g:each in="${ categorys }" var="category" status="index">
		<div class="title <g:if test="${index == 0 }">hover_tab</g:if>">
			${category.name }
		</div>
	</g:each>
	<g:each in="${ categorys }" var="category" status="index">
		<div class="content" <g:if test="${index != 0 }">style="display:none"</g:if>>
			<g:each in="${ category.interfaceObjects }" var="interfaceObject"
				status="interfaceIndex">
				<g:render template="item" model="[interfaceObject:interfaceObject]"></g:render>
			</g:each>
		</div>
	</g:each>
</body>
</html>
