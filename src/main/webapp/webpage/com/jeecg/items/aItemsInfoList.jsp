<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="aItemsInfoList" checkbox="true" pagination="true" fitColumns="true" title="A_ITEMS_INFO" actionUrl="aItemsInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目id"  field="projectId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="阶段id"  field="phasesId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="事项编号"  field="itemsId"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="事项子项编号"  field="itemsChildId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="事项名称"  field="itemsName" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="事项子项名称"  field="itemsChildName"  query="true"   width="120"></t:dgCol>
   <t:dgCol title="部门编号"  field="deptId"  hidden="true"  queryMode="group"   width="120"></t:dgCol>
   <t:dgCol title="部门名称"  field="deptName"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="承诺时限"  field="limitDays"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="createTime"  field="createTime"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="updateTime"  field="updateTime"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="status"  field="status" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark" hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="delFlag"  field="delFlag"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="aItemsInfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="aItemsInfoController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="aItemsInfoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="aItemsInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="aItemsInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/items/aItemsInfoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'aItemsInfoController.do?upload', "aItemsInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("aItemsInfoController.do?exportXls","aItemsInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("aItemsInfoController.do?exportXlsByT","aItemsInfoList");
}

 </script>