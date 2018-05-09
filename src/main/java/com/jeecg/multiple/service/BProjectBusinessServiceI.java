package com.jeecg.multiple.service;
import com.jeecg.multiple.entity.BProjectBusinessEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BProjectBusinessServiceI extends CommonService{
	
 	public void delete(BProjectBusinessEntity entity) throws Exception;
 	
 	public Serializable save(BProjectBusinessEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BProjectBusinessEntity entity) throws Exception;
 	
}
