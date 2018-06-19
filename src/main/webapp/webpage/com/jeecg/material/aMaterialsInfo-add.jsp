<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>A_MATERIALS_INFO</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
	 <script>
         <%-- //        update-start--Author:zhangguoming  Date:20140826 for：将combobox修改为combotree
                 function setdeptId() {
         //            var deptId = $("#orgSelect").combobox("getValues");
                     var deptId = $("#orgSelect").combotree("getValues");
                     $("#deptId").val(deptId);
                 }
                 $(function() {
                     $("#orgSelect").combotree({
                         onChange: function(n, o) {
                             if($("#orgSelect").combotree("getValues") != "") {
                                 $("#orgSelect option").eq(1).attr("selected", true);
                             } else {
                                 $("#orgSelect option").eq(1).attr("selected", false);
                             }
                         }
                     });
                     $("#orgSelect").combobox("setValues", ${orgIdList});
                     $("#orgSelect").combotree("setValues", ${orgIdList});
                 }); --%>
         //       update-start--Author:zhangguoming  Date:20140826 for：将combobox修改为combotree

         function openItessSelect() {
             $.dialog.setting.zIndex = getzIndex();
             var deptId = $("#deptId").val();
             // update-begin--Author:LiShaoQing  Date:20170802 for：z-index被覆盖的问题---------
             $.dialog({content: 'url:aItemsInfoController.do?getItemsInfo&orgIds='+deptId, zIndex: getzIndex(), title: '组织机构列表', lock: true, width: '400px', height: '350px', opacity: 0.4, button: [
                 {name: '<t:mutiLang langKey="common.confirm"/>', callback: callbackDepartmentSelect, focus: true},
                 {name: '<t:mutiLang langKey="common.cancel"/>', callback: function (){}}
             ]}).zindex();
             // update-end--Author:LiShaoQing  Date:20170802 for：z-index被覆盖的问题---------
         }

         function callbackDepartmentSelect() {
             var iframe = this.iframe.contentWindow;
             var treeObj = iframe.$.fn.zTree.getZTreeObj("itemsSelect");
             var nodes = treeObj.getCheckedNodes(true);
             if(nodes.length>0){
                 var ids='',names='';
                 for(i=0;i<nodes.length;i++){
                     var node = nodes[i];
                     ids += node.id;
                     names += node.name;
                 }
                 $('#deptName').val(names);
                 $('#deptName').blur();
                 $('#deptId').val(ids);
             }
         }

         function callbackClean(){
             $('#deptName').val('');
             $('#deptId').val('');
         }

         function setdeptId() {
             return true;
         }
         $(function(){
             $("#deptName").prev().hide();
         });
         <%--update-end--Author:zhangguoming  Date:20140825 for：添加组织机构combobox多选的处理方法--%>
	 </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="aMaterialsInfoController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${aMaterialsInfoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							材料编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="materialsId" name="materialsId" type="text" style="width: 150px" class="inputxt"  ignore="checked" datatype="*" errormsg="该字段不为空" />
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
					     	 <input id="materialsName" name="materialsName" type="text" style="width: 150px" class="inputxt"  ignore="checked" datatype="*" errormsg="该字段不为空" />
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
					     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
					     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
				</tr>--%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							事项编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="itemsId" name="itemsId" type="text" style="width: 150px" class="inputxt"  ignore="checked" datatype="*" errormsg="该字段不为空" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事项编号</label>
						</td>
				</tr>
				<%--<tr>
					<td align="right">
						<label class="Validform_label">
							事项编号:
						</label>
					</td>
					<td class="value">
						<input id="deptName" name="deptName" type="text" readonly="readonly" class="inputxt" datatype="*" value="${deptName}"/>
						<input id="deptId" name="deptId" type="hidden" value="${deptId}"/>
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" id="departSearch" onclick="openItessSelect()">选择</a>
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" id="departRedo" onclick="callbackClean()">清空</a>
							&lt;%&ndash;update-end--Author:jg_renjie  Date:20160320 for：#942 【组件封装】组织机构弹出模式，目前是列表，得改造成树方式&ndash;%&gt;
						<span class="Validform_checktip"><t:mutiLang langKey="please.muti.department"/></span>
						</td>
				</tr>--%>

				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/material/aMaterialsInfo.js"></script>		
