package sjc.investFund.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.investFund.model.Area;
import sjc.investFund.service.AreaService;

@Component
public class StringToAreaConverter implements Converter<String, Area> {

	@Autowired
	private AreaService areaService;

	@Override
	public Area convert(String id) {
		System.out.println(id);
		return areaService.findAreaById(Integer.parseInt(id));
	}

}
