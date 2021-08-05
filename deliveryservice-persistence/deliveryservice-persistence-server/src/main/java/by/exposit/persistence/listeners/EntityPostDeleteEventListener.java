package by.exposit.persistence.listeners;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;

@Slf4j
public class EntityPostDeleteEventListener implements PostDeleteEventListener {

  @Override
  public void onPostDelete(PostDeleteEvent postDeleteEvent) {
    log.info("Entity was deleted: {}", postDeleteEvent.getEntity());
  }

  @Override
  public boolean requiresPostCommitHanding(EntityPersister entityPersister) {
    return false;
  }
}
