package test.repository;


import test.model.Image;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ImageRepository extends SimpleJpaRepository<Image, String> {
    private final EntityManager em;
    public ImageRepository(EntityManager em) {
        super(Image.class, em);
        this.em = em;
    }
    @Override
    public List<Image> findAll() {
        return em.createNativeQuery("Select * from \"testv8\".\"Image\"", Image.class).getResultList();
    }
}