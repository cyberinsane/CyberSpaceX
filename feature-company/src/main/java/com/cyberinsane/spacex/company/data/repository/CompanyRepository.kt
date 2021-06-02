package com.cyberinsane.spacex.company.data.repository

import com.cyberinsane.spacex.company.data.model.Company
import com.cyberinsane.spacex.company.data.service.CompanyService
import com.cyberinsane.spacex.core.data.model.Resource
import com.cyberinsane.spacex.core.data.repository.BaseRepository

class CompanyRepository(private val companyService: CompanyService) : BaseRepository() {

    suspend fun getCompany(): Resource<Company> = execute {
        companyService.getCompany()
    }
}
