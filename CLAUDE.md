# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Android CI Lab is a minimal Android application (Jetpack Compose + Material 3) used as a demonstration project for CI/CD pipeline setup with GitHub Actions.

## Common Commands

```bash
# Lint
./gradlew ktlintCheck        # Check Kotlin code style
./gradlew ktlintFormat       # Auto-fix lint issues

# Tests
./gradlew test               # Run unit tests
./gradlew test --tests "me.hrant.androidcilab.ExampleUnitTest"  # Run a single test class

# Build
./gradlew assembleDebug      # Build debug APK → app/build/outputs/apk/debug/app-debug.apk
./gradlew build              # Build all variants
./gradlew clean              # Clean build outputs
```

## Architecture

Single-module Android app (`app/`) with one activity (`MainActivity.kt`) using Jetpack Compose. No multi-module or navigation architecture — the entire UI is in `MainActivity`.

- **Version catalog:** `gradle/libs.versions.toml` — all dependency versions managed here
- **Root `build.gradle.kts`:** applies KtLint to all subprojects
- **App module:** `app/build.gradle.kts` — AGP 9.0.1, Kotlin 2.0.21, Java 11 source/target, Compose enabled

## CI Pipeline

`.github/workflows/android-ci.yml` runs on push/PR to `master`:
1. KtLint check
2. Unit tests
3. Full build
4. Assemble debug APK and upload as artifact (`android-ci-lab-debug-apk`)

Runs on `ubuntu-latest` with JDK 25 (Temurin).
