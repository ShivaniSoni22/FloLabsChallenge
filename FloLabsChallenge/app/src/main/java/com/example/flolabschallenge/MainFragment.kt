package com.example.flolabschallenge

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest

class MainFragment : Fragment() {

    private lateinit var splitInstallManager: SplitInstallManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.textView1)
        installFeatureModule()
        textView.setOnClickListener {
            if (splitInstallManager.installedModules.contains("feature1")) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_mainFragment_to_signInFragment)
            } else {
                Log.e(tag, "Registration feature is not installed")
            }
        }
    }

    private fun installFeatureModule() {
        splitInstallManager = SplitInstallManagerFactory.create(activity?.applicationContext!!)
        val request = SplitInstallRequest.newBuilder()
            .addModule("feature1")
            .build()

        splitInstallManager.startInstall(request)
            .addOnSuccessListener {
                Log.d(tag, it.toString())
            }
            .addOnFailureListener {
                Log.e(tag, it.toString())
            }
    }
}