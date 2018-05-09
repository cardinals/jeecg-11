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
 * @Description: T_SHARE_CLXX
 * @author onlineGenerator
 * @date 2018-05-04 23:34:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_share_clxx", schema = "")
@SuppressWarnings("serial")
public class TShareClxxEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**材料编号*/
	@Excel(name="材料编号",width=15)
	private String clbh;
	/**材料名称*/
	@Excel(name="材料名称",width=15)
	private String clmc;
	/**dzhyq*/
	@Excel(name="dzhyq",width=15)
	private String dzhyq;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd")
	private Date cjsj;
	/**创建人ID*/
	@Excel(name="创建人ID",width=15)
	private String cjrid;
	/**修改人ID*/
	@Excel(name="修改人ID",width=15)
	private String xgrid;
	/**修改时间*/
	@Excel(name="修改时间",width=15,format = "yyyy-MM-dd")
	private Date xgsj;
	/**备注*/
	@Excel(name="备注",width=15)
	private String bz;
	/**表单版本号*/
	@Excel(name="表单版本号",width=15)
	private String formver;
	/**patterninstid*/
	@Excel(name="patterninstid",width=15)
	private String patterninstid;
	/**表单ID*/
	@Excel(name="表单ID",width=15)
	private String xmlid;
	/**status*/
	@Excel(name="status",width=15)
	private String status;
	/**orinum*/
	@Excel(name="orinum",width=15)
	private String orinum;
	/**copynum*/
	@Excel(name="copynum",width=15)
	private String copynum;
	/**changetype*/
	@Excel(name="changetype",width=15)
	private String changetype;
	/**exchange*/
	@Excel(name="exchange",width=15)
	private String exchange;
	/**创建时间*/
	@Excel(name="创建时间",width=15,format = "yyyy-MM-dd")
	private Date createtime;
	/**修改时间*/
	@Excel(name="修改时间",width=15,format = "yyyy-MM-dd")
	private Date modifytime;
	/**yxq*/
	@Excel(name="yxq",width=15)
	private String yxq;
	/**事件组*/
	@Excel(name="事件组",width=15)
	private String actiongroup;
	/**type*/
	@Excel(name="type",width=15)
	private String type;
	/**hybm*/
	@Excel(name="hybm",width=15)
	private String hybm;
	/**hyfs*/
	@Excel(name="hyfs",width=15)
	private String hyfs;
	/**hlwdz*/
	@Excel(name="hlwdz",width=15)
	private String hlwdz;
	/**接口编号*/
	@Excel(name="接口编号",width=15)
	private String jkbh;
	/**fgw*/
	@Excel(name="fgw",width=15)
	private String fgw;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=50)
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

	@Column(name ="CLBH",nullable=false,length=50)
	public String getClbh(){
		return this.clbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料编号
	 */
	public void setClbh(String clbh){
		this.clbh = clbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  材料名称
	 */

	@Column(name ="CLMC",nullable=false,length=2000)
	public String getClmc(){
		return this.clmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  材料名称
	 */
	public void setClmc(String clmc){
		this.clmc = clmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  dzhyq
	 */

	@Column(name ="DZHYQ",nullable=false,length=20)
	public String getDzhyq(){
		return this.dzhyq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  dzhyq
	 */
	public void setDzhyq(String dzhyq){
		this.dzhyq = dzhyq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */

	@Column(name ="CJSJ",nullable=true)
	public Date getCjsj(){
		return this.cjsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCjsj(Date cjsj){
		this.cjsj = cjsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人ID
	 */

	@Column(name ="CJRID",nullable=true,length=20)
	public String getCjrid(){
		return this.cjrid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人ID
	 */
	public void setCjrid(String cjrid){
		this.cjrid = cjrid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人ID
	 */

	@Column(name ="XGRID",nullable=true,length=20)
	public String getXgrid(){
		return this.xgrid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人ID
	 */
	public void setXgrid(String xgrid){
		this.xgrid = xgrid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */

	@Column(name ="XGSJ",nullable=true)
	public Date getXgsj(){
		return this.xgsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setXgsj(Date xgsj){
		this.xgsj = xgsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BZ",nullable=true,length=2000)
	public String getBz(){
		return this.bz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBz(String bz){
		this.bz = bz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表单版本号
	 */

	@Column(name ="FORMVER",nullable=true,length=5)
	public String getFormver(){
		return this.formver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表单版本号
	 */
	public void setFormver(String formver){
		this.formver = formver;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  patterninstid
	 */

	@Column(name ="PATTERNINSTID",nullable=true,length=20)
	public String getPatterninstid(){
		return this.patterninstid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  patterninstid
	 */
	public void setPatterninstid(String patterninstid){
		this.patterninstid = patterninstid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表单ID
	 */

	@Column(name ="XMLID",nullable=true,length=20)
	public String getXmlid(){
		return this.xmlid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表单ID
	 */
	public void setXmlid(String xmlid){
		this.xmlid = xmlid;
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
	 *@return: java.lang.String  orinum
	 */

	@Column(name ="ORINUM",nullable=true,length=5)
	public String getOrinum(){
		return this.orinum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  orinum
	 */
	public void setOrinum(String orinum){
		this.orinum = orinum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  copynum
	 */

	@Column(name ="COPYNUM",nullable=true,length=5)
	public String getCopynum(){
		return this.copynum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  copynum
	 */
	public void setCopynum(String copynum){
		this.copynum = copynum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  changetype
	 */

	@Column(name ="CHANGETYPE",nullable=true,length=1)
	public String getChangetype(){
		return this.changetype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  changetype
	 */
	public void setChangetype(String changetype){
		this.changetype = changetype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  exchange
	 */

	@Column(name ="EXCHANGE",nullable=true,length=1)
	public String getExchange(){
		return this.exchange;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  exchange
	 */
	public void setExchange(String exchange){
		this.exchange = exchange;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */

	@Column(name ="CREATETIME",nullable=true)
	public Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */

	@Column(name ="MODIFYTIME",nullable=true)
	public Date getModifytime(){
		return this.modifytime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setModifytime(Date modifytime){
		this.modifytime = modifytime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  yxq
	 */

	@Column(name ="YXQ",nullable=true,length=5)
	public String getYxq(){
		return this.yxq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  yxq
	 */
	public void setYxq(String yxq){
		this.yxq = yxq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事件组
	 */

	@Column(name ="ACTIONGROUP",nullable=true,length=50)
	public String getActiongroup(){
		return this.actiongroup;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事件组
	 */
	public void setActiongroup(String actiongroup){
		this.actiongroup = actiongroup;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  type
	 */

	@Column(name ="TYPE",nullable=true,length=10)
	public String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  type
	 */
	public void setType(String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  hybm
	 */

	@Column(name ="HYBM",nullable=true,length=255)
	public String getHybm(){
		return this.hybm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  hybm
	 */
	public void setHybm(String hybm){
		this.hybm = hybm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  hyfs
	 */

	@Column(name ="HYFS",nullable=true,length=10)
	public String getHyfs(){
		return this.hyfs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  hyfs
	 */
	public void setHyfs(String hyfs){
		this.hyfs = hyfs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  hlwdz
	 */

	@Column(name ="HLWDZ",nullable=true,length=500)
	public String getHlwdz(){
		return this.hlwdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  hlwdz
	 */
	public void setHlwdz(String hlwdz){
		this.hlwdz = hlwdz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  接口编号
	 */

	@Column(name ="JKBH",nullable=true,length=500)
	public String getJkbh(){
		return this.jkbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  接口编号
	 */
	public void setJkbh(String jkbh){
		this.jkbh = jkbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fgw
	 */

	@Column(name ="FGW",nullable=true,length=50)
	public String getFgw(){
		return this.fgw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fgw
	 */
	public void setFgw(String fgw){
		this.fgw = fgw;
	}
}
