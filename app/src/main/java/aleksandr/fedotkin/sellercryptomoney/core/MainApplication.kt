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
        private const val ONESIGNAL_APP_ID = "df506608-20fc-460e-8e77-d296037b1a7a"
    }
}
