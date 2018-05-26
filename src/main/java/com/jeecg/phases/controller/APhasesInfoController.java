package com.jeecg.phases.controller;
import com.jeecg.phases.entity.APhasesInfoEntity;
import com.jeecg.phases.service.APhasesInfoServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
 * @Description: A_PHASES_INFO
 * @author onlineGenerator
 * @date 2018-05-26 21:05:11
 * @version V1.0   
 *
 */
@Api(value="APhasesInfo",description="A_PHASES_INFO",tags="aPhasesInfoController")
@Controller
@RequestMapping("/aPhasesInfoController")
public class APhasesInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(APhasesInfoController.class);

	@Autowired
	private APhasesInfoServiceI aPhasesInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * A_PHASES_INFO列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/phases/aPhasesInfoList");
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
	public void datagrid(APhasesInfoEntity aPhasesInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(APhasesInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aPhasesInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.aPhasesInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除A_PHASES_INFO
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(APhasesInfoEntity aPhasesInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		aPhasesInfo = systemService.getEntity(APhasesInfoEntity.class, aPhasesInfo.getId());
		message = "A_PHASES_INFO删除成功";
		try{
			aPhasesInfoService.delete(aPhasesInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "A_PHASES_INFO删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除A_PHASES_INFO
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "A_PHASES_INFO删除成功";
		try{
			for(String id:ids.split(",")){
				APhasesInfoEntity aPhasesInfo = systemService.getEntity(APhasesInfoEntity.class, 
				id
				);
				aPhasesInfoService.delete(aPhasesInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "A_PHASES_INFO删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加A_PHASES_INFO
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(APhasesInfoEntity aPhasesInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "A_PHASES_INFO添加成功";
		try{
			aPhasesInfoService.save(aPhasesInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "A_PHASES_INFO添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新A_PHASES_INFO
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(APhasesInfoEntity aPhasesInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "A_PHASES_INFO更新成功";
		APhasesInfoEntity t = aPhasesInfoService.get(APhasesInfoEntity.class, aPhasesInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(aPhasesInfo, t);
			aPhasesInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "A_PHASES_INFO更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * A_PHASES_INFO新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(APhasesInfoEntity aPhasesInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aPhasesInfo.getId())) {
			aPhasesInfo = aPhasesInfoService.getEntity(APhasesInfoEntity.class, aPhasesInfo.getId());
			req.setAttribute("aPhasesInfoPage", aPhasesInfo);
		}
		return new ModelAndView("com/jeecg/phases/aPhasesInfo-add");
	}
	/**
	 * A_PHASES_INFO编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(APhasesInfoEntity aPhasesInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aPhasesInfo.getId())) {
			aPhasesInfo = aPhasesInfoService.getEntity(APhasesInfoEntity.class, aPhasesInfo.getId());
			req.setAttribute("aPhasesInfoPage", aPhasesInfo);
		}
		return new ModelAndView("com/jeecg/phases/aPhasesInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","aPhasesInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(APhasesInfoEntity aPhasesInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(APhasesInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aPhasesInfo, request.getParameterMap());
		List<APhasesInfoEntity> aPhasesInfos = this.aPhasesInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"A_PHASES_INFO");
		modelMap.put(NormalExcelConstants.CLASS,APhasesInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("A_PHASES_INFO列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,aPhasesInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(APhasesInfoEntity aPhasesInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"A_PHASES_INFO");
    	modelMap.put(NormalExcelConstants.CLASS,APhasesInfoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("A_PHASES_INFO列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<APhasesInfoEntity> listAPhasesInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),APhasesInfoEntity.class,params);
				for (APhasesInfoEntity aPhasesInfo : listAPhasesInfoEntitys) {
					aPhasesInfoService.save(aPhasesInfo);
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
	@ApiOperation(value="A_PHASES_INFO列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<APhasesInfoEntity>> list() {
		List<APhasesInfoEntity> listAPhasesInfos=aPhasesInfoService.getList(APhasesInfoEntity.class);
		return Result.success(listAPhasesInfos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取A_PHASES_INFO信息",notes="根据ID获取A_PHASES_INFO信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		APhasesInfoEntity task = aPhasesInfoService.get(APhasesInfoEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取A_PHASES_INFO信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建A_PHASES_INFO")
	public ResponseMessage<?> create(@ApiParam(name="A_PHASES_INFO对象")@RequestBody APhasesInfoEntity aPhasesInfo, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<APhasesInfoEntity>> failures = validator.validate(aPhasesInfo);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			aPhasesInfoService.save(aPhasesInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("A_PHASES_INFO信息保存失败");
		}
		return Result.success(aPhasesInfo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新A_PHASES_INFO",notes="更新A_PHASES_INFO")
	public ResponseMessage<?> update(@ApiParam(name="A_PHASES_INFO对象")@RequestBody APhasesInfoEntity aPhasesInfo) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<APhasesInfoEntity>> failures = validator.validate(aPhasesInfo);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			aPhasesInfoService.saveOrUpdate(aPhasesInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新A_PHASES_INFO信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新A_PHASES_INFO信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除A_PHASES_INFO")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			aPhasesInfoService.deleteEntityById(APhasesInfoEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("A_PHASES_INFO删除失败");
		}

		return Result.success();
	}
}
