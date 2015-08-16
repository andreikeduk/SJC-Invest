package sjc.investFund.service;
import org.springframework.stereotype.Service;
import sjc.investFund.model.Project;

@Service
public interface ProjectService {
	public Project getUserById(int id);
}
