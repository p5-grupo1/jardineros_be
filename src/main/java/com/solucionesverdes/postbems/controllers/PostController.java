package com.solucionesverdes.postbems.controllers;
import com.solucionesverdes.postbems.exceptions.*;
import com.solucionesverdes.postbems.models.Posts;
import com.solucionesverdes.postbems.repositories.PostsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
public class PostController {
    private final PostsRepository postRepository;


    public PostController(PostsRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts/{idpost}")
    Posts getPost(@PathVariable String idpost) {
        return postRepository.findById(idpost)
                .orElseThrow(() -> new UserNotFoundException("No se encontro el post"));
    }

    @PostMapping("/user/createposts")
    Posts newPost(@RequestBody Posts posts){
        posts.setFechaPublicacion(new Date());
        return postRepository.save(posts);
    }


    @DeleteMapping("/deletepost/{idpost}")
    String deletePost(@PathVariable String idpost) {
        Posts post = postRepository.findById(idpost).orElse(null);
        if (post == null)
            throw new PostNotFoundException("El post no existe");
        postRepository.delete(post);
        return "Borrado existoso";
    }

    @PutMapping("/user/updatepost")
    Posts updatePost(@RequestBody Posts posts) {
        Posts postupdate = postRepository.findById(posts.getIdPost()).orElse(null);
        if (postupdate == null)
            throw new PostNotFoundException("El post no existe");
        postupdate.setUsername(posts.getUsername());
        postupdate.setDescripcionServicio(posts.getDescripcionServicio());
        postupdate.setImagen(posts.getImagen());
        postupdate.setCiudad(posts.getCiudad());
        postupdate.setPrecio(posts.getPrecio());
        postupdate.setArea(posts.getArea());
        postupdate.setFechaPublicacion(new Date());
        return postRepository.save(postupdate);
    }

    @GetMapping("/allposts/")
    List<Posts> getallPost() {
        List<Posts> allpost = postRepository.findAll();
        if (allpost.isEmpty())
            throw new PostNotFoundException("No hay Ningun Post publicado de momento");
        return allpost;
    }

    @GetMapping("/recipient/ciudad")
    List<String> getallcities() {
        List<Posts> allpost = postRepository.findAll();
        if (allpost.isEmpty())
            throw new PostNotFoundException("No hay Ningun Post publicado de momento");
        List<String> listaciudades = new ArrayList<String>();
        for(Posts post: allpost)
            if(!listaciudades.contains(post.getCiudad()))
                listaciudades.add(post.getCiudad());
        return listaciudades;
    }

    @GetMapping("/recipient/precios")
    List<Integer> getallprecios() {
        List<Posts> allpost = postRepository.findAll();
        if (allpost.isEmpty())
            throw new PostNotFoundException("No hay Ningun Post publicado de momento");
        List<Integer> listaprecios = new ArrayList<Integer>();
        for(Posts post: allpost)
            if(!listaprecios.contains(post.getPrecio()))
                listaprecios.add(post.getPrecio());
        return listaprecios;
    }

    @GetMapping("/filterposts/{username}")
    List<Posts> getFilterPostUsername(@PathVariable String username) {
        List<Posts> filterPost = postRepository.findByUsername(username);
        if (filterPost.isEmpty())
            throw new UserNotFoundException("El usuario no se encuentra Registrado");
        return filterPost;
    }

    @GetMapping("/filterposts/lugar-{ciudad}")
    List<Posts> getFilterPostPlace(@PathVariable String ciudad) {
        List<Posts> filterPost = postRepository.findByCiudad(ciudad);
        if (filterPost.isEmpty())
            throw new CiudadNotFoundException("No hay Posts diponibles para esta ciudad");
        return filterPost;
    }

    @GetMapping("/filterposts/area-{area}")
    List<Posts> getFilterPostArea(@PathVariable String area){
        List<Posts> filterPost = postRepository.findByArea(area);
        if (filterPost.isEmpty())
            throw new AreaNotFoundException("No hay Posts disponibles para esta area");
        return filterPost;
    }

    @GetMapping("/filterposts/price-{precio}")
    List<Posts> getFilterPostPrecio(@PathVariable Integer precio) {
        List<Posts> filterPost = postRepository.findByPrecio(precio);
        if (filterPost.isEmpty())
            throw new PrecioNotFoundException("No hay Posts disponibles para este precio");
        return filterPost;
    }
}