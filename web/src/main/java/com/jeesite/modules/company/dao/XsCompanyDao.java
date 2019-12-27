/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.company.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.company.entity.XsCompany;

/**
 * 单位信息DAO接口
 * @author Damon
 * @version 2019-12-26
 */
@MyBatisDao
public interface XsCompanyDao extends CrudDao<XsCompany> {
	
}