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
		// 주석을 하나씩 처리해가며 실습
		////////////////////////////////////////////////////////////////////////////////////////////

//		System.out.println("\n====================================\n");
//		1.1 Http Get 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp.getUserTest_JsonSimple();

//		System.out.println("\n====================================\n");
//		1.2 Http Get 방식 Request : CodeHaus lib 사용
//		RestHttpClientApp.getUserTest_Codehaus();

//		System.out.println("\n====================================\n");
//		2.1 Http Post 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp.LoginTest_JsonSimple();

//		System.out.println("\n====================================\n");
//		2.2 Http Post 방식 Request : CodeHaus lib 사용
//		RestHttpClientApp.LoginTest_Codehaus();

//		System.out.println("\n====================================\n");
//		3.1 Http Get 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp.checkDuplication_JsonSimple();

//		System.out.println("\n====================================\n");
//		3.2 Http Get 방식 Request : CodeHaus lib 사용
//		RestHttpClientApp.checkDuplication_Codehaus();
//
//		System.out.println("\n====================================\n");
//		4.1 Http Get 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp.listUser_JsonSimple();

//		System.out.println("\n====================================\n");
//		4.2 Http Get 방식 Request : CodeHaus lib 사용
//		RestHttpClientApp.listUser_Codehaus();

//		System.out.println("\n====================================\n");
//		5.1 Http Post 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp.addUser_JsonSimple();

//		System.out.println("\n====================================\n");
//		5.2 Http Post 방식 Request : CodeHaus lib 사용
//		RestHttpClientApp.addUser_Codehaus();

//		System.out.println("\n====================================\n");
//		6.1 Http Put 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp.updateUser_JsonSimple();

//		System.out.println("\n====================================\n");
//		6.2 Http Put 방식 Request : CodeHaus lib 사용
//		RestHttpClientApp.updateUser_Codehaus();

//		System.out.println("\n====================================\n");
//		7.1 Http Get 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp.logout_JsonSimple();

//		System.out.println("\n====================================\n");
//		7.2 Http Get 방식 Request : CodeHaus lib 사용
//		RestHttpClientApp.logout_Codehaus();

//		System.out.println("\n====================================\n");
//		8.1 Http Post 방식 Request : JsonSimple lib 사용
//		RestHttpClientApp.addProduct_JsonSimple();

//		System.out.println("\n====================================\n");
//		8.2 Http Post 방식 Request : Codehaus lib 사용
//		RestHttpClientApp.addProduct_Codehaus();

//		System.out.println("\n====================================\n");
//		9.1 Http Get 방식 Request : Codehaus lib 사용
//		RestHttpClientApp.listProduct_JsonSimpleSearch();

//		System.out.println("\n====================================\n");
//		9.1 Http Get 방식 Request : Codehaus lib 사용
//		RestHttpClientApp.listProduct_JsonSimpleManage();

//		System.out.println("\n====================================\n");
//		9.2 Http Get 방식 Request : Codehaus lib 사용
//		RestHttpClientApp.listProduct_CodeHausSearch();

//		System.out.println("\n====================================\n");
//		9.2 Http Get 방식 Request : Codehaus lib 사용
//		RestHttpClientApp.listProduct_CodeHausManage();
	}

//================================================================//

	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib 사용
	public static void getUserTest_JsonSimple() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/getUser/admin";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}

	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib 사용
	public static void getUserTest_Codehaus() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/getUser/admin";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(jsonobj.toString(), User.class);
		System.out.println(user);
	}

//================================================================//	

//================================================================//

	//2.1 Http Protocol POST Request : FromData 전달 / JsonSimple 3rd party lib 사용
	public static void LoginTest_JsonSimple() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/login";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		//[ 방법 1 : String 사용]
//			String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//			HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

		//[ 방법 2 : JSONObject 사용]
		JSONObject json = new JSONObject();
		json.put("userId", "admin");
		json.put("password", "1234");
		HttpEntity httpEntity01 = new StringEntity(json.toString(), "utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println(jsonobj);

	}

	//2.2 Http Protocol POST 방식 Request : FromData전달 
	//==> JsonSimple + codehaus 3rd party lib 사용
	public static void LoginTest_Codehaus() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/login";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

