<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>并联业务信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="bProjectBusinessController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${bProjectBusinessPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>

						<td align="right">
							<label class="Validform_label">
								项目id:
							</label>
						</td>
						<td class="value">
						    <input id="projectId" name="projectId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" value='${bProjectBusinessPage.projectId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目id</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								项目名称:
							</label>
						</td>
						<td class="value">
							<input id="projectName" name="projectName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" value='${bProjectBusinessPage.projectName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>

					</tr>
					<%--<tr>

						<td align="right">
							<label class="Validform_label">
								项目状态:
							</label>
						</td>
						<td class="value">
						    <input id="projectStatus" name="projectStatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.projectStatus}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								证照上传状态:
							</label>
						</td>
						<td class="value">
						    <input id="certificateStatus" name="certificateStatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.certificateStatus}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证照上传状态</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								当前阶段编号:
							</label>
						</td>
						<td class="value">
						    <input id="currentPhases" name="currentPhases" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.currentPhases}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当前阶段编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								当前阶段状态:
							</label>
						</td>
						<td class="value">
						    <input id="currentPhasesStatus" name="currentPhasesStatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.currentPhasesStatus}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当前阶段状态</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建时间:
							</label>
						</td>
						<td class="value">
									  <input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${bProjectBusinessPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>--%>
					<tr>
						<%--<td align="right">
							<label class="Validform_label">
								完结时间:
							</label>
						</td>
						<td class="value">
									  <input id="completeTime" name="completeTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${bProjectBusinessPage.completeTime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">完结时间</label>
						</td>--%>
						<td align="right">
							<label class="Validform_label">
								实际项目名称:
							</label>
						</td>
						<td class="value">
							<input id="realityProjectName" name="realityProjectName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.realityProjectName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际项目名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								申请人:
							</label>
						</td>
						<td class="value">
						    <input id="applyName" name="applyName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.applyName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								申请公司:
							</label>
						</td>
						<td class="value">
						    <input id="applyCompany" name="applyCompany" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.applyCompany}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请公司</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								公司营业执照编号:
							</label>
						</td>
						<td class="value">
						    <input id="businessLicenseId" name="businessLicenseId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.businessLicenseId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司营业执照编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								法人身份证号码:
							</label>
						</td>
						<td class="value">
						    <input id="legalPersonCard" name="legalPersonCard" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.legalPersonCard}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">法人身份证号码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								申请人身份证号:
							</label>
						</td>
						<td class="value">
						    <input id="applyIdentityCard" name="applyIdentityCard" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.applyIdentityCard}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人身份证号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								申请人电话:
							</label>
						</td>
						<td class="value">
						    <input id="applyPhone" name="applyPhone" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bProjectBusinessPage.applyPhone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人电话</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								业务流水号:
							</label>
						</td>
						<td class="value">
							<input id="businessId" name="businessId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" value='${bProjectBusinessPage.businessId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">业务流水号</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/multiple/bProjectBusiness.js"></script>		
