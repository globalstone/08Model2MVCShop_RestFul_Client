package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.model2.mvc.service.domain.Product;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.service.domain.User;

public class RestHttpClientApp {

	// main Method
	public static void main(String[] args) throws Exception {

		////////////////////////////////////////////////////////////////////////////////////////////
		// �ּ��� �ϳ��� ó���ذ��� �ǽ�
		////////////////////////////////////////////////////////////////////////////////////////////

//		System.out.println("\n====================================\n");
//		1.1 Http Get ��� Request : JsonSimple lib ���
//		RestHttpClientApp.getUserTest_JsonSimple();

//		System.out.println("\n====================================\n");
//		1.2 Http Get ��� Request : CodeHaus lib ���
//		RestHttpClientApp.getUserTest_Codehaus();

//		System.out.println("\n====================================\n");
//		2.1 Http Post ��� Request : JsonSimple lib ���
//		RestHttpClientApp.LoginTest_JsonSimple();

//		System.out.println("\n====================================\n");
//		2.2 Http Post ��� Request : CodeHaus lib ���
//		RestHttpClientApp.LoginTest_Codehaus();

//		System.out.println("\n====================================\n");
//		3.1 Http Get ��� Request : JsonSimple lib ���
//		RestHttpClientApp.checkDuplication_JsonSimple();

//		System.out.println("\n====================================\n");
//		3.2 Http Get ��� Request : CodeHaus lib ���
//		RestHttpClientApp.checkDuplication_Codehaus();
//
//		System.out.println("\n====================================\n");
//		4.1 Http Get ��� Request : JsonSimple lib ���
//		RestHttpClientApp.listUser_JsonSimple();

//		System.out.println("\n====================================\n");
//		4.2 Http Get ��� Request : CodeHaus lib ���
//		RestHttpClientApp.listUser_Codehaus();

//		System.out.println("\n====================================\n");
//		5.1 Http Post ��� Request : JsonSimple lib ���
//		RestHttpClientApp.addUser_JsonSimple();

//		System.out.println("\n====================================\n");
//		5.2 Http Post ��� Request : CodeHaus lib ���
//		RestHttpClientApp.addUser_Codehaus();

//		System.out.println("\n====================================\n");
//		6.1 Http Put ��� Request : JsonSimple lib ���
//		RestHttpClientApp.updateUser_JsonSimple();

//		System.out.println("\n====================================\n");
//		6.2 Http Put ��� Request : CodeHaus lib ���
//		RestHttpClientApp.updateUser_Codehaus();

//		System.out.println("\n====================================\n");
//		7.1 Http Get ��� Request : JsonSimple lib ���
//		RestHttpClientApp.logout_JsonSimple();

//		System.out.println("\n====================================\n");
//		7.2 Http Get ��� Request : CodeHaus lib ���
//		RestHttpClientApp.logout_Codehaus();

//		System.out.println("\n====================================\n");
//		8.1 Http Post ��� Request : JsonSimple lib ���
//		RestHttpClientApp.addProduct_JsonSimple();

//		System.out.println("\n====================================\n");
//		8.2 Http Post ��� Request : Codehaus lib ���
//		RestHttpClientApp.addProduct_Codehaus();

//		System.out.println("\n====================================\n");
//		9.1 Http Get ��� Request : Codehaus lib ���
//		RestHttpClientApp.listProduct_JsonSimpleSearch();

//		System.out.println("\n====================================\n");
//		9.1 Http Get ��� Request : Codehaus lib ���
//		RestHttpClientApp.listProduct_JsonSimpleManage();

//		System.out.println("\n====================================\n");
//		9.2 Http Get ��� Request : Codehaus lib ���
//		RestHttpClientApp.listProduct_CodeHausSearch();

//		System.out.println("\n====================================\n");
//		9.2 Http Get ��� Request : Codehaus lib ���
//		RestHttpClientApp.listProduct_CodeHausManage();
	}

//================================================================//

	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
	public static void getUserTest_JsonSimple() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/getUser/admin";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}

	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib ���
	public static void getUserTest_Codehaus() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/getUser/admin";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(jsonobj.toString(), User.class);
		System.out.println(user);
	}

//================================================================//	

