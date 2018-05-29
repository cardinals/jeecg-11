<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tShareClxxList" checkbox="true" pagination="true" fitColumns="true" title="T_SHARE_CLXX" actionUrl="tShareClxxController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="材料编号"  field="clbh"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="材料名称"  field="clmc"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="dzhyq"  field="dzhyq"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="cjsj"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人ID"  field="cjrid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改人ID"  field="xgrid"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="修改时间"  field="xgsj"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="group"  width="120"></t:dgCol>
  <%-- <t:dgCol title="表单版本号"  field="formver"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="patterninstid"  field="patterninstid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="表单ID"  field="xmlid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="status"  field="status"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="orinum"  field="orinum"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="copynum"  field="copynum"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="changetype"  field="changetype"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="exchange"  field="exchange"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createtime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="modifytime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="yxq"  field="yxq"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="事件组"  field="actiongroup"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="type"  field="type"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="hybm"  field="hybm"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="hyfs"  field="hyfs"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="hlwdz"  field="hlwdz"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="接口编号"  field="jkbh"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="fgw"  field="fgw"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tShareClxxController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tShareClxxController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tShareClxxController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tShareClxxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="tShareClxxController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/material/tShareClxxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tShareClxxController.do?upload', "tShareClxxList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tShareClxxController.do?exportXls","tShareClxxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tShareClxxController.do?exportXlsByT","tShareClxxList");
}

 </script>