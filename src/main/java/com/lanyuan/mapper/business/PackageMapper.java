package com.lanyuan.mapper.business;

import com.lanyuan.entity.business.PackageFormMap;
import com.lanyuan.mapper.base.BaseMapper;

import java.util.List;


public interface PackageMapper extends BaseMapper{

	public List<PackageFormMap> findByMap(PackageFormMap packageFormMap);
	
}
