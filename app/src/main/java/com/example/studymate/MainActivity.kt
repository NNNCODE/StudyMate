package com.example.studymate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.material3.*
import com.example.studymate.data.Task
import com.example.studymate.ui.AddTaskScreen
import com.example.studymate.ui.TaskListScreen
import com.example.studymate.ui.theme.StudyMateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyMateTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    // 状态：当前页面
                    var isAdding by remember { mutableStateOf(false) }

                    // 状态：任务列表
                    var tasks by remember { mutableStateOf(listOf<Task>()) }

                    if (isAdding) {
                        AddTaskScreen(
                            onAdd = { task ->
                                tasks = tasks + task
                                isAdding = false
                            },
                            onBack = { isAdding = false }
                        )
                    } else {
                        TaskListScreen(
                            tasks = tasks,
                            onDeleteTask = { task -> tasks = tasks - task },
                            onAddTask = { isAdding = true } // 点击添加按钮
                        )
                    }
                }
            }
        }
    }
}

