package com.solucionesverdes.postbems.repositories;
import com.solucionesverdes.postbems.models.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PostsRepository extends MongoRepository<Posts, String> {
    List<Posts> findByUsername(String username);
    List<Posts> findByPrecio(Integer precio);
    List<Posts> findByArea(String area);
    List<Posts> findByCiudad(String ciudad);
}


