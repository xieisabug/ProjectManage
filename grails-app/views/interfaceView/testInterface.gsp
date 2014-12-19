<!DOCTYPE html>
<html>
<head>
<title>Welcome to Grails</title>
<style type="text/css" media="screen">
pre {outline: 1px solid #ccc; padding: 5px; margin: 5px; }
.string { color: green; }
.number { color: darkorange; }
.boolean { color: blue; }
.null { color: magenta; }
.key { color: red; }
</style>

</head>
<body>
<script type="text/javascript">
	/**
	 * 下面的函数是将返回的json进行格式化，并且着色，让json数据看起来更加美观
	 */
	function output(inp) {
		document.body.appendChild(document.createElement('pre')).innerHTML = inp;
	}
	function syntaxHighlight(json) {
		if (typeof json != 'string') {
			json = JSON.stringify(json, undefined, 2);
		}
		json = json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
		return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
			var cls = 'number';
			if (/^"/.test(match)) {
				if (/:$/.test(match)) {
					cls = 'key';
				} else {
					cls = 'string';
				}
			} else if (/true|false/.test(match)) {
				cls = 'boolean';
			} else if (/null/.test(match)) {
				cls = 'null';
			}
			return '<span class="' + cls + '">' + match + '</span>';
		});
	}
	var json = ${content};
	output(syntaxHighlight(json));
</script>
</body>
</html>
