package by.exposit.persistence.repositories.article;

import by.exposit.persistence.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, Long> {

}
