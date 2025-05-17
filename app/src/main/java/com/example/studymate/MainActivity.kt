package com.example.studymate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.studymate.data.Task
import com.example.studymate.ui.TaskListScreen
import com.example.studymate.ui.theme.StudyMateTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyMateTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    // 假任务列表（测试用）
                    val testTasks = listOf(
                        Task(title = "复习 Kotlin", description = "看 Jetpack Compose 教程", timestamp = System.currentTimeMillis()),
                        Task(title = "写报告", description = "完成 Android 项目说明文档", timestamp = System.currentTimeMillis()),
                        Task(title = "看课程", description = "回看 ISEN 课程录像", timestamp = System.currentTimeMillis())
                    )

                    // 展示任务列表
                    TaskListScreen(
                        tasks = testTasks,
                        onDeleteTask = { /* 暂时不处理删除事件 */ }
                    )
                }
            }
        }
    }
}
