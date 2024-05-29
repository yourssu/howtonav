package com.yourssu.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.compose.rememberNavController
import com.yourssu.navigtion.NavigationUtil

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
                        (requireActivity() as NavigationUtil).navigateToDrawer()
                    },
                    onSettingClick = { /*TODO*/ }
                )
            }
        }
    }
}