//		//[ 방법 1 : String 사용]
//		String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");

//		//[ 방법 2 : JSONObject 사용]
//		JSONObject json = new JSONObject();
//		json.put("userId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");

		//[ 방법 3 : codehaus 사용]
		User user01 = new User();
		user01.setUserId("admin");
		user01.setPassword("1234");
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(user01);

		System.out.println(jsonValue);

		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");

		httpPost.setEntity(httpEntity01);
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(jsonobj.toString(), User.class);
		System.out.println(user);
	}

//================================================================//

	//3.1 Http Protocol Post 방식 Request : UserId 중복체크 : JsonSimple 3rd party lib 사용
	public static void checkDuplication_JsonSimple() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/checkDuplication/botom12";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		Object obj = JSONValue.parse(serverData);
		if (obj instanceof JSONObject) {
			JSONObject jsonobj = (JSONObject) obj;
			System.out.println(jsonobj);
		} else {
			System.out.println("JSONObject 가 아니야.");
		}
	}

	//3.2 Http Protocol Post 방식 Request : UserId 중복체크 : CodeHaus 3rd party lib 사용
	public static boolean checkDuplication_Codehaus() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화
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
			throw new Exception("JSONObject 가 아니야.");
		}
	}

//================================================================//

	//4.1 Http Protocol GET Request : JsonSimple 3rd party lib 사용
	public static void listUser_JsonSimple() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/listUser";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println(jsonobj);

		JSONArray userList = (JSONArray) jsonobj.get("list");
		System.out.println("JSON Response: " + jsonobj);
		System.out.println("User List: " + userList);

	}

	//4.2 Http Protocol GET Request : CodeHaus 3rd party lib 사용
	public static void listUser_Codehaus() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/listUser";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
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

	//5.1 Http Protocol Post 방식 Request : JsonSimple 3rd party lib 사용
	public static void addUser_JsonSimple() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/addUser";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		User user = new User();
		user.setUserId("botom123");
		user.setPassword("1234");
		user.setUserName("홍길동");
		user.setPhone("010-1234-5678");
		user.setAddr("대구");
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
			throw new Exception("JSONObject 가 아니야.");
		}

	}

	//5.2 Http Protocol Post 방식 Request : CodeHaus 3rd party lib 사용
	public static void addUser_Codehaus() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/addUser";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		User user = new User();
		user.setUserId("botom12");
		user.setPassword("1234");
		user.setUserName("홍길동");
		user.setPhone("010-9876-4321");
		user.setAddr("대구");
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

	//6.1 Http Protocol Post Request : JsonSimple 3rd party lib 사용
	public static void updateUser_JsonSimple() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/updateUser/botom12";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		User user = new User();
		user.setUserId("botom12"); // 아이디 설정
		user.setUserName("name");
		user.setPhone("010-3333-3334");
		user.setAddr("부산");
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
			System.out.println("JsonObject 가 아니야.");
		}
	}

	//6.2 Http Protocol Post Request : CodeHaus 3rd party lib 사용
	public static void updateUser_Codehaus() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/updateUser/botom12";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		User user = new User();
		user.setUserId("botom12"); // 아이디를 설정합니다.
		user.setUserName("길동홍"); // 새로운 사용자 이름을 설정합니다.
		user.setPhone("010-2222-2223"); // 새로운 전화번호를 설정합니다.
		user.setAddr("청주"); // 새로운 주소를 설정합니다.
		user.setEmail("gmail@gmail.com"); // 새로운 이메일을 설정합니다.

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

	//7.1 Http Protocol Get 방식 Request : JsonSimple 3rd party lib 사용
	public static void logout_JsonSimple() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/logout";
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		Object obj = JSONValue.parse(serverData);
		if (obj instanceof Boolean) {
			boolean result = (Boolean) obj;
			System.out.println(result);
		} else {
			System.out.println("Received response is not a Boolean.");
		}
	}

	//7.2 Http Protocol Get 방식 Request : CodeHaus 3rd party lib 사용
	public static void logout_Codehaus() throws Exception {
		// HttpClient : Http Protocol 의 client 추상화
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/user/json/logout";
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		ObjectMapper objectMapper = new ObjectMapper();
		Boolean result = objectMapper.readValue(serverData, Boolean.class);
		System.out.println(result);
	}

