plugins {
    alias(libs.plugins.linker.android.library)
    alias(libs.plugins.linker.android.library.compose)
}

android {
    namespace = "com.example.linker.core.ui"
}

dependencies {
    api(projects.core.model)
    api(projects.core.designsystem)

}