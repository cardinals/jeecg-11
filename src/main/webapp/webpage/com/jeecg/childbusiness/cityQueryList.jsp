<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

 <script type="text/javascript">
 $(document).ready(function(){
//     window.location.href = "http://222.143.52.58:6081/login/doLogin.do?lcode=system&lkey=223344";
//     window.location.href = "http://222.143.52.58:6081/search/department/list.do";
     document.getElementById("iframe").src="http://222.143.52.58:6081/search/department/list.do";
 });

 </script>
<iframe border="0" src="http://222.143.52.58:6081/login/doLogin.do?lcode=system&lkey=223344" id="iframe" style="width:95%;height: 95%">


</iframe>