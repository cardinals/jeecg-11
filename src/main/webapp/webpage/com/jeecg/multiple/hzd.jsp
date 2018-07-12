<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>郑东新区建设项目并联审批监管系统</title>
    <link rel="stylesheet" type="text/css" href="plug-in//hzd/body.css">
    <script>
        function fn_print(param) {
            var bodyHtml = document.body.innerHTML;
            if(param=="hz_div_zs"){
                var html = document.getElementById("hz_div_zs").innerHTML;
                document.body.innerHTML=html;
                window.print();
            }else if(param=="hz_div_cd"){
                var html = document.getElementById("hz_div_cd").innerHTML;
                document.body.innerHTML=html;
                window.print();
            }
            document.body.innerHTML=bodyHtml;
        }
    </script>
</head>
<body>
<div align="center" id="hz_div" style="margin-top: 10px;">
    <div  style="width: 600px;" id="hz_div_zs" class="item-sel" title="预受理回执单（申请人）">
        <div align="center" >
        <div style="width: 100%;">
            <div>
                <strong><font style="font-size:20px;" class="systitle">郑东新区建设项目并联审批监管系统</font></strong>
                <br>
                <strong>业务预受理回执单</strong>
            </div>
        </div>
        <div style="text-align:right;margin:0;padding:0;height:20px;width: 600px; ">
            业务号：
            <span id="bsnum">${bProjectBusinessPage.businessId}</span>
        </div>
        <table width="600" border="1">
            <tbody>
            <tr>
                <th>项目名称</th>
                <td colspan="3">${bProjectBusinessPage.realityProjectName}</td>
            </tr>
            <tr>
                <th>用地类型</th>
                <td colspan="3">${bProjectBusinessPage.projectName}</td>
            </tr>
            <tr>
                <th>申请事项</th>
                <td colspan="3">${materialList[0].items_child_name}</td>
            </tr>
            <tr>
                <th>业务部门</th>
                <td>${materialList[0].dept_name}</td>
                <th>咨询电话</th>
                <td></td>
            </tr>
            <tr>
                <th width="15%">受理时间</th>
                <td width="35%">${bProjectBusinessPage.createTime}</td>
                <th width="15%">承诺时间</th>
                <td>${materialList[0].limit_days}
                    工作日
                </td>
            </tr>
            <tr>
                <th>材料接收人</th>
                <td>预受理人员</td>
                <th>受理网点</th>
                <td>郑东新区政务服务中心</td>
            </tr>
            <tr>
                <th>申 请 人</th>
                <td>${bProjectBusinessPage.applyName}</td>
                <th>联系方式</th>
                <td>${bProjectBusinessPage.applyPhone}</td>
            </tr>
            <%--<tr>
                <th>申 请 人</th>
                <td>${bProjectBusinessPage.applyName}</td>
                <th>联系方式</th>
                <td>${bProjectBusinessPage.applyPhone}</td>
            </tr>--%>
            <tr>
                <th valign="center">材料名称</th>
                <td colspan="3" valign="top" style="word-break: break-all">
                    已提交材料清单:
                    <ol style="margin-top: 3; margin-bottom: 3;">
                        <c:forEach items="${materialList}" var="material" varStatus="stuts">
                            <li>${stuts.index+1}、${fn:substring(material.materials_name, 0, 44) }</li>
                        </c:forEach>
                    </ol>
                </td>
            </tr>

            </tbody>
        </table>
        </div>
    </div>

    <div style="text-align: center; margin-top: 5px;">
        <a href='javascript:void(0)' onclick="fn_print('hz_div_zs');" style="background: #6ddae0;font-size: 13px;padding: 2px 8px 3px 8px;">打印</a>
    </div>
    <br>

    <div align="center" style="width: 600px;" id="hz_div_cd" class="print_page_break_ba item-sel" title="受理回执单（存档）">
        <div align="center">
        <div style="width: 100%;">
            <div>
                <strong><font style="font-size:20px;" class="systitle">郑东新区建设项目并联审批监管系统</font></strong>
                <br>
                <strong>业务单（存档）</strong>
            </div>
        </div>
        <div style="text-align:right;margin:0;padding:0;height:20px;width: 600px; ">
            业务号：
            <span id="bsnum">${bProjectBusinessPage.businessId}</span>
        </div>
        <table width="600" border="1">
            <tbody>
            <tr>
                <th>项目名称</th>
                <td colspan="3">${bProjectBusinessPage.realityProjectName}</td>
            </tr>
            <tr>
                <th>用地类型</th>
                <td colspan="3">${bProjectBusinessPage.projectName}</td>
            </tr>
            <tr>
                <th>申请事项</th>
                <td colspan="3">${materialList[0].items_child_name}</td>
            </tr>
            <tr>
                <th>业务部门</th>
                <td>${materialList[0].dept_name}</td>
                <th>咨询电话</th>
                <td></td>
            </tr>
            <tr>
                <th>材料接收人</th>
                <td>预受理人员</td>
                <th>受理网点</th>
                <td>郑东新区政务服务中心</td>
            </tr>
            <tr>
                <th width="15%">受理时间</th>
                <td width="35%">${bProjectBusinessPage.createTime}</td>
                <th width="15%">承诺时间</th>
                <td>${materialList[0].limit_days}
                    工作日
                </td>
            </tr>
            <tr>
                <th>申 请 人</th>
                <td>${bProjectBusinessPage.applyName}</td>
                <th>联系方式</th>
                <td>${bProjectBusinessPage.applyPhone}</td>
            </tr>
            <tr>
                <th valign="top">材料名称</th>
                <td colspan="3" valign="top" style="word-break: break-all">
                    已提交材料清单:
                    <ol style="margin-top: 3; margin-bottom: 3;">
                        <c:forEach items="${materialList}" var="material" varStatus="stuts">
                            <li>${stuts.index+1}、${fn:substring(material.materials_name, 0, 44) }</li>
                        </c:forEach>
                    </ol>
                </td>
            </tr>
            <tr>
                <th valign="center">
                    <div id="twocode_cd"></div>
                    申请确认
                </th>
                <td height="76" colspan="3" valign="bottom">
                    签名 ________________________
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    </div>
    <div style="text-align: center; margin-top: 5px;">
        <a href='javascript:void(0)' onclick="fn_print('hz_div_cd');" style="background: #6ddae0;font-size: 13px;padding: 2px 8px 3px 8px;">打印</a>
    </div>
    <br>
</div>


</body>
</html>