//================================================================//

	//8.1 Http Protocol Post 방식 Request : JsonSimple 3rd party lib 사용
	public static void addProduct_JsonSimple() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Product product = new Product();
		product.setProdName("상품명12");
		product.setProdDetail("상세정보23");
		product.setPrice(50030);
		product.setFileName("수정중4");
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
			throw new Exception("JSONObject 가 아니야.");
		}
	}

	//8.2 Http Protocol Post 방식 Request : Codehaus 3rd party lib 사용
	public static void addProduct_Codehaus() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/addProduct";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Product product = new Product();
		product.setProdName("상품명12");
		product.setProdDetail("상세정보23");
		product.setPrice(50030);
		product.setFileName("수정중4");
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

	//9.1 Http Protocol Get Request : JsonSimple 3rd party lib 사용
	public static void listProduct_JsonSimpleSearch() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct/search";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println("serverData = "+serverData);

		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj"+jsonobj);

		JSONArray productList = (JSONArray) jsonobj.get("list");
		System.out.println("JSON Response: " + jsonobj);
		System.out.println("Product List: " + productList);

	}

	//9.1 Http Protocol Get Request : JsonSimple 3rd party lib 사용
	public static void listProduct_JsonSimpleManage() throws Exception {
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/product/json/listProduct/manage";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);
		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println("serverData = "+serverData);

		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj"+jsonobj);

		JSONArray productList = (JSONArray) jsonobj.get("list");
		System.out.println("JSON Response: " + jsonobj);
		System.out.println("Product List: " + productList);

	}

	//9.2 Http Protocol Get 방식 Request : CodeHaus 3rd party lib 사용
	public static void listProduct_CodeHausSearch() throws Exception {
	// HttpClient : Http Protocol 의 client 추상화
	HttpClient httpClient = new DefaultHttpClient();

	String url = "http://127.0.0.1:8080/product/json/listProduct/search";

	// HttpGet : Http Protocol 의 GET 방식 Request
	HttpGet httpGet = new HttpGet(url);
	httpGet.setHeader("Accept", "application/json");
	httpGet.setHeader("Content-Type", "application/json");

	// HttpResponse : Http Protocol 응답 Message 추상화
	HttpResponse httpResponse = httpClient.execute(httpGet);
	//==> Response 확인
	System.out.println(httpResponse);
	System.out.println();

	//==> Response 중 entity(DATA) 확인
	HttpEntity httpEntity = httpResponse.getEntity();

	//==> InputStream 생성
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

	System.out.println("[ Server 에서 받은 Data 확인 ] ");
	String serverData = br.readLine();
	System.out.println(serverData);

	ObjectMapper objectMapper = new ObjectMapper();
	Map<String, Object> map = objectMapper.readValue(serverData, new TypeReference<Map<String, Object>>() {
	});

		System.out.println("JSON Response: " + map);

	List<Object> productList = (List<Object>) map.get("list");
		System.out.println("Product List: " + productList);
	}

	//9.2 Http Protocol Get 방식 Request : CodeHaus 3rd party lib 사용
	public static void listProduct_CodeHausManage() throws Exception {
	// HttpClient : Http Protocol 의 client 추상화
	HttpClient httpClient = new DefaultHttpClient();

	String url = "http://127.0.0.1:8080/product/json/listProduct/manage";

	// HttpGet : Http Protocol 의 GET 방식 Request
	HttpGet httpGet = new HttpGet(url);
	httpGet.setHeader("Accept", "application/json");
	httpGet.setHeader("Content-Type", "application/json");

	// HttpResponse : Http Protocol 응답 Message 추상화
	HttpResponse httpResponse = httpClient.execute(httpGet);
	//==> Response 확인
	System.out.println(httpResponse);
	System.out.println();

	//==> Response 중 entity(DATA) 확인
	HttpEntity httpEntity = httpResponse.getEntity();

	//==> InputStream 생성
	InputStream is = httpEntity.getContent();
	BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

	System.out.println("[ Server 에서 받은 Data 확인 ] ");
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
