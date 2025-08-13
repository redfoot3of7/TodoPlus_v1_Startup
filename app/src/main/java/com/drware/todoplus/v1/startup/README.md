# TodoPlus Room Persistence Setup

## Gradle Updates

Make sure your `app/build.gradle.kts` includes:

- `kapt` plugin applied in `plugins {}`.
- Room dependencies in `dependencies {}`:

```kotlin
implementation("androidx.room:room-runtime:2.5.2")
kapt("androidx.room:room-compiler:2.5.2")
implementation("androidx.room:room-ktx:2.5.2")
