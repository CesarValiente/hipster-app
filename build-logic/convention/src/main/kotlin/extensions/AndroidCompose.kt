package extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
){
    commonExtension.apply {
        buildFeatures.compose = true
        composeOptions.kotlinCompilerExtensionVersion =
            versionCatalog().findVersion("androidx-compose-compiler").get().toString()

        dependencies {
            add("implementation", versionCatalog().findLibrary("activity.compose").get())
            add("implementation", platform(versionCatalog().findLibrary("compose.bom").get()))
            add("implementation", versionCatalog().findLibrary("compose.ui").get())
            add("implementation", versionCatalog().findLibrary("compose.graphics").get())
            add("implementation", versionCatalog().findLibrary("compose.preview").get())
            add("implementation", versionCatalog().findLibrary("compose.material3").get())
            add("implementation", versionCatalog().findLibrary("compose.icons").get())

            //testing
            add("testImplementation", versionCatalog().findLibrary("junit").get())
            add("androidTestImplementation", versionCatalog().findLibrary("ext.junit").get())
            add("androidTestImplementation", versionCatalog().findLibrary("espresso.core").get())
            add("androidTestImplementation", platform(versionCatalog().findLibrary("compose.bom").get()))
            add("androidTestImplementation", versionCatalog().findLibrary("ui.test.junit4").get())
            add("debugImplementation", versionCatalog().findLibrary("ui.tooling").get())
            add("debugImplementation", versionCatalog().findLibrary("ui.test.manifest").get())
        }
    }
}