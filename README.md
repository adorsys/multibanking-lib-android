[![](https://jitpack.io/v/adorsys/multibanking-lib-android.svg)](https://jitpack.io/#adorsys/multibanking-lib-android)

# multibanking-lib-android

This is the android library which connects to the multibanking service of adorsys

## Integrate into your project
To include it into your project simply add 

```groovy
allprojects {
    repositories {
        // your other dependencies
        maven { url "https://jitpack.io" }
    }
}
```
    
to your project's build.gradle.

In your modules build.gradle you can add the library then as follows:

```groovy
dependencies {
    implementation "com.github.adorsys:multibanking-lib-android:$multibankingLibVersion"
}
```
    
## Configure the library

To configure the library you need to create an application class
```kotlin
class MyApplication: Application() {}
```

then you need to register this application class in your AndroidManifest.xml
```xml
<application android:name=".MyApplication"/>
```

In your application class you can then initialize the library
```kotlin
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Multibanking.init(this,         // Application
                          baseUrl,      // String
                          endpoints,    // Map<Endpoint, String> --> Endpoints is an enum defining what you can pass
                          errorHandler, // optional, ErrorHandler? = null --> if you want to keep track of errors pass an implementation of the interface
                          mock)         // optional, Boolean = false)
    }
}
```


