plugins {
    alias(libs.plugins.linker.android.library)
    alias(libs.plugins.linker.android.room)
    alias(libs.plugins.linker.android.hilt)
}

android {
    namespace = "com.example.linker.core.database"
}

dependencies {
    api(projects.core.model)

    implementation(libs.kotlinx.datetime)
}