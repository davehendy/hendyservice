package uk.me.hendy.service.utility;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtility {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtility.class);
	
	public static String toJson(Object o) {
		logger.debug("toJson("+o+")");
		ObjectMapper mapper = new ObjectMapper();
		String json=null;
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		logger.debug("json="+json);
		return json;
	}

}
