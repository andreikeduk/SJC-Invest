import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import sjc.investFund.repository.impl.ProjectRepository;
import sjc.investFund.service.ProjectService;
import sjc.investFund.serviceImpl.ProjectServiceImpl;
import sjc.investFund.dao.AccountDao;
import sjc.investFund.dao.ProjectDao;
import sjc.investFund.model.Account;
import sjc.investFund.model.Project;

public class Starter {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");
		System.out.println(context);
		/*ProjectDao projectRepository = (ProjectDao) context.getBean("projectRepository");
		//Project p = (Project) projectRepository.findById(1);
		AccountDao accountRepository = (AccountDao) context.getBean("accountRepository");
		Account a = (Account) accountRepository.findById(1);
		System.out.println(a.getNumber());*/
		System.out.println("hello");
	}
}
