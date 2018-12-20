package com.qresq.twitter.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qresq.twitter.dao.EsGpuDAO;
import com.qresq.twitter.elastic.model.GpuEsBean;
import com.qresq.twitter.exception.DAOException;
import com.qresq.twitter.exception.ServiceException;
import com.qresq.twitter.service.GpuService;
import com.qresq.twitter.utils.EntityReader;

/**
 * The Class HotelUploadServiceImpl.
 */
@Service
public class GpuServiceImpl implements GpuService {

	/** The logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GpuServiceImpl.class);

	@Autowired
	private EsGpuDAO gpuDao;

	@Override
	public boolean saveGpuData(String gpuFile) throws ServiceException {
		try {
			List<GpuEsBean> gpuList = EntityReader.getInstance().readFile(gpuFile, GpuEsBean.class);
			gpuDao.injectGpuData(gpuList);
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<GpuEsBean> searchByCompany(List<String> company) throws ServiceException {
		try {
			return gpuDao.searchByCompany(company);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<GpuEsBean> searchByText(String text) throws ServiceException {
		try {
			return gpuDao.searchByText(text);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
