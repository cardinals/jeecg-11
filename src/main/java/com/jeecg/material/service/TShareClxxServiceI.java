package com.jeecg.material.service;
import com.jeecg.material.entity.TShareClxxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShareClxxServiceI extends CommonService{
	
 	public void delete(TShareClxxEntity entity) throws Exception;
 	
 	public Serializable save(TShareClxxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShareClxxEntity entity) throws Exception;
 	
}
