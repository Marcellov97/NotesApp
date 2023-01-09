    package com.socialnotes.controller;

    import com.socialnotes.model.Post;
    import com.socialnotes.service.PostService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;

    @RestController
    @RequestMapping(path= "/post")
    public class PostController {
        private final PostService postService;

        @Autowired
        public PostController(PostService postService) { this.postService = postService; }

        @GetMapping("getAllPosts")
        public List<Post> getAllPost () { return postService.getAllPost(); }

        @GetMapping("getPostsValutazione/{valutazione}")
        public List<Post> getPostsValutazione (@PathVariable String valutazione) { return postService.getPostsValutazione(valutazione); }

        @GetMapping("getPostsUtente/{nomeUtente}")
        public List<Post> getPostsUtente (@PathVariable String nomeUtente) { return postService.getPostsUtente(nomeUtente); }

        @PostMapping("setPost")
        public boolean setPost(@RequestBody Post post) { return postService.setPost(post); }

        @PutMapping("updatePostValutazione/{idPost}/{valutazione}")
        public boolean updatePostValutazione(@PathVariable String idPost, @PathVariable int valutazione) {
            return postService.updatePostValutazione(idPost, valutazione);
        }

        @PutMapping("updatePostSegnalazione/{idPost}")
        public boolean updatePostSegnalazione(@PathVariable String idPost){ return postService.updatePostSegnalazione(idPost); }

        @DeleteMapping("deletePost/{idPost}")
        public boolean deletePost(@PathVariable  String idPost) { return postService.deletePost(idPost); }

    }
