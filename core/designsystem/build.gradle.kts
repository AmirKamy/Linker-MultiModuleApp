plugins {
    alias(libs.plugins.linker.android.library)
    alias(libs.plugins.linker.android.library.compose)
}

android {
    namespace = "com.example.linker.core.designsystem"
}

dependencies {
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.ui.ui)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.ui.tooling)
    api(libs.androidx.navigation.compose)
}