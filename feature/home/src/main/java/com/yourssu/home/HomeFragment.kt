package com.yourssu.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.compose.rememberNavController

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                HomeScreen(
                    onDrawerClick = {
                        val request = NavDeepLinkRequest.Builder
                            .fromUri("https://howtonav.com/drawer".toUri())
                            .build()
                        navController.navigate(request)
                    },
                    onSettingClick = { /*TODO*/ }
                )
            }
        }
    }
}