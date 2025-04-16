plugins {
    alias(libs.plugins.linker.android.library)
    alias(libs.plugins.linker.android.hilt)
}

android {
    namespace = "com.example.core.data"
}

dependencies {
    api(projects.core.common)
    api(projects.core.database)
}