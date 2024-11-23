package clothingmanagement.controllers;

import clothingmanagement.models.ClothingItems;
import clothingmanagement.services.ClothingItemsService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.Optional;

@Controller("/clothing-items")
public class ClothingItemsController {

    private final ClothingItemsService clothingItemsService;

    public ClothingItemsController(ClothingItemsService clothingItemsService) {
        this.clothingItemsService = clothingItemsService;
    }

    // Lấy tất cả sản phẩm
    @Get
    public HttpResponse<Iterable<ClothingItems>> getAllClothingItems() {
        Iterable<ClothingItems> clothingItems = clothingItemsService.getAllClothingItems();
        return HttpResponse.ok(clothingItems);
    }

    // Lấy sản phẩm theo ID
    @Get("/{id}")
    public HttpResponse<ClothingItems> getClothingItem(String id) {
        Optional<ClothingItems> clothingItem = clothingItemsService.getClothingItemById(id);
        return clothingItem.map(HttpResponse::ok).orElse(HttpResponse.notFound());
    }

    // Tạo sản phẩm mới
    @Post
    public HttpResponse<ClothingItems> createClothingItem(@Body ClothingItems clothingItem) {
        ClothingItems savedItem = clothingItemsService.saveClothingItem(clothingItem);
        return HttpResponse.created(savedItem);
    }

    // Xóa sản phẩm theo ID
    @Delete("/{id}")
    public HttpResponse<?> deleteClothingItem(String id) {
        clothingItemsService.deleteClothingItemById(id);
        return HttpResponse.noContent();
    }
}
