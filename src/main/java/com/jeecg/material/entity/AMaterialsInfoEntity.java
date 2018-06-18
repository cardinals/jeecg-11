package com.jeecg.material.entity;

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
 * @Description: A_MATERIALS_INFO
 * @author onlineGenerator
 * @date 2018-06-18 21:04:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "a_materials_info", schema = "")
@SuppressWarnings("serial")
public class AMaterialsInfoEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**材料编号*/
	@Excel(name="材料编号",width=15)
	private String materialsId;
	/**材料名称*/
	@Excel(name="材料名称",width=15)
	private String materialsName;
	/**状态*/
	@Excel(name="状态",width=15)
	private String status;
	/**remark*/
	@Excel(name="remark",width=15)
	private String remark;
	/**createTime*/
	@Excel(name="createTime",width=15,format = "yyyy-MM-dd")
	private Date createTime;
	/**updateTime*/
	@Excel(name="updateTime",width=15,format = "yyyy-MM-dd")
	private Date updateTime;
	/**delFlag*/
	private String delFlag;
	/**事项编号*/
	@Excel(name="事项编号",width=15)
	private String itemsId;
	
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
	 *@return: java.lang.String  材料名称
	 */

	@Column(name ="MATERIALS_NAME",nullable=true,length=2000)
	public String getMaterialsName(){
		return this.materialsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料名称
	 */
	public void setMaterialsName(String materialsName){
		this.materialsName = materialsName;
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
}
