package aleksandr.fedotkin.sellercryptomoney.core

import aleksandr.fedotkin.sellercryptomoney.core.di.appModule
import android.app.Application
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    }

    companion object {
        private const val ONESIGNAL_APP_ID = "0fc70cea-7c25-463e-8118-f813cd7af0f4"
    }
}