//================================================================//

	//2.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
	public static void LoginTest_JsonSimple() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/login";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		//[ ��� 1 : String ���]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

		//[ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("userId", "admin");
		json.put("password", "1234");
		HttpEntity httpEntity01 = new StringEntity(json.toString(), "utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> �����б�(JSON Value Ȯ��)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println(jsonobj);

	}

	//2.2 Http Protocol POST ��� Request : FromData���� 
	//==> JsonSimple + codehaus 3rd party lib ���
	public static void LoginTest_Codehaus() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/login";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

//		//[ ��� 1 : String ���]
//		String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

//		//[ ��� 2 : JSONObject ���]
//		JSONObject json = new JSONObject();
//		json.put("userId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

		//[ ��� 3 : codehaus ���]
		User user01 = new User();
		user01.setUserId("admin");
		user01.setPassword("1234");
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value �� ��ȯ
		String jsonValue = objectMapper01.writeValueAsString(user01);

		System.out.println(jsonValue);

		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(jsonobj.toString(), User.class);
		System.out.println(user);
	}

//================================================================//

	//3.1 Http Protocol Post ��� Request : UserId �ߺ�üũ : JsonSimple 3rd party lib ���
	public static void checkDuplication_JsonSimple() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/checkDuplication/botom12";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> �����б�(JSON Value Ȯ��)
		Object obj = JSONValue.parse(serverData);
		if (obj instanceof JSONObject) {
			JSONObject jsonobj = (JSONObject) obj;
			System.out.println(jsonobj);
		} else {
			System.out.println("JSONObject �� �ƴϾ�.");
		}
	}

	//3.2 Http Protocol Post ��� Request : UserId �ߺ�üũ : CodeHaus 3rd party lib ���
	public static boolean checkDuplication_Codehaus() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		User user01 = new User();
		user01.setUserId("botom12");

		String url = "http://127.0.0.1:8080/user/json/checkDuplication/" + user01.getUserId();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(user01);

		HttpEntity httpEntity = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity);

		HttpResponse httpResponse = httpClient.execute(httpPost);

		HttpEntity responseEntity = httpResponse.getEntity();

		InputStream is = responseEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		Object obj = JSONValue.parse(br);
		if (obj instanceof Boolean) {
			boolean result = (Boolean) obj;
			System.out.println(result);
			return (Boolean) obj;
		} else {
			throw new Exception("JSONObject �� �ƴϾ�.");
		}
	}

//================================================================//

	//4.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
	public static void listUser_JsonSimple() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/listUser";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println(jsonobj);

		JSONArray userList = (JSONArray) jsonobj.get("list");
		System.out.println("JSON Response: " + jsonobj);
		System.out.println("User List: " + userList);

	}

	//4.2 Http Protocol GET Request : CodeHaus 3rd party lib ���
	public static void listUser_Codehaus() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/listUser";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(serverData, new TypeReference<Map<String, Object>>() {
		});

		System.out.println("JSON Response: " + map);

		List<Object> userList = (List<Object>) map.get("list");
		System.out.println("User List: " + userList);
	}

//================================================================//

	//5.1 Http Protocol Post ��� Request : JsonSimple 3rd party lib ���
	public static void addUser_JsonSimple() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/addUser";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		User user = new User();
		user.setUserId("botom123");
		user.setPassword("1234");
		user.setUserName("ȫ�浿");
		user.setPhone("010-1234-5678");
		user.setAddr("�뱸");
		user.setEmail("botom12@naver.com");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(user);

		HttpEntity httpEntity = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity);

		HttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity responseEntity = httpResponse.getEntity();

		InputStream is = responseEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		Object obj = JSONValue.parse(br);
		if (obj instanceof JSONObject) {
			JSONObject result = (JSONObject) obj;
			System.out.println(result);
		} else {
			throw new Exception("JSONObject �� �ƴϾ�.");
		}

	}

	//5.2 Http Protocol Post ��� Request : CodeHaus 3rd party lib ���
	public static void addUser_Codehaus() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/addUser";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		User user = new User();
		user.setUserId("botom12");
		user.setPassword("1234");
		user.setUserName("ȫ�浿");
		user.setPhone("010-9876-4321");
		user.setAddr("�뱸");
		user.setEmail("botom12@naver.com");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(user);

		HttpEntity httpEntity = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity);

		HttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity responseEntity = httpResponse.getEntity();

		InputStream is = responseEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		Map<String, Object> responseMap = objectMapper.readValue(br, new TypeReference<Map<String, Object>>() {
		});
		System.out.println(responseMap);
	}

