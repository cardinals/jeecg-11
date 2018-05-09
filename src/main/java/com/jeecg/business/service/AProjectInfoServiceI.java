package com.jeecg.business.service;
import com.jeecg.business.entity.AProjectInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AProjectInfoServiceI extends CommonService{
	
 	public void delete(AProjectInfoEntity entity) throws Exception;
 	
 	public Serializable save(AProjectInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AProjectInfoEntity entity) throws Exception;
 	
}
