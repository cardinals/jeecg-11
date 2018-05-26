package com.jeecg.items.service;
import com.jeecg.items.entity.AItemsInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AItemsInfoServiceI extends CommonService{
	
 	public void delete(AItemsInfoEntity entity) throws Exception;
 	
 	public Serializable save(AItemsInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AItemsInfoEntity entity) throws Exception;
 	
}
