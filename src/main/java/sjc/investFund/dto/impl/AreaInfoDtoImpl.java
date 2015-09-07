package sjc.investFund.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjc.investFund.dto.AreaInfoDto;
import sjc.investFund.dto.service.AreaInfoDtoService;
import sjc.investFund.model.Area;
import sjc.investFund.service.AccountService;
import sjc.investFund.service.AreaService;

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
