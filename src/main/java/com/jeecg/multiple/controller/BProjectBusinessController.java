package com.jeecg.multiple.controller;
import com.jeecg.business.entity.AProjectInfoEntity;
import com.jeecg.business.service.AProjectInfoServiceI;
import com.jeecg.childbusiness.entity.BChildBusinessEntity;
import com.jeecg.childbusiness.service.BChildBusinessServiceI;
import com.jeecg.materialsupload.entity.AMaterialsUploadEntity;
import com.jeecg.materialsupload.service.AMaterialsUploadServiceI;
import com.jeecg.multiple.entity.BProjectBusinessEntity;
import com.jeecg.multiple.service.BProjectBusinessServiceI;

import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeecg.util.BusinessUtil;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
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
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;

import java.io.OutputStream;

import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
 * @Description: 并联业务信息
 * @author onlineGenerator
 * @date 2018-05-06 10:43:56
 * @version V1.0
 *
 */
@Api(value="BProjectBusiness",description="并联业务信息",tags="bProjectBusinessController")
@Controller
@RequestMapping("/bProjectBusinessController")
public class BProjectBusinessController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BProjectBusinessController.class);

	@Autowired
	private BChildBusinessServiceI bChildBusinessService;
	@Autowired
	private AProjectInfoServiceI aProjectInfoService;
	@Autowired
	private BProjectBusinessServiceI bProjectBusinessService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private AMaterialsUploadServiceI aMaterialsUploadService;
	@Autowired
	private Validator validator;



	/**
	 * 并联业务信息新增页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "accept")
	public ModelAndView accept(AProjectInfoEntity aProjectInfo,BProjectBusinessEntity bProjectBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aProjectInfo.getId())) {
			aProjectInfo = aProjectInfoService.getEntity(AProjectInfoEntity.class, aProjectInfo.getId());
			req.setAttribute("aProjectInfoPage", aProjectInfo);
		}
		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
			req.setAttribute("bProjectBusinessPage", bProjectBusiness);
			req.setAttribute("businessId", DateUtils.date2Str(new SimpleDateFormat("yyyyMMddHHmmss")));
		}
		return new ModelAndView("com/jeecg/multiple/bProjectBusiness-add");
	}

//	/**
//	 * 并联业务跳转至材料上传页面--old
//	 *
//	 * @return
//	 */
//	@RequestMapping(params = "materialList")
//	public ModelAndView materialList(BProjectBusinessEntity bProjectBusiness, HttpServletRequest req,DataGrid dataGrid) {
//		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
//			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
//			req.setAttribute("bProjectBusinessPage", bProjectBusiness);
//		}
//		TSUser user = ResourceUtil.getSessionUser();
//		String sql ="";
//		String check_sql ="";
//		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
//			sql = "select f.id,substr(f.materials_name,37) as file_name, f.materials_path,e.business_id,a.project_id, a.project_name, b.phases_id, b.phases_name, c.items_id || c.items_child_id as items_id, " +
//					"c.items_child_name, d.materials_id, d.materials_name, c.dept_id, c.dept_name from A_PROJECT_INFO a, " +
//					"A_PHASES_INFO b, A_ITEMS_INFO c, A_materials_INFO d, b_project_business e, a_materials_upload f where " +
//					"a.project_id = b.project_id and b.phases_id = c.phases_id and c.items_id || c.items_child_id = d.items_id " +
//					" and e.project_id = a.project_id"+
//					" and f.project_id = a.project_id"+
//					" and f.phases_id = b.phases_id"+
//					" and f.business_id = e.business_id"+
//					" and f.items_id = c.items_id || c.items_child_id"+
//					" and f.materials_id = d.materials_id and f.materials_type = '1'" +
//					" and e.business_id = '"+bProjectBusiness.getBusinessId()+"' order by c.items_id || c.items_child_id";
//			check_sql = "select dept_id,dept_name,items_name,items_id,check_content,check_time from B_CHILD_BUSINESS t " +
//					"where business_id ='"+bProjectBusiness.getBusinessId()+"' " +
//					"and  substr(phases_id,-3) ='001'  order by items_id  ";
//		}else{
//			sql = "select f.id,substr(f.materials_name,37) as file_name, f.materials_path,e.business_id,a.project_id, a.project_name, b.phases_id, b.phases_name, c.items_id || c.items_child_id as items_id, " +
//					"c.items_child_name, d.materials_id, d.materials_name, c.dept_id, c.dept_name from A_PROJECT_INFO a, " +
//					"A_PHASES_INFO b, A_ITEMS_INFO c, A_materials_INFO d, b_project_business e, a_materials_upload f where " +
//					"a.project_id = b.project_id and b.phases_id = c.phases_id and c.items_id || c.items_child_id = d.items_id " +
//					" and e.project_id = a.project_id"+
//					" and f.project_id = a.project_id"+
//					" and f.phases_id = b.phases_id"+
//					" and f.business_id = e.business_id"+
//					" and f.items_id = c.items_id || c.items_child_id"+
//					" and f.materials_id = d.materials_id and f.materials_type = '1'" +
//					" and e.business_id = '"+bProjectBusiness.getBusinessId()+"'" +
//				" and c.dept_id = '"+user.getCurrentDepart().getId()+"' order by c.items_id || c.items_child_id" ;
//			check_sql = "select dept_id,dept_name,items_name,items_id,check_content,check_time from B_CHILD_BUSINESS t " +
//					"where business_id ='"+bProjectBusiness.getBusinessId()+"' " +
//					"and  substr(phases_id,-3) ='001' and dept_id='"+user.getCurrentDepart().getId()+"'  order by items_id  ";
//			req.setAttribute("role", BusinessUtil.DEPT_CHECK_ROLE);
//		}
//
//		List<Map<String, Object>> materialList =  systemService.findForJdbc(sql);
//		List<Map<String, Object>> checklList =  systemService.findForJdbc(check_sql);
//		req.setAttribute("materialList", materialList);
//		req.setAttribute("checklList", checklList);
//		return new ModelAndView("com/jeecg/multiple/bBusinessMaterailList");
//	}


	/**
	 * 并联业务跳转至材料上传页面
	 *
	 * @return
	 */
	@RequestMapping(params = "materialList")
	public ModelAndView materialList(BProjectBusinessEntity bProjectBusiness, HttpServletRequest req,DataGrid dataGrid) {
		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
			req.setAttribute("bProjectBusinessPage", bProjectBusiness);
		}
		TSUser user = ResourceUtil.getSessionUser();
		String sql ="";
		String check_sql ="";
		String itemsId= req.getParameter("itemsId");
		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
			sql = "select f.id,substr(f.materials_name,37) as file_name, f.materials_path,e.business_id,a.project_id, a.project_name, b.phases_id, b.phases_name, c.items_id || c.items_child_id as items_id, " +
					"c.items_child_name, d.materials_id, d.materials_name, c.dept_id, c.dept_name from A_PROJECT_INFO a, " +
					"A_PHASES_INFO b, A_ITEMS_INFO c, A_materials_INFO d, b_project_business e, a_materials_upload f where " +
					"a.project_id = b.project_id and b.phases_id = c.phases_id and c.items_id || c.items_child_id = d.items_id " +
					" and e.project_id = a.project_id"+
					" and f.project_id = a.project_id"+
					" and f.phases_id = b.phases_id"+
					" and f.business_id = e.business_id"+
					" and f.items_id = c.items_id || c.items_child_id"+
					" and f.materials_id = d.materials_id and f.materials_type = '1'" +
					" and e.business_id = '"+bProjectBusiness.getBusinessId()+"' and d.items_id = '"+itemsId+"' and length(f.id) = 32  order by c.items_id || c.items_child_id";
			check_sql = "select dept_id,dept_name,items_name,items_id,check_content,check_time,check_status from B_CHILD_BUSINESS t " +
					"where business_id ='"+bProjectBusiness.getBusinessId()+"' " +
					"and items_id = '"+itemsId+"' order by items_id  ";
		}else{
			sql = "select f.id,substr(f.materials_name,37) as file_name, f.materials_path,e.business_id,a.project_id, a.project_name, b.phases_id, b.phases_name, c.items_id || c.items_child_id as items_id, " +
					"c.items_child_name, d.materials_id, d.materials_name, c.dept_id, c.dept_name from A_PROJECT_INFO a, " +
					"A_PHASES_INFO b, A_ITEMS_INFO c, A_materials_INFO d, b_project_business e, a_materials_upload f where " +
					"a.project_id = b.project_id and b.phases_id = c.phases_id and c.items_id || c.items_child_id = d.items_id " +
					" and e.project_id = a.project_id"+
					" and f.project_id = a.project_id"+
					" and f.phases_id = b.phases_id"+
					" and f.business_id = e.business_id"+
					" and f.items_id = c.items_id || c.items_child_id"+
					" and f.materials_id = d.materials_id and f.materials_type = '1'" +
					" and e.business_id = '"+bProjectBusiness.getBusinessId()+"'" +
					" and c.dept_id = '"+user.getCurrentDepart().getId()+"' and d.items_id = '"+itemsId+"' and length(f.id) = 32 order by c.items_id || c.items_child_id" ;
			check_sql = "select dept_id,dept_name,items_name,items_id,check_content,check_time,check_status from B_CHILD_BUSINESS t " +
					"where business_id ='"+bProjectBusiness.getBusinessId()+"' " +
					" and items_id='"+itemsId+"'  order by items_id  ";
			req.setAttribute("role", BusinessUtil.DEPT_CHECK_ROLE);
		}

		List<Map<String, Object>> materialList =  systemService.findForJdbc(sql);
		List<Map<String, Object>> checklList =  systemService.findForJdbc(check_sql);
		req.setAttribute("materialList", materialList);
		req.setAttribute("checklList", checklList);
		return new ModelAndView("com/jeecg/multiple/bBusinessMaterailList");
	}
	/**
	 * 跳转至文件预览页面
	 *
	 * @return
	 */
	@RequestMapping(params = "fileView")
	public ModelAndView fileView(AMaterialsUploadEntity file, HttpServletRequest req,DataGrid dataGrid) {
		if (StringUtil.isNotEmpty(file.getId())) {
			file = aMaterialsUploadService.getEntity(AMaterialsUploadEntity.class, file.getId());
			req.setAttribute("file", file);
		}
		TSUser user = ResourceUtil.getSessionUser();
		String sql ="";

//		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
			sql = "select *" +
					"  from A_MATERIALS_UPLOAD" +
					" where business_id = '"+file.getBusinessId()+"'" +
					"   and project_id = '"+file.getProjectId()+"'" +
					"   and phases_id = '"+file.getPhasesId()+"'" +
					"   and items_id = '"+file.getItemsId()+"'" +
					"   and materials_id = '"+file.getMaterialsId()+"'";

//		}else{
//			sql = "" ;
//		}

		List<Map<String, Object>> fileList =  systemService.findForJdbc(sql);
		req.setAttribute("fileList", fileList);
		return new ModelAndView("com/jeecg/multiple/fileViewList");
	}

	/**
	 * 跳转高拍仪页面
	 *
	 * @return
	 */
	@RequestMapping(params = "gpy")
	public ModelAndView gp(BProjectBusinessEntity bProjectBusiness, HttpServletRequest req,DataGrid dataGrid) {
		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
			req.setAttribute("bProjectBusiness", bProjectBusiness);
		}
		String itemsId= req.getParameter("itemsId");
		String materialId= req.getParameter("materialId");
		String flag= req.getParameter("type");
		req.setAttribute("materialId", materialId);
		req.setAttribute("itemsId", itemsId);
		req.setAttribute("flag", flag);
		return new ModelAndView("com/jeecg/multiple/gpy");
	}
	/**
	 * 并联业务跳转至证照上传页面
	 *
	 * @return
	 */
	@RequestMapping(params = "uploadcl")
	public ModelAndView uploadcl(BProjectBusinessEntity bProjectBusiness, HttpServletRequest req,DataGrid dataGrid) {
		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
			req.setAttribute("bProjectBusinessPage", bProjectBusiness);
		}
		String condition = "" ;
		TSUser user = ResourceUtil.getSessionUser();
		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
			condition = "and substr(a.phases_id,-3) <='" +bProjectBusiness.getCurrentPhases().substring(bProjectBusiness.getCurrentPhases().length()-3) +"'";
		}else{
			condition = "and a.dept_id ='" +user.getDepartid() +"'";
		}
		String sql = "select a.business_id,a.project_id,substr(a.phases_id,-3) as phases_id , a.items_id,a.items_name ,a.dept_id,a.dept_name,a.reality_project_name,b.id, " +
				" a.check_status, a.confirm_upload_time, CASE" +
				"        WHEN a.confirm_upload_time is null THEN '待上传' " +
				"        WHEN (a.confirm_upload_time is not null and a.check_status is null) " +
				"           or (a.confirm_upload_time > a.check_time and a.check_status = '0') THEN '待审核'" +
				"        WHEN  a.confirm_upload_time is not null and a.check_status ='1' THEN '审核通过'" +
				"        WHEN  a.confirm_upload_time is not null and a.check_status ='0' THEN '审核退回'" +
				"        ELSE '其他' END as status," +
				" substr(b.materials_name,37) as file_name from B_CHILD_BUSINESS a, A_MATERIALS_UPLOAD b " +
				" where   a.business_id = b.business_id" +
				"      and a.project_id = b.project_id" +
				"      and a.phases_id = b.phases_id" +
				"      and a.items_id = b.items_id" +
				"      and b.materials_type = '2'" + condition +
				"      and a.business_id = '"+bProjectBusiness.getBusinessId()+"' order by a.phases_id ";
		List<Map<String, Object>> certificateList =  systemService.findForJdbc(sql);
		req.setAttribute("certificateList", certificateList);
		req.setAttribute("deptId", user.getDepartid());
		//上传证照权限只给预受理人员
		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
			req.setAttribute("role", BusinessUtil.WINDOW_ACCEPT);
		}
		return new ModelAndView("com/jeecg/multiple/bBusinessClUploadListNew");
	}
	/**
	 * 并联业务跳转至证照上传页面
	 *
	 * @return
	 */
	@RequestMapping(params = "certificateList")
	public ModelAndView certificateList(BProjectBusinessEntity bProjectBusiness, HttpServletRequest req,DataGrid dataGrid) {
		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
			req.setAttribute("bProjectBusinessPage", bProjectBusiness);
		}

		TSUser user = ResourceUtil.getSessionUser();
		String sql = "select a.business_id,a.project_id,substr(a.phases_id,-3) as phases_id , a.items_id,a.items_name ,a.dept_id,a.dept_name,a.reality_project_name,b.id, " +
				" substr(b.materials_name,37) as file_name from B_CHILD_BUSINESS a, A_MATERIALS_UPLOAD b " +
				" where   a.business_id = b.business_id" +
				"      and a.project_id = b.project_id" +
				"      and a.phases_id = b.phases_id" +
				"      and a.items_id = b.items_id" +
				"      and b.materials_type = '2' and a.status = '1'" +
				"      and a.business_id = '"+bProjectBusiness.getBusinessId()+"' order by a.phases_id ";
		List<Map<String, Object>> certificateList =  systemService.findForJdbc(sql);
		req.setAttribute("certificateList", certificateList);
		req.setAttribute("deptId", user.getDepartid());
		//上传证照权限只给预受理人员
		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
			req.setAttribute("role", BusinessUtil.WINDOW_ACCEPT);
		}
		return new ModelAndView("com/jeecg/multiple/bBusinessCertificateList");
	}

	/**
	 * 并联业务日志展示页面
	 *
	 * @return
	 */
	@RequestMapping(params = "loadBusinessLog")
	public ModelAndView loadBusinessLog(BProjectBusinessEntity bProjectBusiness, HttpServletRequest req,DataGrid dataGrid) {
		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
			req.setAttribute("bProjectBusiness", bProjectBusiness);
		}
