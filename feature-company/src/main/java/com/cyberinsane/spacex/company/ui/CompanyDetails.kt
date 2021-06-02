package com.cyberinsane.spacex.company.ui

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberinsane.spacex.company.data.model.Company

@Composable
fun Company() {
    val viewModel = hiltViewModel<CompanyViewModel>()
    val companyViewState = viewModel.companyViewState.collectAsState()

    if (companyViewState.value.progress) {
        CircularProgressIndicator()
    }
    CompanyDetails(companyViewState.value.company)
}

@Composable
fun CompanyDetails(company: Company?) {
    company?.let {
        Text(
            text = company.toString()
        )
    }
}
