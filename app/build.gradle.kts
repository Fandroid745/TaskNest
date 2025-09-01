// app/build.gradle.kts (module-level)

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.ksp) // Use alias for KSP plugin
}

android {
    namespace = "com.example.tasknest" // <<<<<<< ENSURE THIS IS YOUR CORRECT NAMESPACE
    compileSdk = 36 // Or your target compile SDK, e.g., 34 if 36 isn't final

    defaultConfig {
        applicationId = "com.example.tasknest" // <<<<<<< ENSURE THIS IS YOUR CORRECT ID
        minSdk = 24
        targetSdk = 36 // Or your target SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources=true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11 // Or JavaVersion.VERSION_17 if you prefer
        targetCompatibility = JavaVersion.VERSION_11 // Or JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "11" // Or "17" if matching above
    }
    buildFeatures {
        compose = true
    }

    // THIS IS THE CRUCIAL PART TO ADD/UPDATE
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" // Set the correct version based on your Kotlin version and Compose BOM
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Room Dependencies (using version catalog)
    implementation(libs.androidx.room.runtime.android)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.material3.android)
    ksp(libs.androidx.room.compiler) // Ensure this uses ksp

    // ViewModel (using version catalog)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debug
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}