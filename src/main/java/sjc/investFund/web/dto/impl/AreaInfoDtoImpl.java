package sjc.investFund.web.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjc.investFund.domain.model.Area;
import sjc.investFund.domain.service.AccountService;
import sjc.investFund.domain.service.AreaService;
import sjc.investFund.dto.service.AreaInfoDtoService;
import sjc.investFund.web.dto.AreaInfoDto;

@Service
public class AreaInfoDtoImpl implements AreaInfoDtoService {

	@Autowired
	private AreaService areaService;
	@Autowired
	private AccountService accountService;

	@Override
	public AreaInfoDto getAreaInfo(Area area) {
		Long projectsCount = areaService.getProjectsCount(area);
		Long balance = accountService.getAccountBalance(area.getAccount());
		AreaInfoDto areaInfoDto = new AreaInfoDto(area, projectsCount, balance);
		return areaInfoDto;
	}

}
