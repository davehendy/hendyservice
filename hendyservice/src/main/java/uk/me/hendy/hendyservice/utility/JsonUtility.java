package uk.me.hendy.hendyservice.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonUtility {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtility.class);
	
	public static String toJson(Object o, boolean pretty) {
		logger.debug("toJson("+o+")");
		ObjectMapper mapper = new ObjectMapper();
		String json=null;
		try {
			if (pretty) {
				json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
			} else {
				json = mapper.writeValueAsString(o);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		logger.debug("json="+json);
		return json;
	}

}
