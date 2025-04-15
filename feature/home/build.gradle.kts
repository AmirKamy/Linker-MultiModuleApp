plugins {
    alias(libs.plugins.linker.android.feature)
    alias(libs.plugins.linker.android.library.compose)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.linker.feature.home"
}

dependencies {


}