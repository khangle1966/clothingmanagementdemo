package clothingmanagement.services;

import clothingmanagement.models.ClothingItems;
import clothingmanagement.repositories.ClothingItemsRepository;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class ClothingItemsService {

    private final ClothingItemsRepository clothingItemsRepository;

    public ClothingItemsService(ClothingItemsRepository clothingItemsRepository) {
        this.clothingItemsRepository = clothingItemsRepository;
    }

    // Lấy tất cả sản phẩm
    public Iterable<ClothingItems> getAllClothingItems() {
        return clothingItemsRepository.findAll();
    }

    // Lấy sản phẩm theo ID
    public Optional<ClothingItems> getClothingItemById(String id) {
        return clothingItemsRepository.findById(id);
    }

    // Tạo sản phẩm mới
    public ClothingItems saveClothingItem(ClothingItems clothingItem) {
        return clothingItemsRepository.save(clothingItem);
    }

    // Xóa sản phẩm theo ID
    public void deleteClothingItemById(String id) {
        clothingItemsRepository.deleteById(id);
    }
}
