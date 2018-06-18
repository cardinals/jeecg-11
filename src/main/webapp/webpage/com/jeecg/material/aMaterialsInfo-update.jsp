<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>A_MATERIALS_INFO</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="aMaterialsInfoController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${aMaterialsInfoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								材料编号:
							</label>
						</td>
						<td class="value">
						    <input id="materialsId" name="materialsId" type="text" style="width: 150px" class="inputxt"  ignore="checked"  value='${aMaterialsInfoPage.materialsId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">材料编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								材料名称:
							</label>
						</td>
						<td class="value">
						    <input id="materialsName" name="materialsName" type="text" style="width: 150px" class="inputxt"  ignore="checked"  value='${aMaterialsInfoPage.materialsName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">材料名称</label>
						</td>
					</tr>
					<%--<tr>
						<td align="right">
							<label class="Validform_label">
								状态:
							</label>
						</td>
						<td class="value">
						    <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aMaterialsInfoPage.status}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					</tr>--%>
					<tr>
						<td align="right">
							<label class="Validform_label">
								remark:
							</label>
						</td>
						<td class="value">
						    <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aMaterialsInfoPage.remark}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">remark</label>
						</td>
					</tr>
					<%--<tr>
						<td align="right">
							<label class="Validform_label">
								createTime:
							</label>
						</td>
						<td class="value">
									  <input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${aMaterialsInfoPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'/>
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
									  <input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${aMaterialsInfoPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">updateTime</label>
						</td>
					</tr>--%>
					<tr>
						<td align="right">
							<label class="Validform_label">
								事项编号:
							</label>
						</td>
						<td class="value">
						    <input id="itemsId" name="itemsId" type="text" style="width: 150px" class="inputxt"  ignore="checked"  value='${aMaterialsInfoPage.itemsId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事项编号</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/material/aMaterialsInfo.js"></script>		
