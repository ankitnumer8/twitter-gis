/**
 * 
 */
package com.qresq.twitter.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ankit.gupta4
 *
 */
public class EntityReader {

	/**
	 * The logger.
	 */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * Get the unique instnce of entity builder.
	 */
	private static EntityReader instance;

	/**
	 * Json mapper.
	 */
	private ObjectMapper mapper;

	/**
	 * Default constructor.
	 */
	private EntityReader() {
		mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
		mapper.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
	}

	/**
	 * Gets the entity builder.
	 * 
	 * @return the entity builder.
	 */
	public static EntityReader getInstance() {
		if (instance == null) {
			instance = new EntityReader();
		}
		return instance;
	}

	/**
	 * Read file.
	 *
	 * @param <T>
	 *            the generic type
	 * @param fileName
	 *            the file name
	 * @param pojoClass
	 *            the pojo class
	 * @return the list
	 */
	public <T> List<T> readFile(String fileName, Class<T> pojoClass) {
		List<T> list = null;
		try {
			File jsonFile = new File(fileName);
			list = mapper.readValue(jsonFile, mapper.getTypeFactory().constructCollectionType(List.class, pojoClass));
			System.out.println("Records Read in File --> " + fileName + " --> " + list.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
