plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mw.example.daggerlazymultimodule"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mw.example.daggerlazymultimodule"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(mapOf("path" to ":injector")))
    implementation(project(mapOf("path" to ":repository_api")))
    implementation(project(mapOf("path" to ":repository_impl")))

    implementation(project(mapOf("path" to ":feature_list_api")))
    implementation(project(mapOf("path" to ":feature_list_impl")))
    implementation(project(mapOf("path" to ":feature_detail_api")))
    implementation(project(mapOf("path" to ":feature_detail_impl")))
    implementation(project(mapOf("path" to ":feature_pdf_api")))
    implementation(project(mapOf("path" to ":feature_pdf_impl")))

    implementation ("com.google.dagger:dagger:2.46.1")
    implementation(project(mapOf("path" to ":injector_compose")))
    kapt ("com.google.dagger:dagger-compiler:2.46.1")

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.6.0")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}