package com.jeecg.phases.service;
import com.jeecg.phases.entity.APhasesInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface APhasesInfoServiceI extends CommonService{
	
 	public void delete(APhasesInfoEntity entity) throws Exception;
 	
 	public Serializable save(APhasesInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(APhasesInfoEntity entity) throws Exception;
 	
}
