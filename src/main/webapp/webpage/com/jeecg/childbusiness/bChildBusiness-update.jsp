<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>B_CHILD_BUSINESS</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="bChildBusinessController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${bChildBusinessPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								并联业务流水号:
							</label>
						</td>
						<td class="value">
						    <input id="businessId" name="businessId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.businessId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">并联业务流水号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								子业务流水号:
							</label>
						</td>
						<td class="value">
						    <input id="childBusinessId" name="childBusinessId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.childBusinessId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">子业务流水号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								事项名称:
							</label>
						</td>
						<td class="value">
						    <input id="itemsName" name="itemsName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.itemsName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">事项名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								部门名称:
							</label>
						</td>
						<td class="value">
						    <input id="deptName" name="deptName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.deptName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">部门名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际项目名称:
							</label>
						</td>
						<td class="value">
						    <input id="realityProjectName" name="realityProjectName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.realityProjectName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际项目名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								createTime:
							</label>
						</td>
						<td class="value">
									  <input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${bChildBusinessPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">createTime</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								申请人名称:
							</label>
						</td>
						<td class="value">
						    <input id="applyName" name="applyName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.applyName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								申请公司:
							</label>
						</td>
						<td class="value">
						    <input id="applyCompany" name="applyCompany" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.applyCompany}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请公司</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								申请人电话:
							</label>
						</td>
						<td class="value">
						    <input id="applyPhone" name="applyPhone" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.applyPhone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人电话</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								申请人身份证号:
							</label>
						</td>
						<td class="value">
						    <input id="applyIdentityCard" name="applyIdentityCard" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.applyIdentityCard}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请人身份证号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								申请时间:
							</label>
						</td>
						<td class="value">
									  <input id="applyTime" name="applyTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${bChildBusinessPage.applyTime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								所剩时限:
							</label>
						</td>
						<td class="value">
						    <input id="ssgzr" name="ssgzr" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.ssgzr}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所剩时限</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								业务状态:
							</label>
						</td>
						<td class="value">
						    <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.status}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">业务状态</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								remark:
							</label>
						</td>
						<td class="value">
							<input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.remark}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">remark</label>
						</td>
					</tr>
				<%--
                        <tr>
                            <td align="right">
                                <label class="Validform_label">
                                    预审时间:
                                </label>
                            </td>
                            <td class="value">
                                          <input id="checkTime" name="checkTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${bChildBusinessPage.checkTime}' type="date" pattern="yyyy-MM-dd"/>'/>
                                <span class="Validform_checktip"></span>
                                <label class="Validform_label" style="display: none;">预审时间</label>
                            </td>
                            <td align="right">
								<label class="Validform_label">
									预审内容:
								</label>
							</td>
							<td class="value">
								<input id="checkContent" name="checkContent" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.checkContent}'/>
								<span class="Validform_checktip"></span>
								<label class="Validform_label" style="display: none;">预审内容</label>
							</td>

                        </tr>
                        <tr>
                            <td align="right">
                                <label class="Validform_label">
                                    证照名称:
                                </label>
                            </td>
                            <td class="value">
                                <input id="certificateName" name="certificateName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.certificateName}'/>
                                <span class="Validform_checktip"></span>
                                <label class="Validform_label" style="display: none;">证照名称</label>
                            </td>
                            <td align="right">
                                <label class="Validform_label">
                                    证照路径:
                                </label>
                            </td>
                            <td class="value">
                                <input id="certificatePath" name="certificatePath" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.certificatePath}'/>
                                <span class="Validform_checktip"></span>
                                <label class="Validform_label" style="display: none;">证照路径</label>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <label class="Validform_label">
                                    证照上传时间:
                                </label>
                            </td>
                            <td class="value">
                                          <input id="certificateTime" name="certificateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${bChildBusinessPage.certificateTime}' type="date" pattern="yyyy-MM-dd"/>'/>
                                <span class="Validform_checktip"></span>
                                <label class="Validform_label" style="display: none;">证照上传时间</label>
                            </td>
                            <td align="right">
                                <label class="Validform_label">
                                    上传人:
                                </label>
                            </td>
                            <td class="value">
                                <input id="createBy" name="createBy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${bChildBusinessPage.createBy}'/>
                                <span class="Validform_checktip"></span>
                                <label class="Validform_label" style="display: none;">上传人</label>
                            </td>
                        </tr>--%>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/childbusiness/bChildBusiness.js"></script>		
