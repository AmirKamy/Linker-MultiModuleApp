import com.example.linker.build_logic.convention.implementation

plugins {
    alias(libs.plugins.linker.android.feature)
    alias(libs.plugins.linker.android.library.compose)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.linker.feature.home"
}

dependencies {
    implementation(projects.core.domain)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.mpandroidchart)
    implementation(libs.accompanist)
}