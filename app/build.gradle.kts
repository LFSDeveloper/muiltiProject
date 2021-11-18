plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.carvana.android.myapplication"
        minSdk = 21
        targetSdk = 31
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

    flavorDimensionList.add("AppFlavorDim")
    productFlavors {
        create("dev") {
            dimension = "AppFlavorDim"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
        }

        create("tst") {
            dimension = "AppFlavorDim"
            applicationIdSuffix = ".test"
            versionNameSuffix = "-test"
        }

        create("prod") {
            dimension = "AppFlavorDim"
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

    // using common library
    implementation(project(":common"))

    // defining the dependencies exclusion to be added into other project deps
    val depsExclude = Action<ProjectDependency> {
        exclude(group = "com.carvana.android.common", module = "common")
    }

    implementation(project(":account"), depsExclude)
    implementation(project(":explore"), depsExclude)
    implementation(project(":mycars"), depsExclude)
    implementation(project(":prequal"), depsExclude)
    implementation(project(":selltrade"), depsExclude)

}