/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.company.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.company.entity.XsCompany;
import com.jeesite.modules.company.dao.XsCompanyDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 单位信息Service
 * @author Damon
 * @version 2019-12-26
 */
@Service
@Transactional(readOnly=true)
public class XsCompanyService extends CrudService<XsCompanyDao, XsCompany> {
	
	/**
	 * 获取单条数据
	 * @param xsCompany
	 * @return
	 */
	@Override
	public XsCompany get(XsCompany xsCompany) {
		return super.get(xsCompany);
	}
	
	/**
	 * 查询分页数据
	 * @param xsCompany 查询条件
	 * @param xsCompany.page 分页对象
	 * @return
	 */
	@Override
	public Page<XsCompany> findPage(XsCompany xsCompany) {
		return super.findPage(xsCompany);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xsCompany
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XsCompany xsCompany) {
		super.save(xsCompany);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(xsCompany.getId(), "xsCompany_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(xsCompany.getId(), "xsCompany_file");
	}
	
	/**
	 * 更新状态
	 * @param xsCompany
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XsCompany xsCompany) {
		super.updateStatus(xsCompany);
	}
	
	/**
	 * 删除数据
	 * @param xsCompany
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XsCompany xsCompany) {
		super.delete(xsCompany);
	}
	
}