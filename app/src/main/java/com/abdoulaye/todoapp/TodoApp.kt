package com.abdoulaye.todoapp

import android.app.Application

class TodoApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}