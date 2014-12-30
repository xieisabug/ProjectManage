package interfacemanage

import java.util.ResourceBundle.RBClassLoader;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response

/**
 * 访问接口
 * 用于在测试接口的时候，访问网络，获取数据
 */
class InterfaceViewController {
	OkHttpClient client = new OkHttpClient();
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	Gson gson = new Gson();

	/**
	 * 显示index主界面，由于使用ajax加载数据，所以不返回任何数据
	 */
    def index() {
	}

	/**
	 * 获取所有接口的列表，返回json数据
	 * @return 所有接口列表的json
	 */
	def getCategory() {
		//render方法是将数据渲染，这里是渲染成json数据
		render(contentType: "text/json") {
			Category.list()
		}
	}

	/**
	 * 测试接口，会跳转到一个界面去显示接口返回的数据
	 * @return 跳转界面，展示接口返回的数据
	 */
	def testInterface(){
		//获取到要测试的接口对象
		def interfaceObj = InterfaceObject.get(params.interfaceId)
		//request对象
		Request rq = null
		if (interfaceObj.method.equals("POST")) {//如果是POST方法
			//测试接口填写的参数数据
			def json = gson.toJson(params);
			//创建一个request
			RequestBody rb = RequestBody.create(JSON, json);
			rq = new Request.Builder()
			.url(interfaceObj.link)
			.post(rb)
			.build()
		} else if (interfaceObj.method.equals("GET")) {//如果是GET方法
			//1=1方便后面的参数拼接
			String l = interfaceObj.link+"?1=1"
			//拼接参数
			for (param in interfaceObj.params) {
				l += "&" + param.name+"="+params[param.name]
			}
			rq = new Request.Builder()
			.url(l)
			.get()
			.build()
		} 
		
//		println "res body is"
//		println res.body().string()
		//发送request，获取返回数据，跳转界面显示
		Response res = client.newCall(rq).execute()
		return [content:res.body().string()]
	}
}
