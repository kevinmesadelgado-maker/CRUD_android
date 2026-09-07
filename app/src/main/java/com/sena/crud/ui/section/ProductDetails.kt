package com.sena.crud.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.crud.domain.model.ProductModel
import com.sena.crud.ui.component.UpdateProductForm
import com.sena.crud.ui.component.productCard
import com.sena.crud.ui.state.ProductUIState

@Composable
fun ProductDetails(
    uiState: ProductUIState,
    onRetry: () -> Unit,
    onEditClick: () -> Unit,
    onUpdateProduct: (ProductModel) -> Unit,
    onCancelEdit: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.updateMessage != null) {
            Text(
                text = uiState.updateMessage,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        when {
            uiState.isLoading -> {
                CircularProgressIndicator()
            }
            uiState.errorMessage != null -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = uiState.errorMessage ?: "Error en la cargar del producto"
                    )
                    Button(onClick = onRetry) {
                        Text(text = "Reintentar")
                    }
                }
            }
            uiState.product != null -> {
                if (uiState.isEditMode) {
                    UpdateProductForm(
                        product = uiState.product,
                        isUpdating = uiState.isUpdating,
                        onUpdate = onUpdateProduct,
                        onCancel = onCancelEdit
                    )
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        productCard(product = uiState.product)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = onEditClick,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Editar Producto")
                        }
                    }
                }
            }
        }
    }
}