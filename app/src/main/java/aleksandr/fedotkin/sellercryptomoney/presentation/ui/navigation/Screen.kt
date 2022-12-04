package aleksandr.fedotkin.sellercryptomoney.presentation.ui.navigation

import androidx.navigation.NamedNavArgument

sealed interface Screen {

    val name: String

    val route: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    object Products: Screen {

        override val name = "products"

        override val route = name
    }

    object Purchases: Screen {

        override val name = "purchases"

        override val route = name
    }
}
