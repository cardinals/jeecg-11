package com.jeecg.business.entity;

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
 * @Description: 项目基本信息
 * @author onlineGenerator
 * @date 2018-05-05 20:50:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "a_project_info", schema = "")
@SuppressWarnings("serial")
public class AProjectInfoEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**项目id*/
	@Excel(name="项目id",width=15)
	private String projectId;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private String projectName;
	/**createTime*/
	@Excel(name="createTime",width=15,format = "yyyy-MM-dd")
	private Date createTime;
	/**updateTime*/
	@Excel(name="updateTime",width=15,format = "yyyy-MM-dd")
	private Date updateTime;
	/**delFlag*/
	@Excel(name="delFlag",width=15)
	private String delFlag;
	/**项目简介*/
	@Excel(name="项目简介",width=15)
	private String projectIntro;
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
	 *@return: java.lang.String  delFlag
	 */

	@Column(name ="DEL_FLAG",nullable=true,length=1)
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  delFlag
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目简介
	 */

	@Column(name ="PROJECT_INTRO",nullable=true,length=2000)
	public String getProjectIntro(){
		return this.projectIntro;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目简介
	 */
	public void setProjectIntro(String projectIntro){
		this.projectIntro = projectIntro;
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
