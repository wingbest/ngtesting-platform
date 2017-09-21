package com.ngtesting.platform.service;

import com.alibaba.fastjson.JSONObject;
import com.ngtesting.platform.entity.TestPlan;
import com.ngtesting.platform.vo.TestPlanVo;

import java.util.List;

public interface PlanService extends BaseService {

	List<TestPlan> query(JSONObject json);
	TestPlanVo getById(Long caseId);
	TestPlan save(JSONObject json);
	TestPlan delete(Long vo, Long userId);

	List<TestPlanVo> genVos(List<TestPlan> pos);
	TestPlanVo genVo(TestPlan po);

	void dictPers();

}
