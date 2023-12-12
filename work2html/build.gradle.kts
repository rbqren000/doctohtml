plugins {
    id("com.android.library")
}

android {
    namespace = "com.poi.org.work2html"
    compileSdk = 33

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(files("libs/commons-codec-1.14-SNAPSHOT.jar"))
    implementation(files("libs/dom4j-1.6.1.jar"))
    implementation(files("libs/poi-3.9-20121203.jar"))
    implementation(files("libs/poi-ooxml-3.9-20121203.jar"))
    implementation(files("libs/poi-ooxml-schemas-3.9-20121203.jar"))
    implementation(files("libs/poi-scratchpad-3.9-20121203.jar"))
    implementation(files("libs/stax-api-1.0.1.jar"))
    implementation(files("libs/xmlbeans-2.3.0.jar"))
}