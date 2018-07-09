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
         $("#change_phases").change(function(){
             var opt=$("#change_phases").val();
             window.location.href="bProjectBusinessController.do?uploadcl&id=${bProjectBusinessPage.id}&phasesId="+opt;
         });
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

   <span style="display:-moz-inline-box;display:inline-block;margin-bottom:2px;text-align:justify;">
   <span style="vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 90px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; " title="选择阶段">选择阶段：</span>
   <select name="change_phases" id="change_phases"  width="120" style="width: 120px">
    <option value="">-- 所有阶段 --</option>
    <option value="001" <c:if test="${phasesId=='001'}">selected="selected"</c:if>>第一阶段</option>
    <option value="002" <c:if test="${phasesId=='002'}">selected="selected"</c:if>>第二阶段</option>
    <option value="003" <c:if test="${phasesId=='003'}">selected="selected"</c:if>>第三阶段</option>
    <option value="004" <c:if test="${phasesId=='004'}">selected="selected"</c:if>>第四阶段</option>
    <option value="005" <c:if test="${phasesId=='005'}">selected="selected"</c:if>>第五阶段</option>
   </select>
  </span>

   <table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable table table-hover" >
    <thead>
    <tr style="height: 42px;background: #81b5e2">
     <th align="center" style="width: 3%;">序号</th>
     <th align="center" style="width: 15%;">部门名称</th>
     <%--<th align="center" style="width: 20%;">实际项目名称</th>--%>
     <th align="center" style="width: 8%;">阶段</th>
     <th align="center" style="width: 25%;">事项名称</th>
     <%--<th style="width: 40%;">材料名称</th>--%>
     <c:if test="${role =='WINDOW_ACCEPT'}">
      <th align="center" style="width: 15%;">证照上传</th>
     </c:if>
     <th align="center" style="width: 20%;">证照名称</th>
     <%--<th align="center" style="width: 8%;">操作</th>--%>

    </tr>
    </thead>
   <c:if test="${fn:length(certificateList)  > 0 }">
    <c:forEach items="${certificateList}" var="certificate" varStatus="stuts">
     <c:if test="${stuts.index % 2 == 0}">
      <tr style="height: 42px;background: #ebecdb;">
     </c:if>
     <c:if test="${stuts.index % 2 != 0}">
      <tr style="height: 42px;background: #f8f8f9;">
     </c:if>
      <td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>

      <input name="certificateList[${stuts.index }].project_id" type="hidden" value="${certificate.project_id }"/>
     <td align="center">
       ${certificate.dept_name }
     </td>
     <%--<td align="center">
        ${certificate.reality_project_name }
      </td>--%>
      <td align="center">
       <c:if test="${certificate.phases_id == '001' }">
         第一阶段
       </c:if>
       <c:if test="${certificate.phases_id == '002' }">
        第二阶段
       </c:if>
       <c:if test="${certificate.phases_id == '003' }">
        第三阶段
       </c:if>
       <c:if test="${certificate.phases_id == '004' }">
        第四阶段
       </c:if>
       <c:if test="${certificate.phases_id == '005' }">
        第五阶段
       </c:if>
       <c:if test="${certificate.phases_id == '006' }">
        第六阶段
       </c:if>
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
     <c:if test="${role =='WINDOW_ACCEPT'}">
      <%--<td align="center">
       &lt;%&ndash;<c:if test="${certificate.dept_id == deptId }">&ndash;%&gt;
         <span class="btn btn-success fileinput-button"><span>选择文件</span>
           <input class="materials" id="fileupload" type="file" name="files[]" data-url="aMaterialsUploadController.do?uploadFile&id=${certificate.id }&type=2"  >
           &nbsp;&nbsp;  <input id="filePaths" name="filePaths" type="hidden" />
         </span>
       </td>--%>

      <td align="center">
        <%--<span class="btn btn-success fileinput-button"><span>本地上传</span>--%>
       <span class="fileinput-button" style="background: #4eb110;;color: white;padding: 2px;width: 50px;height: 20px;"><font>本地上传</font>
         <input class="materials" id="fileupload" type="file" name="files[]" data-url="aMaterialsUploadController.do?uploadFile&id=${certificate.id }&type=2"  >
         &nbsp;&nbsp;  <input id="filePaths" name="filePaths" type="hidden" />
        </span>

       <span class="fileinput-button" style="cursor:pointer;background: #498bdc;color: white;padding: 2px;width: 50px;height: 20px;" onclick="javascript:window.open('bProjectBusinessController.do?gpy&id=${bProjectBusinessPage.id}&itemsId=${certificate.items_id}&materialId=${certificate.id }&type=2 ')"><font>拍照上传</font>
        </span>
      </td>

     </c:if>


      <td align="left" title="${certificate.file_name }">
       <%--<a href='aMaterialsUploadController.do?downloadFile&id=${certificate.id }&type=download' target='_blank'>${certificate.file_name }</a>--%>
       <a href='bProjectBusinessController.do?fileView&id=${certificate.id }&type=download' target='_blank'>${certificate.file_name }</a>
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