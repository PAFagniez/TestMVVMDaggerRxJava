package com.example.testmvvmdaggerrx.app.injection.component

import com.example.testmvvmdaggerrx.app.injection.module.NetworkModule
import com.example.testmvvmdaggerrx.app.ui.milkywayimages.fragment.MilkywayImageFragment
import com.example.testmvvmdaggerrx.app.ui.milkywayimages.fragment.MilkywayImageListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

   fun inject(fragment: MilkywayImageFragment)
   fun inject(fragment: MilkywayImageListFragment)

   @Component.Builder
   interface Builder {
      fun build(): NetworkComponent
      fun networkModule(networkModule: NetworkModule): Builder
   }
}