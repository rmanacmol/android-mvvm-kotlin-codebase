package mobiledev.rpm.com

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by RenzManacmol
 */

@Module
class ApplicationModule(private val mApplication: Application) {

  @Provides
  @Singleton
  fun providesApplication(): Application {
    return mApplication
  }

  @Provides
  @Singleton
  fun provideGson(): Gson {
    return GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create()
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.connectTimeout(5, TimeUnit.MINUTES)
      .writeTimeout(5, TimeUnit.MINUTES)
      .readTimeout(5, TimeUnit.MINUTES)
    if (BuildConfig.DEBUG) {
      val logging = HttpLoggingInterceptor()
      logging.level = HttpLoggingInterceptor.Level.BODY
      httpClient.addInterceptor(logging)
    }
    return httpClient.build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .baseUrl(mApplication.getString(R.string.base_service_url))
      .client(okHttpClient)
      .build()
  }

  @Provides
  @Singleton
  fun providesApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
  }
}
