/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.company.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.file.utils.FileUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.company.entity.XsCompany;
import com.jeesite.modules.company.service.XsCompanyService;

/**
 * 单位信息Controller
 * @author Damon
 * @version 2019-12-26
 */
@Controller
@RequestMapping(value = "${adminPath}/company/xsCompany")
public class XsCompanyController extends BaseController {

	@Autowired
	private XsCompanyService xsCompanyService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XsCompany get(String companyId, boolean isNewRecord) {
		return xsCompanyService.get(companyId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("company:xsCompany:view")
	@RequestMapping(value = {"list", ""})
	public String list(XsCompany xsCompany, Model model) {
		model.addAttribute("xsCompany", xsCompany);
		return "modules/company/xsCompanyList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("company:xsCompany:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XsCompany> listData(XsCompany xsCompany, HttpServletRequest request, HttpServletResponse response) {
		xsCompany.setPage(new Page<>(request, response));
		Page<XsCompany> page = xsCompanyService.findPage(xsCompany);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("company:xsCompany:view")
	@RequestMapping(value = "form")
	public String form(XsCompany xsCompany, Model model) {
		model.addAttribute("xsCompany", xsCompany);
		return "modules/company/xsCompanyForm";
	}

	/**
	 * 保存单位信息
	 */
	@RequiresPermissions("company:xsCompany:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XsCompany xsCompany) {
		FileUploadUtils.saveFileUpload(xsCompany.getId(), "xsCompany_topology");
		xsCompanyService.save(xsCompany);
		return renderResult(Global.TRUE, text("保存单位信息成功！"));
	}
	
	/**
	 * 停用单位信息
	 */
	@RequiresPermissions("company:xsCompany:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(XsCompany xsCompany) {
		xsCompany.setStatus(XsCompany.STATUS_DISABLE);
		xsCompanyService.updateStatus(xsCompany);
		return renderResult(Global.TRUE, text("停用单位信息成功"));
	}
	
	/**
	 * 启用单位信息
	 */
	@RequiresPermissions("company:xsCompany:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(XsCompany xsCompany) {
		xsCompany.setStatus(XsCompany.STATUS_NORMAL);
		xsCompanyService.updateStatus(xsCompany);
		return renderResult(Global.TRUE, text("启用单位信息成功"));
	}
	
	/**
	 * 删除单位信息
	 */
	@RequiresPermissions("company:xsCompany:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XsCompany xsCompany) {
		xsCompanyService.delete(xsCompany);
		return renderResult(Global.TRUE, text("删除单位信息成功！"));
	}
	
}