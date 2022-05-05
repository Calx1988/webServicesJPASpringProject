package webservices_springboot_jpa.webservices_springboot_jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.Category;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.get();
    }
}
