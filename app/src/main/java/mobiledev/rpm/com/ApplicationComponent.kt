package mobiledev.rpm.com

import dagger.Component
import mobiledev.rpm.com.viewmodel.BaseViewModel
import javax.inject.Singleton

/**
 * Created by RenzManacmol
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
  fun inject(baseViewModel: BaseViewModel)
}
