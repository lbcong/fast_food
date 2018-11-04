package com.project.fastfood.controllers;

import com.project.fastfood.entities.CategoriesEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class AdminCategoryController extends AdminSupperController{
    @GetMapping("/admin/categories")
    public String index(HttpServletRequest request, ModelMap modelMap) {
        modelMap.addAttribute("categories", categoriesService.findAllCategories());
        return "admin.category.index";
    }

    @GetMapping("/admin/categories/new")
    public String newCategory() {
        return "admin.category.new";
    }

    @PostMapping("/admin/categories/new")
    public String createCategory(@ModelAttribute CategoriesEntity category,
                                 @RequestParam("img") MultipartFile img, ModelMap modelMap,
                                 RedirectAttributes ra, HttpServletRequest request) {

        String filename = System.nanoTime() + img.getOriginalFilename();
        category.setImage(filename);
        try {
            if (!img.isEmpty()) {
                String dirPath = request.getServletContext().getRealPath("/files");
                Path path = Paths.get(dirPath + File.separator + filename);
                File file = new File(dirPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                byte[] bytes = img.getBytes();
                Files.write(path, bytes);
            }
        } catch (Exception e) {
            modelMap.addAttribute("category", category);
            modelMap.addAttribute("error", "Có lỗi xẩy ra");
            return "admin.category.new";
        }
        categoriesService.saveCategory(category);
        ra.addFlashAttribute("success", "Thêm Thành Công");
        return "redirect:/admin/categories";
    }
}
