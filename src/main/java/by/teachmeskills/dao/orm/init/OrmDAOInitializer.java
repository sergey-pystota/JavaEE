package by.teachmeskills.dao.orm.init;

import by.teachmeskills.DAOInitializer;
import by.teachmeskills.dao.orm.session.SessionFactoryProvider;

public class OrmDAOInitializer  implements DAOInitializer {
    @Override
    public void init() {
        SessionFactoryProvider.getInstance().init();

    }
}
