plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.kvn.job_opp_mobile"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kvn.job_opp_mobile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.jupiter)
    // BOM de Compose (Bill of Materials)
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Core y ciclo de vida
    implementation(libs.androidx.core.ktx)

    // Activity y Compose
    implementation(libs.androidx.activity.compose)

    // Compose UI
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    // Material 3
    implementation(libs.androidx.material3)

    // ConstraintLayout para Compose
    implementation(libs.androidx.constraintlayout)

    // 🔥 Íconos extendidos (Work, MenuBook, Bookmark, etc.)
    implementation(libs.androidx.material.icons.extended)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debug
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    dependencies {
        // Actividades modernas y ciclo de vida
        implementation(libs.androidx.activity.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx.v270)

        // Coroutines
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)

        // AppCompat (si usas layouts clásicos)
        implementation(libs.androidx.appcompat)

        // Otros necesarios
        implementation(libs.androidx.core.ktx)
    }

}
