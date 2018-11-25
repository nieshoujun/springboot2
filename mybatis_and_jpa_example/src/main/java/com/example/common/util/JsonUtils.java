package com.example.common.util;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class JsonUtils {

	private final static Log log = LogFactory.getLog(JsonUtils.class);
	private final static String resultFlag = "result";

	private final static BASE64Encoder BASE64_ENCODER = new BASE64Encoder();

	private final static BASE64Decoder BASE64_DECODER = new BASE64Decoder();

	/**
	 * Gson转换工具
	 */
	public static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	public static void write(HttpServletResponse response, JSON json) {
		write(response, json.toString());
	}

	public static void write(HttpServletResponse response, String str) {
		response.setContentType("text/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().println(str);
			response.getWriter().close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public static JSONObject write(String key, Object value) {
		JSONObject o = new JSONObject();
		o.put(key, value);
		return o;
	}

	public static JSONObject write(Object value) {
		JSONObject o = new JSONObject();
		o.put(resultFlag, value);
		return o;
	}

	public static JSONObject getSuccess() {
		JSONObject o = new JSONObject();
		o.put(resultFlag, true);
		return o;
	}

	public static JSONObject getFailure() {
		JSONObject o = new JSONObject();
		o.put(resultFlag, false);
		return o;
	}

	public static JSONObject getFailure(String msg) {
		JSONObject o = getFailure();
		o.put("msg", msg);
		return o;
	}

	public static JSONObject getSuccess(String msg) {
		JSONObject o = getSuccess();
		o.put("msg", msg);
		return o;
	}

	public static JSONObject getJSONObject(Object object) {
		JSONObject o = JSONObject.fromObject(object);
		if (object != null)
			o.put("msg", true);
		else
			o.put("msg", false);
		return o;
	}

	public static List<Map<String, String>> jsonStringToList(String jsonString) throws Exception {
		JSONArray arry = JSONArray.fromObject(jsonString);
		List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();
		for (int i = 0; i < arry.size(); i++) {
			JSONObject jsonObject = arry.getJSONObject(i);
			Map<String, String> map = new HashMap<String, String>();
			for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();) {
				String key = (String) iter.next();
				String value = jsonObject.get(key).toString();
				map.put(key, value);
			}
			rsList.add(map);
		}
		return rsList;
	}


	public static Map<String, Object> removeNullValues(Map<String, Object> inputMap) {
		Map<String, Object> outputMap = new HashMap<String, Object>();
		Iterator entries = inputMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				log.warn("[removeNullValues] the value is null, will remove key : " + key);
				continue;
			}
			if (value instanceof Map) {
				log.warn("[removeNullValues] a second level map in input map. recall the filter function.");
				value = removeNullValues((Map<String, Object>) value);
			}

			outputMap.put(key, value);
		}
		return outputMap;
	}

	public static Map<String, Object> replaceNullValues(Map<String, Object> inputMap) {
		Map<String, Object> outputMap = new HashMap<String, Object>();
		Iterator entries = inputMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				log.warn("[removeNullValues] the value is null, will put empty string as value key : " + key);
				value = "";
			}
			if (value instanceof Map) {
				log.warn("[removeNullValues] a second level map in input map. recall the filter function.");
				value = replaceNullValues((Map<String, Object>) value);
			}

			outputMap.put(key, value);
		}
		return outputMap;
	}

	public static void nullValuesToString(Map<String, Object> map) {
		Iterator entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				map.put(key, "");
				continue;
			}
			if (value instanceof Map) {
				log.warn("[removeNullValues] a second level map in input map. recall the filter function.");
				nullValuesToString((Map<String, Object>) value);
			}
		}
	}


	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		// Map<String, Object> map = new HashMap<String, Object>();
		// UserInfo userInfo2 = new UserInfo();
		// userInfo2.setDeptId(3l);
		// // map.put("b", userInfo);
		// // map.put("c", userInfo2);
		// // map.put("d", userInfo3);
		// JSONObject json = new JSONObject();
		// // JsonUtils.putAll(json, map, null);
		// json.put("a", userInfo2);
		//
		// System.out.println(json);

		Map<String, Object> testInputMap = new HashMap<String, Object>();
		Map<String, Object> secondLevelMap = new HashMap<String, Object>();
		secondLevelMap.put("1", new Object());
		secondLevelMap.put("2", new Object());
		secondLevelMap.put("3", new Object());
		secondLevelMap.put("4", new Object());
		secondLevelMap.put("5", null);
		secondLevelMap.put("6", new Object());
		testInputMap.put("1", new Object());
		testInputMap.put("2", new Object());
		testInputMap.put("3", new Object());
		testInputMap.put("4", null);
		testInputMap.put("5", secondLevelMap);

		Map<String, Object> testOutputMap = removeNullValues(testInputMap);
		Iterator entries = testOutputMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			Object value = (Object) entry.getValue();
			System.out.println("Key = " + key + ", Value = " + value);

		}

	}

	public static Object getObjByJsonStr(String jsonString, Class pojoCalss) {
		Object pojo = null;
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		pojo = JSONObject.toBean(jsonObject, pojoCalss);
		return pojo;
	}

	public static Object getObjByJsonStr(String jsonString, Class pojoCalss, Map classMap) {
		Object pojo = null;
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		pojo = JSONObject.toBean(jsonObject, pojoCalss, classMap);
		return pojo;
	}

	public static Map jsonStringToMap(String jsonString) throws Exception {
		JSONObject jsonObj = JSONObject.fromObject(jsonString);
		Iterator<String> nameItr = jsonObj.keys();
		String name;
		Map<String, String> outMap = new HashMap<String, String>();
		while (nameItr.hasNext()) {
			name = nameItr.next();
			outMap.put(name, jsonObj.getString(name));
		}
		return outMap;
	}

	/**
	 * 
	 * @param parameterMap
	 * @return
	 * @author: xuefeng
	 * @email: xuefeng6@xdf.cn
	 * @创建日期: 2016年8月30日
	 * @功能说明: 根据Parameter生成Map
	 */
	public static Map getMapByParameter(Map<String, String[]> parameterMap) {
		Iterator<String> keys = parameterMap.keySet().iterator();
		Map<String, String> param = new HashMap<String, String>();
		while (keys.hasNext()) {
			String key = keys.next();
			if (null != parameterMap.get(key) && parameterMap.get(key).length > 0) {
				param.put(key, parameterMap.get(key)[0]);
			}
		}
		return param;
	}


	/**
	 * 
	 * @param str
	 * @return
	 * @author: xuefeng
	 * @email: xuefeng6@xdf.cn
	 * @创建日期: 2016年12月26日
	 * @功能说明: BASE64Encoder encode
	 */
	public static String encode(String str) {
		try {
			return BASE64_ENCODER.encode(str.getBytes());
		} catch (Exception e) {
			log.error("BASE64Encoder失败");
		}
		return str;
	}

	/**
	 * 
	 * @param str
	 * @return
	 * @author: xuefeng
	 * @email: xuefeng6@xdf.cn
	 * @创建日期: 2016年12月26日
	 * @功能说明: BASE64Decoder decode
	 */
	public static String decode(String str) {
		try {
			return new String(BASE64_DECODER.decodeBuffer(str));
		} catch (Exception e) {
			log.error("BASE64Decoder失败");
		}
		return str;
	}

	/**
	 * 随机指定范围内N个不重复的数 最简单最基本的方法
	 * 
	 * @param min(指定范围最小值)
	 * @param max(指定范围最大值)
	 * @param n(随机数个数)
	 */
	public static int[] randomCommon(int min, int max, int n) {
		if (n > (max - min + 1) || max < min) {
			return null;
		}
		int[] result = new int[n];
		int count = 0;
		while (count < n) {
			int num = (int) (Math.random() * (max - min)) + min;
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (num == result[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result[count] = num;
				count++;
			}
		}
		return result;
	}

	public static  String usefastjsoncorvetjavebean(Object ob){
		return com.alibaba.fastjson.JSON.toJSONString(ob, SerializerFeature.PrettyFormat,
				SerializerFeature.WriteMapNullValue).replaceAll("null","\"\"");
	}
}
