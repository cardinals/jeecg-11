package com.jeecg.material.controller;
import com.jeecg.material.entity.AMaterialsInfoEntity;
import com.jeecg.material.service.AMaterialsInfoServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.tag.vo.datatable.SortDirection;
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
 * @Description: A_MATERIALS_INFO
 * @author onlineGenerator
 * @date 2018-06-18 21:04:56
 * @version V1.0   
 *
 */
@Api(value="AMaterialsInfo",description="A_MATERIALS_INFO",tags="aMaterialsInfoController")
@Controller
@RequestMapping("/aMaterialsInfoController")
public class AMaterialsInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AMaterialsInfoController.class);

	@Autowired
	private AMaterialsInfoServiceI aMaterialsInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * A_MATERIALS_INFO列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/material/aMaterialsInfoList");
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
	public void datagrid(AMaterialsInfoEntity aMaterialsInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AMaterialsInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aMaterialsInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.addOrder("itemsId", SortDirection.asc);
		cq.add();
		this.aMaterialsInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除A_MATERIALS_INFO
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AMaterialsInfoEntity aMaterialsInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		aMaterialsInfo = systemService.getEntity(AMaterialsInfoEntity.class, aMaterialsInfo.getId());
		message = "A_MATERIALS_INFO删除成功";
		try{
			aMaterialsInfoService.delete(aMaterialsInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "A_MATERIALS_INFO删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除A_MATERIALS_INFO
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "A_MATERIALS_INFO删除成功";
		try{
			for(String id:ids.split(",")){
				AMaterialsInfoEntity aMaterialsInfo = systemService.getEntity(AMaterialsInfoEntity.class, 
				id
				);
				aMaterialsInfoService.delete(aMaterialsInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "A_MATERIALS_INFO删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加A_MATERIALS_INFO
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AMaterialsInfoEntity aMaterialsInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "A_MATERIALS_INFO添加成功";
		try{
			aMaterialsInfoService.save(aMaterialsInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "A_MATERIALS_INFO添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新A_MATERIALS_INFO
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AMaterialsInfoEntity aMaterialsInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "A_MATERIALS_INFO更新成功";
		AMaterialsInfoEntity t = aMaterialsInfoService.get(AMaterialsInfoEntity.class, aMaterialsInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(aMaterialsInfo, t);
			aMaterialsInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "A_MATERIALS_INFO更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * A_MATERIALS_INFO新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AMaterialsInfoEntity aMaterialsInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aMaterialsInfo.getId())) {
			aMaterialsInfo = aMaterialsInfoService.getEntity(AMaterialsInfoEntity.class, aMaterialsInfo.getId());
			req.setAttribute("aMaterialsInfoPage", aMaterialsInfo);
		}
		return new ModelAndView("com/jeecg/material/aMaterialsInfo-add");
	}
	/**
	 * A_MATERIALS_INFO编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AMaterialsInfoEntity aMaterialsInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aMaterialsInfo.getId())) {
			aMaterialsInfo = aMaterialsInfoService.getEntity(AMaterialsInfoEntity.class, aMaterialsInfo.getId());
			req.setAttribute("aMaterialsInfoPage", aMaterialsInfo);
		}
		return new ModelAndView("com/jeecg/material/aMaterialsInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","aMaterialsInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AMaterialsInfoEntity aMaterialsInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AMaterialsInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aMaterialsInfo, request.getParameterMap());
		List<AMaterialsInfoEntity> aMaterialsInfos = this.aMaterialsInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"A_MATERIALS_INFO");
		modelMap.put(NormalExcelConstants.CLASS,AMaterialsInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("A_MATERIALS_INFO列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,aMaterialsInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AMaterialsInfoEntity aMaterialsInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"A_MATERIALS_INFO");
    	modelMap.put(NormalExcelConstants.CLASS,AMaterialsInfoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("A_MATERIALS_INFO列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<AMaterialsInfoEntity> listAMaterialsInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AMaterialsInfoEntity.class,params);
				for (AMaterialsInfoEntity aMaterialsInfo : listAMaterialsInfoEntitys) {
					aMaterialsInfoService.save(aMaterialsInfo);
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
	@ApiOperation(value="A_MATERIALS_INFO列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<AMaterialsInfoEntity>> list() {
		List<AMaterialsInfoEntity> listAMaterialsInfos=aMaterialsInfoService.getList(AMaterialsInfoEntity.class);
		return Result.success(listAMaterialsInfos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取A_MATERIALS_INFO信息",notes="根据ID获取A_MATERIALS_INFO信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		AMaterialsInfoEntity task = aMaterialsInfoService.get(AMaterialsInfoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取A_MATERIALS_INFO信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建A_MATERIALS_INFO")
	public ResponseMessage<?> create(@ApiParam(name="A_MATERIALS_INFO对象")@RequestBody AMaterialsInfoEntity aMaterialsInfo, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AMaterialsInfoEntity>> failures = validator.validate(aMaterialsInfo);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			aMaterialsInfoService.save(aMaterialsInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("A_MATERIALS_INFO信息保存失败");
		}
		return Result.success(aMaterialsInfo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新A_MATERIALS_INFO",notes="更新A_MATERIALS_INFO")
	public ResponseMessage<?> update(@ApiParam(name="A_MATERIALS_INFO对象")@RequestBody AMaterialsInfoEntity aMaterialsInfo) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AMaterialsInfoEntity>> failures = validator.validate(aMaterialsInfo);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			aMaterialsInfoService.saveOrUpdate(aMaterialsInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新A_MATERIALS_INFO信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新A_MATERIALS_INFO信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除A_MATERIALS_INFO")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			aMaterialsInfoService.deleteEntityById(AMaterialsInfoEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("A_MATERIALS_INFO删除失败");
		}

		return Result.success();
	}
}
