/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.linker.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.linker.R
import com.example.linker.core.designsystem.icon.LinkerIcons
import com.example.linker.feature.home.navigation.HomeDestination
import com.example.linker.feature.my_games.navigation.MyGamesDestination
import com.example.linker.feature.search.navigation.SearchDestination
import kotlin.reflect.KClass

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val titleTextId: Int,
    val route: String
) {
    HOME(
        selectedIcon = LinkerIcons.Home,
        unselectedIcon = LinkerIcons.Home,
        titleTextId = R.string.home,
        route = HomeDestination.HomeScreen.route,
    ),
    SEARCH(
        selectedIcon = LinkerIcons.Search,
        unselectedIcon = LinkerIcons.Search,
        titleTextId = R.string.search,
        route = SearchDestination.SearchScreen.route,
    ),
    MY_GAMES(
        selectedIcon = LinkerIcons.Games,
        unselectedIcon = LinkerIcons.Games,
        titleTextId = R.string.my_games,
        route = MyGamesDestination.MyGamesScreen.route,
    )
}

