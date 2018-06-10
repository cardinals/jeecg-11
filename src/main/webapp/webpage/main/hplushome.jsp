<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->
    <title>郑东新区建设项目并联审批监管系统建设合同</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <link rel="shortcut icon" href="plug-in-ui/hplushome/images/favicon.ico">
    <link href="plug-in-ui/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="plug-in-ui/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="plug-in/hplushome/css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        //通知
        function notice(){
            createdetailwindow("通知", "noticeController.do?noticeList","700","500");
        }
        //公告
        function public(){
            createdetailwindow("公告", "noticeController.do?publicList","700","500");
        }
        //待上传
        function waitUpload(){
            createdetailwindow("待上传", "bProjectBusinessController.do?list","1000","500");
        }
        //待审核
        function waitCheck(){
            createdetailwindow("待审核", "bProjectBusinessController.do?list","1000","500");
        }
    </script>
</head>

<body style="overflow: hidden">
<%--<img src='plug-in/ace/img/zdxq_home.jpg' style="width:100%" />--%>


<div class="t2-main t2-main-bj">
    <div class="container" style="padding: 0;">

        <div class="t2-neiye to_top">
            <h1 class="t2_nytitle">待处理业务</h1>
            <div class="gzzjgl_content block_icon clearfix">
                <c:if test="${role =='WINDOW_ACCEPT'}">
                    <a href="javascript:void(0);" class="t2-xuanzhuan" onclick="waitUpload()">
                        <span class="duigou t2-abs">${witeUploadCount}</span>
                        <img src="plug-in/hplushome/images/sx_img1.png" alt="" /><br />待上传
                    </a>
                </c:if>
                <c:if test="${role =='DEPT_CHECK_ROLE'}">
                    <a href="javascript:void(0);" class="t2-xuanzhuan" onclick="waitCheck()">
                        <span class="duigou t2-abs">${witeCheckCount}</span>
                        <img src="plug-in/hplushome/images/sx_img1.png" alt="" /><br />待审核
                    </a>
                </c:if>


                <a href="javascript:void(0);" class="t2-xuanzhuan" onclick="notice()">
                    <span class="duigou t2-abs"  >${noticeCount}</span>
                    <img src="plug-in/hplushome/images/sx_img2.png" alt="" /><br />通知
                </a>
                <a href="javascript:void(0);" class="t2-xuanzhuan"onclick="public()">
                    <span class="duigou t2-abs" >${publicCount}</span>
                    <img src="plug-in/hplushome/images/sx_img3.png" alt="" /><br />公告
                </a>
            </div>
            <div class="pull-left t2_common_lr_left">
                <div class="panel panel-primary t2-delsb t2-panel t2-panel_style1">
                    <div class="panel-heading"> <a href="javascript:void(0)" style="line-height: 30px;" class="t2-panel-more">更多</a>
                        <h3 class="panel-title"><span><img src="plug-in/hplushome/images/index_icon4.png" alt="" style="margin-bottom:3px"/></span> 关注业务</h3>
                    </div>
                    <div class="panel-body">
                        <ul class="list-group t2-list-group">
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--   t2_common_lmr_left end  -->

            <div class="pull-right t2_common_lr_right" style="margin-left: 8%;float: left!important;width:;40%;">
                <div class="panel panel-primary t2-delsb t2-panel t2-panel_style1">
                    <div class="panel-heading"> <a href="javascript:void(0)" style="line-height: 30px;" class="t2-panel-more">更多</a>
                        <h3 class="panel-title"><span><img src="plug-in/hplushome/images/index_icon5.png" alt="" style="margin-bottom:3px"/></span> 系统公告</h3>
                    </div>
                    <div class="panel-body">
                        <ul class="list-group t2-list-group">
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                            <li class="list-group-item"><i class="glyphicon glyphicon-stop"></i> <a href="javascript:void(0)">中央机构编制委员会办公室关于实施城市生活无着的流浪乞讨人员救助</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--main end-->

<!--footer end-->

<script language="javascript" type="text/javascript" src="plug-in/hplushome/js/index.js"></script>
</div>

<!-- 全局js -->
<%--<script src="plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script>--%>
<script src="plug-in-ui/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="plug-in-ui/hplus/js/content.js"></script>
</body>

</html>
