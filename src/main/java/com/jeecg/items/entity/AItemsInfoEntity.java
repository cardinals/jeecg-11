package com.jeecg.items.entity;

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
 * @Description: A_ITEMS_INFO
 * @author onlineGenerator
 * @date 2018-05-26 19:36:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "a_items_info", schema = "")
@SuppressWarnings("serial")
public class AItemsInfoEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**项目id*/
	@Excel(name="项目id",width=15)
	private String projectId;
	/**阶段id*/
	@Excel(name="阶段id",width=15)
	private String phasesId;
	/**事项编号*/
	@Excel(name="事项编号",width=15)
	private String itemsId;
	/**事项子项编号*/
	@Excel(name="事项子项编号",width=15)
	private String itemsChildId;
	/**事项名称*/
	@Excel(name="事项名称",width=15)
	private String itemsName;
	/**事项子项名称*/
	@Excel(name="事项子项名称",width=15)
	private String itemsChildName;
	/**部门编号*/
	@Excel(name="部门编号",width=15)
	private String deptId;
	/**部门名称*/
	@Excel(name="部门名称",width=15)
	private String deptName;
	/**承诺时限*/
	@Excel(name="承诺时限",width=15)
	private String limitDays;
	/**createTime*/
	private Date createTime;
	/**updateTime*/
	private Date updateTime;
	/**status*/
	@Excel(name="status",width=15)
	private String status;
	/**remark*/
	@Excel(name="remark",width=15)
	private String remark;
	/**delFlag*/
	private String delFlag;
	
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
	 *@return: java.lang.String  项目id
	 */

	@Column(name ="PROJECT_ID",nullable=true,length=40)
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
	 *@return: java.lang.String  阶段id
	 */

	@Column(name ="PHASES_ID",nullable=true,length=40)
	public String getPhasesId(){
		return this.phasesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  阶段id
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
	 *@return: java.lang.String  事项子项编号
	 */

	@Column(name ="ITEMS_CHILD_ID",nullable=true,length=40)
	public String getItemsChildId(){
		return this.itemsChildId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事项子项编号
	 */
	public void setItemsChildId(String itemsChildId){
		this.itemsChildId = itemsChildId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事项名称
	 */

	@Column(name ="ITEMS_NAME",nullable=true,length=100)
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
	 *@return: java.lang.String  事项子项名称
	 */

	@Column(name ="ITEMS_CHILD_NAME",nullable=true,length=100)
	public String getItemsChildName(){
		return this.itemsChildName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事项子项名称
	 */
	public void setItemsChildName(String itemsChildName){
		this.itemsChildName = itemsChildName;
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

	@Column(name ="DEPT_NAME",nullable=true,length=60)
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
	 *@return: java.lang.String  承诺时限
	 */

	@Column(name ="LIMIT_DAYS",nullable=true,length=30)
	public String getLimitDays(){
		return this.limitDays;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承诺时限
	 */
	public void setLimitDays(String limitDays){
		this.limitDays = limitDays;
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
	 *@return: java.lang.String  status
	 */

	@Column(name ="STATUS",nullable=true,length=1)
	public String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  status
	 */
	public void setStatus(String status){
		this.status = status;
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
}
