<div class="card">
	<div>接口名：${ interfaceObject.name }</div>
	<div>接口方法类型：${ interfaceObject.method }</div>
	<div>接口地址：${ interfaceObject.link }</div>
	<div>接口简介：${ interfaceObject.remark }</div>
	<div>
	<g:form controller="interfaceView" action="testInterface">
		<g:hiddenField name="interfaceId" value="${interfaceObject.id }"/>
		<g:each in="${ interfaceObject.param.split(",") }" var="fieldName">
			${fieldName } : <input type="text" name="${ fieldName }"> 
		</g:each>
		<g:submitButton name="提交"/>
	</g:form>
	</div>
</div>