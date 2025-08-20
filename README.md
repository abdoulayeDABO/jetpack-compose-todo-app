# Todo App

Une application de gestion de tâches moderne développée avec **Kotlin**, **Jetpack Compose** et l'architecture **MVVM**.

## Technologies Utilisées

- **Kotlin** - Langage de programmation principal
- **Jetpack Compose** - UI toolkit moderne pour Android
- **MVVM (Model-View-ViewModel)** - Architecture pattern
- **Room Database** - Base de données locale
- **Navigation Compose** - Navigation entre les écrans
- **Material Design 3** - Design system moderne
- **Coroutines & Flow** - Gestion asynchrone des données

## Fonctionnalités

- ✅ Ajouter de nouvelles tâches
- ✅ Marquer les tâches comme complétées
- ✅ Supprimer des tâches
- ✅ Interface utilisateur moderne et intuitive
- ✅ Persistance des données avec Room
- ✅ Navigation fluide entre les écrans

## Architecture

L'application suit l'architecture MVVM avec les composants suivants :

- **Model** : Entités Room et Repository
- **View** : Composables Jetpack Compose
- **ViewModel** : Gestion de l'état et de la logique métier

### Structure du Projet

```
app/src/main/java/com/abdoulaye/todoapp/
├── data/
│   ├── Todo.kt              # Entité Room
│   ├── TodoDao.kt           # Data Access Object
│   ├── TodoDatabase.kt      # Base de données Room
│   └── TodoRepository.kt    # Repository pattern
├── components/              # Composables réutilisables
├── ui/                      # Composables UI
├── TodoViewModel.kt         # ViewModel principal
├── HomeView.kt              # Écran principal
├── AddView.kt               # Écran d'ajout de tâche
├── Navigation.kt            # Navigation Compose
└── Graph.kt                 # Injection de dépendances
```

## 📸 Captures d'Écran

![Écran Principal](screenshots/Screenshot_20250819_152909_Todo%20App.jpg)

![Ajout de Tâche](screenshots/Screenshot_20250819_153017_Todo%20App.jpg)


![Interface Moderne](screenshots/Screenshot_20250819_153113_Todo%20App.jpg)

![Gestion des Tâches](screenshots/Screenshot_20250819_153119_Todo%20App.jpg)

## 🛠️ Installation et Configuration

### Prérequis

- Android Studio Hedgehog ou plus récent
- Android SDK 24+
- Kotlin 1.9+

### Étapes d'Installation

1. Clonez le repository :
```bash
git clone [URL_DU_REPO]
cd TodoApp
```

2. Ouvrez le projet dans Android Studio

3. Synchronisez les dépendances Gradle

4. Exécutez l'application sur un émulateur ou appareil Android


## 🎯 Fonctionnalités Techniques

### Base de Données Room
- Entité `Todo` avec champs : id, title, isCompleted
- DAO avec opérations CRUD
- Repository pattern pour l'abstraction des données

### ViewModel
- Gestion de l'état avec `mutableStateOf`
- Opérations asynchrones avec Coroutines
- Séparation de la logique métier de l'UI

### UI avec Jetpack Compose
- Composables réactifs
- Material Design 3
- Navigation fluide
- Interface utilisateur moderne

## 📄 Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.


⭐ N'oubliez pas de donner une étoile si ce projet vous a été utile !
