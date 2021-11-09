package com.carvana.android.common.models

/**
 * Defines all the app components
 *
 * @param features that an element of [AppComponent] owns
 */
enum class AppComponent(
    val features: List<AppFeature> = listOf()
) {

    Explore(listOf(AppFeature.Srp, AppFeature.VDP, AppFeature.Filters)),
    SellTrade,
    MyCars(listOf(AppFeature.OwnedCars, AppFeature.FavoriteCars)),
    Account,
    Prequal
}