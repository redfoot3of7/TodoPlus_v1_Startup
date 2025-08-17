# Developer Notes — TodoPlus_v1_Startup

## 2025-08-16
### Lesson Learned: Material3 Theme Issues on Android 12+
- Always include `themes-v31.xml` for API 31+ (Android 12+) to prevent resource linking errors:
  - `Theme.Material3.Light` and `Theme.Material3.Dark` are not automatically available.
  - Dynamic color support should be explicitly handled via `android:forceDarkAllowed="true"`.
- Keep `md_theme_*` color resources consistent across:
  - `values/colors.xml`
  - `values-night/colors.xml`
  - `values-v31/themes-v31.xml`
  - `values-night-v31/themes-night-v31.xml`
- Always include file headers with timestamps to track updates.

### Action Items:
1. Ensure `themes-v31.xml` exists and references all `md_theme_light_*` colors.
2. Ensure `themes-night-v31.xml` exists for night mode dynamic theming.
3. Commit headers on all resource files to avoid losing important edits.
4. Document all Material3 versioning and Kotlin compiler dependencies in `build.gradle.kts`.
