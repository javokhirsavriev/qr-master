package uz.javokhir.kqr.master.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

expect fun randomUUID(): String

expect val mainDispatcher: MainCoroutineDispatcher
expect val ioDispatcher: CoroutineDispatcher