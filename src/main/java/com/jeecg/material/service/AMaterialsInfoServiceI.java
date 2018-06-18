package com.jeecg.material.service;
import com.jeecg.material.entity.AMaterialsInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AMaterialsInfoServiceI extends CommonService{
	
 	public void delete(AMaterialsInfoEntity entity) throws Exception;
 	
 	public Serializable save(AMaterialsInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AMaterialsInfoEntity entity) throws Exception;
 	
}
