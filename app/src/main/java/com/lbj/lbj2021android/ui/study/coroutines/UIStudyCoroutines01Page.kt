package com.lbj.lbj2021android.ui.study.coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * 作者：李炳军
 * 创建日期：2021-02-02  16:43
 * 释义：
 */

fun main() = coroutines_13()

class MyThread :Thread(){
    override fun run() {
        super.run()
        try {
            for(index in 0..500000){
                println("===> $index")
                // 异常法，使线程自行停止
                throw InterruptedException()
            }
        }catch (e: Exception){
            println("===> mythread e")
        }
    }
}

fun coroutines_13(){

}

fun coroutines_12(){
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) { // 一个执行计算的循环，只是为了占用 CPU
                // 每秒打印消息两次
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("当前为 ${i + 1} ...")
                    nextPrintTime += 500L
                }
                i++
            }
        }
        println("111")
        delay(1300L) // 等待一段时间
        println("222")
        job.cancelAndJoin() // 取消一个作业并且等待它结束
        println("333")
    }
}

// 执行三次结束
fun coroutines_11() {
    runBlocking {
        val job = launch {
            repeat(10) {
                println("第 $it 次")
                delay(500L)
            }
        }
        delay(1300L)
        job.cancel()
        job.join()
        job.cancelAndJoin()
    }
}

// 执行2次后就结束了
fun coroutines_10() {
    runBlocking {
        GlobalScope.launch {
            repeat(1000) {
                delay(500L)
                println("这是第 $it 次")
            }
        }
        delay(1200L)
    }
}

fun coroutines_09() {
    runBlocking {
        repeat(100000) { // 启动大量的协程
            launch {
                delay(500L)
                print(".")
            }
        }
    }
}

fun coroutines_08() {
    runBlocking {
        launch { coroutines_08_child() }
    }
}

suspend fun coroutines_08_child() {
    delay(1000L)
    println("hello")
}

// 执行顺序：3-1-2-4
fun coroutines_07() {
    runBlocking {
        launch {
            delay(2000L)
            println("11111111111111")
        }
        coroutineScope {
            launch {
                delay(5000L)
                println("22222222222222")
            }
            delay(1000L)
            println("333333333333")
        }
        println("444444444444444")
    }
}

fun coroutines_06() {
    runBlocking {
        launch {
            delay(1000L)
            println("world...")
        }
        println("hello...")
    }
}

fun coroutines_05() {
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("world...")
        }
        println("hello...")
        job.join()
    }
}

fun coroutines_04() {
    runBlocking {
        GlobalScope.launch {
            delay(1000L)
            println("world...")
        }
        println("hello...")
        delay(2000L)
    }
}

fun coroutines_03() {
    GlobalScope.launch {
        delay(1000L)
        println("world...")
    }
    println("hello...")
    runBlocking {
        delay(2000L)
    }
}

fun coroutines_02() {
    thread { // GlobalScope.launch 替换成 thread
        Thread.sleep(1000L) // delay 替换成 Thread.sleep ，必须替换，因为 delay 是一个挂起函数
        println("world...")
    }
    println("hello...")
    Thread.sleep(2000L)
}

fun coroutines_01() {
    GlobalScope.launch { // 在后台启动一个新的协程
        delay(1000L) // 挂起函数，非阻塞等待1s
        println("world...")
    }
    println("hello...")
    Thread.sleep(2000L) // 阻塞主线程，保证协程能执行完毕
}

