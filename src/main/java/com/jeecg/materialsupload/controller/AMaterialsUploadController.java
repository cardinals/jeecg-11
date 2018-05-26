package com.jeecg.materialsupload.controller;
import com.jeecg.materialsupload.entity.AMaterialsUploadEntity;
import com.jeecg.materialsupload.service.AMaterialsUploadServiceI;


import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

import javax.servlet.http.HttpSession;
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
 * @Description: 材料上传信息
 * @author onlineGenerator
 * @date 2018-05-06 19:41:59
 * @version V1.0   
 *
 */
@Api(value="AMaterialsUpload",description="材料上传信息",tags="aMaterialsUploadController")
@Controller
@RequestMapping("/aMaterialsUploadController")
public class AMaterialsUploadController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AMaterialsUploadController.class);

	@Autowired
	private AMaterialsUploadServiceI aMaterialsUploadService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	private String message;
	/**
	 * 附件上传
	 * @return
	 */
	@RequestMapping(params = "uploadFile")
	@ResponseBody
	public AjaxJson uploadFile(MultipartHttpServletRequest request,HttpSession session) throws IOException {
		AjaxJson j = new AjaxJson();
		message = "上传成功";
		String id = request.getParameter("id");
		String businessId = request.getParameter("business_id");
		String projectId = request.getParameter("project_id");
		String phasesId = request.getParameter("phases_id");
		String itemsId = request.getParameter("items_id");
		String materialsId = request.getParameter("materials_id");
		String type = request.getParameter("type");
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		String relativePath = "";
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			try {
				if (mpf.getSize() < 104857600) {
					String attachmentName = StringUtils.substringBeforeLast(
							mpf.getOriginalFilename(), ".");
					String ext = StringUtils.substringAfterLast(
							mpf.getOriginalFilename(), ".");
//					String rootPath = ResourceUtil.getConfigByName("webUploadpath");
					String rootPath = session.getServletContext().getRealPath("/");
					String photoPath = "fileUpload\\patrol";
					String fileName = UUID.randomUUID() + attachmentName + "." + ext;
					relativePath = photoPath + "\\" + fileName;
					File realPath = new File(rootPath + photoPath);
					if (!realPath.exists()) {
						realPath.mkdirs();
					}
					FileCopyUtils.copy(mpf.getBytes(),new File(realPath.getAbsolutePath() + "\\" + fileName));
					upload(rootPath + relativePath, fileName,id,businessId,projectId,phasesId,itemsId,materialsId,type);
				} else {
					message = "文件太大，请不要 超过100M";
				}
			} catch (Exception e) {
				message = "上传失败";
				logger.error(e);
			}
		}
		j.setMsg(message);
		j.setObj(id);
		return j;
	}
	/**
	 * 删除附件
	 */
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "删除成功";
		try {
			String fileId=request.getParameter("fileId");
			AMaterialsUploadEntity file = systemService.getEntity(AMaterialsUploadEntity.class,fileId);
			systemService.delete(file);
			File f = new File(file.getMaterialsPath());
			if(f.exists()){
				f.delete();
			}
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "删除失败";
			logger.error(e);
		}
		return j;
	}

	/**
	 * 下载任务附件
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params = "downloadFile")
	public void downloadFile(HttpServletResponse response, HttpServletRequest request) throws IOException{
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		AMaterialsUploadEntity file = systemService.getEntity(AMaterialsUploadEntity.class,id);
		String filePath = file.getMaterialsPath();
		String name = file.getMaterialsName();
		if("download".equals(type)){
			name = new String(name.getBytes("GBK"),"ISO-8859-1");
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-Disposition", "attachment; filename=" + name.substring(36,name.length()));
		}
		File f = new File(filePath);
		if(f.exists()){
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			OutputStream os = null;
			InputStream is = null;
			try {
				is = new FileInputStream(filePath);
				bis = new  BufferedInputStream(is);
				os = response.getOutputStream();
				bos = new BufferedOutputStream(os);
				int byteRead = 0;
				byte[] buffer = new byte[5*1024];
				while((byteRead = bis.read(buffer))!=-1){
					bos.write(buffer,0,byteRead);
				}
				bos.close();
				bis.close();
				os.close();
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

//	/**
//	 * 更新案中提请
//	 *
//	 * @param ids
//	 * @return
//	 */
//	@RequestMapping(params = "doUpdate")
//	@ResponseBody
//	public AjaxJson doUpdate(CaseApplyEntity caseApply, HttpServletRequest request) {
//		AjaxJson j = new AjaxJson();
//		message = "案中提请更新成功";
//		CaseApplyEntity t = caseApplyService.get(CaseApplyEntity.class, caseApply.getId());
//		try {
//			String caseIds=request.getParameter("caseIds");
//			CourtCaseEntity courtCase=systemService.getEntity(CourtCaseEntity.class, caseIds);
//			caseApply.setCourtCase(courtCase);
//			MyBeanUtils.copyBeanNotNull2Bean(caseApply, t);
//			caseApplyService.saveOrUpdate(t);
//			String filePaths=request.getParameter("filePaths");
//			String[] filePathArray = filePaths.split(",");
//			for (String filePath : filePathArray) {
//				if(filePath.trim().length()==0){
//					continue;
//				}
//				String ext = StringUtils.substringAfterLast(filePath, ".");
//				String fileName = StringUtils.substring(filePath,
//						filePath.lastIndexOf("\\") + 1,
//						filePath.indexOf(".") - 36);
//				String realName = fileName + "." + ext;
//				caseApplyService.upload(filePath, realName, caseApply);
//			}
//			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
//		} catch (Exception e) {
//			e.printStackTrace();
//			message = "案中提请更新失败";
//			throw new BusinessException(e.getMessage());
//		}
//		j.setMsg(message);
//		return j;
//	}



	public void upload(String filePath,String realName,String id,String businessId,String projectId,String phasesId,
					   String itemsId,String materialsId,String type) throws IOException {
		AMaterialsUploadEntity file = new AMaterialsUploadEntity();
		file.setId(id);
		file = aMaterialsUploadService.getEntity(AMaterialsUploadEntity.class, file.getId());
		//type==1 表示 上传的是材料 type==2 表示 上传的是证照
//		if("1".equals(type)){
			file.setCreateTime(new Date());
			file.setMaterialsPath(filePath);
			file.setMaterialsName(realName);
			file.setMaterialsType(type);

//			file.setBusinessId(businessId);
//			file.setProjectId(projectId);
//			file.setPhasesId(phasesId);
//			file.setItemsId(itemsId);
//			file.setMaterialsId(materialsId);
//		}

		systemService.updateEntitie(file);
	}


