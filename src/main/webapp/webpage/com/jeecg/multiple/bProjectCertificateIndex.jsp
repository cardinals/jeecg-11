<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="bProjectBusinessList"  pagination="true" fitColumns="true" title="证照信息" actionUrl="bProjectBusinessController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="业务流水号"  field="businessId"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="realityProjectName"  query="true"  width="150"></t:dgCol>
   <t:dgCol title="项目编号"  field="projectId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用地类型"  field="projectName"  query="true" replace="郑东新区招拍挂类建设项目_郑东新区招拍挂类建设项目,招拍挂类项目(测试)_招拍挂类项目(测试),3_3" width="120"></t:dgCol>
   <%--<t:dgCol title="项目状态"  field="projectStatus"  queryMode="group" replace="证照上传_1,证照查看_2" width="80"></t:dgCol>--%>
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
   <%--<t:dgFunOpt funname="accept(id)" title="查看"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>--%>
   <%--<t:dgFunOpt funname="uploadMaterial(id)" title="证照上传"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
   <t:dgFunOpt funname="uploadCertificate(id)" title="证照上传"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>--%>

   <c:if test="${role =='WINDOW_ACCEPT'}">
    <t:dgFunOpt funname="uploadCertificate(id)" title="证照上传"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
    <%--<t:dgDelOpt title="删除" url="bProjectBusinessController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   </c:if>
   <c:if test="${role =='DEPT_CHECK_ROLE'}">
    <t:dgFunOpt funname="uploadCertificate(id)" title="证照查看"  urlclass="ace_button"  urlfont="fa-copy"></t:dgFunOpt>
   </c:if>

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


//证照上传
function uploadCertificate(id){
    if("WINDOW_ACCEPT"=="${role}"){
        createdetailwindow("证照上传", "bProjectBusinessController.do?certificateList&id="+id,"1000","500");
    }else{
        createdetailwindow("证照查看", "bProjectBusinessController.do?certificateList&id="+id,"1000","500");
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