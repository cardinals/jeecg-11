package com.jeecg.childbusiness.service.impl;
import com.jeecg.childbusiness.service.BChildBusinessServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.childbusiness.entity.BChildBusinessEntity;
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

@Service("bChildBusinessService")
@Transactional
public class BChildBusinessServiceImpl extends CommonServiceImpl implements BChildBusinessServiceI {

	
 	public void delete(BChildBusinessEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(BChildBusinessEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(BChildBusinessEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(BChildBusinessEntity t) throws Exception{
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
	private void doUpdateBus(BChildBusinessEntity t) throws Exception{
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
	private void doDelBus(BChildBusinessEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(BChildBusinessEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("business_id", t.getBusinessId());
		map.put("child_business_id", t.getChildBusinessId());
		map.put("project_id", t.getProjectId());
		map.put("phases_id", t.getPhasesId());
		map.put("items_id", t.getItemsId());
		map.put("items_name", t.getItemsName());
		map.put("dept_id", t.getDeptId());
		map.put("dept_name", t.getDeptName());
		map.put("reality_project_name", t.getRealityProjectName());
		map.put("create_time", t.getCreateTime());
		map.put("apply_name", t.getApplyName());
		map.put("apply_company", t.getApplyCompany());
		map.put("apply_phone", t.getApplyPhone());
		map.put("apply_identity_card", t.getApplyIdentityCard());
		map.put("apply_time", t.getApplyTime());
		map.put("ssgzr", t.getSsgzr());
		map.put("status", t.getStatus());
		map.put("check_content", t.getCheckContent());
		map.put("check_time", t.getCheckTime());
		map.put("remark", t.getRemark());
		map.put("certificate_name", t.getCertificateName());
		map.put("certificate_path", t.getCertificatePath());
		map.put("certificate_time", t.getCertificateTime());
		map.put("create_by", t.getCreateBy());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,BChildBusinessEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{business_id}",String.valueOf(t.getBusinessId()));
 		sql  = sql.replace("#{child_business_id}",String.valueOf(t.getChildBusinessId()));
 		sql  = sql.replace("#{project_id}",String.valueOf(t.getProjectId()));
 		sql  = sql.replace("#{phases_id}",String.valueOf(t.getPhasesId()));
 		sql  = sql.replace("#{items_id}",String.valueOf(t.getItemsId()));
 		sql  = sql.replace("#{items_name}",String.valueOf(t.getItemsName()));
 		sql  = sql.replace("#{dept_id}",String.valueOf(t.getDeptId()));
 		sql  = sql.replace("#{dept_name}",String.valueOf(t.getDeptName()));
 		sql  = sql.replace("#{reality_project_name}",String.valueOf(t.getRealityProjectName()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{apply_name}",String.valueOf(t.getApplyName()));
 		sql  = sql.replace("#{apply_company}",String.valueOf(t.getApplyCompany()));
 		sql  = sql.replace("#{apply_phone}",String.valueOf(t.getApplyPhone()));
 		sql  = sql.replace("#{apply_identity_card}",String.valueOf(t.getApplyIdentityCard()));
 		sql  = sql.replace("#{apply_time}",String.valueOf(t.getApplyTime()));
 		sql  = sql.replace("#{ssgzr}",String.valueOf(t.getSsgzr()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{check_content}",String.valueOf(t.getCheckContent()));
 		sql  = sql.replace("#{check_time}",String.valueOf(t.getCheckTime()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{certificate_name}",String.valueOf(t.getCertificateName()));
 		sql  = sql.replace("#{certificate_path}",String.valueOf(t.getCertificatePath()));
 		sql  = sql.replace("#{certificate_time}",String.valueOf(t.getCertificateTime()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
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
					javaInter.execute("b_child_business",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}