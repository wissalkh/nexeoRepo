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
import fr.sg.cata.sgbank.exception.InsufficientAmountException;
import fr.sg.cata.sgbank.service.AccountOperationFacade;
import fr.sg.cata.sgbank.service.impl.AccountOperationImpl;

public class CataRunner {

	public static void main(String[] args) throws InsufficientAmountException {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		AccountOperationFacade service = context.getBean(AccountOperationFacade.class);

		System.out.println("Please, enter your code:");
		Scanner scanner = new Scanner(System.in);
		String code = scanner.nextLine();
		scanner.close();		

		service.deposeMoney(new BigDecimal(500), code);
		service.withdrawMoney(new BigDecimal(300), code);
		service.checkOperations(code);

		service.withdrawMoney(new BigDecimal(1000), code);
		service.checkOperations(code);
		

	}
}
