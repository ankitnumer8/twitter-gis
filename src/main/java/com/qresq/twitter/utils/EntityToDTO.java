package com.qresq.twitter.utils;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.qresq.twitter.dto.PdfDTO;
import com.qresq.twitter.elastic.model.ResearchPaperEsBean;

/**
 * The Class EntityToDTO.
 */
public final class EntityToDTO {
	/**
	 * The unique instance.
	 */
	private static EntityToDTO instance;

	/**
	 * The model mapper.
	 */
	private ModelMapper mapper = new ModelMapper();

	/**
	 * Default constructor.
	 */
	private EntityToDTO() {
		initConfig();
	}

	/**
	 * Initialize.
	 */
	private void initConfig() {
	}

	/**
	 * Gets the unique instance.
	 * 
	 * @return the unique instance.
	 */
	public static EntityToDTO getInstance() {
		if (instance == null) {
			instance = new EntityToDTO();
		}
		return instance;
	}

	/**
	 * Gets the object.
	 *
	 * @param <S>
	 *            the generic type
	 * @param <D>
	 *            the generic type
	 * @param source
	 *            the source
	 * @param sourceClass
	 *            the source class
	 * @param destinationClass
	 *            the destination class
	 * @return the object
	 */
	public <S, D> D getObject(S source, Class<S> sourceClass, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	}

	/**
	 * Gets the object.
	 *
	 * @param paper
	 *            the paper
	 * @return the object
	 */
	public List<PdfDTO> getObject(List<ResearchPaperEsBean> paper) {
		java.lang.reflect.Type targetListType = new TypeToken<List<PdfDTO>>() {
		}.getType();
		return mapper.map(paper, targetListType);
	}
}
