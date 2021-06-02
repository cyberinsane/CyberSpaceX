package com.cyberinsane.spacex.company.data.service

import com.cyberinsane.spacex.company.data.model.Company
import retrofit2.http.GET

interface CompanyService {

    @GET("/v4/company")
    suspend fun getCompany(): Company
}
