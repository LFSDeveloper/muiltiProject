package com.carvana.android.common.models


/**
 * Describe all the app features among all the AppComponent
 *
 * @param isPublic tells if this [AppFeature] instance belongs to the associated component
 * public navigation flow.
 *
 */
enum class AppFeature(
    val isPublic: Boolean = false
) {
    ExploreHome(true),
    SellTradeHome(true),
    MyCarsHome(true),
    AccountHome(true),
    Srp(true),
    VDP,
    Filters,
    OwnedCars,
    FavoriteCars,
    PrequalHome,
    SrpModal
}
