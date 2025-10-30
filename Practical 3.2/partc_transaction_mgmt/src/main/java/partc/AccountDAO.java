package partc;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Account findById(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public void update(Account account) {
        sessionFactory.getCurrentSession().update(account);
    }
}
