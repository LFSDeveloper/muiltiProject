plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

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
    // Koin core features
    api("io.insert-koin:koin-core:3.1.3")
    api("io.insert-koin:koin-android:3.1.3")
    api("io.insert-koin:koin-androidx-navigation:3.1.3")

    // Koin test features
    testApi("io.insert-koin:koin-test:3.1.3")

    api("androidx.core:core-ktx:1.7.0")
    api("androidx.appcompat:appcompat:1.3.1")
    api("com.google.android.material:material:1.4.0")

    // adding support to multi-stack
    api("androidx.navigation:navigation-fragment-ktx:2.4.0-alpha02")
    api("androidx.navigation:navigation-ui-ktx:2.4.0-alpha02")

    testApi("junit:junit:4.+")
    androidTestApi("androidx.test.ext:junit:1.1.3")
    androidTestApi("androidx.test.espresso:espresso-core:3.4.0")
}