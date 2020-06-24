package com.teamaad34.polls.data

sealed class TaskResult<out T> {
    data class Success<T>(val data: T) : TaskResult<T>()
    data class Error(val error: Exception) : TaskResult<Nothing>()
    object Loading : TaskResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> this.data.toString()
            is Error -> this.error.toString()
            Loading -> "Loading..."
        }
    }
}

inline val TaskResult<*>.isLoading
    get() = this is TaskResult.Loading

inline val TaskResult<*>.isSuccessful
    get() = this is TaskResult.Success && data != null

inline val <T> TaskResult<T>.data: T?
    get() = if (isSuccessful) (this as TaskResult.Success).data else null

inline val <T> TaskResult<T>.dataOrFail: T
    get() = try {
        this.data!!
    } catch (ex: Exception) {
        throw Exception("Invalid ${TaskResult::class.java.simpleName} type! ${ex.message}")
    }

inline val <T> TaskResult<List<T>>.listData: List<T>
    get() = data ?: emptyList()

inline val TaskResult<*>.isError
    get() = this is Error

inline val <T> TaskResult<T>.errorMessage: String?
    get() = if (isError) (this as TaskResult.Error).message else null

inline val TaskResult.Error.message: String
    get() = error.message!!