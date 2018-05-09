package com.jeecg.multiple.service.impl;
import com.jeecg.multiple.service.BProjectBusinessServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.multiple.entity.BProjectBusinessEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("bProjectBusinessService")
@Transactional
public class BProjectBusinessServiceImpl extends CommonServiceImpl implements BProjectBusinessServiceI {

	
 	public void delete(BProjectBusinessEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(BProjectBusinessEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(BProjectBusinessEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(BProjectBusinessEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(BProjectBusinessEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(BProjectBusinessEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(BProjectBusinessEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("business_id", t.getBusinessId());
		map.put("project_id", t.getProjectId());
		map.put("project_name", t.getProjectName());
		map.put("project_status", t.getProjectStatus());
		map.put("certificate_status", t.getCertificateStatus());
		map.put("current_phases", t.getCurrentPhases());
		map.put("current_phases_status", t.getCurrentPhasesStatus());
		map.put("create_time", t.getCreateTime());
		map.put("complete_time", t.getCompleteTime());
		map.put("apply_name", t.getApplyName());
		map.put("apply_company", t.getApplyCompany());
		map.put("business_license_id", t.getBusinessLicenseId());
		map.put("legal_person_card", t.getLegalPersonCard());
		map.put("apply_identity_card", t.getApplyIdentityCard());
		map.put("apply_phone", t.getApplyPhone());
		map.put("reality_project_name", t.getRealityProjectName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,BProjectBusinessEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{business_id}",String.valueOf(t.getBusinessId()));
 		sql  = sql.replace("#{project_id}",String.valueOf(t.getProjectId()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{project_status}",String.valueOf(t.getProjectStatus()));
 		sql  = sql.replace("#{certificate_status}",String.valueOf(t.getCertificateStatus()));
 		sql  = sql.replace("#{current_phases}",String.valueOf(t.getCurrentPhases()));
 		sql  = sql.replace("#{current_phases_status}",String.valueOf(t.getCurrentPhasesStatus()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{complete_time}",String.valueOf(t.getCompleteTime()));
 		sql  = sql.replace("#{apply_name}",String.valueOf(t.getApplyName()));
 		sql  = sql.replace("#{apply_company}",String.valueOf(t.getApplyCompany()));
 		sql  = sql.replace("#{business_license_id}",String.valueOf(t.getBusinessLicenseId()));
 		sql  = sql.replace("#{legal_person_card}",String.valueOf(t.getLegalPersonCard()));
 		sql  = sql.replace("#{apply_identity_card}",String.valueOf(t.getApplyIdentityCard()));
 		sql  = sql.replace("#{apply_phone}",String.valueOf(t.getApplyPhone()));
 		sql  = sql.replace("#{reality_project_name}",String.valueOf(t.getRealityProjectName()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("b_project_business",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}