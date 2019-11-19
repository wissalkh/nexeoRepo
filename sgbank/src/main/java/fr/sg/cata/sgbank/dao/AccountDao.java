package fr.sg.cata.sgbank.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import fr.sg.cata.sgbank.configuration.HibernateUtil;
import fr.sg.cata.sgbank.entities.Account;

@Component
public class AccountDao {
	
public Account findByCode(int code) {
	Session session = createSession();
	Account account = (Account)session.get(Account.class, code);
	session.close();
	return account;
}

public void persist(Account account) {
	Session session = createSession();
	Transaction transaction = createTransaction();
	session.save("Account", account);
	transaction.commit();
	session.close();
}

private Transaction createTransaction() {
	Session session = createSession();
	return session.beginTransaction();
}

private Session createSession() {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	return session;
}

public void update(Account account) {
	Session session = createSession();
	session.update(account);
	
}
}
