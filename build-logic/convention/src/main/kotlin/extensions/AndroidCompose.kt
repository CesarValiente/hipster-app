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
            with(versionCatalog()) {
                add("implementation", findLibrary("activity.compose").get())
                add("implementation", platform(findLibrary("compose.bom").get()))
                add("implementation", findLibrary("compose.ui").get())
                add("implementation", findLibrary("compose.graphics").get())
                add("implementation", findLibrary("compose.preview").get())
                add("implementation", findLibrary("compose.material3").get())
                add("implementation", findLibrary("compose.icons").get())

                //testing
                add("testImplementation", findLibrary("junit").get())
                add("androidTestImplementation", findLibrary("ext.junit").get())
                add("androidTestImplementation", findLibrary("espresso.core").get())
                add("androidTestImplementation", platform(findLibrary("compose.bom").get()))
                add("androidTestImplementation", findLibrary("ui.test.junit4").get())
                add("debugImplementation", findLibrary("ui.tooling").get())
                add("debugImplementation", findLibrary("ui.test.manifest").get())
            }
        }
    }
}