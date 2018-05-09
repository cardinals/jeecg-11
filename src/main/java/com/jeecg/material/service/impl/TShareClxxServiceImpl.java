package com.jeecg.material.service.impl;
import com.jeecg.material.service.TShareClxxServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.material.entity.TShareClxxEntity;
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

@Service("tShareClxxService")
@Transactional
public class TShareClxxServiceImpl extends CommonServiceImpl implements TShareClxxServiceI {

	
 	public void delete(TShareClxxEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TShareClxxEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TShareClxxEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TShareClxxEntity t) throws Exception{
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
	private void doUpdateBus(TShareClxxEntity t) throws Exception{
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
	private void doDelBus(TShareClxxEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TShareClxxEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("clbh", t.getClbh());
		map.put("clmc", t.getClmc());
		map.put("dzhyq", t.getDzhyq());
		map.put("cjsj", t.getCjsj());
		map.put("cjrid", t.getCjrid());
		map.put("xgrid", t.getXgrid());
		map.put("xgsj", t.getXgsj());
		map.put("bz", t.getBz());
		map.put("formver", t.getFormver());
		map.put("patterninstid", t.getPatterninstid());
		map.put("xmlid", t.getXmlid());
		map.put("status", t.getStatus());
		map.put("orinum", t.getOrinum());
		map.put("copynum", t.getCopynum());
		map.put("changetype", t.getChangetype());
		map.put("exchange", t.getExchange());
		map.put("createtime", t.getCreatetime());
		map.put("modifytime", t.getModifytime());
		map.put("yxq", t.getYxq());
		map.put("actiongroup", t.getActiongroup());
		map.put("type", t.getType());
		map.put("hybm", t.getHybm());
		map.put("hyfs", t.getHyfs());
		map.put("hlwdz", t.getHlwdz());
		map.put("jkbh", t.getJkbh());
		map.put("fgw", t.getFgw());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TShareClxxEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{clbh}",String.valueOf(t.getClbh()));
 		sql  = sql.replace("#{clmc}",String.valueOf(t.getClmc()));
 		sql  = sql.replace("#{dzhyq}",String.valueOf(t.getDzhyq()));
 		sql  = sql.replace("#{cjsj}",String.valueOf(t.getCjsj()));
 		sql  = sql.replace("#{cjrid}",String.valueOf(t.getCjrid()));
 		sql  = sql.replace("#{xgrid}",String.valueOf(t.getXgrid()));
 		sql  = sql.replace("#{xgsj}",String.valueOf(t.getXgsj()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
 		sql  = sql.replace("#{formver}",String.valueOf(t.getFormver()));
 		sql  = sql.replace("#{patterninstid}",String.valueOf(t.getPatterninstid()));
 		sql  = sql.replace("#{xmlid}",String.valueOf(t.getXmlid()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{orinum}",String.valueOf(t.getOrinum()));
 		sql  = sql.replace("#{copynum}",String.valueOf(t.getCopynum()));
 		sql  = sql.replace("#{changetype}",String.valueOf(t.getChangetype()));
 		sql  = sql.replace("#{exchange}",String.valueOf(t.getExchange()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{modifytime}",String.valueOf(t.getModifytime()));
 		sql  = sql.replace("#{yxq}",String.valueOf(t.getYxq()));
 		sql  = sql.replace("#{actiongroup}",String.valueOf(t.getActiongroup()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{hybm}",String.valueOf(t.getHybm()));
 		sql  = sql.replace("#{hyfs}",String.valueOf(t.getHyfs()));
 		sql  = sql.replace("#{hlwdz}",String.valueOf(t.getHlwdz()));
 		sql  = sql.replace("#{jkbh}",String.valueOf(t.getJkbh()));
 		sql  = sql.replace("#{fgw}",String.valueOf(t.getFgw()));
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
					javaInter.execute("t_share_clxx",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}