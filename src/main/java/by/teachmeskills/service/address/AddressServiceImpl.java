package by.teachmeskills.service.address;

import by.teachmeskills.dao.AddressDAO;
import by.teachmeskills.dao.orm.AddressOrmDAO;
import by.teachmeskills.entity.adress.AddressEntity;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDAO addressDAO = new AddressOrmDAO();
    @Override
    public List<AddressEntity> getALL() {
        return addressDAO.getAll();
    }
}