//================================================================//

	//6.1 Http Protocol Post Request : JsonSimple 3rd party lib ���
	public static void updateUser_JsonSimple() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/updateUser/botom12";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		User user = new User();
		user.setUserId("botom12"); // ���̵� ����
		user.setUserName("name");
		user.setPhone("010-3333-3334");
		user.setAddr("�λ�");
		user.setEmail("email@email.com");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(user);

		HttpEntity httpEntity = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity);

		HttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity responseEntity = httpResponse.getEntity();

		InputStream is = responseEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		String serverData = br.readLine();
		System.out.println(serverData);

		Object obj = JSONValue.parse(serverData);
		if (obj instanceof JSONObject) {
			JSONObject result = (JSONObject) obj;
			System.out.println(result);
		} else {
			System.out.println("JsonObject �� �ƴϾ�.");
		}
	}

	//6.2 Http Protocol Post Request : CodeHaus 3rd party lib ���
	public static void updateUser_Codehaus() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/updateUser/botom12";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		User user = new User();
		user.setUserId("botom12"); // ���̵� �����մϴ�.
		user.setUserName("�浿ȫ"); // ���ο� ����� �̸��� �����մϴ�.
		user.setPhone("010-2222-2223"); // ���ο� ��ȭ��ȣ�� �����մϴ�.
		user.setAddr("û��"); // ���ο� �ּҸ� �����մϴ�.
		user.setEmail("gmail@gmail.com"); // ���ο� �̸����� �����մϴ�.

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(user);

		HttpEntity httpEntity = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity);

		HttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity responseEntity = httpResponse.getEntity();

		InputStream is = responseEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		Map<String, Object> responseMap = objectMapper.readValue(br, new TypeReference<Map<String, Object>>() {
		});
		System.out.println(responseMap);
	}

//================================================================//

	//7.1 Http Protocol Get ��� Request : JsonSimple 3rd party lib ���
	public static void logout_JsonSimple() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/logout";
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> �����б�(JSON Value Ȯ��)
		Object obj = JSONValue.parse(serverData);
		if (obj instanceof Boolean) {
			boolean result = (Boolean) obj;
			System.out.println(result);
		} else {
			System.out.println("Received response is not a Boolean.");
		}
	}

	//7.2 Http Protocol Get ��� Request : CodeHaus 3rd party lib ���
	public static void logout_Codehaus() throws Exception {
		// HttpClient : Http Protocol �� client �߻�ȭ
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/logout";
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> �����б�(JSON Value Ȯ��)
		ObjectMapper objectMapper = new ObjectMapper();
		Boolean result = objectMapper.readValue(serverData, Boolean.class);
		System.out.println(result);
	}

//================================================================//

	//8.1 Http Protocol Post ��� Request : JsonSimple 3rd party lib ���
	public static void addProduct_JsonSimple() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Product product = new Product();
		product.setProdName("��ǰ��12");
		product.setProdDetail("������23");
		product.setPrice(50030);
		product.setFileName("������4");
		product.setManuDate("2022-01-05");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(product);

		HttpEntity httpEntity = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity);

		HttpResponse httpResponse = httpClient.execute(httpPost);
		System.out.println(httpResponse);

		HttpEntity responseEntity = httpResponse.getEntity();
		InputStream is = responseEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		Object obj = JSONValue.parse(br);
		if (obj instanceof JSONObject) {
			JSONObject result = (JSONObject) obj;
			System.out.println(result);
		} else {
			throw new Exception("JSONObject �� �ƴϾ�.");
		}
	}

	//8.2 Http Protocol Post ��� Request : Codehaus 3rd party lib ���
	public static void addProduct_Codehaus() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Product product = new Product();
		product.setProdName("��ǰ��12");
		product.setProdDetail("������23");
		product.setPrice(50030);
		product.setFileName("������4");
		product.setManuDate("2022-01-05");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = objectMapper.writeValueAsString(product);

		HttpEntity httpEntity = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity);

		HttpResponse httpResponse = httpClient.execute(httpPost);
		System.out.println(httpResponse);

		HttpEntity responseEntity = httpResponse.getEntity();

		InputStream is = responseEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		Map<String, Object> responseMap = objectMapper.readValue(br, new TypeReference<Map<String, Object>>() {
		});
		System.out.println(responseMap);
	}

