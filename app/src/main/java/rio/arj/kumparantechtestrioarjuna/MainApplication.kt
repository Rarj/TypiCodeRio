package rio.arj.kumparantechtestrioarjuna

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import rio.arj.kumparantechtestrioarjuna.di.appModules
import rio.arj.kumparantechtestrioarjuna.di.repositoryModules
import rio.arj.kumparantechtestrioarjuna.di.viewModelModules

class MainApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    if (GlobalContext.getOrNull() == null) {
      startKoin {
        androidContext(this@MainApplication)
        modules(appModules, viewModelModules, repositoryModules)
      }
    }
  }
}