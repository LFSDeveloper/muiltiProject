plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

//apply(from = ".../dependencies.gradle.kts")

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    
    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    // applying all koin major dependencies together
    api(libs.bundles.koin)

    api(libs.androidxKt.core)
    api(libs.androidx.appCompat)
    api(libs.android.material)

    // adding support to multi-stack
    api(libs.bundles.androidxKtNav)

    testApi(libs.junit)

    androidTestApi(libs.androidx.test.ext)
    androidTestApi(libs.androidx.test.espresso)
}