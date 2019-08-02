package com.example.data.repository

import com.example.common.domain.exception.Failure
import com.example.common.domain.functional.Either
import com.example.common.domain.functional.flatMapIterable
import com.example.data.api.BlueService
import com.example.data.utils.safeApiCall
import com.example.feature_blue.domain.model.BlueModel
import com.example.feature_blue.domain.repository.FeatureBlueRepository

class FeatureBlueRepositoryImpl(private val blueService: BlueService) :
    FeatureBlueRepository {
    override suspend fun paintInBlue(): Either<Failure, List<BlueModel>> {
        var count = 0
        return safeApiCall(blueService.paintInBlue(), emptyList())
            .flatMapIterable {
                count++
                BlueModel(count.toString())
            }
    }
}
