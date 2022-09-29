package com.example.demo.controllers;

import com.example.demo.models.PostTwo;
import com.example.demo.repo.PostRepositoryTwo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repo.PostRepository;
import com.example.demo.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController  {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostRepositoryTwo postRepositoryTwo;

    @GetMapping("/")
    public String blogMain(Model model)
    {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/mobile/Main")
    public String Mobile(Model model) {return "Main";}

   @GetMapping("/blog/add")
    public String blogAdd(Model model)
    {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String modelsTel,
                              @RequestParam String number,
                              @RequestParam String memory,
                              @RequestParam String memoryGB,
                              @RequestParam String operator, Model model)
    {
        Post post = new Post(modelsTel, number, memory, memoryGB, operator);
        postRepository.save(post);
        return "redirect:/";
    }

    @GetMapping("/blog/filter")
    public String blogFilter(Model model)
    {
        return "blog-filter";
    }

    @PostMapping("/blog/filter/result")
    public String blogResult(@RequestParam String modelsTel, Model model)
    {
        List<Post> result = postRepository.findByModelsTelContains(modelsTel);
//        List<Post> result = postRepository.findLikeTitle(modelsTel);
        model.addAttribute("result", result);
        return "blog-filter";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        if(!postRepository.existsById(id))
        {
            return "redirect:/blog";
        }
        return "blog-details";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogBlogDelete(@PathVariable("id")long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/";
    }




    @GetMapping("/GG/Main")
    public String GG(Model model) {return "GG-main";}

    @GetMapping("/GG/add")
    public String GGAdd(Model model)
    {
        return "GG-add";
    }

    @PostMapping("/GG/add")
    public String GGPostAdd(@RequestParam String nazvanie,
                              @RequestParam String strana,
                              @RequestParam String ves,
                              @RequestParam String forma,
                              @RequestParam String kolwo, Model model)
    {
        PostTwo postTwo = new PostTwo(nazvanie, strana, ves, forma, kolwo);
        postRepositoryTwo.save(postTwo);
        return "GG-main";
    }

    @GetMapping("/GG/filter")
    public String GGFilter(Model model)
    {
        return "GG-filter";
    }

    @PostMapping("/GG/filter/result")
    public String GGResult(@RequestParam String nazvanie, Model model)
    {
        List<PostTwo> result = postRepositoryTwo.findByNazvanieContains(nazvanie);
//        List<Post> result = postRepository.findLikeTitle(modelsTel);
        model.addAttribute("result", result);
        return "GG-filter";
    }

    @GetMapping("/GG/{id}")
    public String GGDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<PostTwo> postTwo = postRepositoryTwo.findById(id);
        ArrayList<PostTwo> res = new ArrayList<>();
        postTwo.ifPresent(res::add);
        model.addAttribute("postTwo", res);
        if(!postRepositoryTwo.existsById(id))
        {
            return "redirect:/GG";
        }
        return "GG-details";
    }

    @PostMapping("/GG/{id}/remove")
    public String blogGGDelete(@PathVariable("id")long id, Model model){
        PostTwo postTwo = postRepositoryTwo.findById(id).orElseThrow();
        postRepositoryTwo.delete(postTwo);
        return "redirect:/";
    }
}
