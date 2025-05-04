// Project-level build.gradle.kts
plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false // ✅ Only here
    id("com.android.application") version "8.9.0" apply false
    id("com.android.library") version "8.9.0" apply false
}
