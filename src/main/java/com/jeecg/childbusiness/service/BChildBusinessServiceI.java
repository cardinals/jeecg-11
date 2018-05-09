package com.jeecg.childbusiness.service;
import com.jeecg.childbusiness.entity.BChildBusinessEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BChildBusinessServiceI extends CommonService{
	
 	public void delete(BChildBusinessEntity entity) throws Exception;
 	
 	public Serializable save(BChildBusinessEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BChildBusinessEntity entity) throws Exception;
 	
}
