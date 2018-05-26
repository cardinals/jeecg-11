package com.jeecg.phases.entity;

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
 * @Description: A_PHASES_INFO
 * @author onlineGenerator
 * @date 2018-05-26 21:05:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "a_phases_info", schema = "")
@SuppressWarnings("serial")
public class APhasesInfoEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**项目编号*/
	@Excel(name="项目编号",width=15)
	private String projectId;
	/**阶段编号*/
	@Excel(name="阶段编号",width=15)
	private String phasesId;
	/**阶段名称*/
	@Excel(name="阶段名称",width=15)
	private String phasesName;
	/**创建时间*/
	private Date createTime;
	/**修改时间*/
	private Date updateTime;
	/**阶段状态*/
	private String phasesStatus;
	/**备注*/
	@Excel(name="备注",width=15)
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
	 *@return: java.lang.String  项目编号
	 */

	@Column(name ="PROJECT_ID",nullable=true,length=20)
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

	@Column(name ="PHASES_ID",nullable=true,length=20)
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
	 *@return: java.lang.String  阶段名称
	 */

	@Column(name ="PHASES_NAME",nullable=true,length=20)
	public String getPhasesName(){
		return this.phasesName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  阶段名称
	 */
	public void setPhasesName(String phasesName){
		this.phasesName = phasesName;
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
	 *@return: java.util.Date  修改时间
	 */

	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  阶段状态
	 */

	@Column(name ="PHASES_STATUS",nullable=true,length=20)
	public String getPhasesStatus(){
		return this.phasesStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  阶段状态
	 */
	public void setPhasesStatus(String phasesStatus){
		this.phasesStatus = phasesStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="REMARK",nullable=true,length=2000)
	public String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
}
