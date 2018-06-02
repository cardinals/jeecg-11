<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="bProjectBusinessList"  pagination="true" fitColumns="true" title="并联业务信息" actionUrl="bProjectBusinessController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="业务流水号"  field="businessId"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="实际项目名称"  field="realityProjectName"  query="true"  width="150"></t:dgCol>
   <t:dgCol title="项目id"  field="projectId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目状态"  field="projectStatus"  queryMode="group" replace="材料上传_1,预审核_2" width="80"></t:dgCol>
   <t:dgCol title="证照上传状态"  field="certificateStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="当前阶段编号"  field="currentPhases" hidden="true"  queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="当前阶段状态"  field="currentPhasesStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="完结时间"  field="completeTime" hidden="true" formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请人"  field="applyName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请公司"  field="applyCompany"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司营业执照编号"  field="businessLicenseId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="法人身份证号码"  field="legalPersonCard"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请人身份证号"  field="applyIdentityCard"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请人电话"  field="applyPhone"  hidden="true"  queryMode="group"  width="120"></t:dgCol>

   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="accept(id)" title="查看"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
   <%--<t:dgFunOpt funname="uploadMaterial(id)" title="材料上传"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
   <t:dgFunOpt funname="uploadCertificate(id)" title="证照上传"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>--%>

   <c:if test="${role =='WINDOW_ACCEPT'}">
    <t:dgFunOpt funname="uploadcl(id)" title="材料上传"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
    <%--<t:dgDelOpt title="删除" url="bProjectBusinessController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   </c:if>
   <c:if test="${role =='DEPT_CHECK_ROLE'}">
    <t:dgFunOpt funname="uploadCertificate(id)" title="预审核"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
   </c:if>
   <%--<t:dgFunOpt funname="loadBusinessLog(id)" title="流程日志"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>--%>
   <%--<t:dgDelOpt title="删除" url="bProjectBusinessController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="bProjectBusinessController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="bProjectBusinessController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="bProjectBusinessController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="bProjectBusinessController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/multiple/bProjectBusinessList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });


//查看
function accept(id,tableName){
    createdetailwindow("查看", "bProjectBusinessController.do?goUpdate&id="+id);
}
//材料上传
function uploadMaterial(id){
    //材料上传权限进入查看窗口
    if("WINDOW_ACCEPT"=="${role}"){
        createdetailwindow("材料上传", "bProjectBusinessController.do?materialList&id="+id,"1000","500");
    }else{
        createwindow("材料上传", "bProjectBusinessController.do?materialList&id="+id,"1000","500");
    }
}
////证照上传
//function uploadCertificate(id){
//    createdetailwindow("证照上传", "bProjectBusinessController.do?certificateList&id="+id,"1000","500");
//}

//材料上传
function uploadCertificate(id){
    if("WINDOW_ACCEPT"=="${role}"){
        createdetailwindow("材料上传", "bProjectBusinessController.do?certificateList&id="+id,"1000","500");
    }else{
        createdetailwindow("预审核", "bProjectBusinessController.do?certificateList&id="+id,"1000","500");
    }

}
 //材料上传
 function uploadcl(id){
     if("WINDOW_ACCEPT"=="${role}"){
         createdetailwindow("材料上传", "bProjectBusinessController.do?uploadcl&id="+id,"1000","500");
     }else{
         createdetailwindow("预审核", "bProjectBusinessController.do?uploadcl&id="+id,"1000","500");
     }

 }
////流程日志
//function loadBusinessLog(id){
//    window.open("bProjectBusinessController.do?loadBusinessLog&id="+id);
//}
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'bProjectBusinessController.do?upload', "bProjectBusinessList");
}

//导出
function ExportXls() {
	JeecgExcelExport("bProjectBusinessController.do?exportXls","bProjectBusinessList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("bProjectBusinessController.do?exportXlsByT","bProjectBusinessList");
}

 </script>