# Walkthrough - Product Update Functionality

I have successfully implemented the "Update" functionality for the Product entity, following the existing Clean Architecture patterns.

## Changes Made

### 1. Domain Layer
- **Repository Interface**: Added `UpdateProduct` to [ProductRepository.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/domain/repository/ProductRepository.kt).
- **UseCase**: Created [UpdateProductUseCase.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/domain/useCase/UpdateProductUseCase.kt) to handle the update business logic.

### 2. Data Layer
- **DTO**: Created [ProductUpdateRequest.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/data/remote/dto/req/product/ProductUpdateRequest.kt) for the PUT request body.
- **API Service**: Added `@PUT` endpoint to [ProductApiService.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/data/remote/api/ProductApiService.kt).
- **Mapper**: Added mapping from `ProductModel` to `ProductUpdateRequest` in [ProductMapper.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/data/mapper/ProductMapper.kt).
- **Repository Implementation**: Implemented the update logic in [ProductRepositoryImpl.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/data/repository/ProductRepositoryImpl.kt).

### 3. UI Layer
- **State**: Enhanced [ProductUIState.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/state/ProductUIState.kt) with `isEditMode`, `isUpdating`, and `updateMessage`.
- **ViewModel**: Updated [ProductViewModel.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/viewModel/ProductViewModel.kt) to handle the update flow and toggle edit mode.
- **Components**:
    - Created [UpdateProductForm.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/component/UpdateProductForm.kt) for editing product data.
    - Updated [ProductDetails.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/section/ProductDetails.kt) to include an "Edit" button and show the form when needed.
- **Screen**: Updated [ProductScreen.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/screen/ProductScreen.kt) to connect the UI with the ViewModel's new update functions.

## Bug Fixes & Refinement

- **Permission Denied**: Fixed a `SecurityException` by adding the missing `INTERNET` permission to [AndroidManifest.xml](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/AndroidManifest.xml).
- **Dependency Inconsistency**: Changed all `jakarta.inject` imports to `javax.inject` in the Data and DI layers to ensure full compatibility and consistency with the rest of the Hilt project.

## Verification Results

### Automated Tests
- Ran `gradlew app:assembleDebug`: **Build Successful**.

### Manual Verification Path
1. Launch the app (it should now load data correctly instead of crashing).
2. You will see a new **"Editar Producto"** button below the product card.
3. Clicking it opens the edit form.
4. Modify any field and click **"Guardar"**.
5. The UI will show a success message and return to the card view with the "updated" data.

> [!NOTE]
> Since this uses `dummyjson.com`, the API will return the updated object, but it won't actually change the data on their server permanently.
