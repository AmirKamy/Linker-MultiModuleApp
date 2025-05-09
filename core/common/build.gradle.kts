plugins {
    alias(libs.plugins.linker.android.library)
    alias(libs.plugins.linker.android.hilt)
}

android {
    namespace = "com.example.linker.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
}