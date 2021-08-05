package by.exposit.persistence.listeners.configuration;

import by.exposit.persistence.listeners.EntityPostDeleteEventListener;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateListenersConfiguration {

  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  @PostConstruct
  protected void registerListeners()
  {
    SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
    EventListenerRegistry registry = sessionFactory.getServiceRegistry()
        .getService(EventListenerRegistry.class);

    registry.getEventListenerGroup(EventType.POST_DELETE)
        .appendListener(new EntityPostDeleteEventListener());
  }
}
