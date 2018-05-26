<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目基本信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="aProjectInfoController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${aProjectInfoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="projectId" name="projectId" type="text" style="width: 150px" class="inputxt" datatype="*" ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目编号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="projectName" name="projectName" type="text" style="width: 150px" class="inputxt" datatype="*" ignore="checked"  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
				</tr>
				<%--<tr>
					<td align="right">
						<label class="Validform_label">
							createTime:
						</label>
					</td>
					<td class="value">
							   <input id="createTime" name="createTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">createTime</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							updateTime:
						</label>
					</td>
					<td class="value">
							   <input id="updateTime" name="updateTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">updateTime</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							delFlag:
						</label>
					</td>
					<td class="value">
					     	 <input id="delFlag" name="delFlag" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">delFlag</label>
						</td>
				</tr>--%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目简介:
						</label>
					</td>
					<td class="value">
					     	 <input id="projectIntro" name="projectIntro" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目简介</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">remark</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/business/aProjectInfo.js"></script>		
