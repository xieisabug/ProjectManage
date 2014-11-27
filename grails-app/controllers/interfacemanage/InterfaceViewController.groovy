package interfacemanage

import java.util.ResourceBundle.RBClassLoader;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response

class InterfaceViewController {
	OkHttpClient client = new OkHttpClient();
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	Gson gson = new Gson();
	
    def index() {
		def categorys = Category.list();
		return [categorys:categorys]
	}
	
	def testInterface(){
		def interfaceObj = InterfaceObject.get(params.interfaceId)
		Request rq = null
		//POST«Î«Û
		if (interfaceObj.method.equals("POST")) {
			def json = gson.toJson(params);
			RequestBody rb = RequestBody.create(JSON, json);
			rq = new Request.Builder()
			.url(interfaceObj.link)
			.post(rb)
			.build()
		} else if (interfaceObj.method.equals("GET")) {
			String l = interfaceObj.link+"?1=1"
			for (param in interfaceObj.param.split(",")) {
				l += "&" + param+"="+params[param]
			}
			rq = new Request.Builder()
			.url(l)
			.get()
			.build()
		} 
		
//		println "res body is"
//		println res.body().string()
		Response res = client.newCall(rq).execute()
		return [content:res.body().string()]
	}
}