//		String phasesId = bProjectBusiness.getCurrentPhases();
		String phasesId = req.getParameter("phasesId") == null || req.getParameter("phasesId")=="" ?bProjectBusiness.getCurrentPhases():req.getParameter("phasesId");

		TSUser user = ResourceUtil.getSessionUser();
		//查询并联业务阶段信息
		String phaseSql = "select a.current_phases," +
				"     CASE WHEN substr(b.phases_id,-3) = '001' THEN '第一' " +
				"         WHEN substr(b.phases_id,-3) = '002' THEN '第二' " +
				"         WHEN substr(b.phases_id,-3) = '003' THEN '第三' " +
				"         WHEN substr(b.phases_id,-3) = '004' THEN '第四' " +
				"         WHEN substr(b.phases_id,-3) = '005' THEN '第五'  END as phases_sort," +
				" CASE WHEN substr(a.current_phases,-3) > substr(b.phases_id,-3) THEN 'ed' " +
				"      WHEN substr(a.current_phases,-3) = substr(b.phases_id,-3) THEN 'ing' " +
				"      WHEN substr(a.current_phases,-3) < substr(b.phases_id,-3) THEN 'will' ELSE 'aaa' END as current_phases_status," +
				"       a.current_phases," +
				"       b.project_id," +
				"       b.phases_id," +
				"       b.phases_name" +
				"  from b_project_business a, a_phases_info b" +
				" where a.project_id = b.project_id" +
				"   and a.business_id = '"+bProjectBusiness.getBusinessId()+"' order by b.phases_id ";
		List<Map<String, Object>> phaseList =  systemService.findForJdbc(phaseSql);
		req.setAttribute("phaseList", phaseList);
		//查询并联业务选中阶段子项业务信息
		String childBusinessSql = "select c.materials_path," +
				"       substr(c.materials_name, 37) as materials_name," +
				"       b.*" +
				"  from b_project_business a" +
				"  left join b_child_business b" +
				"    on a.business_id = b.business_id" +
				"  left join a_materials_upload c" +
				"    on b.business_id = c.business_id  and c.phases_id= b.phases_id" +
				"   and b.items_id = c.items_id" +
				"   and c.materials_type = '2'" +
				" where a.business_id = '"+bProjectBusiness.getBusinessId()+"'   and b.phases_id = '"+phasesId+"' order by b.ssgzr";
		List<Map<String, Object>> childBusinessList =  systemService.findForJdbc(childBusinessSql);
		req.setAttribute("childBusinessList", childBusinessList);
		req.setAttribute("deptId", user.getDepartid());
		//上传证照权限只给预受理人员
		req.setAttribute("role", BusinessUtil.WINDOW_ACCEPT);
		return new ModelAndView("com/jeecg/multiple/bBusinessLog");
	}

	/**
	 * 子业务日志展示页面
	 *
	 * @return
	 */
	@RequestMapping(params = "loadChildLog")
	public ModelAndView goAdd(BChildBusinessEntity bChildBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bChildBusiness.getId())) {
			bChildBusiness = bChildBusinessService.getEntity(BChildBusinessEntity.class, bChildBusiness.getId());
			req.setAttribute("bChildBusiness", bChildBusiness);
		}
		//查询子业务日志信息
		String childLogSql = "select a.id,a.child_business_id, b.items_id,b.arrive_time,b.handle_time,b.idea,b.handler,b.node_name " +
				"  from b_child_log b" +
				"  left join B_CHILD_BUSINESS a" +
				"    on a.child_business_id = b.child_business_id where a.id = '"+bChildBusiness.getId()+"' order by b.handle_time";
		List<Map<String, Object>> childLogList =  systemService.findForJdbc(childLogSql);
		req.setAttribute("childLogList", childLogList);
		return new ModelAndView("com/jeecg/multiple/bChildBusiness");
	}

	/**
	 * 更新并联业务信息
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCheck")
	@ResponseBody
	public AjaxJson doCheck(BProjectBusinessEntity bProjectBusiness, String checkContent,String checkStatus,String businessId,
							String projectId,String phasesId,String itemsId,String deptId,HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核意见提交成功";

		try {
//			String sql = "update b_child_business a set a.check_time = sysdate ,a.check_content ='"+checkContent+"' " +
//					" where a.business_id ='"+businessId+"' " +
//					" and a.project_id ='"+projectId+"' " +
//					" and a.phases_id ='"+phasesId+"' " +
//					" and a.items_id = '"+itemsId+"'";
			String sql = "update b_child_business a set a.check_time = sysdate ,a.check_status ='"+checkStatus+"' ,a.check_content ='"+checkContent+"' " +
					" where a.business_id ='"+businessId+"' " +
					" and a.project_id ='"+projectId+"' " +
					" and a.phases_id ='"+phasesId+"' " +
					" and a.items_id = '"+itemsId+"'";
			int result =  systemService.updateBySqlString(sql);
//			bChildBusinessService.saveOrUpdate(bChildBusiness);
		} catch (Exception e) {
			e.printStackTrace();
			message = "审核意见提交失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新并联业务信息
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "confirmUpload")
	@ResponseBody
	public AjaxJson confirmUpload(BProjectBusinessEntity bProjectBusiness,String businessId,
							String projectId,String phasesId,String itemsId,String deptId,HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "确认材料提交成功";
		try {
			String sql = "update b_child_business a set a.CONFIRM_UPLOAD_TIME = sysdate " +
					" where a.business_id ='"+businessId+"' " +
					" and a.project_id ='"+projectId+"' " +
					" and a.phases_id ='"+phasesId+"' " +
					" and a.items_id = '"+itemsId+"'";
			int result =  systemService.updateBySqlString(sql);
//			bChildBusinessService.saveOrUpdate(bChildBusiness);
		} catch (Exception e) {
			e.printStackTrace();
			message = "确认材料提交失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

//~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * 材料上传/审核 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUser();
		//前台获取权限
		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
			request.setAttribute("role", BusinessUtil.WINDOW_ACCEPT);
		}
		return new ModelAndView("com/jeecg/multiple/bProjectBusinessList");
	}

    /**
     * 并联业务信息列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "businessLoglist")
    public ModelAndView businessLoglist(HttpServletRequest request) {
        TSUser user = ResourceUtil.getSessionUser();
        //前台获取权限
        if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
            request.setAttribute("role", BusinessUtil.WINDOW_ACCEPT);
        }
        return new ModelAndView("com/jeecg/multiple/bProjectBusinessLogList");
    }
	/**
	 * 证照管理列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "certificateIndex")
	public ModelAndView certificateIndex(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUser();
		//前台获取权限
		if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
			request.setAttribute("role", BusinessUtil.WINDOW_ACCEPT);
		}
		return new ModelAndView("com/jeecg/multiple/bProjectCertificateIndex");
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
	public void datagrid(BProjectBusinessEntity bProjectBusiness,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		TSUser user = ResourceUtil.getSessionUser();
		CriteriaQuery cq = new CriteriaQuery(BProjectBusinessEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bProjectBusiness, request.getParameterMap());
		try{
			//预受理部门id 为 ResourceUtil.getConfigByName("accept_deptid")
			if (ResourceUtil.getConfigByName("accept_deptid").equals(user.getCurrentDepart().getId())){
			}else{
				String sql = "select business_id from B_CHILD_BUSINESS t where t.dept_id ='"+user.getCurrentDepart().getId()+"'";
//				String sql = "select business_id from B_CHILD_BUSINESS t where t.dept_id ='8a8ab0b246dc81120146dc8180a20016'";
				List<Map<String, Object>> list =  systemService.findForJdbc(sql);
				List<String> arrayList = new ArrayList<String>();
				if(list!=null && list.size()>0){
					for(int i=0;i<list.size();i++){
						Map<String, Object> obj =  list.get(i);
						arrayList.add(String.valueOf(obj.get("business_id")));
					}
				}
				Object[] keyvalue = arrayList.toArray();
				cq.in("businessId", keyvalue);
			}
//
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.bProjectBusinessService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除并联业务信息
	 *
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BProjectBusinessEntity bProjectBusiness, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		bProjectBusiness = systemService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
		message = "并联业务信息删除成功";
		try{
			bProjectBusinessService.delete(bProjectBusiness);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "并联业务信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除并联业务信息
	 *
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "并联业务信息删除成功";
		try{
			for(String id:ids.split(",")){
				BProjectBusinessEntity bProjectBusiness = systemService.getEntity(BProjectBusinessEntity.class,
				id
				);
				bProjectBusinessService.delete(bProjectBusiness);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "并联业务信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加并联业务信息
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BProjectBusinessEntity bProjectBusiness, HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUser();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "并联业务信息添加成功";
		try{
			bProjectBusiness.setCurrentPhases(bProjectBusiness.getProjectId() + "-001");
			bProjectBusiness.setProjectStatus("1");
			bProjectBusinessService.save(bProjectBusiness);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			//1.插入子项业务信息
			String itemsSql ="select func_getnewid(20) as child_business,a.project_id," +
					"       a.project_name," +
					"       b.phases_id," +
					"       b.phases_name," +
					"       c.items_id || c.items_child_id as items_id," +
					"       c.items_child_name," +
					"       c.dept_id," +
					"       c.dept_name" +
					"  from A_PROJECT_INFO   a," +
					"       A_PHASES_INFO    b," +
					"       A_ITEMS_INFO     c " +
					" where a.project_id = b.project_id" +
					"   and b.phases_id = c.phases_id" +
					"   and a.project_id = '"+bProjectBusiness.getProjectId()+"' order by b.phases_id,c.items_id";
			List<Map<String, Object>> itemsList =  systemService.findForJdbc(itemsSql);
			if(itemsList!=null && itemsList.size()>0){
				for(int i=0;i<itemsList.size();i++){
					BChildBusinessEntity bChildBusiness = new BChildBusinessEntity();
					Map<String, Object> obj =  itemsList.get(i);
					bChildBusiness.setBusinessId(bProjectBusiness.getBusinessId());
					bChildBusiness.setChildBusinessId(String.valueOf(obj.get("child_business")));
					bChildBusiness.setProjectId(bProjectBusiness.getProjectId());
					bChildBusiness.setPhasesId(String.valueOf(obj.get("phases_id")));
					bChildBusiness.setItemsId(String.valueOf(obj.get("items_id")));
					bChildBusiness.setItemsName(String.valueOf(obj.get("items_child_name")));
					bChildBusiness.setDeptId(String.valueOf(obj.get("dept_id")));
					bChildBusiness.setDeptName(String.valueOf(obj.get("dept_name")));
					bChildBusiness.setRealityProjectName(bProjectBusiness.getRealityProjectName());
					bChildBusiness.setCreateTime(new Date());
					bChildBusinessService.save(bChildBusiness);
				}
			}

			//2.插入该项目的所有材料信息
//			String sql = "select a.project_id, a.project_name, b.phases_id, b.phases_name, " +
//					"c.items_id || c.items_child_id as items_id, c.items_child_name, d.materials_id, d.materials_name, " +
//					"c.dept_id, c.dept_name from A_PROJECT_INFO a, A_PHASES_INFO b, A_ITEMS_INFO c, " +
//					"A_materials_INFO d where a.project_id = b.project_id and b.phases_id = c.phases_id and " +
//					"c.items_id || c.items_child_id = d.items_id and a.project_id = '"+bProjectBusiness.getProjectId()+"'" +
//					" and substr(b.phases_id,-3) ='001'";
			String sql = "select a.project_id, a.project_name, b.phases_id, b.phases_name, " +
					"c.items_id || c.items_child_id as items_id, c.items_child_name, d.materials_id, d.materials_name, " +
					"c.dept_id, c.dept_name from A_PROJECT_INFO a, A_PHASES_INFO b, A_ITEMS_INFO c, " +
					"A_materials_INFO d where a.project_id = b.project_id and b.phases_id = c.phases_id and " +
					"c.items_id || c.items_child_id = d.items_id and a.project_id = '"+bProjectBusiness.getProjectId()+"'"  ;
			List<Map<String, Object>> resultList =  systemService.findForJdbc(sql);
			if(resultList!=null && resultList.size()>0){
				for(int i=0;i<resultList.size();i++){
					AMaterialsUploadEntity aMaterialsUpload = new AMaterialsUploadEntity();
					Map<String, Object> obj =  resultList.get(i);
					aMaterialsUpload.setBusinessId(bProjectBusiness.getBusinessId());
					aMaterialsUpload.setProjectId(bProjectBusiness.getProjectId());
					aMaterialsUpload.setPhasesId(String.valueOf(obj.get("phases_id")));
					aMaterialsUpload.setItemsId(String.valueOf(obj.get("items_id")));
					aMaterialsUpload.setMaterialsId(String.valueOf(obj.get("materials_id")));
					aMaterialsUpload.setStatus("1");
					//MaterialsType == 1 表示材料 MaterialsType ==2 表示证照
					aMaterialsUpload.setMaterialsType("1");
					aMaterialsUpload.setCreateTime(new Date());
					aMaterialsUploadService.save(aMaterialsUpload);

				}
			}

			//3.插入该项目的所有子项证照信息
			String certsql = "select * from B_CHILD_BUSINESS t where t.business_id = '"+bProjectBusiness.getBusinessId()+"'";
			List<Map<String, Object>> certificateList =  systemService.findForJdbc(certsql);
			if(certificateList!=null && certificateList.size()>0){
				for(int i=0;i<certificateList.size();i++){
					AMaterialsUploadEntity aMaterialsUpload = new AMaterialsUploadEntity();
					Map<String, Object> obj =  certificateList.get(i);
					aMaterialsUpload.setBusinessId(bProjectBusiness.getBusinessId());
					aMaterialsUpload.setProjectId(bProjectBusiness.getProjectId());
					aMaterialsUpload.setPhasesId(String.valueOf(obj.get("phases_id")));
					aMaterialsUpload.setItemsId(String.valueOf(obj.get("items_id")));
					aMaterialsUpload.setMaterialsId(String.valueOf(obj.get("materials_id")));
					aMaterialsUpload.setStatus("1");
					//MaterialsType == 1 表示材料 MaterialsType ==2 表示证照
					aMaterialsUpload.setMaterialsType("2");
					aMaterialsUpload.setCreateTime(new Date());
					aMaterialsUploadService.save(aMaterialsUpload);
				}
			}


		}catch(Exception e){
			e.printStackTrace();
			message = "并联业务信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新并联业务信息
	 *
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BProjectBusinessEntity bProjectBusiness, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "并联业务信息更新成功";
		BProjectBusinessEntity t = bProjectBusinessService.get(BProjectBusinessEntity.class, bProjectBusiness.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(bProjectBusiness, t);
			bProjectBusinessService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "并联业务信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 并联业务信息新增页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BProjectBusinessEntity bProjectBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
			req.setAttribute("bProjectBusinessPage", bProjectBusiness);
		}
		return new ModelAndView("com/jeecg/multiple/bProjectBusiness-add");
	}
	/**
	 * 并联业务信息编辑页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BProjectBusinessEntity bProjectBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bProjectBusiness.getId())) {
			bProjectBusiness = bProjectBusinessService.getEntity(BProjectBusinessEntity.class, bProjectBusiness.getId());
			req.setAttribute("bProjectBusinessPage", bProjectBusiness);
		}
		return new ModelAndView("com/jeecg/multiple/bProjectBusiness-update");
	}

	/**
	 * 导入功能跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","bProjectBusinessController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BProjectBusinessEntity bProjectBusiness,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BProjectBusinessEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, bProjectBusiness, request.getParameterMap());
		List<BProjectBusinessEntity> bProjectBusinesss = this.bProjectBusinessService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"并联业务信息");
		modelMap.put(NormalExcelConstants.CLASS,BProjectBusinessEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("并联业务信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,bProjectBusinesss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BProjectBusinessEntity bProjectBusiness,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"并联业务信息");
    	modelMap.put(NormalExcelConstants.CLASS,BProjectBusinessEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("并联业务信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<BProjectBusinessEntity> listBProjectBusinessEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BProjectBusinessEntity.class,params);
				for (BProjectBusinessEntity bProjectBusiness : listBProjectBusinessEntitys) {
					bProjectBusinessService.save(bProjectBusiness);
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
	@ApiOperation(value="并联业务信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<BProjectBusinessEntity>> list() {
		List<BProjectBusinessEntity> listBProjectBusinesss=bProjectBusinessService.getList(BProjectBusinessEntity.class);
		return Result.success(listBProjectBusinesss);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取并联业务信息信息",notes="根据ID获取并联业务信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		BProjectBusinessEntity task = bProjectBusinessService.get(BProjectBusinessEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取并联业务信息信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建并联业务信息")
	public ResponseMessage<?> create(@ApiParam(name="并联业务信息对象")@RequestBody BProjectBusinessEntity bProjectBusiness, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BProjectBusinessEntity>> failures = validator.validate(bProjectBusiness);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			bProjectBusinessService.save(bProjectBusiness);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("并联业务信息信息保存失败");
		}
		return Result.success(bProjectBusiness);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新并联业务信息",notes="更新并联业务信息")
	public ResponseMessage<?> update(@ApiParam(name="并联业务信息对象")@RequestBody BProjectBusinessEntity bProjectBusiness) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<BProjectBusinessEntity>> failures = validator.validate(bProjectBusiness);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			bProjectBusinessService.saveOrUpdate(bProjectBusiness);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新并联业务信息信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新并联业务信息信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除并联业务信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			bProjectBusinessService.deleteEntityById(BProjectBusinessEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("并联业务信息删除失败");
		}

		return Result.success();
	}
}
