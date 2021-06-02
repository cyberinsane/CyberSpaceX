package com.cyberinsane.spacex.company.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberinsane.spacex.company.data.model.Company
import com.cyberinsane.spacex.company.usecase.GetCompanyUseCase
import com.cyberinsane.spacex.core.data.model.onError
import com.cyberinsane.spacex.core.data.model.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(private val getCompanyUseCase: GetCompanyUseCase) :
    ViewModel() {

    private val _companyViewState = MutableStateFlow(CompanyViewState())
    val companyViewState: StateFlow<CompanyViewState> = _companyViewState

    init {
        viewModelScope.launch {
            _companyViewState.value = _companyViewState.value.setProgress(true)
            getCompanyUseCase(Unit).onSuccess {
                Timber.i(it.toString())
                _companyViewState.value =
                    _companyViewState.value.copy(company = it, progress = false)
            }.onError {
                Timber.i(it.toString())
                _companyViewState.value = _companyViewState.value.copy(progress = false)
            }
        }
    }
}

data class CompanyViewState(
    val progress: Boolean = false,
    val company: Company? = null
) {
    fun setProgress(progress: Boolean) = copy(progress = progress)
    fun setCompany(company: Company?) = copy(company = company)
}
