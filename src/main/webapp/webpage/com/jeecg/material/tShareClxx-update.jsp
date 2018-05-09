<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>T_SHARE_CLXX</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tShareClxxController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tShareClxxPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								材料编号:
							</label>
						</td>
						<td class="value">
						    <input id="clbh" name="clbh" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tShareClxxPage.clbh}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">材料编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								材料名称:
							</label>
						</td>
						<td class="value">
						    <input id="clmc" name="clmc" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tShareClxxPage.clmc}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">材料名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								dzhyq:
							</label>
						</td>
						<td class="value">
						    <input id="dzhyq" name="dzhyq" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tShareClxxPage.dzhyq}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">dzhyq</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建时间:
							</label>
						</td>
						<td class="value">
									  <input id="cjsj" name="cjsj" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${tShareClxxPage.cjsj}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建人ID:
							</label>
						</td>
						<td class="value">
						    <input id="cjrid" name="cjrid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.cjrid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								修改人ID:
							</label>
						</td>
						<td class="value">
						    <input id="xgrid" name="xgrid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.xgrid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改人ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								修改时间:
							</label>
						</td>
						<td class="value">
									  <input id="xgsj" name="xgsj" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${tShareClxxPage.xgsj}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="bz" name="bz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.bz}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								表单版本号:
							</label>
						</td>
						<td class="value">
						    <input id="formver" name="formver" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.formver}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表单版本号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								patterninstid:
							</label>
						</td>
						<td class="value">
						    <input id="patterninstid" name="patterninstid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.patterninstid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">patterninstid</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								表单ID:
							</label>
						</td>
						<td class="value">
						    <input id="xmlid" name="xmlid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.xmlid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">表单ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								status:
							</label>
						</td>
						<td class="value">
						    <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.status}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">status</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								orinum:
							</label>
						</td>
						<td class="value">
						    <input id="orinum" name="orinum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.orinum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">orinum</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								copynum:
							</label>
						</td>
						<td class="value">
						    <input id="copynum" name="copynum" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.copynum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">copynum</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								changetype:
							</label>
						</td>
						<td class="value">
						    <input id="changetype" name="changetype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.changetype}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">changetype</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								exchange:
							</label>
						</td>
						<td class="value">
						    <input id="exchange" name="exchange" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.exchange}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">exchange</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建时间:
							</label>
						</td>
						<td class="value">
									  <input id="createtime" name="createtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${tShareClxxPage.createtime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								修改时间:
							</label>
						</td>
						<td class="value">
									  <input id="modifytime" name="modifytime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${tShareClxxPage.modifytime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								yxq:
							</label>
						</td>
						<td class="value">
						    <input id="yxq" name="yxq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.yxq}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">yxq</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								事件组:
							</label>
						</td>
						<td class="value">
						    <input id="actiongroup" name="actiongroup" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.actiongroup}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事件组</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								type:
							</label>
						</td>
						<td class="value">
						    <input id="type" name="type" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.type}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">type</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								hybm:
							</label>
						</td>
						<td class="value">
						    <input id="hybm" name="hybm" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.hybm}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">hybm</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								hyfs:
							</label>
						</td>
						<td class="value">
						    <input id="hyfs" name="hyfs" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.hyfs}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">hyfs</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								hlwdz:
							</label>
						</td>
						<td class="value">
						    <input id="hlwdz" name="hlwdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.hlwdz}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">hlwdz</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								接口编号:
							</label>
						</td>
						<td class="value">
						    <input id="jkbh" name="jkbh" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.jkbh}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">接口编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								fgw:
							</label>
						</td>
						<td class="value">
						    <input id="fgw" name="fgw" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tShareClxxPage.fgw}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">fgw</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/material/tShareClxx.js"></script>		
