package com.jeecg.childbusiness.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: B_CHILD_BUSINESS
 * @author onlineGenerator
 * @date 2018-05-08 10:03:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "b_child_business", schema = "")
@SuppressWarnings("serial")
public class BChildBusinessEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**并联业务流水号*/
	@Excel(name="并联业务流水号",width=15)
	private String businessId;
	/**子业务流水号*/
	@Excel(name="子业务流水号",width=15)
	private String childBusinessId;
	/**项目编号*/
	private String projectId;
	/**阶段编号*/
	private String phasesId;
	/**事项编号*/
	private String itemsId;
	/**事项名称*/
	@Excel(name="事项名称",width=15)
	private String itemsName;
	/**部门编号*/
	private String deptId;
	/**部门名称*/
	@Excel(name="部门名称",width=15)
	private String deptName;
	/**实际项目名称*/
	@Excel(name="实际项目名称",width=15)
	private String realityProjectName;
	/**createTime*/
	@Excel(name="createTime",width=15,format = "yyyy-MM-dd")
	private Date createTime;
	/**申请人名称*/
	@Excel(name="申请人名称",width=15)
	private String applyName;
	/**申请公司*/
	@Excel(name="申请公司",width=15)
	private String applyCompany;
	/**申请人电话*/
	@Excel(name="申请人电话",width=15)
	private String applyPhone;
	/**申请人身份证号*/
	@Excel(name="申请人身份证号",width=15)
	private String applyIdentityCard;
	/**申请时间*/
	@Excel(name="申请时间",width=15,format = "yyyy-MM-dd")
	private Date applyTime;
	/**所剩时限*/
	@Excel(name="所剩时限",width=15)
	private String ssgzr;
	/**业务状态*/
	@Excel(name="业务状态",width=15)
	private String status;
	/**预审内容*/
	@Excel(name="预审内容",width=15)
	private String checkContent;
	/**预审时间*/
	@Excel(name="预审时间",width=15,format = "yyyy-MM-dd")
	private Date checkTime;
	/**remark*/
	@Excel(name="remark",width=15)
	private String remark;
	/**证照名称*/
	@Excel(name="证照名称",width=15)
	private String certificateName;
	/**证照路径*/
	@Excel(name="证照路径",width=15)
	private String certificatePath;
	/**证照上传时间*/
	@Excel(name="证照上传时间",width=15,format = "yyyy-MM-dd")
	private Date certificateTime;
	/**上传人*/
	@Excel(name="上传人",width=15)
	private String createBy;

	/**审核状态 （0：退回；1：通过）*/
	@Excel(name="审核状态",width=15)
	private String checkStatus;
	/**确认上传时间*/
	@Excel(name="确认上传时间",width=15,format = "yyyy-MM-dd")
	private Date confirmUploadTime;


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=40)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  并联业务流水号
	 */

	@Column(name ="BUSINESS_ID",nullable=true,length=40)
	public String getBusinessId(){
		return this.businessId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  并联业务流水号
	 */
	public void setBusinessId(String businessId){
		this.businessId = businessId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  子业务流水号
	 */

	@Column(name ="CHILD_BUSINESS_ID",nullable=true,length=40)
	public String getChildBusinessId(){
		return this.childBusinessId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  子业务流水号
	 */
	public void setChildBusinessId(String childBusinessId){
		this.childBusinessId = childBusinessId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目编号
	 */

	@Column(name ="PROJECT_ID",nullable=true,length=40)
	public String getProjectId(){
		return this.projectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目编号
	 */
	public void setProjectId(String projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  阶段编号
	 */

	@Column(name ="PHASES_ID",nullable=true,length=40)
	public String getPhasesId(){
		return this.phasesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  阶段编号
	 */
	public void setPhasesId(String phasesId){
		this.phasesId = phasesId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事项编号
	 */

	@Column(name ="ITEMS_ID",nullable=true,length=40)
	public String getItemsId(){
		return this.itemsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事项编号
	 */
	public void setItemsId(String itemsId){
		this.itemsId = itemsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事项名称
	 */

	@Column(name ="ITEMS_NAME",nullable=true,length=200)
	public String getItemsName(){
		return this.itemsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事项名称
	 */
	public void setItemsName(String itemsName){
		this.itemsName = itemsName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门编号
	 */

	@Column(name ="DEPT_ID",nullable=true,length=40)
	public String getDeptId(){
		return this.deptId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门编号
	 */
	public void setDeptId(String deptId){
		this.deptId = deptId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门名称
	 */

	@Column(name ="DEPT_NAME",nullable=true,length=100)
	public String getDeptName(){
		return this.deptName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门名称
	 */
	public void setDeptName(String deptName){
		this.deptName = deptName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际项目名称
	 */

	@Column(name ="REALITY_PROJECT_NAME",nullable=true,length=200)
	public String getRealityProjectName(){
		return this.realityProjectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际项目名称
	 */
	public void setRealityProjectName(String realityProjectName){
		this.realityProjectName = realityProjectName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createTime
	 */

	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createTime
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人名称
	 */

	@Column(name ="APPLY_NAME",nullable=true,length=200)
	public String getApplyName(){
		return this.applyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人名称
	 */
	public void setApplyName(String applyName){
		this.applyName = applyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请公司
	 */

	@Column(name ="APPLY_COMPANY",nullable=true,length=200)
	public String getApplyCompany(){
		return this.applyCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请公司
	 */
	public void setApplyCompany(String applyCompany){
		this.applyCompany = applyCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人电话
	 */

	@Column(name ="APPLY_PHONE",nullable=true,length=40)
	public String getApplyPhone(){
		return this.applyPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人电话
	 */
	public void setApplyPhone(String applyPhone){
		this.applyPhone = applyPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人身份证号
	 */

	@Column(name ="APPLY_IDENTITY_CARD",nullable=true,length=40)
	public String getApplyIdentityCard(){
		return this.applyIdentityCard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人身份证号
	 */
	public void setApplyIdentityCard(String applyIdentityCard){
		this.applyIdentityCard = applyIdentityCard;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */

	@Column(name ="APPLY_TIME",nullable=true)
	public Date getApplyTime(){
		return this.applyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setApplyTime(Date applyTime){
		this.applyTime = applyTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所剩时限
	 */

	@Column(name ="SSGZR",nullable=true,length=20)
	public String getSsgzr(){
		return this.ssgzr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所剩时限
	 */
	public void setSsgzr(String ssgzr){
		this.ssgzr = ssgzr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务状态
	 */

	@Column(name ="STATUS",nullable=true,length=10)
	public String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务状态
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预审内容
	 */

	@Column(name ="CHECK_CONTENT",nullable=true,length=2000)
	public String getCheckContent(){
		return this.checkContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预审内容
	 */
	public void setCheckContent(String checkContent){
		this.checkContent = checkContent;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预审时间
	 */

	@Column(name ="CHECK_TIME",nullable=true)
	public Date getCheckTime(){
		return this.checkTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预审时间
	 */
	public void setCheckTime(Date checkTime){
		this.checkTime = checkTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark
	 */

	@Column(name ="REMARK",nullable=true,length=2000)
	public String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证照名称
	 */

	@Column(name ="CERTIFICATE_NAME",nullable=true,length=400)
	public String getCertificateName(){
		return this.certificateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证照名称
	 */
	public void setCertificateName(String certificateName){
		this.certificateName = certificateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证照路径
	 */

	@Column(name ="CERTIFICATE_PATH",nullable=true,length=2000)
	public String getCertificatePath(){
		return this.certificatePath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证照路径
	 */
	public void setCertificatePath(String certificatePath){
		this.certificatePath = certificatePath;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  证照上传时间
	 */

	@Column(name ="CERTIFICATE_TIME",nullable=true)
	public Date getCertificateTime(){
		return this.certificateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  证照上传时间
	 */
	public void setCertificateTime(Date certificateTime){
		this.certificateTime = certificateTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上传人
	 */

	@Column(name ="CREATE_BY",nullable=true,length=40)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上传人
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}

	@Column(name ="CHECK_STATUS",nullable=true,length=1)
	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Column(name ="CONFIRM_UPLOAD_TIME",nullable=true)
	public Date getConfirmUploadTime() {
		return confirmUploadTime;
	}

	public void setConfirmUploadTime(Date confirmUploadTime) {
		this.confirmUploadTime = confirmUploadTime;
	}
}
