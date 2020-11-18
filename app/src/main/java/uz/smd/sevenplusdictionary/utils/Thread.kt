package uz.smd.sevenplusdictionary.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

private val executor = Executors.newSingleThreadExecutor()
private val handle = Handler(Looper.getMainLooper())

 fun runOnWorkerThread(f: () -> Unit) {
    executor.execute { f() }
}
 fun runOnUIThread(f: () -> Unit) {
    if (Thread.currentThread() == Looper.getMainLooper().thread) {
        f()
    } else {
        handle.post { f() }
    }
}