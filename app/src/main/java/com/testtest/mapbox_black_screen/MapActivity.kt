package com.testtest.mapbox_black_screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.FragmentTransaction
import com.mapbox.mapboxsdk.Mapbox

class MapActivity : AppCompatActivity() {

    companion object {

        fun startActivityWithOptions(activity: MainActivity) {
            ActivityCompat.startActivity(
                activity, Intent(activity, MapActivity::class.java),
                ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle()
            )
            ActivityCompat.finishAfterTransition(activity)
        }

        fun startActivityWithoutOptions(activity: MainActivity) {
            ActivityCompat.startActivity(activity, Intent(activity, MapActivity::class.java), null)
            ActivityCompat.finishAfterTransition(activity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token))
        setContentView(R.layout.activity_map)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, MapboxFragment())
        transaction.commit()
    }

    override fun onBackPressed() {
        finish()
        MainActivity.start(this)
    }

}
