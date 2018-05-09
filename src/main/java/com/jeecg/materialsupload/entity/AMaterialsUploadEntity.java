package com.jeecg.materialsupload.entity;

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
 * @Description: 材料上传信息
 * @author onlineGenerator
 * @date 2018-05-06 19:41:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "a_materials_upload", schema = "")
@SuppressWarnings("serial")
public class AMaterialsUploadEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**业务编号*/
	@Excel(name="业务编号",width=15)
	private String businessId;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private String projectId;
	/**阶段编号*/
	@Excel(name="阶段编号",width=15)
	private String phasesId;
	/**事项编号*/
	@Excel(name="事项编号",width=15)
	private String itemsId;
	/**材料编号*/
	@Excel(name="材料编号",width=15)
	private String materialsId;
	/**材料存储路径*/
	@Excel(name="材料存储路径",width=15)
	private String materialsPath;
	/**上传材料名称*/
	@Excel(name="材料名称",width=15)
	private String materialsName;
	/**上传材料类型*/
	@Excel(name="材料类型",width=15)
	private String materialsType;
	/**状态*/
	@Excel(name="状态",width=15)
	private String status;
	/**createTime*/
	@Excel(name="createTime",width=15,format = "yyyy-MM-dd")
	private Date createTime;
	/**updateTime*/
	@Excel(name="updateTime",width=15,format = "yyyy-MM-dd")
	private Date updateTime;
	/**remark*/
	@Excel(name="remark",width=15)
	private String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务编号
	 */

	@Column(name ="BUSINESS_ID",nullable=true,length=40)
	public String getBusinessId(){
		return this.businessId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务编号
	 */
	public void setBusinessId(String businessId){
		this.businessId = businessId;
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
	 *@return: java.lang.String  材料编号
	 */

	@Column(name ="MATERIALS_ID",nullable=true,length=40)
	public String getMaterialsId(){
		return this.materialsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料编号
	 */
	public void setMaterialsId(String materialsId){
		this.materialsId = materialsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  材料存储路径
	 */

	@Column(name ="MATERIALS_PATH",nullable=true,length=1000)
	public String getMaterialsPath(){
		return this.materialsPath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料存储路径
	 */
	public void setMaterialsPath(String materialsPath){
		this.materialsPath = materialsPath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  材料上传名称
	 */

	@Column(name ="MATERIALS_NAME",nullable=true,length=1000)
	public String getMaterialsName(){
		return this.materialsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料上传名称
	 */
	public void setMaterialsName(String materialsName){
		this.materialsName = materialsName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  材料类型
	 */

	@Column(name ="MATERIALS_TYPE",nullable=true,length=1000)
	public String getMaterialsType(){
		return this.materialsType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料类型
	 */
	public void setMaterialsType(String materialsType){
		this.materialsType = materialsType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="STATUS",nullable=true,length=1)
	public String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(String status){
		this.status = status;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updateTime
	 */

	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateTime
	 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
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
}
