package example.bankdata.services.extensions.smallRye

import io.smallrye.mutiny.*
import io.smallrye.mutiny.coroutines.*

suspend fun <Dto, ResultModel> Uni<Dto>.awaitCatchingMapping(
    transform: (Dto) -> ResultModel
): Result<ResultModel> = runCatching {
    val dto: Dto = awaitSuspending()
    val mapped: ResultModel = transform(dto)
    return Result.success(value = mapped)
}
