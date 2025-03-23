plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "yoon.tutorials.coutermvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "yoon.tutorials.coutermvvm"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Dagger Hilt Android 라이브러리 추가
    implementation("com.google.dagger:hilt-android:2.44")
    // Dagger Hilt Android Kapt 라이브러리 추가
    // Kapt는 Kotlin Annotation Processor Tool의 약자로, Dagger Hilt에서 사용하는 Annotation Processor를 사용하기 위한 라이브러리입니다.
    // Kapt 라이브러리를 사용하면 Dagger Hilt에서 사용하는 Annotation Processor를 사용할 수 있습니다.
    // Kapt 라이브러리를 사용하려면 build.gradle 파일에 kapt 플러그인을 추가해야 합니다.
    kapt("com.google.dagger:hilt-compiler:2.44")

    implementation("androidx.core:core-ktx:1.12.0")
    // 이 라이브러리는 LifecycleOwner 및 LifecycleObserver와 같은 컴포넌트를 더 쉽게 사용할 수 있게 합니다.
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    // ViewModel과 Compose 통합을 위한 라이브러리 추가
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0")
    // Jetpack Compose와 Activity를 통합하는 기능을 제공합니다.
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

kapt {
    correctErrorTypes = true
}