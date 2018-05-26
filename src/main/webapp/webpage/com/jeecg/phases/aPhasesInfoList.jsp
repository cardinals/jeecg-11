<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="aPhasesInfoList" checkbox="true" pagination="true" fitColumns="true" title="A_PHASES_INFO" actionUrl="aPhasesInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目编号"  field="projectId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="阶段编号"  field="phasesId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="阶段名称"  field="phasesName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createTime"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="updateTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="阶段状态"  field="phasesStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="aPhasesInfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="aPhasesInfoController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="aPhasesInfoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="aPhasesInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="aPhasesInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/phases/aPhasesInfoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'aPhasesInfoController.do?upload', "aPhasesInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("aPhasesInfoController.do?exportXls","aPhasesInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("aPhasesInfoController.do?exportXlsByT","aPhasesInfoList");
}

 </script>