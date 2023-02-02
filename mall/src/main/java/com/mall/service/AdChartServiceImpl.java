package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.domain.ChartCartVO;
import com.mall.mapper.AdChartMapper;

import lombok.Setter;

@Service
public class AdChartServiceImpl implements AdChartService {

	@Setter(onMethod_ = {@Autowired})
	private AdChartMapper adChartMapper;

	@Override
	public List<ChartCartVO> chartCartProductList() {
		return adChartMapper.chartCartProductList();
	}
}
