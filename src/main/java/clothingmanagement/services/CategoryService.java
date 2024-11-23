package clothingmanagement.services;

import clothingmanagement.models.Category;
import clothingmanagement.repositories.CategoryRepository;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Lấy tất cả danh mục
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Lấy danh mục theo ID
    public Optional<Category> getCategoryById(String id) {
        return categoryRepository.findById(id);
    }

    // Tạo danh mục mới
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Xóa danh mục theo ID
    public void deleteCategoryById(String id) {
        categoryRepository.deleteById(id);
    }
}
