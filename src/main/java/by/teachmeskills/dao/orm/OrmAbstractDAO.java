package by.teachmeskills.dao.orm;

import by.teachmeskills.dao.AbstractDAO;
import by.teachmeskills.dao.DAO;
import by.teachmeskills.dao.exceptions.DAOException;
import by.teachmeskills.dao.orm.session.SessionFactoryProvider;
import by.teachmeskills.entity.Entity;
import by.teachmeskills.entity.IEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class OrmAbstractDAO<T extends IEntity> extends AbstractDAO<T> implements DAO<T> {
    private SessionFactoryProvider sessionFactoryProvider = SessionFactoryProvider.getInstance();

    @Override
    public T create(T entity) throws DAOException, SQLException {
        try (Session session = getSession()) {
            session.persist(entity);
            final Long identifier = (Long) session.getIdentifier(entity);
            entity.setId(identifier);
            return entity;
        } catch (Exception e) {
            LOGGER.error("Unable to save entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to save entity" + e.getMessage());
        }

    }

    @Override
    public T updateEntity(T entity) throws DAOException {
        try (Session session = getSession()) {
            session.update(entity);
            return entity;
        } catch (Exception e) {
            LOGGER.error("Unable to update entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to update entities:" + e.getMessage());
        }

    }

    public Optional<T> getEntity(Long id) throws DAOException {
        try (Session session = getSession()) {
            return Optional.ofNullable(session.find(getEntityClass(), id));
        } catch (Exception e) {
            LOGGER.error("Unable to read entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to read entity: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {
        try (Session session = getSession()) {
            Optional<T> entityOptional = getEntity(id);
            entityOptional.ifPresent(session::remove);
        } catch (Exception e) {
            LOGGER.error("Unable to delete entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to show entity:" + e.getMessage());
        }

    }

    @Override
    public List<T> getAll() throws DAOException {
        try (Session session = getSession()) {
            CriteriaQuery<T> criteria = session.getCriteriaBuilder().createQuery(getEntityClass());
            return session.createQuery(criteria.select(criteria.from(getEntityClass()))).getResultList();

        } catch (Exception e) {
            LOGGER.error("Unable to show entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to show entities:" + e.getMessage());
        }

    }

    private Session getSession() {
        return sessionFactoryProvider.getSessionFactory().openSession();

    }

    protected abstract Class<T> getEntityClass();
}
