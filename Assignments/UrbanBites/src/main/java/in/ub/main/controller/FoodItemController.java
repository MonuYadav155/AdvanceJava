package in.ub.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import in.ub.main.dto.FoodItemDto;
import in.ub.main.services.FoodItemService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{restaurantId}/fooditems")
    public ResponseEntity<FoodItemDto> addFoodItem(
            @PathVariable Long restaurantId,
            @Valid @RequestBody FoodItemDto dto) {

        return ResponseEntity.ok(foodItemService.addFoodItem(restaurantId, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/fooditems/{id}")
    public ResponseEntity<FoodItemDto> updateFoodItem(
            @PathVariable Long id,
            @Valid @RequestBody FoodItemDto dto) {

        return ResponseEntity.ok(foodItemService.updateFoodItem(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/fooditems/{id}")
    public ResponseEntity<FoodItemDto> patchFoodItem(
            @PathVariable Long id,
            @RequestBody FoodItemDto dto) {

        return ResponseEntity.ok(foodItemService.patchFoodItem(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/fooditems/{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable Long id) {

        foodItemService.deleteFoodItem(id);
        return ResponseEntity.ok("Food item deleted successfully");
    }
}