package sjc.investFund.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.investFund.domain.model.Project;
import sjc.investFund.domain.service.ProjectService;

@Component
public class StringToProjectConverter implements Converter<String, Project>{
	@Autowired
	private ProjectService projectService;
     
    @Override
    public Project convert(String id) {
        return projectService.getProjectById(Integer.parseInt(id));
    }
}
