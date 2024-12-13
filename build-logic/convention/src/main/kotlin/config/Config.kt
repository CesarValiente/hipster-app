package config

import org.gradle.api.JavaVersion

object Config {
    val android = AndroidConfig(
        minSdkVersion = 32,
        targetSdkVersion = 35,
        compileSdkVersion = 35,
        applicationId = "com.cesarvaliente.hipsterapp",
        versionCode = 1,
        versionName = "1.0",
        nameSpace = "com.cesarvaliente.hipsterapp"
    )
    val jvm = JvmConfig(
        javaVersion = JavaVersion.VERSION_1_8,
        kotlinJvm = JavaVersion.VERSION_1_8.toString(),
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    )
}
data class AndroidConfig(
    val minSdkVersion : Int,
    val targetSdkVersion : Int,
    val compileSdkVersion : Int,
    val applicationId : String,
    val versionCode : Int,
    val versionName : String,
    val nameSpace: String
)
data class JvmConfig(
    val javaVersion : JavaVersion,
    val kotlinJvm : String,
    val freeCompilerArgs : List<String>
)