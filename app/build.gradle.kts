import com.example.linker.build_logic.convention.implementation

plugins {
    alias(libs.plugins.linker.android.application)
    alias(libs.plugins.linker.android.application.compose)
    alias(libs.plugins.linker.android.hilt)
}

android {
    namespace = "com.example.linker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.linker"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(projects.core.designsystem)
    implementation(projects.feature.home)
    implementation(projects.feature.myGames)
    implementation(projects.feature.search)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.navigation.compose)
}