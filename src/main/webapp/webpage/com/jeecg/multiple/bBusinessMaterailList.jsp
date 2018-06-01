<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <title>并联业务信息</title>
 <t:base type="jquery,easyui,tools,DatePicker,fileupload"></t:base>
<%-- <script src = "plug-in/fileupload/js/myuploadfunction.js"></script>--%>
 <script type="text/javascript">
     $(function(){
         $('input.materials').fileupload({
             dataType: 'json',
             acceptFileTypes: /(\.|\/)(gif|jpe?g|png|pdf|txt|doc|docx|xls|xlsx|ppt|rar|zip)$/i,
             maxFileSize: 2097152*3,  // 2*3 MB
             done: function (e, data) {
                 debugger;
                 console.log(data);
                 var id = data.result.obj;
//                 var uploadPath = data.result.obj;
//                 uploadPath = uploadPath.replace("\\", "\\\\");
//                 var filePaths = $("#filePaths").val();
//                 if(filePaths==null||filePaths==""){
//                     $("#filePaths").val(uploadPath);
//                 }else{
//                     $("#filePaths").val(filePaths+","+uploadPath);
//                 }
                 for(var i=0;i<data.files.length;i++){
                     var idaa= Math.random().toString(36).substr(2);
//                     var u=uploadPath.replace(/\\/g,"\\\\");
//                     $("#fileList").append("<div id='"+idaa+"'><a href='aMaterialsUploadController.do?downloadFile&id="+id+"&type=download' target='_blank'>"+data.files[i].name+"</a>&nbsp;&nbsp;<a href='javascript:void(0)' onclick=\"delFile('','0','"+idaa+"')\">删除</a></div>");
                     window.location.reload();
                 }
             }
         }).on('fileuploadprocessalways', function (e, data) {
             console.info(data.files);
             if(data.files.error){
                 if(data.files[0].error=='File type not allowed'){
                     alertTip(data.files[0].name+'文件类型错误','提示');
                 }
                 if(data.files[0].error=='File is too large'){
                     alert(data.files[0].name+"文件过大");
                 }
             }
         });
     });
     function delFile(filePath,type,idaa){
         $.dialog.setting.zIndex =9999;
         $.dialog.confirm("确认删除该文件吗?", function(){
             if(type=="0"){
                 var filePaths = $("#filePaths").val();
                 filePaths=filePaths.replace(filePath,"");
                 $("#filePaths").val(filePaths);
                 $("#"+idaa).hide();
             }else{
                 var url="aMaterialsUploadController.do?delFile&fileId="+idaa;
                 $.ajax({
                     type : 'POST',
                     url : url,// 请求的action路径
                     error : function() {// 请求失败处理函数
                     },
                     success : function(data) {
                         var d = $.parseJSON(data);
                         if (d.success) {
                             var msg = d.msg;
                             tip(msg);
                         }
                         $("#"+idaa).hide();
                     }
                 });
             }
         }, function(){
         });
     }
function check_sub() {
    $("#formobj").submit();
}
 </script>

</head>
<body>

