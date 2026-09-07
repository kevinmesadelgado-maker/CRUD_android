# Implementation Plan - Product Update Functionality

This plan outlines the steps to add "Update" functionality to the existing Product CRUD structure. This includes changes across the data, domain, and UI layers.

## User Review Required

> [!IMPORTANT]
> The update operation will target the `https://dummyjson.com/` API. Note that DummyJSON is a mock API, so the changes won't be persisted on their server, but the API will return the "updated" product in the response.

## Proposed Changes

### Data Layer

#### [NEW] [ProductUpdateRequest.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/data/remote/dto/req/product/ProductUpdateRequest.kt)
Create a DTO to represent the fields that can be updated (title, description, category, price).

#### [MODIFY] [ProductApiService.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/data/remote/api/ProductApiService.kt)
Add `@PUT("products/{id}")` method to handle the update request.

#### [MODIFY] [ProductRepositoryImpl.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/data/repository/ProductRepositoryImpl.kt)
Implement the `updateProduct` method, mapping the domain model to the update request DTO.

---

### Domain Layer

#### [MODIFY] [ProductRepository.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/domain/repository/ProductRepository.kt)
Add the `updateProduct` method definition to the interface.

#### [NEW] [UpdateProductUseCase.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/domain/useCase/UpdateProductUseCase.kt)
Create a new use case mirroring `GetProductUseCase.kt`, using the `operator fun invoke` pattern to call the repository.

---

### UI Layer

#### [MODIFY] [ProductUIState.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/state/ProductUIState.kt)
Add fields for update status: `isUpdating` (Boolean) and `updateMessage` (String?).

#### [MODIFY] [ProductViewModel.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/viewModel/ProductViewModel.kt)
Add `updateProduct` function to handle the interaction between UI and UseCase.

#### [NEW] [UpdateProductForm.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/component/UpdateProductForm.kt)
Create a new composable component that provides text fields for editing product details.

#### [MODIFY] [ProductScreen.kt](file:///C:/Users/kevin/StudioProjects/CRUD_ANDROID/app/src/main/java/com/sena/crud/ui/screen/ProductScreen.kt)
Update the screen to allow toggling between the display view and the edit form.

## Verification Plan

### Manual Verification
1.  Navigate to the Product screen.
2.  Click on the "Edit" button (to be added).
3.  Modify product fields (Title, Price, etc.).
4.  Click "Save".
5.  Verify that a loading indicator appears.
6.  Verify that the "updated" product data is displayed after success.
7.  Check Logcat for API request/response details.
