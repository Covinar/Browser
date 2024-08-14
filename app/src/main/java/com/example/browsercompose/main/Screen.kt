package com.example.browsercompose.main

sealed class Screen(
    val route: String
) {

    data object Browser: Screen(BROWSER_ROUTE)

    data object About: Screen(ABOUT_ROUTE)

    companion object {

        const val ABOUT_ROUTE = "image_preview"
        const val BROWSER_ROUTE = "files"

    }

}