<%--<form name="formobj" id="formobj" action="bProjectBusinessController.do?doCheck" method="post"></form>--%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
   <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="bProjectBusinessController.do?doCheck" >
   <table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable" >
    <thead>
    <tr style="height: 42px;background: #e897ad;">
     <th align="center">序号</th>
     <th align="center" style="width: 15%;">部门名称</th>
     <th align="center" style="width: 25%;">事项名称</th>
     <th align="center" style="width: 30%;">材料名称</th>
     <c:if test="${role =='WINDOW_ACCEPT'}">
      <th align="center" style="width: 15%;">操作</th>
     </c:if>

     <th align="center" style="width: 20%;">文件名称</th>
    </tr>
    </thead>
   <c:if test="${fn:length(materialList)  > 0 }">
    <input name="businessId" type="hidden" value="${materialList[0].business_id }"/>
    <input name="projectId" type="hidden" value="${materialList[0].project_id }"/>
    <input name="phasesId" type="hidden" value="${materialList[0].phases_id }"/>
    <input name="itemsId" type="hidden" value="${materialList[0].items_id }"/>
    <input name="deptId" type="hidden" value="${materialList[0].dept_id }"/>



    <c:forEach items="${materialList}" var="material" varStatus="stuts">
     <c:if test="${stuts.index % 2 == 0}">
      <tr style="height: 42px;background: #ebecdb;">
     </c:if>
     <c:if test="${stuts.index % 2 != 0}">
      <tr style="height: 42px;background: #d5d5e0;">
     </c:if>
      <td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>

      <input name="materialList[${stuts.index }].project_id" type="hidden" value="${material.project_id }"/>
      <td align="center">
        ${material.dept_name }
      </td>
      <%--<td align="center">
        ${material.items_id }
       <label class="Validform_label" style="display: none;">事项编号</label>
      </td>--%>
      <td align="center">
        ${material.items_child_name }
      </td>
      <%--<td align="center">
        ${material.materials_id }
       <label class="Validform_label" style="display: none;">材料编号</label>
      </td>--%>
      <td align="left" title="${material.materials_name }">
        ${fn:substring(material.materials_name, 0, 44) }
      </td>

     <c:if test="${role =='WINDOW_ACCEPT'}">
      <td align="center">
        <span class="btn btn-success fileinput-button"><span>选择文件</span>
         <input class="materials" id="fileupload" type="file" name="files[]" data-url="aMaterialsUploadController.do?uploadFile&id=${material.id }&type=1"  >
         &nbsp;&nbsp;  <input id="filePaths" name="filePaths" type="hidden" />
        </span>
       </td>
     </c:if>
      <td align="left" title="${material.file_name }">
       <a href='aMaterialsUploadController.do?downloadFile&id=${material.id }&type=download' target='_blank'>${material.file_name }</a>
      </td>
      </tr>
    </c:forEach>
   </c:if>
   </table>

   <c:if test="${role =='DEPT_CHECK_ROLE'}">
    <br>
    <div>
      审核状态：
      <select name="checkStatus">
       <option value="1" ${checklList[0].check_status==1?'selected':''}>通过</option>
       <option value="0" ${checklList[0].check_status==0?'selected':''}>退回</option>
      </select><br>
      审核意见：
      <textarea name="checkContent" id="checkContent" style="width: 99%;height: 80px;max-width: 99%">${checklList[0].check_content }</textarea>
     <div style="text-align: center;">
      <a href='javascript:void(0)' onclick="javascript:history.go(-1)" class="ace_button" target='_blank'>返回</a>
      <a href='javascript:void(0)' onclick="check_sub()" class="ace_button" target='_blank' style="background-color: #d25656;">提交</a>
     </div>
    </div>
   </c:if>

    <c:if test="${role !='DEPT_CHECK_ROLE'}">
     <br>
    <%--<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable" >
     <thead>
     <tr style="height: 42px;background: #e897ad;">
      <th align="center">序号</th>
      <th align="center" style="width: 15%;">部门名称</th>
      <th align="center" style="width: 25%;">事项名称</th>
      <th align="center" style="width: 30%;">审核意见</th>
      <th align="center" style="width: 15%;">审核时间</th>
     </tr>
     </thead>
      <c:forEach items="${checklList}" var="check" varStatus="stuts">
      <c:if test="${stuts.index % 2 == 0}">
      <tr style="height: 42px;background: #ebecdb;">
       </c:if>
       <c:if test="${stuts.index % 2 != 0}">
      <tr style="height: 42px;background: #d5d5e0;">
       </c:if>
         <td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
         <td align="center">
           ${check.dept_name }
         </td>
          <td align="center">
            ${check.items_name }
          </td>
          <td align="center">
            ${check.check_content }
          </td>
          <td align="center">
            ${check.check_time }
          </td>
        </tr>
      </c:forEach>
    </table>--%>
     <div>
      审核状态：
      <c:if test="${checklList[0].check_status == 0}">退回</c:if>
      <c:if test="${checklList[0].check_status == 1}">通过</c:if>
      <c:if test="${checklList[0].check_status == '' || checklList[0].check_status == null}">待审核</c:if>
      <br>
      审核意见：
      <textarea name="checkContent" readonly style="width: 99%;height: 80px;max-width: 99%">${checklList[0].check_content }</textarea>
      <div style="text-align: center;">
       <a href='javascript:void(0)' onclick="javascript:history.go(-1)" class="ace_button" target='_blank'>返回</a>
      </div>
     </div>
    </c:if>

  </div>
 </div>
<%--</form>--%>
</t:formvalid>
</body>
 <script src = "webpage/com/jeecg/multiple/bProjectBusinessList.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
 });

//提交审核意见
function sub_check(){
    $("#check_content").val();
    alert($("#check_content").html());
}

//查看
function accept(id,tableName){
    createwindow("查看", "aMaterialsUploadController.do?goUpdate&id="+id);
}
//材料上传
function uploadMaterial(id){
    createwindow("材料上传", "aMaterialsUploadController.do?materialList&id="+id);
}
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'aMaterialsUploadController.do?upload', "bProjectBusinessList");
}

//导出
function ExportXls() {
	JeecgExcelExport("aMaterialsUploadController.do?exportXls","bProjectBusinessList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("aMaterialsUploadController.do?exportXlsByT","bProjectBusinessList");
}

 </script>