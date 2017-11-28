package com.lanyuan.mapper.business;

import com.lanyuan.entity.business.CompanyFormMap;
import com.lanyuan.mapper.base.BaseMapper;

import java.util.List;


public interface CompanyMapper extends BaseMapper{

	public List<CompanyFormMap> findByPage(CompanyFormMap companyFormMap);
	
}
