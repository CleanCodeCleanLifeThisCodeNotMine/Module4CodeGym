package org.example.blogg.controller;

import org.example.blogg.model.Blog;
import org.example.blogg.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "blogs/list";
    }

    @GetMapping("/new")
    public String createBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blogs/create";
    }

    @PostMapping("/")
    public String createBlog(@ModelAttribute Blog blog) {
        blogService.createBlog(blog);
        return "redirect:/blogs/";
    }

    @GetMapping("/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id).orElse(null));
        return "blogs/view";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id).orElse(null));
        return "blogs/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBlog(@PathVariable Long id, @ModelAttribute Blog blog) {
        blogService.updateBlog(id, blog);
        return "redirect:/blogs/";
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "redirect:/blogs/";
    }
}
