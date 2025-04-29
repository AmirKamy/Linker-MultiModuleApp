package com.example.linker.feature.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.linker.core.designsystem.component.MetalItem
import com.example.linker.core.model.Product
import com.example.linker.core.model.Resource

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), onProductClick: (Int) -> Unit) {

    val state by viewModel.chartDataGroup.collectAsState()

    when (state) {
        is Resource.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is Resource.Error -> {
            val message = (state as Resource.Error).message
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "خطا: $message")
            }
        }

        is Resource.Success -> {
            val data = (state as Resource.Success).data
            ShowContent(data, viewModel) { product ->
                viewModel.selectProduct(product)
                onProductClick(product.id)
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowContent(
    products: List<Product>,
    viewModel: HomeViewModel,
    onProductClick: (Product) -> Unit
) {

    val cartItems = viewModel.cartItems
    val cartCount = cartItems.size

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.cart),
                                contentDescription = "Cart",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                modifier = Modifier.padding(top = 5.dp),
                                text = "$cartCount",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }

                        Text(
                            modifier = Modifier.padding(end = 16.dp),
                            text = "محصولات",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items(products) { product ->
                val isInCart = product.id in cartItems
                MetalItem(
                    product = product,
                    isInCart = isInCart,
                    onToggleCart = {
                        if (isInCart) {
                            cartItems.remove(product.id)
                        } else {
                            cartItems.add(product.id)
                        }
                    },
                    onItemClick = onProductClick
                )
            }
        }
    }


}


@Composable
fun ProductItem(product: Product) {
    Text(text = product.title)
}