//================================================================//

	//9.1 Http Protocol Get Request : JsonSimple 3rd party lib ���
	public static void listProduct_JsonSimpleSearch() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct/search";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("serverData = "+serverData);

		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj"+jsonobj);

		JSONArray productList = (JSONArray) jsonobj.get("list");
		System.out.println("JSON Response: " + jsonobj);
		System.out.println("Product List: " + productList);

	}

	//9.1 Http Protocol Get Request : JsonSimple 3rd party lib ���
	public static void listProduct_JsonSimpleManage() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct/manage";

		// HttpGet : Http Protocol �� GET ��� Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ
		HttpResponse httpResponse = httpClient.execute(httpGet);
		//==> Response Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//==> Response �� entity(DATA) Ȯ��
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("serverData = "+serverData);

		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj"+jsonobj);

		JSONArray productList = (JSONArray) jsonobj.get("list");
		System.out.println("JSON Response: " + jsonobj);
		System.out.println("Product List: " + productList);

	}

	//9.2 Http Protocol Get ��� Request : CodeHaus 3rd party lib ���
	public static void listProduct_CodeHausSearch() throws Exception {
	// HttpClient : Http Protocol �� client �߻�ȭ
	HttpClient httpClient = new DefaultHttpClient();

	String url = "http://127.0.0.1:8080/product/json/listProduct/search";

	// HttpGet : Http Protocol �� GET ��� Request
	HttpGet httpGet = new HttpGet(url);
	httpGet.setHeader("Accept", "application/json");
	httpGet.setHeader("Content-Type", "application/json");

	// HttpResponse : Http Protocol ���� Message �߻�ȭ
	HttpResponse httpResponse = httpClient.execute(httpGet);
	//==> Response Ȯ��
	System.out.println(httpResponse);
	System.out.println();

	//==> Response �� entity(DATA) Ȯ��
	HttpEntity httpEntity = httpResponse.getEntity();

	//==> InputStream ����
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

	System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
	String serverData = br.readLine();
	System.out.println(serverData);

	ObjectMapper objectMapper = new ObjectMapper();
	Map<String, Object> map = objectMapper.readValue(serverData, new TypeReference<Map<String, Object>>() {
	});

		System.out.println("JSON Response: " + map);

	List<Object> productList = (List<Object>) map.get("list");
		System.out.println("Product List: " + productList);
	}

	//9.2 Http Protocol Get ��� Request : CodeHaus 3rd party lib ���
	public static void listProduct_CodeHausManage() throws Exception {
	// HttpClient : Http Protocol �� client �߻�ȭ
	HttpClient httpClient = new DefaultHttpClient();

	String url = "http://127.0.0.1:8080/product/json/listProduct/manage";

	// HttpGet : Http Protocol �� GET ��� Request
	HttpGet httpGet = new HttpGet(url);
	httpGet.setHeader("Accept", "application/json");
	httpGet.setHeader("Content-Type", "application/json");

	// HttpResponse : Http Protocol ���� Message �߻�ȭ
	HttpResponse httpResponse = httpClient.execute(httpGet);
	//==> Response Ȯ��
	System.out.println(httpResponse);
	System.out.println();

	//==> Response �� entity(DATA) Ȯ��
	HttpEntity httpEntity = httpResponse.getEntity();

	//==> InputStream ����
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

	System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
	String serverData = br.readLine();
	System.out.println(serverData);

	ObjectMapper objectMapper = new ObjectMapper();
	Map<String, Object> map = objectMapper.readValue(serverData, new TypeReference<Map<String, Object>>() {
	});

		System.out.println("JSON Response: " + map);

	List<Object> productList = (List<Object>) map.get("list");
		System.out.println("Product List: " + productList);
	}
}
