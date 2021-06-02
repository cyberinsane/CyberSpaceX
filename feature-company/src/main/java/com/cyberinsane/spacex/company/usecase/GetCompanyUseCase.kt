package com.cyberinsane.spacex.company.usecase

import com.cyberinsane.spacex.company.data.model.Company
import com.cyberinsane.spacex.company.data.repository.CompanyRepository
import com.cyberinsane.spacex.core.data.model.Resource
import com.cyberinsane.spacex.core.usecase.BaseAsyncUseCase

class GetCompanyUseCase(private val companyRepository: CompanyRepository) :
    BaseAsyncUseCase<Unit, Company>() {

    override suspend fun createSuspend(data: Unit): Resource<Company> {
        return companyRepository.getCompany()
    }
}
