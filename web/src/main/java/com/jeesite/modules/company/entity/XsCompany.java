/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.company.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 单位信息Entity
 * @author Damon
 * @version 2019-12-26
 */
@Table(name="xs_company", alias="a", columns={
		@Column(name="company_id", attrName="companyId", label="单位ID", isPK=true),
		@Column(name="name", attrName="name", label="单位名称", queryType=QueryType.LIKE),
		@Column(name="quality", attrName="quality", label="单位性质"),
		@Column(name="is_secret", attrName="isSecret", label="涉密资质"),
		@Column(name="address", attrName="address", label="单位地址", queryType=QueryType.LIKE),
		@Column(name="linkman", attrName="linkman", label="联系人"),
		@Column(name="contact_way", attrName="contactWay", label="联系方式", isQuery=false),
		@Column(name="kingdom", attrName="kingdom", label="规模及行业领域", isQuery=false),
		@Column(name="foreign_affairs", attrName="foreignAffairs", label="涉外情况", isQuery=false),
		@Column(name="network_usage", attrName="networkUsage", label="内网使用情况", isQuery=false),
		@Column(name="internet_access", attrName="internetAccess", label="互联网接入情况", isQuery=false),
		@Column(name="allocation_ip", attrName="allocationIp", label="IP分配情况附件", isQuery=false),
		@Column(name="flutter_description", attrName="flutterDescription", label="网络拓扑描述", isQuery=false),
		@Column(name="network_topology", attrName="networkTopology", label="网络拓扑图附件", isQuery=false),
		@Column(name="deployment", attrName="deployment", label="网络边界完全防护部署", isQuery=false),
		@Column(name="access_log", attrName="accessLog", label="网络访问日志", isQuery=false),
		@Column(name="device_condition", attrName="deviceCondition", label="附件", isQuery=false),
		@Column(name="audit_log", attrName="auditLog", label="附件逗号分隔", isQuery=false),
		@Column(name="risk_points", attrName="riskPoints", label="风险隐患点", isQuery=false),
		@Column(name="land_waiter", attrName="landWaiter", label="检查人员", isQuery=false),
		@Column(name="land_data", attrName="landData", label="检查日期", isQuery=false),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="update_by", attrName="updateBy", label="更新者", isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false),
		@Column(name="del_flag", attrName="delFlag", label="删除标记", isInsert=false, isQuery=false),
		@Column(name="remarks", attrName="remarks", label="备注信息", isQuery=false),
		@Column(name="upload_time", attrName="uploadTime", label="上传时间", isInsert=false, isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class XsCompany extends DataEntity<XsCompany> {
	
	private static final long serialVersionUID = 1L;
	private String companyId;		// 单位ID
	private String name;		// 单位名称
	private String quality;		// 单位性质
	private Integer isSecret;		// 涉密资质
	private String address;		// 单位地址
	private String linkman;		// 联系人
	private String contactWay;		// 联系方式
	private String kingdom;		// 规模及行业领域
	private String foreignAffairs;		// 涉外情况
	private String networkUsage;		// 内网使用情况
	private String internetAccess;		// 互联网接入情况
	private String allocationIp;		// IP分配情况附件
	private String flutterDescription;		// 网络拓扑描述
	private String networkTopology;		// 网络拓扑图附件
	private String deployment;		// 网络边界完全防护部署
	private String accessLog;		// 网络访问日志
	private String deviceCondition;		// 附件
	private String auditLog;		// 附件逗号分隔
	private String riskPoints;		// 风险隐患点
	private String landWaiter;		// 检查人员
	private Date landData;		// 检查日期
	private String delFlag;		// 删除标记
	private Date uploadTime;		// 上传时间
	
	public XsCompany() {
		this(null);
	}

	public XsCompany(String id){
		super(id);
	}
	
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	@NotBlank(message="单位名称不能为空")
	@Length(min=0, max=255, message="单位名称长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank(message="单位性质不能为空")
	@Length(min=0, max=255, message="单位性质长度不能超过 255 个字符")
	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	@NotNull(message="涉密资质不能为空")
	public Integer getIsSecret() {
		return isSecret;
	}

	public void setIsSecret(Integer isSecret) {
		this.isSecret = isSecret;
	}
	
	@NotBlank(message="单位地址不能为空")
	@Length(min=0, max=255, message="单位地址长度不能超过 255 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@NotBlank(message="联系人不能为空")
	@Length(min=0, max=255, message="联系人长度不能超过 255 个字符")
	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	
	@NotBlank(message="联系方式不能为空")
	@Length(min=0, max=255, message="联系方式长度不能超过 255 个字符")
	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	
	@NotBlank(message="规模及行业领域不能为空")
	@Length(min=0, max=255, message="规模及行业领域长度不能超过 255 个字符")
	public String getKingdom() {
		return kingdom;
	}

	public void setKingdom(String kingdom) {
		this.kingdom = kingdom;
	}
	
	@NotBlank(message="涉外情况不能为空")
	@Length(min=0, max=255, message="涉外情况长度不能超过 255 个字符")
	public String getForeignAffairs() {
		return foreignAffairs;
	}

	public void setForeignAffairs(String foreignAffairs) {
		this.foreignAffairs = foreignAffairs;
	}
	
	@Length(min=0, max=255, message="内网使用情况长度不能超过 255 个字符")
	public String getNetworkUsage() {
		return networkUsage;
	}

	public void setNetworkUsage(String networkUsage) {
		this.networkUsage = networkUsage;
	}
	
	@Length(min=0, max=255, message="互联网接入情况长度不能超过 255 个字符")
	public String getInternetAccess() {
		return internetAccess;
	}

	public void setInternetAccess(String internetAccess) {
		this.internetAccess = internetAccess;
	}
	
	@Length(min=0, max=255, message="IP分配情况附件长度不能超过 255 个字符")
	public String getAllocationIp() {
		return allocationIp;
	}

	public void setAllocationIp(String allocationIp) {
		this.allocationIp = allocationIp;
	}
	
	@NotBlank(message="网络拓扑描述不能为空")
	@Length(min=0, max=255, message="网络拓扑描述长度不能超过 255 个字符")
	public String getFlutterDescription() {
		return flutterDescription;
	}

	public void setFlutterDescription(String flutterDescription) {
		this.flutterDescription = flutterDescription;
	}
	
	//@NotBlank(message="网络拓扑图附件不能为空")
	@Length(min=0, max=255, message="网络拓扑图附件长度不能超过 255 个字符")
	public String getNetworkTopology() {
		return networkTopology;
	}

	public void setNetworkTopology(String networkTopology) {
		this.networkTopology = networkTopology;
	}
	
	@NotBlank(message="网络边界完全防护部署不能为空")
	@Length(min=0, max=255, message="网络边界完全防护部署长度不能超过 255 个字符")
	public String getDeployment() {
		return deployment;
	}

	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}
	
	@Length(min=0, max=255, message="网络访问日志长度不能超过 255 个字符")
	public String getAccessLog() {
		return accessLog;
	}

	public void setAccessLog(String accessLog) {
		this.accessLog = accessLog;
	}
	
	@Length(min=0, max=255, message="附件长度不能超过 255 个字符")
	public String getDeviceCondition() {
		return deviceCondition;
	}

	public void setDeviceCondition(String deviceCondition) {
		this.deviceCondition = deviceCondition;
	}
	
	@Length(min=0, max=255, message="附件逗号分隔长度不能超过 255 个字符")
	public String getAuditLog() {
		return auditLog;
	}

	public void setAuditLog(String auditLog) {
		this.auditLog = auditLog;
	}
	
	@Length(min=0, max=255, message="风险隐患点长度不能超过 255 个字符")
	public String getRiskPoints() {
		return riskPoints;
	}

	public void setRiskPoints(String riskPoints) {
		this.riskPoints = riskPoints;
	}
	
	@NotBlank(message="检查人员不能为空")
	@Length(min=0, max=255, message="检查人员长度不能超过 255 个字符")
	public String getLandWaiter() {
		return landWaiter;
	}

	public void setLandWaiter(String landWaiter) {
		this.landWaiter = landWaiter;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="检查日期不能为空")
	public Date getLandData() {
		return landData;
	}

	public void setLandData(Date landData) {
		this.landData = landData;
	}
	
	@Length(min=0, max=1, message="删除标记长度不能超过 1 个字符")
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
}