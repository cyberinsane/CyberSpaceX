package com.cyberinsane.spacex.company.di

import com.cyberinsane.spacex.company.data.repository.CompanyRepository
import com.cyberinsane.spacex.company.data.service.CompanyService
import com.cyberinsane.spacex.company.usecase.GetCompanyUseCase
import com.cyberinsane.spacex.core.di.provideService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CompanyModule {

    // Use-case
    @Provides
    fun provideGetCompanyUseCase(companyRepository: CompanyRepository) =
        GetCompanyUseCase(companyRepository)

    // Repository
    @Provides
    @Singleton
    fun provideCompanyRepository(companyService: CompanyService) = CompanyRepository(companyService)

    // Network Services
    @Provides
    @Singleton
    fun provideCompanyService(retrofit: Retrofit) = provideService<CompanyService>(retrofit)
}
