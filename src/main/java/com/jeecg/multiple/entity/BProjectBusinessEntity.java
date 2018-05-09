package com.jeecg.multiple.entity;

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
 * @Description: 并联业务信息
 * @author onlineGenerator
 * @date 2018-05-06 10:43:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "b_project_business", schema = "")
@SuppressWarnings("serial")
public class BProjectBusinessEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**业务流水号*/
	@Excel(name="业务流水号",width=15)
	private String businessId;
	/**项目id*/
	@Excel(name="项目id",width=15)
	private String projectId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private String projectName;
	/**项目状态*/
	@Excel(name="项目状态",width=15)
	private String projectStatus;
	/**证照上传状态*/
	@Excel(name="证照上传状态",width=15)
	private String certificateStatus;
	/**当前阶段编号*/
	@Excel(name="当前阶段编号",width=15)
	private String currentPhases;
	/**当前阶段状态*/
	@Excel(name="当前阶段状态",width=15)
	private String currentPhasesStatus;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd")
	private Date createTime;
	/**完结时间*/
	@Excel(name="完结时间",width=15,format = "yyyy-MM-dd")
	private Date completeTime;
	/**申请人*/
	@Excel(name="申请人",width=15)
	private String applyName;
	/**申请公司*/
	@Excel(name="申请公司",width=15)
	private String applyCompany;
	/**公司营业执照编号*/
	@Excel(name="公司营业执照编号",width=15)
	private String businessLicenseId;
	/**法人身份证号码*/
	@Excel(name="法人身份证号码",width=15)
	private String legalPersonCard;
	/**申请人身份证号*/
	@Excel(name="申请人身份证号",width=15)
	private String applyIdentityCard;
	/**申请人电话*/
	@Excel(name="申请人电话",width=15)
	private String applyPhone;
	/**实际项目名称*/
	@Excel(name="实际项目名称",width=15)
	private String realityProjectName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=20)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务流水号
	 */

	@Column(name ="BUSINESS_ID",nullable=true,length=20)
	public String getBusinessId(){
		return this.businessId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务流水号
	 */
	public void setBusinessId(String businessId){
		this.businessId = businessId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目id
	 */

	@Column(name ="PROJECT_ID",nullable=true,length=20)
	public String getProjectId(){
		return this.projectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目id
	 */
	public void setProjectId(String projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */

	@Column(name ="PROJECT_NAME",nullable=true,length=100)
	public String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目状态
	 */

	@Column(name ="PROJECT_STATUS",nullable=true,length=1)
	public String getProjectStatus(){
		return this.projectStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目状态
	 */
	public void setProjectStatus(String projectStatus){
		this.projectStatus = projectStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证照上传状态
	 */

	@Column(name ="CERTIFICATE_STATUS",nullable=true,length=1)
	public String getCertificateStatus(){
		return this.certificateStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证照上传状态
	 */
	public void setCertificateStatus(String certificateStatus){
		this.certificateStatus = certificateStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当前阶段编号
	 */

	@Column(name ="CURRENT_PHASES",nullable=true,length=20)
	public String getCurrentPhases(){
		return this.currentPhases;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当前阶段编号
	 */
	public void setCurrentPhases(String currentPhases){
		this.currentPhases = currentPhases;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当前阶段状态
	 */

	@Column(name ="CURRENT_PHASES_STATUS",nullable=true,length=1)
	public String getCurrentPhasesStatus(){
		return this.currentPhasesStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当前阶段状态
	 */
	public void setCurrentPhasesStatus(String currentPhasesStatus){
		this.currentPhasesStatus = currentPhasesStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */

	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  完结时间
	 */

	@Column(name ="COMPLETE_TIME",nullable=true)
	public Date getCompleteTime(){
		return this.completeTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  完结时间
	 */
	public void setCompleteTime(Date completeTime){
		this.completeTime = completeTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人
	 */

	@Column(name ="APPLY_NAME",nullable=true,length=40)
	public String getApplyName(){
		return this.applyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人
	 */
	public void setApplyName(String applyName){
		this.applyName = applyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请公司
	 */

	@Column(name ="APPLY_COMPANY",nullable=true,length=80)
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
	 *@return: java.lang.String  公司营业执照编号
	 */

	@Column(name ="BUSINESS_LICENSE_ID",nullable=true,length=40)
	public String getBusinessLicenseId(){
		return this.businessLicenseId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司营业执照编号
	 */
	public void setBusinessLicenseId(String businessLicenseId){
		this.businessLicenseId = businessLicenseId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  法人身份证号码
	 */

	@Column(name ="LEGAL_PERSON_CARD",nullable=true,length=40)
	public String getLegalPersonCard(){
		return this.legalPersonCard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  法人身份证号码
	 */
	public void setLegalPersonCard(String legalPersonCard){
		this.legalPersonCard = legalPersonCard;
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
	 *@return: java.lang.String  实际项目名称
	 */

	@Column(name ="REALITY_PROJECT_NAME",nullable=true,length=100)
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
}
