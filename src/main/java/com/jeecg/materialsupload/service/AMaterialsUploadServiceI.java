package com.jeecg.materialsupload.service;
import com.jeecg.materialsupload.entity.AMaterialsUploadEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AMaterialsUploadServiceI extends CommonService{
	
 	public void delete(AMaterialsUploadEntity entity) throws Exception;
 	
 	public Serializable save(AMaterialsUploadEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AMaterialsUploadEntity entity) throws Exception;
 	
}
