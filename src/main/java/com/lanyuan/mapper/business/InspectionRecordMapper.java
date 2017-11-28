package com.lanyuan.mapper.business;

import com.lanyuan.entity.business.InspectionRecordFormMap;
import com.lanyuan.entity.business.PackageFormMap;
import com.lanyuan.mapper.base.BaseMapper;

import java.util.List;


public interface InspectionRecordMapper extends BaseMapper{

	public List<InspectionRecordFormMap> findByMap(InspectionRecordFormMap inspectionRecordFormMap);
	
}
