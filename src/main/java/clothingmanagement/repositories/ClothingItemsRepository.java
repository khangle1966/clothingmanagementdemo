package clothingmanagement.repositories;

import clothingmanagement.models.ClothingItems;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@Repository
@MongoRepository
public interface ClothingItemsRepository extends CrudRepository<ClothingItems, String> {
}
