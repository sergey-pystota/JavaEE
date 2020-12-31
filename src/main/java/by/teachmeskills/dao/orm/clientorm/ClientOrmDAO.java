package by.teachmeskills.dao.orm.clientorm;

import by.teachmeskills.dao.client.ClientDAO;
import by.teachmeskills.dao.orm.OrmAbstractDAO;
import by.teachmeskills.entity.client.ClientEntity;

public class ClientOrmDAO extends OrmAbstractDAO<ClientEntity> implements ClientDAO {

    @Override
    protected Class<ClientEntity> getEntityClass() {
        return ClientEntity.class;
    }
}
