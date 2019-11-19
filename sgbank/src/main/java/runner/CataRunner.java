package runner;

import java.math.BigDecimal;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.sg.cata.sgbank.configuration.HibernateUtil;
import fr.sg.cata.sgbank.configuration.SpringConfiguration;
import fr.sg.cata.sgbank.entities.Account;
import fr.sg.cata.sgbank.service.AccountOperationService;
import fr.sg.cata.sgbank.service.impl.AccountOperationImpl;

public class CataRunner {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		AccountOperationService service = context.getBean(AccountOperationService.class);

		Account acc1 = new Account(100, new BigDecimal(1000));
		Account acc2 = new Account(200, new BigDecimal(1000));
		service.persist(acc1);
		service.persist(acc2);

		System.out.println("Please, enter your code:");
		Scanner scanner = new Scanner(System.in);
		String code = scanner.nextLine();
		scanner.close();
		
		Account account = service.findAccountByCode(Integer.parseInt(code));

		if (account != null) {
			System.out.println(account.toString());

			service.deposeMoney(new BigDecimal(500), account);
			service.withdrawMoney(new BigDecimal(300), account);
			service.checkOperations(account);

			service.withdrawMoney(new BigDecimal(1000), account);
			service.checkOperations(account);
		}

	}
}
