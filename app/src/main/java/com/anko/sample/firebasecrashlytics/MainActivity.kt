package com.anko.sample.firebasecrashlytics

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import org.jetbrains.anko.button
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    lateinit var mFirebaseAnalytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout {
            button("Crash!") {
                setOnClickListener {
//                    Crashlytics.getInstance().crash()
                    val list: ArrayList<Int> = arrayListOf(0)

                    Log.d("List", "list[1] ${list[10]}")


                }
            }

            button("AddToWishList") {
                setOnClickListener {
                    mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, Bundle().apply {
                        putString(FirebaseAnalytics.Param.ITEM_ID, "LoginButton")
                        putString(FirebaseAnalytics.Param.ITEM_NAME, "LoginButtonClicked")
                    })
                }
            }

            button("AddToWishList") {
                setOnClickListener {
                    mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ADD_TO_WISHLIST, Bundle().apply {
                        putString(FirebaseAnalytics.Param.ITEM_ID, "AddToWishListButton")
                        putString(FirebaseAnalytics.Param.ITEM_NAME, "AddToWishListButtonClicked")
                    })
                }
            }
        }

        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, "item id")
            putString(FirebaseAnalytics.Param.ITEM_NAME, "item name")
            putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
        }

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this).apply { logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle) }



    }
}
