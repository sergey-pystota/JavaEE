package by.teachmeskills.service.client;

import by.teachmeskills.dao.client.ClientDAO;
import by.teachmeskills.dao.orm.clientorm.ClientOrmDAO;
import by.teachmeskills.entity.client.ClientEntity;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO = new ClientOrmDAO();

    @Override
    public List<ClientEntity> getAll() {
        return clientDAO.getAll();
    }
}
