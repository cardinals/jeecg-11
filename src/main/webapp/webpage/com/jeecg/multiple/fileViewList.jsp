<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <title>并联业务信息</title>
 <t:base type="jquery,easyui,tools,DatePicker,fileupload"></t:base>
<%-- <script src = "plug-in/fileupload/js/myuploadfunction.js"></script>--%>
 <script type="text/javascript">
     $(function(){
     });
     function deleteFile(fileId) {
         debugger;
         $.post("aMaterialsUploadController.do?delFile&fileId="+fileId,function(data){
             var d = $.parseJSON(data);
             if (d.success) {
                 alert(d.msg);
                 location.reload();
             }else{
                 alert(d.msg);
             }
         });
     }
 </script>

</head>
<body>
<c:forEach items="${fileList}" var="file" varStatus="stuts">
<%-- <c:if test="${stuts.index % 2 == 0}">
1111:${file.materials_name}---<img src="${file.materials_path}">
 </c:if>
 <c:if test="${stuts.index % 2 != 0}">
2222:${file.materials_name} ---<img src="${file.materials_path}">
 </c:if>--%>
 <div style="height: 240px;width: 240px;float: left">
  <img src="${file.materials_path}" style="width:180px;height: 180px "><br>
  下载：<a href='aMaterialsUploadController.do?downloadFile&id=${file.id }&type=download' target='_blank'>${fn:substring(file.materials_name, 36,60)}</a><br>
  删除：<a href='javascript:void(0)' onclick="deleteFile('${file.id }')">${fn:substring(file.materials_name, 36,60)}</a><br>
 </div>

 <%--下载：<a href='${file.materials_path}' target='_blank'>${fn:substring(file.materials_name, 36,-1)}</a><br>--%>


</c:forEach>

</body>
 <script src = "webpage/com/jeecg/multiple/bProjectBusinessList.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
 });


 </script>