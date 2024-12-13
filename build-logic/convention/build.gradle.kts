import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApp") {
            id = "conventionPluginsApp.android.application"
            implementationClass = "plugins.AndroidAppConventionPlugin"
        }
        register("androidAppCompose") {
            id = "conventionPluginsApp.android.app.compose"
            implementationClass = "plugins.AndroidComposeConventionPlugin"
        }
    }
}
