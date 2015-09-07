package sjc.investFund.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sjc.investFund.model.Project;
import sjc.investFund.service.ProjectService;

@Component
public class StringToProjectConverter implements Converter<String, Project>{
	@Autowired
	private ProjectService projectService;
     
    @Override
    public Project convert(String id) {
        return projectService.getProjectById(Integer.parseInt(id));
    }
}
