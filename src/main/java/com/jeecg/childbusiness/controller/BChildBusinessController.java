package com.jeecg.childbusiness.controller;
import com.jeecg.childbusiness.entity.BChildBusinessEntity;
import com.jeecg.childbusiness.service.BChildBusinessServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: B_CHILD_BUSINESS
 * @author onlineGenerator
 * @date 2018-05-08 10:03:17
 * @version V1.0   
 *
 */
@Api(value="BChildBusiness",description="B_CHILD_BUSINESS",tags="bChildBusinessController")
@Controller
@RequestMapping("/bChildBusinessController")
public class BChildBusinessController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BChildBusinessController.class);

	@Autowired
	private BChildBusinessServiceI bChildBusinessService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * B_CHILD_BUSINESS列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/childbusiness/bChildBusinessList");
	}

	/**
	 * 子业务统计分析 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "statisticsList")
	public ModelAndView statisticsList(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/childbusiness/bChildStatisticsList");
	}

	/**
	 * 时限监控 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "limitList")
	public ModelAndView limitList(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/childbusiness/bChildLimitList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(BChildBusinessEntity bChildBusiness,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BChildBusinessEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bChildBusiness, request.getParameterMap());
		TSUser user = ResourceUtil.getSessionUser();
		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
		}else{
			cq.eq("deptId",user.getDepartid());
		}
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.bChildBusinessService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * easyui AJAX请求数据
	 *
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "limitDatagrid")
	public void limitDatagrid(BChildBusinessEntity bChildBusiness,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(BChildBusinessEntity.class, dataGrid);
//		//查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bChildBusiness, request.getParameterMap());
//		TSUser user = ResourceUtil.getSessionUser();
//		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
//		}else{
//			cq.eq("deptId",user.getDepartid());
//		}
//		try{
//			//自定义追加查询条件
//		}catch (Exception e) {
//			throw new BusinessException(e.getMessage());
//		}
//		cq.add();
//		this.bChildBusinessService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		String condition ="";
		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
		}else{
			condition += "and a.dept_id ='" +user.getDepartid() +"'";
		}
		String sql = "select func_getLimitDate(a.confirm_upload_time,'G',2) AS ENDTIME," +
				"case when SYSDATE > func_getLimitDate(a.confirm_upload_time,'G',1) AND a.CHECK_TIME is NULL then '超期'" +
				"     when SYSDATE > func_getLimitDate(a.confirm_upload_time,'G',1) AND a.CHECK_TIME >func_getLimitDate(a.confirm_upload_time,'G',1) then '超期'" +
				"     when a.check_status ='0' and SYSDATE > func_getLimitDate(a.confirm_upload_time,'G',1) " +
				"       and a.CHECK_TIME < a.confirm_upload_time then '超期'  " +
				"     else '正常' end jcstatus ,a.*" +
				"from B_CHILD_BUSINESS a where 1=1 " +condition;


		List<Map<String, Object>> resultList =  systemService.findForJdbc(sql,dataGrid.getPage(),dataGrid.getRows());
		//将List转换成JSON存储
		dataGrid.setResults(resultList);
		String getCountSql ="SELECT count(1) as count from B_CHILD_BUSINESS a where 1=1 " + condition;
		List<Map<String, Object>> resultList2 =  systemService.findForJdbc(getCountSql);
		Object count = resultList2.get(0).get("count");

		dataGrid.setTotal(Integer.valueOf(count.toString()));
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除B_CHILD_BUSINESS
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BChildBusinessEntity bChildBusiness, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		bChildBusiness = systemService.getEntity(BChildBusinessEntity.class, bChildBusiness.getId());
		message = "B_CHILD_BUSINESS删除成功";
		try{
			bChildBusinessService.delete(bChildBusiness);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "B_CHILD_BUSINESS删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除B_CHILD_BUSINESS
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "B_CHILD_BUSINESS删除成功";
		try{
			for(String id:ids.split(",")){
				BChildBusinessEntity bChildBusiness = systemService.getEntity(BChildBusinessEntity.class, 
				id
				);
				bChildBusinessService.delete(bChildBusiness);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "B_CHILD_BUSINESS删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加B_CHILD_BUSINESS
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BChildBusinessEntity bChildBusiness, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "B_CHILD_BUSINESS添加成功";
		try{
			bChildBusinessService.save(bChildBusiness);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "B_CHILD_BUSINESS添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新B_CHILD_BUSINESS
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BChildBusinessEntity bChildBusiness, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "B_CHILD_BUSINESS更新成功";
		BChildBusinessEntity t = bChildBusinessService.get(BChildBusinessEntity.class, bChildBusiness.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(bChildBusiness, t);
			bChildBusinessService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "B_CHILD_BUSINESS更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * B_CHILD_BUSINESS新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BChildBusinessEntity bChildBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bChildBusiness.getId())) {
			bChildBusiness = bChildBusinessService.getEntity(BChildBusinessEntity.class, bChildBusiness.getId());
			req.setAttribute("bChildBusinessPage", bChildBusiness);
		}
		return new ModelAndView("com/jeecg/childbusiness/bChildBusiness-add");
	}
	/**
	 * B_CHILD_BUSINESS编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BChildBusinessEntity bChildBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bChildBusiness.getId())) {
			bChildBusiness = bChildBusinessService.getEntity(BChildBusinessEntity.class, bChildBusiness.getId());
			req.setAttribute("bChildBusinessPage", bChildBusiness);
		}
		return new ModelAndView("com/jeecg/childbusiness/bChildBusiness-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","bChildBusinessController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BChildBusinessEntity bChildBusiness,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BChildBusinessEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bChildBusiness, request.getParameterMap());
		List<BChildBusinessEntity> bChildBusinesss = this.bChildBusinessService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"B_CHILD_BUSINESS");
		modelMap.put(NormalExcelConstants.CLASS,BChildBusinessEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("B_CHILD_BUSINESS列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,bChildBusinesss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BChildBusinessEntity bChildBusiness,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"B_CHILD_BUSINESS");
    	modelMap.put(NormalExcelConstants.CLASS,BChildBusinessEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("B_CHILD_BUSINESS列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<BChildBusinessEntity> listBChildBusinessEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BChildBusinessEntity.class,params);
				for (BChildBusinessEntity bChildBusiness : listBChildBusinessEntitys) {
					bChildBusinessService.save(bChildBusiness);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="B_CHILD_BUSINESS列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BChildBusinessEntity>> list() {
		List<BChildBusinessEntity> listBChildBusinesss=bChildBusinessService.getList(BChildBusinessEntity.class);
		return Result.success(listBChildBusinesss);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取B_CHILD_BUSINESS信息",notes="根据ID获取B_CHILD_BUSINESS信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BChildBusinessEntity task = bChildBusinessService.get(BChildBusinessEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取B_CHILD_BUSINESS信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建B_CHILD_BUSINESS")
	public ResponseMessage<?> create(@ApiParam(name="B_CHILD_BUSINESS对象")@RequestBody BChildBusinessEntity bChildBusiness, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BChildBusinessEntity>> failures = validator.validate(bChildBusiness);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			bChildBusinessService.save(bChildBusiness);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("B_CHILD_BUSINESS信息保存失败");
		}
		return Result.success(bChildBusiness);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新B_CHILD_BUSINESS",notes="更新B_CHILD_BUSINESS")
	public ResponseMessage<?> update(@ApiParam(name="B_CHILD_BUSINESS对象")@RequestBody BChildBusinessEntity bChildBusiness) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BChildBusinessEntity>> failures = validator.validate(bChildBusiness);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			bChildBusinessService.saveOrUpdate(bChildBusiness);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新B_CHILD_BUSINESS信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新B_CHILD_BUSINESS信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除B_CHILD_BUSINESS")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			bChildBusinessService.deleteEntityById(BChildBusinessEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("B_CHILD_BUSINESS删除失败");
		}

		return Result.success();
	}
}
