<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="renderer" content="webkit">
 <meta name="applicable-device" content="pc,mobile">
 <meta http-equiv="Cache-Control" content="no-transform" />
 <meta name="MobileOptimized" content="width" />
 <meta name="HandheldFriendly" content="true" />
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta charset="UTF-8" />
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <title>业务日志信息</title>
 <t:base type="jquery,easyui,tools,DatePicker,fileupload"></t:base>

 <link rel="stylesheet" href="plug-in/businessLog/css/iconfonts.css" />
 <link rel="stylesheet" type="text/css" href="plug-in/businessLog/css/style.css">

 <%-- <script src = "plug-in/fileupload/js/myuploadfunction.js"></script>--%>
 <style>
  .str_p{
   line-height: 75px;text-indent: 55px;font-family: 'microsoft yahei';font-size: 24px;color: red;
  }
 </style>
 <script type="text/javascript">


 </script>

</head>
<body>
<header>
 <img src="plug-in/businessLog/img/progress-.png"/>阶段办理进度
 <div class="head-right iconfont icon-fanhui" style="font-weight:2;width:12%;cursor: pointer;" onclick="javascript:history.go(-1);">返回</div>
</header>
<div class="header-nav iconfont icon-xunhuan--">${bChildBusiness.itemsName}<img src="plug-in/businessLog/img/line-y.png"/></div>
<div class="center-category">
 <div class="center-title">以下状态模式时无论是在审核中还是在办结完状态均为这几种状态</div>
 <div class="center-section">



  <c:forEach items="${childLogList}" var="childLog" varStatus="stuts">

   <c:if test="${stuts.index % 2 == 0}">

   </c:if>
  <div class="section-line">
   <div class="section-tai">已办理完结</div>
   <div class="section-icon"></div>
   <c:if test="${childLog.node_name == '受理'}">
     <div class="section-img"><img src="plug-in/businessLog/img/01-02.png"/></div>
   </c:if>
   <c:if test="${childLog.node_name = '审核'}">
    <div class="section-img"><img src="plug-in/businessLog/img/02-02.png"/></div>
   </c:if>
   <c:if test="${childLog.node_name == '办结'}">
    <div class="section-img"><img src="plug-in/businessLog/img/03-01.png"/></div>
   </c:if>
   <div class="section-name">处理人：<span class="name-span" style="    font-size: 22px;">${childLog.handler}</span></div>
   <div class="section-time"><fmt:formatDate value="${childLog.handle_time}" pattern="yyyy年MM月dd日 HH:mm:ss" /></div>
   <div class="section-idea">${childLog.idea}</div>
  </div>
 </c:forEach>


 <%-- <div class="section-line">
   <div class="section-tai">正在办理中</div>
   <div class="section-icon-wai"></div>
   <div class="section-icon-two"></div>
   <div class="section-img"><img src="plug-in/businessLog/img/02-02.png"/></div>
   <div class="section-name">审批人：<span class="name-span">李思雨</span></div>
   <div class="section-time">2018.05.24<span class="time-span">10:55</span></div>
   <div class="section-idea"></div>
   <div class="tai-img"><img src="plug-in/businessLog/img/arrows-.png"/></div>
  </div>--%>
  <%--<div class="section-line lest">
   <div class="section-tai">未办理</div>
   <div class="section-icon"></div>
   <div class="section-img"><img src="plug-in/businessLog/img/03-01.png"/></div>
   <!--<div class="section-name">审批人：<span class="name-span">李思雨</span></div>
   <div class="section-time">2018.05.24<span class="time-span">10:55</span></div>-->
   <div class="section-idea"></div>
  </div>--%>
 </div>
</div>
<div class="Footer">
 <img src="plug-in/businessLog/img/line-y.png"/>
 <p class="Footer-One iconfont icon-zhuangtai">&nbsp;当前业务状态：<span class="str_p">${bChildBusiness.status  == '1' ? '已办结' : '审核中'}</span></p>
 <p class="Footer-Two iconfont icon-shizhong">&nbsp;所剩余时间为：<span class="str_p">${bChildBusiness.ssgzr} &nbsp;</span>个工作日&nbsp;&nbsp;
  <c:if test="${bChildBusiness.ssgzr == 0}">
   <strong class="str_p">预警</strong>
  </c:if>
  <c:if test="${bChildBusiness.ssgzr < 0}">
   <strong class="str_p">超期</strong>
  </c:if>
 </p>
</div>
<!--删除图标-->
<%--<div class="posi-img"><img src="plug-in/businessLog/img/delete.png"/></div>--%>
</body>

<script type="text/javascript">
    $(document).ready(function(){
    });



</script>