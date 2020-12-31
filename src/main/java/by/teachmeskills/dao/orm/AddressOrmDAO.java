package by.teachmeskills.dao.orm;

import by.teachmeskills.dao.AddressDAO;
import by.teachmeskills.entity.adress.AddressEntity;

public class AddressOrmDAO extends OrmAbstractDAO<AddressEntity> implements AddressDAO {
    @Override
    protected Class<AddressEntity> getEntityClass() {
        return AddressEntity.class;
    }
}
