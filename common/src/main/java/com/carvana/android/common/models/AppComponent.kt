package com.carvana.android.common.models

/**
 * Defines all the app components
 *
 * @param features that an element of [AppComponent] owns
 */
enum class AppComponent(
    val features: List<AppFeature> = listOf()
) {

    Explore(listOf(AppFeature.ExploreHome, AppFeature.Srp, AppFeature.VDP, AppFeature.Filters)),
    SellTrade(listOf(AppFeature.SellTradeHome)),
    MyCars(listOf(AppFeature.MyCarsHome, AppFeature.OwnedCars, AppFeature.FavoriteCars)),
    Account(listOf(AppFeature.AccountHome)),
    Prequal(listOf(AppFeature.PrequalHome))
}