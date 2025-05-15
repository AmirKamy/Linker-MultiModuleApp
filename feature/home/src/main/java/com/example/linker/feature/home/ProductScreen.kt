package com.example.linker.feature.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.linker.core.designsystem.component.DynamicAsyncImage
import com.example.linker.core.designsystem.component.LinkerTopAppBar
import com.example.linker.core.designsystem.icon.LinkerIcons
import com.example.linker.core.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val product = viewModel.selectedProduct.value
    if (product != null)
        ShowContent(product, viewModel, navController)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowContent(product: Product, viewModel: HomeViewModel, navController: NavController) {

    val productId = product.id
    val cartItems = viewModel.cartItems
    val isInCart = product.id in cartItems

    Scaffold(
        topBar = {
            LinkerTopAppBar(
                R.string.products_detail,
                navigationIcon = LinkerIcons.ArrowBack,
                navigationIconContentDescription = "Back",
                action = {
                    IconButton(onClick = {
                        if (isInCart) {
                            cartItems.remove(productId)
                        } else {
                            cartItems.add(productId)
                        }
                    }) {
                        Icon(
                            imageVector = if (isInCart) Icons.Default.Delete else Icons.Default.Add,
                            contentDescription = "add to cart",
                            tint = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                },
                onNavigationClick = { navController.popBackStack() },
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(16.dp),
                    ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp),
                content = {
                    Column {
                        DynamicAsyncImage(
                            imageUrl = product.image,
                            contentDescription = "Product Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                                .align(Alignment.CenterHorizontally),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = product.title,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = product.description.trim(),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 24.dp).fillMaxWidth()
                        )
                    }

                }
            )
        }

    }
}

