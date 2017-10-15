package com.ngtesting.platform.service;

import com.ngtesting.platform.entity.TestOrgRole;
import com.ngtesting.platform.vo.OrgRoleVo;

import java.util.List;

public interface OrgRoleService extends BaseService {

	List list(Long orgId, String keywords, String disabled);

	TestOrgRole save(OrgRoleVo vo, Long orgId);
	boolean delete(Long id);

	List<OrgRoleVo> genVos(List<TestOrgRole> pos);
	OrgRoleVo genVo(TestOrgRole role);

}
