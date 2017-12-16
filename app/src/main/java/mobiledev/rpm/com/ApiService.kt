package mobiledev.rpm.com

import io.reactivex.Observable
import mobiledev.rpm.com.model.Product
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by RenzManacmol
 */

interface ApiService {

  @GET("api/cars")
  fun getProduct(
    @Query("page") page: Int,
    @Query("maxitems") maxitems: Int,
    @Query("sort") sort: String): Observable<Product>

}
