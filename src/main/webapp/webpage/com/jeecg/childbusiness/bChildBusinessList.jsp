<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="bChildBusinessList" pagination="true" fitColumns="true" title="子业务信息" actionUrl="bChildBusinessController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际项目名称"  field="realityProjectName" query="true"  width="120"></t:dgCol>
   <t:dgCol title="并联业务流水号"  field="businessId" hidden="true" query="true" width="120"></t:dgCol>
   <t:dgCol title="子业务流水号"  field="childBusinessId"  query="true" width="150"></t:dgCol>
   <t:dgCol title="项目编号"  field="projectId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="阶段编号"  field="phasesId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="事项编号"  field="itemsId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="事项名称"  field="itemsName"  queryMode="group"  width="180"></t:dgCol>
   <t:dgCol title="部门编号"  field="deptId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="部门名称"  field="deptName"  queryMode="group"  width="120"></t:dgCol>

   <t:dgCol title="createTime"  field="createTime"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请人名称"  field="applyName" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请公司"  field="applyCompany" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请人电话"  field="applyPhone"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请人身份证号"  field="applyIdentityCard"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请时间"  field="applyTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所剩时限"  field="ssgzr"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="业务状态"  field="status"  queryMode="group" replace="在办_0,办结_1,作废_2,补交挂起_3,特别程序_4,暂存_5,已归档_6" width="120"></t:dgCol>
   <t:dgCol title="预审内容"  field="checkContent" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预审时间"  field="checkTime"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="remark"  field="remark"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证照名称"  field="certificateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="证照路径"  field="certificatePath"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="证照上传时间"  field="certificateTime"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="上传人"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="bChildBusinessController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgFunOpt funname="view(id)" title="查看"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
   <%--<t:dgFunOpt funname="uploadMaterial(id)" title="证照上传"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>--%>

   <%--<t:dgToolBar title="录入" icon="icon-add" url="bChildBusinessController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bChildBusinessController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="bChildBusinessController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="bChildBusinessController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/childbusiness/bChildBusinessList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });


//查看
function view(id,tableName){
    createdetailwindow("查看", "bChildBusinessController.do?goUpdate&id="+id);
}
////证照上传
//function uploadMaterial(id){
//    createwindow("证照上传", "bProjectBusinessController.do?materialList&id="+id,"1000","500");
//}
//
////导入
//function ImportXls() {
//	openuploadwin('Excel导入', 'bChildBusinessController.do?upload', "bChildBusinessList");
//}

//导出
function ExportXls() {
	JeecgExcelExport("bChildBusinessController.do?exportXls","bChildBusinessList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("bChildBusinessController.do?exportXlsByT","bChildBusinessList");
}

 </script>