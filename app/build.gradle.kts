plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "acount.poly.movies_minhkt"
    compileSdk = 34

    defaultConfig {
        applicationId = "acount.poly.movies_minhkt"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

// retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // dagger-hilt
    implementation("com.google.dagger:hilt-android:2.48")
    annotationProcessor("com.google.dagger:hilt-android-compiler:2.44")

    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("androidx.navigation:navigation-fragment:2.7.7")

    implementation("com.google.android.flexbox:flexbox:3.0.0")

    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    implementation("com.google.android.flexbox:flexbox:3.0.0")

    // media3 exoplayer
    implementation("androidx.media3:media3-exoplayer:1.3.0")
    implementation("androidx.media3:media3-ui:1.3.0")
}