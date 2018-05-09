<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <title>并联业务证照信息</title>
 <t:base type="jquery,easyui,tools,DatePicker,fileupload"></t:base>
 <%-- <script src = "plug-in/fileupload/js/myuploadfunction.js"></script>--%>
 <script type="text/javascript">
     $(function(){
         $('input.materials').fileupload({
             dataType: 'json',
             acceptFileTypes: /(\.|\/)(gif|jpe?g|png|pdf|txt|doc|docx|xls|xlsx|ppt)$/i,
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

 </script>

</head>
<body>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
   <table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable table table-hover" >
    <thead>
    <tr>
     <th>序号</th>
     <th style="width: 20%;">实际项目名称</th>
     <th style="width: 30%;">阶段编号</th>
     <th style="width: 30%;">事项名称</th>
     <%--<th style="width: 40%;">材料名称</th>--%>
     <th style="width: 40%;">操作</th>
    </tr>
    </thead>
   <c:if test="${fn:length(certificateList)  > 0 }">
    <c:forEach items="${certificateList}" var="certificate" varStatus="stuts">
     <tr style="height: 42px;">
      <td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>

      <input name="certificateList[${stuts.index }].project_id" type="hidden" value="${certificate.project_id }"/>
      <td align="center">
        ${certificate.reality_project_name }
      </td>
      <td align="center">
        ${certificate.phases_id }
      </td>

      <td align="center">
        ${certificate.items_name }<label class="Validform_label" style="display: none;">事项名称</label>
      </td>
      <%--<td align="center">
        ${certificate.certificates_id }
       <label class="Validform_label" style="display: none;">材料编号</label>
      </td>--%>
     <%-- <td align="left" title="${certificate.certificates_name }">
        ${fn:substring(certificate.certificates_name, 0, 40) }
      </td>--%>
      <td align="center">
        <%--<input type="file">--%>

        <label class="Validform_label"> 文件上传: </label>
        <span class="btn btn-success fileinput-button"><span>选择文件</span>
         <input id="fileupload" type="file" name="files[]"
               data-url="AcertificatesUploadController.do?uploadFile" multiple>&nbsp;&nbsp;
                         <input id="filePaths" name="filePaths" type="hidden" />
        </span>

        <label class="Validform_label"> 文件列表: </label>
       <div class="value" colspan="2" id="fileList"><c:forEach
               var="file" items="${casefileList}">
        <div id="${file.id }">
         <a href='AcertificatesUploadController.do?downloadFile&id=${file.id}&type=download'>${file.name }</a>&nbsp;&nbsp;<a
                href="javascript:void(0)" onclick="delFile('','1','${file.id}')">删除</a>
        </div>
       </c:forEach></div>

       </td>
      </tr>
    </c:forEach>
   </c:if>
   </table>
  </div>
 </div>
</body>
 <script src = "webpage/com/jeecg/multiple/bProjectBusinessList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });


//查看
function accept(id,tableName){
    createwindow("查看", "AcertificatesUploadController.do?goUpdate&id="+id);
}
//材料上传
function uploadcertificate(id){
    createwindow("材料上传", "AcertificatesUploadController.do?certificateList&id="+id);
}
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'AcertificatesUploadController.do?upload', "bProjectBusinessList");
}

//导出
function ExportXls() {
	JeecgExcelExport("AcertificatesUploadController.do?exportXls","bProjectBusinessList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("AcertificatesUploadController.do?exportXlsByT","bProjectBusinessList");
}

 </script>