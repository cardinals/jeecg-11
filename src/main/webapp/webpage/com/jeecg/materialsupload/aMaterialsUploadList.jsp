<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="aMaterialsUploadList" checkbox="true" pagination="true" fitColumns="true" title="材料上传信息" actionUrl="aMaterialsUploadController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="业务编号"  field="businessId"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="项目编号"  field="projectId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="阶段编号"  field="phasesId"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="事项名称"  field="itemsChildName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="材料编号"  field="materialsId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文件名称"  field="materialsName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文件类型"  field="materialsType"  queryMode="group" replace="证照_2,材料_1" width="120"></t:dgCol>
   <%--<t:dgCol title="文件路径"  field="materialsPath" queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="createTime"  field="createTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="上传时间"  field="updateTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="备注"  field="remark"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="view(id)" title="查看"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
   <%--<t:dgDelOpt title="删除" url="aMaterialsUploadController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="aMaterialsUploadController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="aMaterialsUploadController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="aMaterialsUploadController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="aMaterialsUploadController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/materialsupload/aMaterialsUploadList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });


 //查看
 function view(id,tableName){
     window.open("aMaterialsUploadController.do?downloadFile&id="+id+"&type=download");
 }
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'aMaterialsUploadController.do?upload', "aMaterialsUploadList");
}

//导出
function ExportXls() {
	JeecgExcelExport("aMaterialsUploadController.do?exportXls","aMaterialsUploadList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("aMaterialsUploadController.do?exportXlsByT","aMaterialsUploadList");
}

 </script>