//	~~~~~~~~~~~~~
	/**
	 * 材料上传信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/materialsupload/aMaterialsUploadList");
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
	public void datagrid(AMaterialsUploadEntity aMaterialsUpload,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(AMaterialsUploadEntity.class, dataGrid);
//		//查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aMaterialsUpload, request.getParameterMap());
//		try{
//		//自定义追加查询条件
//		}catch (Exception e) {
//			throw new BusinessException(e.getMessage());
//		}
//		cq.add();
//		this.aMaterialsUploadService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
		TSUser user = ResourceUtil.getSessionUser();
		String sql = "select a.id,a.business_id,a.materials_id,a.materials_path,a.update_time," +
				"      substr(a.materials_name ,37) as materials_name," +
				"       a.materials_type," +
				"       b.items_child_name" +
				"  from A_MATERIALS_UPLOAD a, a_items_info b " +
				" where a.items_id = b.items_id||b.items_child_id order by a.update_time";

		List<Map<String, Object>> resultList =  systemService.findForJdbc(sql,dataGrid.getPage(),dataGrid.getRows());
		//将List转换成JSON存储
		List<Map<String, Object>> materialsList = new ArrayList<Map<String, Object>>();
		if(resultList!=null && resultList.size()>0){
			for(int i=0;i<resultList.size();i++){
				Map<String, Object> obj =  resultList.get(i);
				Map<String, Object> n = new HashMap<String, Object>();
				n.put("id",String.valueOf(obj.get("id")));
				n.put("businessId", String.valueOf(obj.get("business_id")));
				n.put("materialsId", String.valueOf(obj.get("materials_id")));
				n.put("materialsPath", String.valueOf(obj.get("materials_path")));
				n.put("materialsName",String.valueOf(obj.get("materials_name")));
				n.put("materialsType",String.valueOf(obj.get("materials_type")));
				n.put("itemsChildName",String.valueOf(obj.get("items_child_name")));
				n.put("updateTime",String.valueOf(obj.get("update_time")));
				materialsList.add(n);
			}
		}
		dataGrid.setResults(materialsList);
		String getCountSql ="select count(a.id) as count " +
				"  from A_MATERIALS_UPLOAD a, a_items_info b " +
				" where a.items_id = b.items_id||b.items_child_id";
		List<Map<String, Object>> resultList2 =  systemService.findForJdbc(getCountSql);
		Object count = resultList2.get(0).get("count");

		dataGrid.setTotal(Integer.valueOf(count.toString()));
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除材料上传信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(AMaterialsUploadEntity aMaterialsUpload, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		aMaterialsUpload = systemService.getEntity(AMaterialsUploadEntity.class, aMaterialsUpload.getId());
		message = "材料上传信息删除成功";
		try{
			aMaterialsUploadService.delete(aMaterialsUpload);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "材料上传信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除材料上传信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "材料上传信息删除成功";
		try{
			for(String id:ids.split(",")){
				AMaterialsUploadEntity aMaterialsUpload = systemService.getEntity(AMaterialsUploadEntity.class, 
				id
				);
				aMaterialsUploadService.delete(aMaterialsUpload);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "材料上传信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加材料上传信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(AMaterialsUploadEntity aMaterialsUpload, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "材料上传信息添加成功";
		try{
			aMaterialsUploadService.save(aMaterialsUpload);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "材料上传信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新材料上传信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(AMaterialsUploadEntity aMaterialsUpload, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "材料上传信息更新成功";
		AMaterialsUploadEntity t = aMaterialsUploadService.get(AMaterialsUploadEntity.class, aMaterialsUpload.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(aMaterialsUpload, t);
			aMaterialsUploadService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "材料上传信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 材料上传信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(AMaterialsUploadEntity aMaterialsUpload, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aMaterialsUpload.getId())) {
			aMaterialsUpload = aMaterialsUploadService.getEntity(AMaterialsUploadEntity.class, aMaterialsUpload.getId());
			req.setAttribute("aMaterialsUploadPage", aMaterialsUpload);
		}
		return new ModelAndView("com/jeecg/materialsupload/aMaterialsUpload-add");
	}
	/**
	 * 材料上传信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(AMaterialsUploadEntity aMaterialsUpload, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aMaterialsUpload.getId())) {
			aMaterialsUpload = aMaterialsUploadService.getEntity(AMaterialsUploadEntity.class, aMaterialsUpload.getId());
			req.setAttribute("aMaterialsUploadPage", aMaterialsUpload);
		}
		return new ModelAndView("com/jeecg/materialsupload/aMaterialsUpload-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","aMaterialsUploadController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(AMaterialsUploadEntity aMaterialsUpload,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(AMaterialsUploadEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aMaterialsUpload, request.getParameterMap());
		List<AMaterialsUploadEntity> aMaterialsUploads = this.aMaterialsUploadService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"材料上传信息");
		modelMap.put(NormalExcelConstants.CLASS,AMaterialsUploadEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("材料上传信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,aMaterialsUploads);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(AMaterialsUploadEntity aMaterialsUpload,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"材料上传信息");
    	modelMap.put(NormalExcelConstants.CLASS,AMaterialsUploadEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("材料上传信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<AMaterialsUploadEntity> listAMaterialsUploadEntitys = ExcelImportUtil.importExcel(file.getInputStream(),AMaterialsUploadEntity.class,params);
				for (AMaterialsUploadEntity aMaterialsUpload : listAMaterialsUploadEntitys) {
					aMaterialsUploadService.save(aMaterialsUpload);
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
	@ApiOperation(value="材料上传信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<AMaterialsUploadEntity>> list() {
		List<AMaterialsUploadEntity> listAMaterialsUploads=aMaterialsUploadService.getList(AMaterialsUploadEntity.class);
		return Result.success(listAMaterialsUploads);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取材料上传信息信息",notes="根据ID获取材料上传信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		AMaterialsUploadEntity task = aMaterialsUploadService.get(AMaterialsUploadEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取材料上传信息信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建材料上传信息")
	public ResponseMessage<?> create(@ApiParam(name="材料上传信息对象")@RequestBody AMaterialsUploadEntity aMaterialsUpload, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AMaterialsUploadEntity>> failures = validator.validate(aMaterialsUpload);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			aMaterialsUploadService.save(aMaterialsUpload);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("材料上传信息信息保存失败");
		}
		return Result.success(aMaterialsUpload);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新材料上传信息",notes="更新材料上传信息")
	public ResponseMessage<?> update(@ApiParam(name="材料上传信息对象")@RequestBody AMaterialsUploadEntity aMaterialsUpload) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<AMaterialsUploadEntity>> failures = validator.validate(aMaterialsUpload);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			aMaterialsUploadService.saveOrUpdate(aMaterialsUpload);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新材料上传信息信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新材料上传信息信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除材料上传信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			aMaterialsUploadService.deleteEntityById(AMaterialsUploadEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("材料上传信息删除失败");
		}

		return Result.success();
	}
}
