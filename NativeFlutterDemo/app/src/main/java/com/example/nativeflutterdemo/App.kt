package com.example.nativeflutterdemo

import android.app.Application
import android.content.Intent
import com.idlefish.flutterboost.FlutterBoost

import com.idlefish.flutterboost.containers.FlutterBoostActivity

import com.idlefish.flutterboost.FlutterBoostRouteOptions

import com.idlefish.flutterboost.FlutterBoostDelegate
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine


class App :Application() {

    override fun onCreate() {
        super.onCreate()
        FlutterBoost.instance().setup(this, object : FlutterBoostDelegate {
            override fun pushNativeRoute(options: FlutterBoostRouteOptions) {
                //这里根据options.pageName来判断你想跳转哪个页面，这里简单给一个
                val intent = Intent(
                    FlutterBoost.instance().currentActivity(),
                    YourTargetAcitvity::class.java
                )
                FlutterBoost.instance().currentActivity()
                    .startActivityForResult(intent, options.requestCode())
            }

            override fun pushFlutterRoute(options: FlutterBoostRouteOptions) {
                val intent: Intent =
                    FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity::class.java)
                        .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                        .destroyEngineWithActivity(false)
                        .uniqueId(options.uniqueId())
                        .url(options.pageName())
                        .urlParams(options.arguments())
                        .build(FlutterBoost.instance().currentActivity())
                FlutterBoost.instance().currentActivity().startActivity(intent)
            }
        }) { engine: FlutterEngine? -> }
    }
}