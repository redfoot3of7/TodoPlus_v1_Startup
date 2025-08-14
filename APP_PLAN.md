# TodoPlus_v1_startup — App Development Plan

## 1. App Overview
TodoPlus is a task/data manager that allows users to record, store, and organize tasks. It supports:
- Editable main categories
- Optional subcategories
- Voice input & spell check
- Persistent data storage
- Biometric authentication for access
- Customizable reminders (multiple per task)
- Recurring dates with advanced rules
- Sorting by any task field

---

## 2. Core Features
1. **Task Management**
   - Main category (spinner-editable list)
   - Subcategory (optional)
   - Title & description
   - Date created & due date
2. **Reminders**
   - Multiple alerts per task
   - User-defined intervals (e.g., 1 week, 1 day, 1 hour before)
3. **Recurrence**
   - Daily, weekly, monthly, yearly, and advanced patterns (e.g., “2nd Thursday”)
4. **Data Storage**
   - Persistent via Room Database
   - Sortable list views
5. **Security**
   - Biometric authentication
6. **Notifications**
   - System notifications for reminders
7. **Voice Input**
   - For adding/editing tasks

---

## 3. File Architecture

### **model/**
- `Todo.kt` — Core task data class
- `Reminder.kt` — Reminder structure
- `RecurrenceInfo.kt` — Recurrence rules

### **data/**
- `TodoEntity.kt` — Room entity
- `TodoDao.kt` — DAO interface
- `TodoRepository.kt` — Repository pattern for data access

### **ui/**
- `TodoMainScreen.kt` — Main list screen
- `TodoList.kt` — List display composable
- `TodoItem.kt` — Single item composable
- `TodoInputDialog.kt` — Add/edit task dialog
- `CategorySpinner.kt` — Editable category dropdown

### **notifications/**
- `ReminderScheduler.kt` — Schedules reminders
- `NotificationHelper.kt` — Builds and triggers notifications

### **auth/**
- `BiometricAuthManager.kt` — Handles fingerprint/face unlock

---

## 4. Branch Strategy

### **Branches**
- `main` → Always stable, deployable
- `dev` → Active feature integration
- `feature/<name>` → Isolated feature work

### **Versioning (SemVer)**
- `MAJOR.MINOR.PATCH`
- Example:
  - `v1.0.0` → Initial stable release
  - `v1.1.0` → Added reminders
  - `v1.2.0` → Added recurrence rules

---

## 5. Development Workflow
1. Create a feature branch from `dev`
2. Implement feature in self-contained chunk
3. Commit & push to feature branch
4. Merge into `dev` after testing
5. Merge `dev` into `main` only when stable
6. Tag a new version on `main`

---

## 6. Current Progress
- **Chunk 1 completed**: `Todo.kt`, `Reminder.kt`, `RecurrenceInfo.kt` created in `model/`
- Compiles successfully (no Room/Compose dependencies yet)

---

## 7. Next Planned Chunks
- **Chunk 2**: Room Database setup
  - `TodoEntity.kt`
  - `TodoDao.kt`
  - `TodoRepository.kt`
- **Chunk 3**: ViewModel integration
- **Chunk 4**: UI basic structure
- **Chunk 5**: Reminders & notifications
- **Chunk 6**: Biometric authentication
- **Chunk 7**: Voice input integration

---

_Last updated: 2025-08-13_
