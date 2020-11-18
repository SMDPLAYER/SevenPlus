package uz.smd.sevenplusdictionary.utils

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren

class CompositeJob {
    private val map = hashMapOf<String, Job>()

    fun add(job: Job, key: String = job.hashCode().toString()) = map.put(key, job)?.cancel()

    fun cancel() {
        for ((_, job) in map) {
            job.cancelChildren()
            job.cancel()
        }
    }
}
