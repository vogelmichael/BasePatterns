package RegistrySpecialCaseLayerSupertypeRecordSet.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class RegistrySupertype<T> {
    static SessionFactory sessionFactory;
    private Class<T> classVariable;

    @SuppressWarnings("unchecked")
    protected RegistrySupertype() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        this.classVariable = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        //getting class can be done either by reflection like above or by passing Class<T> in constructor
    }

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public T getByID(int ID) {
        try(Session session = sessionFactory.openSession()) {
            Query<T> query = session.createQuery(
            "From " +
                    classVariable.getName() +
                    " t " +
                    "where t.id = :id", classVariable);
            query.setParameter("id", ID);
            List<T> resultList = query.getResultList();
            if(resultList.size() > 0) {
                return resultList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @SafeVarargs
    public final void add(T... objects) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            for(T object : objects) {
                session.save(object);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }
}
