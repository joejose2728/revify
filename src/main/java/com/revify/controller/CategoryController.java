package com.revify.controller;

import com.revify.dto.CategoryDTO;
import com.revify.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces="application/json")
    public List<CategoryDTO> getCategories() {
        List<CategoryDTO> categories = categoryService.findAllCategories();
        return categories;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET, produces = "text/plain")
    public String getCategoryID(@RequestParam(required = true, value = "categoryName") String categoryName){
        return categoryService.getCategoryID(categoryName).toString();
    }

}
